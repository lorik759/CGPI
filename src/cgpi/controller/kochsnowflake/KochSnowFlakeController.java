package cgpi.controller.kochsnowflake;

import cgpi.vtec.controllers.AbstractDesenhoController;

/**
 * @author vitor.alves
 */
public class KochSnowFlakeController extends AbstractDesenhoController<KochSnowFlakeModel> {

    @Override
    protected KochSnowFlakeModel createModel() {
        return new KochSnowFlakeModel();
    }
}
