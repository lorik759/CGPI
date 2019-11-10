package cgpi.controller.kochsnowflake;

import cgpi.figuras.model.Desenho;
import cgpi.vtec.annotation.OnMouseClick;
import cgpi.vtec.annotation.TextField;

/**
 * @author vitor.alves
 */
public class KochSnowFlakeModel {

    private String level;

    private Desenho desenho;

    public Desenho getDesenho() {
        return desenho;
    }

    @OnMouseClick(value = "desenhoButton", event = KochSnowFlakeEvent.class)
    public void setDesenho(Desenho desenho) {
        this.desenho = desenho;
    }

    public String getLevel() {
        return level;
    }

    @TextField("level")
    public void setLevel(String level) {
        this.level = level;
    }
}
