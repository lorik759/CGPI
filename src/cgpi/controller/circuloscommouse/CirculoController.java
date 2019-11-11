package cgpi.controller.circuloscommouse;

import cgpi.vtec.controllers.AbstractDesenhoController;

/**
 * @author Douglas.cavalcanti
 */

public class CirculoController extends AbstractDesenhoController<CirculoModel> {

    @Override
    protected CirculoModel createModel() {
        return new CirculoModel();
    }
}
