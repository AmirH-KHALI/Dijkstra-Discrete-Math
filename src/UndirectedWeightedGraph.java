public class UndirectedWeightedGraph extends DirectedWeightedGraph {

    UndirectedWeightedGraph(int v) {

        super(v);

    }

    @Override
    public void addEdge(int a, int b, int weight) {

        super.addEdge(a, b, weight);
        super.addEdge(b, a, weight);

    }

}
