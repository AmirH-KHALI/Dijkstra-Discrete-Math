import com.sun.javafx.geom.Edge;

import java.util.ArrayList;

public class Dijkstra {

    private int n;
    private Edges w[][];
    private int dist[];
    private int mark[];
    private int par[];
    private ArrayList<Integer> ans;
    private ArrayList<Integer> distArr;

    private DirectedWeightedGraph myGraph;

    Dijkstra (DirectedWeightedGraph myGraph) {

        n = myGraph.getNumberOfV();

        System.out.println(n);

        w = myGraph.getWeight();

        dist = new int[n];
        mark = new int[n];
        par = new int[n];

        ans = new ArrayList<Integer>();
        distArr = new ArrayList<Integer>();

        this.myGraph = myGraph;

    }

    public ArrayList<Edges> doDijkstra (int s) {
        for (int i = 0; i < n; ++i) {
                dist[i] = Integer.MAX_VALUE;
                par[i] = i;
        }
        dist[s] = 0;
        for (int rep = 0; rep < n; ++rep) {
            int u = -1;
            int du = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                if (mark[i] == 0 && dist[i] <= du) {
                    u = i;
                    du = dist[i];
                }
            }
            mark[u] = 1;
            ans.add(u);
            for (int v = 0; v < n; ++v)
                if(w[u][v] != null && w[u][v].getVal() > 0)
                    if (dist[v] > dist[u] + w[u][v].getVal()) {
                        dist[v] = dist[u] + w[u][v].getVal();
                        par[v] = u;
                    }
        }

        return writeOutput(s);
    }

    public ArrayList<Edges> writeOutput (int s) {

        ArrayList<Edges> ansE = new ArrayList<Edges>();

//        for (int i : ans) {
//            System.out.println(i);
//        }

        for (int i : ans) {
            if (i != s) {
                ansE.add(w[par[i]][i]);
                distArr.add(dist[i]);
            }
        }

        return ansE;
    }

    public ArrayList<Integer> getDist () {
        return distArr;
    }

}
