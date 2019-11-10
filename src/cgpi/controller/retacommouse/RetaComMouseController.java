package cgpi.controller.retacommouse;

import cgpi.controller.AbstractController;
import com.sun.xml.internal.ws.developer.UsesJAXBContext;

/**
 * @author vitor.alves
 */
public class RetaComMouseController extends AbstractController<RetaComMouseModel> {


    @Override
    protected RetaComMouseModel createModel() {
        return new RetaComMouseModel();
    }
}
