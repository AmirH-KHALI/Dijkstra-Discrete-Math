import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Nodes {

    private boolean mark = false;
    private int distToRoot = 1000000000;

    private Circle myFace;

    private Text num;

    public Nodes (double x, double y, int num) {

        this.num = new Text(Integer.toString(num));
        this.num.setX(x - 5);
        this.num.setY(y + 5);
        this.num.setStroke(Color.BLACK);
        this.num.setFill(Color.BLACK);
        this.num.toFront();

        myFace = new Circle();

        myFace.setFill(Color.WHITE);

        myFace.setCenterX(x);
        myFace.setCenterY(y);
        myFace.setRadius(10);

    }

    public Circle getFace () {
        return myFace;
    }

    public Text getNumFace () {
        return num;
    }
}
