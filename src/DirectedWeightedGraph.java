import org.w3c.dom.Text;

import java.util.ArrayList;

public class DirectedWeightedGraph {

    protected int numberOfV;
    protected int[][] matrix;
    protected Main texture;


    DirectedWeightedGraph(int v, Main texture){

        numberOfV = v;
        matrix = new int[numberOfV][numberOfV];

        this.texture = texture;

    }


    public void addEdge(int a, int b, int weight) {

        matrix[a][b] = weight;

    }

    public ArrayList<Integer> getAdj(int v) {

        ArrayList<Integer> adj = new ArrayList<>();

        for (int i = 0; i < numberOfV; i++) {

            if (matrix[v][i] >= 1) {

                adj.add(i);

            }

        }

        return adj;

    }

    public int getNumberOfV() {

        return numberOfV;

    }

    public int[][] getMatrix() {

        return matrix;

    }

    public int getFromMatrix(int a, int b) {

        return matrix[a][b];

    }

}
