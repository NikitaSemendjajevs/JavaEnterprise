import java.util.*;

public class DFSVoyager implements Voyager {

    private final Map<Vertex, List<Vertex>> graph;

    private static class Vertex {

        private final int row;
        private final int column;

        public Vertex(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public int hashCode() {
            int result = Integer.hashCode(row);
            return result * 31 + Integer.hashCode(column);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Vertex v) {
                return row == v.row && column == v.column;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Land:" + "(" + row + "," + column + ")";
        }

    }

    public DFSVoyager(int[][] map) {
        graph = toGraph(map);
    }

    private static Map<Vertex, List<Vertex>> toGraph(int[][] map) {
        Map<Vertex, List<Vertex>> graph = new HashMap<>();
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                if (map[row][column] != 0) {
                    Vertex vertex = new Vertex(row, column);
                    graph.put(vertex, new ArrayList<>());

                    if (row + 1 < map.length && map[row + 1][column] != 0) {
                        graph.get(vertex).add(new Vertex(row + 1, column));
                    }
                    if (column + 1 < map[row].length && map[row][column + 1] != 0) {
                        graph.get(vertex).add(new Vertex(row, column + 1));
                    }
                    if (row - 1 >= 0 && map[row - 1][column] != 0) {
                        graph.get(vertex).add(new Vertex(row - 1, column));
                    }
                    if (column - 1 >= 0 && map[row][column - 1] != 0) {
                        graph.get(vertex).add(new Vertex(row, column - 1));
                    }
                }
            }
        }
        return graph;
    }

    private void dfs(Vertex v, Set<Vertex> visited) {
        if (visited.contains(v)) return;
        visited.add(v);

        for (Vertex neighbor : graph.get(v)) {
            dfs(neighbor, visited);
        }
    }

    @Override
    public int lookupIslands(int[][] map) {
        int islands = 0;
        Set<Vertex> visited = new HashSet<>();

        for (Vertex v : graph.keySet()) {
            if (!visited.contains(v)) {
                dfs(v, visited);
                islands++;
            }
        }
        return islands;
    }

    public int lookupIslands() {
        int islands = 0;

        Set<Vertex> visited = new HashSet<>();
        LinkedList<Vertex> queue = new LinkedList<>();

        for (Vertex v : graph.keySet()) {
            if (!visited.contains(v)) {
                visited.add(v);
                queue.add(v);
                while (!queue.isEmpty()) {
                    Vertex visitedVertex = queue.poll();
                    for (Vertex unvisited: graph.get(visitedVertex)) {
                        if (!visited.contains(unvisited)) {
                            visited.add(unvisited);
                            queue.add(unvisited);
                        }
                    }
                }
                islands++;
            }
        }
        return islands;
    }

    public void printGraph() {
        for (Vertex v : new ArrayList<>(graph.keySet())) {
            System.out.print(v + ":" + graph.get(v).toString() + "\n");
        }
    }

}

class Main {
    public static void main(String[] args) {
        int[][] islands = {
                {1, 1, 0, 0, 0, 1},
                {1, 0, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 0}
        };
        DFSVoyager voyager = new DFSVoyager(islands);
        voyager.printGraph();
        System.out.println("Number of islands: " + voyager.lookupIslands(islands));
        System.out.println(voyager.lookupIslands());
    }
}
