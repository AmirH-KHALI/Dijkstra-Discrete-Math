import java.util.Scanner;

public class Main {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        int numberOfVertex, numberOfEdge;

        numberOfVertex = input.nextInt();
        numberOfEdge = input.nextInt();

        DirectedWeightedGraph mygraph = new DirectedWeightedGraph(numberOfVertex);

        for (int i = 0; i < numberOfEdge; i++){

            int a, b, c;
            a = input.nextInt();
            b = input.nextInt();
            c = input.nextInt();
            mygraph.addEdge(a, b, c);

        }


        System.out.println(mygraph.toString());

    }

}
