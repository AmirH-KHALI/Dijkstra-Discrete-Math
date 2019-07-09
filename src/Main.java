import com.sun.javafx.geom.Edge;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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

    public static Pane root;

    private int itemNumber = 1;

    public <T extends Group> void printShape(double itemNumber, T shape, T rShape) {

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {

                double delta = (currentNanoTime - startNanoTime) / 1000000000.0;

                if (delta > itemNumber/3) {

                    root.getChildren().remove(rShape);
                    root.getChildren().add(shape);
                    fixTopShaps();
                    stop();

                }

            }
        }.start();

    }

    public <T extends Shape> void printShape(double itemNumber, T shape, T rShape) {

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {

                double delta = (currentNanoTime - startNanoTime) / 1000000000.0;

                if (delta > itemNumber/3) {

                    root.getChildren().remove(rShape);
                    root.getChildren().add(shape);
                    fixTopShaps();
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

        for (Arrow arrow : myGraph.getEdgesFace()) {

            //arrow.setFill(Color.RED);
            root.getChildren().add(arrow);
            //itemNumber++;

        }

        for (Text val : myGraph.getEdgesValFace()) {

            root.getChildren().add(val);
            //itemNumber++;

        }

        for (Circle circle : myGraph.getNodesFace()) {

            root.getChildren().add(circle);
            //itemNumber++;

        }

        for (Text num : myGraph.getNodesNumFace()) {
            root.getChildren().add(num);
        }


    }

    public void fixTopShaps () {

        for (Circle circle : myGraph.getNodesFace()) {

            circle.toFront();

        }

        for (Text num : myGraph.getNodesNumFace()) {

            num.toFront();

        }

    }

    public void showDij(ArrayList<Edges> edgeWalk, ArrayList<Integer> dist) {

        itemNumber = 4;

        int i = 0;

        Text valueFace;

        valueFace = new Text(Integer.toString(0));
        valueFace.setStroke(Color.GREEN);
        valueFace.setFill(Color.GREEN);
        valueFace.setX(myGraph.getNodesFace().get(0).getCenterX() - 5);
        valueFace.setY(myGraph.getNodesFace().get(0).getCenterY() - 15);
        root.getChildren().add(valueFace);


        for (Edges edge : edgeWalk) {

            Edges e = new Edges(edge.getFirstNode(), edge.getSecondNode(), edge.getVal());

            valueFace = new Text(Integer.toString(dist.get(i)));
            valueFace.setStroke(Color.GREEN);
            valueFace.setFill(Color.GREEN);
            valueFace.setX(e.getSecondNode().getFace().getCenterX() - 5);
            valueFace.setY(e.getSecondNode().getFace().getCenterY() - 15);

            Arrow arrow = e.getFace();

            Text val = e.getValFace();

            //root.getChildren().add(arrow);

            arrow.setFill(Color.rgb(238, 237, 73));
            printShape(itemNumber, arrow, edge.getFace());
            //itemNumber++;
            printShape(itemNumber, val, edge.getValFace());
            printShape(itemNumber, valueFace, null);
            itemNumber += 4;

            i++;

        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Discrete Math final project - Discrete");

        root = new Pane();
        root.setStyle("-fx-background-color:RGB(238, 73, 74)");
//        root.setStyle("-fx-background-color:RGB(158,158,158)");

        Scene scene = new Scene(root,1000, 700);

        primaryStage.setScene(scene);

        createMyGraph();

        Dijkstra myDij = new Dijkstra(myGraph);
        ArrayList<Edges> edgeWalk = myDij.doDijkstra(0);

        ArrayList<Integer> dist = myDij.getDist();

        showDij(edgeWalk, dist);

        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();

    }

    public static void main(String args[]){

        launch(args);
    }

}
