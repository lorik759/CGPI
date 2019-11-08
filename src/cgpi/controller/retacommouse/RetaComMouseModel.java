package cgpi.controller.retacommouse;

import cgpi.figuras.model.Desenho;
import cgpi.vtec.annotation.OnMouseClick;
import cgpi.vtec.events.RetaComMouseEvent;

/**
 * @author vitor.alves
 */
public class RetaComMouseModel {

    private Desenho desenho;

    public Desenho getDesenho() {
        return desenho;
    }

    @OnMouseClick(value = "canvas", event = RetaComMouseEvent.class)
    public void setDesenho(Desenho desenho) {
        this.desenho = desenho;
    }
}
