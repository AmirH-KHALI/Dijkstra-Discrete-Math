import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    static Scanner input = new Scanner(System.in);

    private DirectedWeightedGraph myGraph;

    public static Group root;

    private int itemNumber = 1;

    public <T extends Group> void printShape(double itemNumber, T shape) {

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

        //itemNumber = 1;
        for (Circle circle : myGraph.getNodesFace()) {

            root.getChildren().add(circle);
            //itemNumber++;

        }

//        for (Arrow arrow : myGraph.getEdgesFace()) {
//
//            //arrow.setFill(Color.RED);
//            root.getChildren().add(arrow);
//            //itemNumber++;
//
//        }

        for (Text val : myGraph.getEdgesValFace()) {

            //root.getChildren().add(val);
            //itemNumber++;

        }


    }

    public void showDij(ArrayList<Edges> edgeWalk) {

        for (Edges edge : edgeWalk) {

            Arrow arrow = edge.getFace();

            Text val = edge.getValFace();

            //root.getChildren().add(arrow);

            arrow.setFill(Color.RED);
            printShape(itemNumber, arrow);
            itemNumber++;
            printShape(itemNumber, val);
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

        Dijkstra myDij = new Dijkstra(myGraph);
        ArrayList<Edges> edgeWalk = myDij.doDijkstra(0);

        showDij(edgeWalk);

        primaryStage.show();

    }

    public static void main(String args[]){

        launch(args);
    }

}
