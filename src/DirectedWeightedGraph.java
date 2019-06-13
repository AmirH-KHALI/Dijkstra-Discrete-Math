import java.util.ArrayList;

public class DirectedWeightedGraph {

    protected int numberOfV;
    protected ArrayList<ArrayList<Integer>> matrix;


    DirectedWeightedGraph(int v){

        numberOfV = v;
        matrix = new ArrayList<>();

        ArrayList<Integer> newEmptyArrayList = new ArrayList<>();

        for (int i = 0; i < v; i++) newEmptyArrayList.add(0);

        for (int i = 0; i < v; i++) matrix.add(new ArrayList<>(newEmptyArrayList));

    }


    public void addEdge(int a, int b, int weight) {

        matrix.get(a).set(b, weight);

    }

    public ArrayList<Integer> getAdj(int v) {

        ArrayList<Integer> adj = new ArrayList<>();

        for (int i = 0; i < numberOfV; i++) {

            if (matrix.get(v).get(i) >= 1) {

                adj.add(i);

            }

        }

        return adj;

    }


    @Override
    public String toString(){

        String theString = "\n";

        for (int i = 0; i < numberOfV; i++)  theString += "Node " + i + " -> " + matrix.get(i) + "\n";

        return theString;

    }

    public int getNumberOfV() {

        return numberOfV;

    }

    public ArrayList<ArrayList<Integer>> getMatrix() {

        return matrix;

    }

    public int getFromMatrix(int a, int b) {

        return matrix.get(a).get(b);

    }

}
