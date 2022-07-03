import java.util.*;

class Graph {

    Map<Integer, ArrayList<Integer>> map;

    public Graph() {
        map = new HashMap<Integer, ArrayList<Integer>>();

    }

    public void addVertex(int node) {
        map.put(node, new ArrayList<Integer>());
    }

    public void addEdge(int node1, int node2) {
        map.get(node1).add(node2);
        map.get(node2).add(node1);
    }

    public void showConnection(){
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println(entry.getValue().toString());
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 2);
        g.addEdge(4, 5);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(6, 5);

        g.showConnection();


    }

}