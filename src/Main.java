import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    static Scanner input = new Scanner(System.in);

    private DirectedWeightedGraph myGraph;

    private Group root;

    public <T extends Shape> void printShape(double itemNumber, T shape) {

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {

                double delta = (currentNanoTime - startNanoTime) / 1000000000.0;

                if (delta > itemNumber/3) {

                    root.getChildren().add(shape);
                    stop();

                }

            }
        }.start();

    }

    public void createMyGraph () throws Exception {

        int numberOfVertex;
        int numberOfEdge;
        int itemNumber;

        numberOfVertex = input.nextInt();
        numberOfEdge = input.nextInt();

        myGraph = new DirectedWeightedGraph(numberOfVertex);


        for (int i = 0; i < numberOfEdge; i++){

            int st, en, wei;
            st = input.nextInt();
            en = input.nextInt();
            wei = input.nextInt();
            myGraph.addEdge(st, en, wei);

        }

        itemNumber = 1;
        for (Circle circle : myGraph.getNodesFace()) {

            printShape(itemNumber, circle);
            itemNumber++;

        }

        for (Line line : myGraph.getEdgesFace()) {

            printShape(itemNumber, line);
            itemNumber++;

        }


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Discrete Math final project - Discrete");

        root = new Group();

        Scene scene = new Scene(root,1000, 700);

        primaryStage.setScene(scene);

        createMyGraph();

//        Dijkstra<DirectedWeightedGraph> myDij = new Dijkstra<DirectedWeightedGraph>(myGraph, this);
//        myDij.start(0);

        primaryStage.show();

    }

    public static void main(String args[]){

        launch(args);
    }

}
