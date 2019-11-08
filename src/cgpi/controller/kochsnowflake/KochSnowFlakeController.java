package cgpi.controller.kochsnowflake;

import cgpi.controller.AbstractController;
import cgpi.vtec.Inicializavel;

/**
 * @author vitor.alves
 */
public class KochSnowFlakeController extends AbstractController<KochSnowFlakeModel> implements Inicializavel {

    @Override
    public void inicialize() {
    }

    @Override
    protected KochSnowFlakeModel createModel() {
        return new KochSnowFlakeModel();
    }
}
