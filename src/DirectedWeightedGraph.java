import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class DirectedWeightedGraph {

    protected int numberOfV;

    protected ArrayList<Nodes> nodesList = new ArrayList<Nodes>();
    protected ArrayList<Edges>[] adj;

    DirectedWeightedGraph (int v) throws Exception {

        numberOfV = v;

        setNodes();

        adj = new ArrayList[numberOfV];

        for (int i = 0; i < numberOfV; ++i) {
            adj[i] = new ArrayList<Edges>();
        }

    }

    public ArrayList<Circle> getNodesFace () {

        ArrayList<Circle> ans = new ArrayList<Circle>();

        for (Nodes x : nodesList) {
            ans.add(x.getFace());
        }
        return ans;
    }

    public ArrayList<Line> getEdgesFace () {

        ArrayList<Line> edgesList = new ArrayList<Line>();

        for (int i = 0; i < numberOfV; ++i) {
            for (int j = 0; j < adj[i].size(); ++j)
                edgesList.add(adj[i].get(j).getFace());
        }

        return edgesList;
    }

    public void setNodes() throws Exception {

        int rad = 200;

        for (int i = 0; i < numberOfV; ++i) {

            final double angle = Math.toRadians(((double) i / numberOfV) * 360d);

            double x = (Math.cos(angle) * rad) + 500;
            double y = (Math.sin(angle) * rad) + 350;

            Nodes node = new Nodes(x, y);

            nodesList.add(node);
        }
    }


    public void addEdge (int a, int b, int weight) {

        Edges edge = new Edges(nodesList.get(a), nodesList.get(b), weight);

        adj[a].add(edge);

    }

    public ArrayList<Edges> getAdj(int v) {

        return adj[v];

    }

    public int getNumberOfV() {

        return numberOfV;

    }
}
