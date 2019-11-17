package cgpi.controller.retangulocommouse;

import cgpi.vtec.controllers.AbstractDesenhoController;

/**
 * @author vitor.alves
 */
public class RetanguloController extends AbstractDesenhoController<RetanguloModel> {

    @Override
    protected RetanguloModel createModel() {
        return new RetanguloModel();
    }
}
