package cgpi.view.enums;

/**
 * @author vitor.alves
 */
public enum Scenes {

  MAIN("/cgpi/view/scene/MainView.fxml", "Main"),
  KOCH_SNOW_FLAKE("/cgpi/view/scene/KochSnowFlakeView.fxml", "KochSnowFlake"),
  RETA_COM_MOUSE("/cgpi/view/scene/RetaComMouseView.fxml", "Reta"),
  CIRCULO("/cgpi/view/scene/CirculoView.fxml", "Circulo"),
  RETANGULO_COM_MOUSE("/cgpi/view/scene/RetanguloView.fxml", "Retangulo"),
  POLIGANO_COM_MOUSE("/cgpi/view/scene/PoliganoViw.fxml", "Poligano");


  private final String location;

  private final String titel;

  Scenes(String location, String titel) {
    this.location = location;
    this.titel = titel;
  }

  public String getLocation() {
    return this.location;
  }

  public String getTitel() {
    return titel;
  }
}
