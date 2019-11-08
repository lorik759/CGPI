package cgpi.view.enums;

/**
 * @author vitor.alves
 */
public enum Scenes {

  MAIN("/cgpi/view/scene/MainView.fxml"),
  KOCH_SNOW_FLAKE("/cgpi/view/scene/KochSnowFlakeView.fxml"),
  RETA_COM_MOUSE("/cgpi/view/scene/RetaComMouseView.fxml");

  private final String location;

  Scenes(String location) {
    this.location = location;
  }

  public String getLocation() {
    return this.location;
  }
}
