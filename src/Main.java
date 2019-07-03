import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    static Scanner input = new Scanner(System.in);

    private Stage myStage;
    private Scene myScene;

    private DirectedWeightedGraph myGraph;

    private Group root;

    public void createWindow (Stage primaryStage) throws Exception {

        myStage = primaryStage;
        myStage.setTitle("Discrete Math final project - dijkstra");

        root = new Group();

        Scene scene = new Scene(root,1000, 700);

        myScene = scene;

        myStage.setScene(myScene);
        myStage.show();
    }

    public void createMyGraph () throws Exception {

        int numberOfVertex;
        int numberOfEdge;

        numberOfVertex = input.nextInt();
        numberOfEdge = input.nextInt();

        myGraph = new DirectedWeightedGraph(numberOfVertex);

        root.getChildren().addAll(myGraph.getNodesFace());

        for (int i = 0; i < numberOfEdge; i++){

            int st, en, wei;
            st = input.nextInt();
            en = input.nextInt();
            wei = input.nextInt();
            myGraph.addEdge(st, en, wei);
        }

        root.getChildren().addAll(myGraph.getEdgesFace());

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        createWindow(primaryStage);

        createMyGraph();

        Dijkstra<DirectedWeightedGraph> myDij = new Dijkstra<DirectedWeightedGraph>(myGraph, this);
        myDij.start(0);

    }

    public static void main(String args[]){

        launch(args);
    }
}
























