import javafx.scene.shape.Line;

public class Edges extends Line {

    private int weight;
    private Nodes start;
    private Nodes end;
    private boolean mark = false;
    private Line myFace;

    public Edges (Nodes start, Nodes end, int value) {

        myFace = new Line();

        this.start = start;
        this.end = end;
        weight = value;

        myFace.setStartX(start.getFace().getCenterX());
        myFace.setStartY(start.getFace().getCenterY());
        myFace.setEndX(end.getFace().getCenterX());
        myFace.setEndY(end.getFace().getCenterY());
    }

    public Line getFace () {
        return myFace;
    }

}
