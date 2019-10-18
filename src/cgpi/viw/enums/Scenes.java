package cgpi.viw.enums;

/**
 * @author vitor.alves
 */
public enum Scenes {

  MAIN("/cgpi/viw/scene/MainView.fxml"),
  KOCH_SNOW_FLAKE("/cgpi/viw/scene/KochSnowFlakeView.fxml"),
  Circulos_Retas("/cgpi/viw/scene/CirculosRetasView.fxml"),
  Reta("/cgpi/viw/scene/RetaView.fxml"),
  Retangulo("/cgpi/viw/scene/RetanguloView.fxml"),
  Circulo("/cgpi/viw/scene/CirculoView.fxml");


  private final String location;

  Scenes(String location) {
    this.location = location;
  }

  public String getLocation() {
    return this.location;
  }
}
