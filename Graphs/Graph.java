package Graphs;

import java.util.*;

public class Graph<T> {

    private Map<T, Collection<Edge<T>>> adjList = new HashMap<>();
    private final boolean directed;
    private final boolean isMultigraph;
    private final boolean weighted;

    private static class Edge<T> {

        T dest;
        double weight;

        Edge(T dest, double weight) {

            this.dest = dest;
            this.weight = weight;
        }

    }

    public Graph(boolean directed, boolean isMultigraph, boolean weighted) {
        this.directed = directed;
        this.isMultigraph = isMultigraph;
        this.weighted = weighted;

    }

    public void addVertex(T vertex) {

        if (!adjList.containsKey(vertex)) {

            adjList.put(vertex, isMultigraph ? new ArrayList<>() : new HashSet<>());
        }
    }

    public void addEdge(T src, T dest) {

        addEdge(src, dest, 1.0);

    }

    public void addEdge(T src, T dest, double weight) {

        addVertex(src);
        addVertex(dest);
        Edge<T> edge = new Edge<>(dest, weighted ? weight : 1.0);
        Collection<Edge<T>> neighbors = adjList.get(src);
        if (isMultigraph || !neighbors.contains(edge)) {

            neighbors.add(edge);
        }

        if (!directed) {

            Edge<T> reverseEdge = new Edge<>(src, weighted ? weight : 1.0);
            Collection<Edge<T>> neighborsDest = adjList.get(dest);
            if (isMultigraph || !neighborsDest.contains(reverseEdge)) {

                neighborsDest.add(reverseEdge);
            }
        }
    }

    public void removeEdge(T src, T dest) {

        Collection<Edge<T>> neighbors = adjList.get(src);
        if (neighbors != null) {

            neighbors.removeIf(e -> e.dest.equals(dest));
        }

        if (!directed) {

            Collection<Edge<T>> neighborsDest = adjList.get(dest);
            if (neighborsDest != null) {
                neighborsDest.removeIf(e -> e.dest.equals(src));
            }
        }
    }

    public void removeEdge(T src, T dest, double weight) {

        Collection<Edge<T>> neighbors = adjList.get(src);
        if (neighbors != null) {
            neighbors.removeIf(e -> e.dest.equals(dest) && e.weight == weight);
        }

        if (!directed) {

            Collection<Edge<T>> neighborsDest = adjList.get(dest);
            if (neighborsDest != null) {
                neighborsDest.removeIf(e -> e.dest.equals(src) && e.weight == weight);
            }
        }
    }

    public void removeVertex(T vertex) {

        adjList.remove(vertex);
        for (Collection<Edge<T>> neighbors : adjList.values()) {

            neighbors.removeIf(e -> e.dest.equals(vertex));
        }
    }

    public List<T> getNeighbors(T vertex) {

        Collection<Edge<T>> neighbors = adjList.getOrDefault(vertex, Collections.emptyList());
        List<T> result = new ArrayList<>();

        for (Edge<T> edge : neighbors) {

            result.add(edge.dest);
        }

        return result;
    }

    public Set<T> getVertices() {

        return adjList.keySet();

    }

    public boolean hasVertex(T vertex) {

        return adjList.containsKey(vertex);
    }

    public boolean hasEdge(T src, T dest) {

        Collection<Edge<T>> neighbors = adjList.get(src);
        if (neighbors == null)
            return false;
        for (Edge<T> edge : neighbors) {
            if (edge.dest.equals(dest))
                return true;
        }

        return false;
    }

    public Double getWeight(T src, T dest) {

        Collection<Edge<T>> neighbors = adjList.get(src);
        if (neighbors == null)
            return null;
        for (Edge<T> edge : neighbors) {

            if (edge.dest.equals(dest))
                return edge.weight;
        }

        return null;

    }

    public List<T> dfs(T start) {
        List<T> visitedOrder = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        dfsHelper(start, visited, visitedOrder);

        return visitedOrder;

    }

    private void dfsHelper(T current, Set<T> visited, List<T> visitedOrder) {

        if (!adjList.containsKey(current) || visited.contains(current))
            return;

        visited.add(current);
        visitedOrder.add(current);
        for (Edge<T> edge : adjList.get(current)) {
            dfsHelper(edge.dest, visited, visitedOrder);
        }
    }

    public List<T> bfs(T start) {

        List<T> visitedOrder = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            T current = queue.poll();
            visitedOrder.add(current);

            for (Edge<T> edge : adjList.getOrDefault(current, Collections.emptyList())) {

                if (!visited.contains(edge.dest)) {

                    visited.add(edge.dest);
                    queue.add(edge.dest);

                }

            }

        }

        return visitedOrder;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (T vertex : adjList.keySet()) {

            sb.append(vertex).append(": ").append(adjList.get(vertex)).append("\n");
        }

        return sb.toString();
    }

}
