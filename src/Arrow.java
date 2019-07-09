import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;


public class Arrow extends Group {

    private final Line mainLine;
    private final Line arrowLine1;
    private final Line arrowLine2;


    public Arrow() {
        this(new Line(), new Line(), new Line());
    }

    private static final double arrowLength = 20;
    private static final double arrowWidth = 7;

    private Arrow(Line line, Line arrow1, Line arrow2) {
        super(line, arrow1, arrow2);
        this.mainLine = line;
        this.arrowLine1 = arrow1;
        this.arrowLine2 = arrow2;

        InvalidationListener updater = o -> {
            double ex = getEndX();
            double ey = getEndY();
            double sx = getStartX();
            double sy = getStartY();

            arrow1.setEndX(ex);
            arrow1.setEndY(ey);
            arrow2.setEndX(ex);
            arrow2.setEndY(ey);

            if (ex == sx && ey == sy) {
                // arrow parts of length 0
                arrow1.setStartX(ex);
                arrow1.setStartY(ey);
                arrow2.setStartX(ex);
                arrow2.setStartY(ey);
            } else {
                double factor = arrowLength / Math.hypot(sx-ex, sy-ey);
                double factorO = arrowWidth / Math.hypot(sx-ex, sy-ey);

                // part in direction of main line
                double dx = (sx - ex) * factor;
                double dy = (sy - ey) * factor;

                // part ortogonal to main line
                double ox = (sx - ex) * factorO;
                double oy = (sy - ey) * factorO;

                arrow1.setStartX(ex + dx - oy);
                arrow1.setStartY(ey + dy + ox);
                arrow2.setStartX(ex + dx + oy);
                arrow2.setStartY(ey + dy - ox);
            }
        };

        // add updater to properties
        startXProperty().addListener(updater);
        startYProperty().addListener(updater);
        endXProperty().addListener(updater);
        endYProperty().addListener(updater);
        updater.invalidated(null);
    }

    // start/end properties

    public final void setStartX(double value) {
        mainLine.setStartX(value);
    }

    public final double getStartX() {
        return mainLine.getStartX();
    }

    public final DoubleProperty startXProperty() { return mainLine.startXProperty(); }

    public final void setStartY(double value) {
        mainLine.setStartY(value);
    }

    public final double getStartY() {
        return mainLine.getStartY();
    }

    public final DoubleProperty startYProperty() {
        return mainLine.startYProperty();
    }

    public final void setEndX(double value) {
        mainLine.setEndX(value);
    }

    public final double getEndX() {
        return mainLine.getEndX();
    }

    public final DoubleProperty endXProperty() {
        return mainLine.endXProperty();
    }

    public final void setEndY(double value) {
        mainLine.setEndY(value);
    }

    public final double getEndY() {
        return mainLine.getEndY();
    }

    public final DoubleProperty endYProperty() {
        return mainLine.endYProperty();
    }

    public final void setFill (Paint color) {
        mainLine.setFill(color);
        //arrowLine1.setFill(color);
        //arrowLine2.setFill(color);
    }

}