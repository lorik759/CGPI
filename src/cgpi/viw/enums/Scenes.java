package cgpi.viw.enums;

/**
 * @author vitor.alves
 */
public enum Scenes {

  MAIN("/cgpi/viw/scene/MainView.fxml"),
  KOCH_SNOW_FLAKE("/cgpi/viw/scene/KochSnowFlakeView.fxml");

  private final String location;

  Scenes(String location) {
    this.location = location;
  }

  public String getLocation() {
    return this.location;
  }
}
