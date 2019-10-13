package cgpi.vtec.control;

import javafx.scene.control.Button;

/**
 * @author vitor.alves
 */
public class DrawingButton extends Button {

    private DrawingType drawingType;

    public DrawingType getDrawingType() {
        return drawingType;
    }

    public void setDrawingType(DrawingType drawingType) {
        this.drawingType = drawingType;
    }
}
