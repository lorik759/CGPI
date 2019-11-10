package cgpi.controller.kochsnowflake;

import cgpi.controller.AbstractController;

/**
 * @author vitor.alves
 */
public class KochSnowFlakeController extends AbstractController<KochSnowFlakeModel> {

    @Override
    protected KochSnowFlakeModel createModel() {
        return new KochSnowFlakeModel();
    }
}
