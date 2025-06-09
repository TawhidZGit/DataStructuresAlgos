package Hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomHashMap<K, V> {

    private static class Entry<K, V> {

        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size = 0;
    private int threshold;

    public CustomHashMap() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
        threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
    }

    private int indexFor(K key) {

        return (key == null) ? 0 : ((key.hashCode() & 0x7fffffff) % table.length);
    }

    public V put(K key, V value) {

        int index = indexFor(key);
        Entry<K, V> curr = table[index];

        while (curr != null) {

            if (Objects.equals(curr.key, key)) {
                V oldValue = curr.value;
                curr.value = value;
                return oldValue;
            }

            curr = curr.next;
        }

        Entry<K, V> newNode = new Entry<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;

        if (size > threshold) {
            resize();
        }

        return null;

    }

    public V get(K key) {

        int index = indexFor(key);
        Entry<K, V> curr = table[index];

        while (curr != null) {

            if (Objects.equals(curr.key, key)) {

                return curr.value;

            }

            curr = curr.next;
        }
        return null;
    }

    public boolean containsKey(K key) {

        return get(key) != null;

    }

    public V remove(K key) {

        int index = indexFor(key);
        Entry<K, V> curr = table[index];
        Entry<K, V> prev = null;

        while (curr != null) {

            if (Objects.equals(curr.key, key)) {

                if (prev == null)
                    table[index] = curr.next;
                else
                    prev.next = curr.next;
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    private void resize() {

        int newCapacity = table.length * 2;
        Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[newCapacity];

        for (Entry<K, V> head : table) {

            while (head != null) {

                Entry<K, V> next = head.next;

                int index = (head.key == null) ? 0 : (head.key.hashCode() & 0x7fffffff) % newCapacity;

                head.next = newTable[index];
                newTable[index] = head;

                head = next;
            }

        }

        table = newTable;
        threshold = (int) (newCapacity * LOAD_FACTOR);

    }

    public void clear(){

    	table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
    	size = 0;
        threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
    }

    public Iterable<K> keySet(){
        List<K> keys = new ArrayList<>();
        for(Entry<K, V> bucket : table){
            for(Entry<K, V> curr = bucket; curr != null; curr = curr.next){
                keys.add(curr.key);

            }
        }

        return keys;
    }

    public Iterable<V> values(){

        List<V> values = new ArrayList<>();
        for(Entry<K, V> bucket : table){
            for(Entry<K, V> curr = bucket; curr != null; curr = curr.next){
                values.add(curr.value);
            }
        }

        return values;
    }

    public Iterable<Entry<K, V>> entrySet(){

        List<Entry<K, V>> entrySet = new ArrayList<>();
        for(Entry<K, V> bucket: table){
            for(Entry<K, V> curr = bucket; curr != null; curr = curr.next){
                entrySet.add(curr);
            }            
        }
        return entrySet;
    }

    @Override
    public String toString(){

    	StringBuilder sb = new StringBuilder();
    	sb.append("{");

    	boolean first = true;
    	for(Entry<K, V> bucket : table){
    		Entry<K, V> curr = bucket;
    		while(curr != null){
    			if(!first) sb.append(", ");
	    		sb.append(curr.key).append("=").append(curr.value);
	    		first = false;
	    		curr = curr.next;
    		}	    		
    	}
    	sb.append("}");
    	return sb.toString();
    }

}


