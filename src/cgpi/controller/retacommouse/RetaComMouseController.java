package cgpi.controller.retacommouse;

import cgpi.vtec.controllers.AbstractDesenhoController;

/**
 * @author vitor.alves
 */
public class RetaComMouseController extends AbstractDesenhoController<RetaComMouseModel> {

    @Override
    protected RetaComMouseModel createModel() {
        return new RetaComMouseModel();
    }
}
