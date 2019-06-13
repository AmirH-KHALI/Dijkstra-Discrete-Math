public class DirectedGraph extends DirectedWeightedGraph {


    DirectedGraph(int v){

        super(v);

    }

    public void addEdge(int a, int b) {

        super.addEdge(a, b, 1);

    }

}