public class Dijkstra< T > {

    private int[] values;
    private int[] comeFrom;
    private boolean[] marked;
    private DirectedWeightedGraph myGraph;
    private Main texture;

    Dijkstra(T myGraph, Main texture) {

        this.texture = texture;

        int numberOfVertex = ((DirectedWeightedGraph)myGraph).getNumberOfV();

        values = new int[numberOfVertex];
        comeFrom = new int[numberOfVertex];
        marked = new boolean[numberOfVertex];

        for (int i = 0; i < numberOfVertex; i++) {

            values[i] = Integer.MAX_VALUE;

        }

        this.myGraph = (DirectedWeightedGraph) myGraph;

    }


    public void start(int v) {

        values[v] = 0;

        // dijkstra code


//        for (int adj : myGraph.getAdj(v)) {
//
//            if (!marked[adj] || values[v] + myGraph.getFromMatrix(v, adj) < values[adj]) {
//
//                values[adj] = values[v] + myGraph.getFromMatrix(v, adj);
//                comeFrom[adj] = v;
//
//            }
//
//        }

    }
}
