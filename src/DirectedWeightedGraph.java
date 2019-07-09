import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class DirectedWeightedGraph {

    protected int numberOfV;

    protected ArrayList<Nodes> nodesList = new ArrayList<Nodes>();

    protected Edges[][] weight;

    DirectedWeightedGraph (int v) throws Exception {

        numberOfV = v;

        weight = new Edges[numberOfV][numberOfV];

        for (int i = 0; i < numberOfV; ++i) {
            for (int j = 0; j < numberOfV; ++j) {
                weight[i][j] = null;
            }
        }

        setNodes();
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

        this.weight[a][b] = new Edges(nodesList.get(a), nodesList.get(b), weight);

    }

    public int getNumberOfV() {
        return numberOfV;
    }

    public Edges[][] getWeight () {
        return weight;
    }

    public ArrayList<Circle> getNodesFace () {

        ArrayList<Circle> ans = new ArrayList<Circle>();

        for (Nodes x : nodesList) {
            ans.add(x.getFace());
        }
        return ans;
    }

    public ArrayList<Arrow> getEdgesFace () {

        ArrayList<Arrow> edgesList = new ArrayList<Arrow>();

        for (int i = 0; i < numberOfV; ++i) {
            for (int j = 0; j < numberOfV; ++j) {
                if (weight[i][j] != null)
                    edgesList.add(weight[i][j].getFace());
            }
        }

        return edgesList;
    }

    public ArrayList<Text> getEdgesValFace () {

        ArrayList<Text> edgesList = new ArrayList<Text>();

        for (int i = 0; i < numberOfV; ++i) {
            for (int j = 0; j < numberOfV; ++j) {
                if (weight[i][j] != null)
                    edgesList.add(weight[i][j].getValFace());
            }
        }

        return edgesList;
    }
}
