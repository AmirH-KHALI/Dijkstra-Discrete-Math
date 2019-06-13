public class Dijkstra< T > {

    int[] values;
    int[] comeFrom;
    boolean[] marked;
    DirectedWeightedGraph myGraph;

    Dijkstra(T myGraph, int vertex) {

        int numberOfVertex = ((DirectedWeightedGraph)myGraph).getNumberOfV();

        values = new int[numberOfVertex];
        comeFrom = new int[numberOfVertex];
        marked = new boolean[numberOfVertex];

        comeFrom[vertex] = -1;

        for (int i = 0; i < numberOfVertex; i++) {

            if (vertex != i) {

                values[i] = Integer.MAX_VALUE;

            }

        }

        this.myGraph = (DirectedWeightedGraph) myGraph;

    }


    public void startDijkstra(int v) {

        for (int adj : myGraph.getAdj(v)) {

            if (!marked[adj] || values[v] + myGraph.getFromMatrix(v, adj) < values[adj]) {

                values[adj] = values[v] + myGraph.getFromMatrix(v, adj);
                comeFrom[adj] = v;

            }

        }

    }




    public static void main(String args[]){
//
//        UndirectedWeightedGraph hamid = new UndirectedWeightedGraph(2);
//        Dijkstra amin = new Dijkstra(hamid);



    }

}
