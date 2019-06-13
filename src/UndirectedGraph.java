public class UndirectedGraph extends UndirectedWeightedGraph {

    UndirectedGraph(int v) {

        super(v);

    }

    public void addEdge(int a, int b) {

        super.addEdge(a, b, 1);
        super.addEdge(b, a, 1);

    }

}
