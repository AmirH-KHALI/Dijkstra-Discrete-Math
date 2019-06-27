import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

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

    public void createMyGraph () {

        int numberOfVertex;
        int numberOfEdge;

        numberOfVertex = input.nextInt();
        numberOfEdge = input.nextInt();

        myGraph = new DirectedWeightedGraph(numberOfVertex, this);

        for (int i = 0; i < numberOfEdge; i++){

            int a, b, c;
            a = input.nextInt();
            b = input.nextInt();
            c = input.nextInt();
            myGraph.addEdge(a, b, c);

        }
    }

    public void setEdges (int[][] matrix) {

    }

    public void setNodes (int v) {
        Circle circle1 = new Circle();
        circle1.setCenterX(20);
        circle1.setCenterY(20);
        circle1.setRadius(20);
        root.getChildren().addAll(circle1);
        myStage.setScene(myScene);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        createWindow(primaryStage);

        createMyGraph();

        setNodes(myGraph.getNumberOfV());

        setEdges(myGraph.getMatrix());

        Dijkstra <DirectedWeightedGraph> myDij = new Dijkstra<DirectedWeightedGraph>(myGraph, this);
        myDij.start(0);

    }

    public static void main(String args[]){

        launch(args);
    }
}
