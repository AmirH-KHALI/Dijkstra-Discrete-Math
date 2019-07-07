import javafx.scene.shape.Circle;

public class Nodes {

    private boolean mark = false;
    private int distToRoot = 1000000000;
    private Circle myFace;

    public Nodes (double x, double y) {

        myFace = new Circle();

        myFace.setCenterX(x);
        myFace.setCenterY(y);
        myFace.setRadius(7);

    }

    public Circle getFace () {
        return myFace;
    }

}
