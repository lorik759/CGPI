package cgpi.vtec.exporter;

import cgpi.figuras.actors.DesenhoActor;
import cgpi.figuras.model.*;
import cgpi.vtec.controllers.AbstractDesenhoController;
import cgpi.vtec.exception.VFXMLLoaderException;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static cgpi.figuras.DesenhoUtils.replicarDesenho;

/**
 * @author vitor.alves
 */
public class XmlDesenhoImporter implements Importer {

    private final Desenho desenho = new Desenho();

    private final DesenhoActor actor;

    private AbstractDesenhoController controller;

    private Canvas canvas;

    public XmlDesenhoImporter(AbstractDesenhoController controller) {
        this.controller = controller;
        this.canvas = (Canvas) controller.get("canvas");
        this.actor = new DesenhoActor(canvas.getGraphicsContext2D());
    }

    @Override
    public void importe() throws VFXMLLoaderException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select desenho");

        File xmlFile = fileChooser.showOpenDialog(new Stage());
        if (xmlFile.getName().contains(".xml")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            Document doc = null;
            try {
                builder = factory.newDocumentBuilder();
                doc = builder.parse(xmlFile);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            getRetas(doc);
            getCirculos(doc);
            getRetangulos(doc);
            getPoligono(doc);

            actor.desenhe(desenho);
            replicateEvent();
        } else {
            throw new VFXMLLoaderException("Arquivo selecionado nao e um xml");
        }
    }

    private void getRetangulos(Document doc) {
        NodeList retangulosNodeList = doc.getElementsByTagName("Retangulo");
        List<Ponto> pontos;
        Color color;
        for (int i = 0; i < retangulosNodeList.getLength(); i++) {
            Node retanguloNode = retangulosNodeList.item(i);
            if (retanguloNode.getNodeType() == Node.ELEMENT_NODE) {
                Element retanguloElemento = (Element) retanguloNode;
                NodeList pontosNode = retanguloElemento.getElementsByTagName("Ponto");

                pontos = getPontos(pontosNode);


                NodeList coresNode = retanguloElemento.getElementsByTagName("Cor");
                color = getColor(coresNode);
                desenho.addRetangulo(new Retangulo(pontos.get(0), pontos.get(1), color));
                pontos.clear();
            }
        }
    }

    private void getCirculos(Document doc) {
        NodeList circuloNodeList = doc.getElementsByTagName("Circulo");
        List<Ponto> pontos;
        Color color;
        for (int i = 0; i < circuloNodeList.getLength(); i++) {
            Node circuloNode = circuloNodeList.item(i);
            if (circuloNode.getNodeType() == Node.ELEMENT_NODE) {
                Element circuloElement = (Element) circuloNode;
                NodeList pontosNode = circuloElement.getElementsByTagName("Ponto");

                pontos = getPontos(pontosNode);

                String raio = circuloElement.getElementsByTagName("Raio").item(0).getTextContent();

                double raioTotal = Double.parseDouble(raio) * (canvas.getWidth());

                NodeList coresNode = circuloElement.getElementsByTagName("Cor");
                color = getColor(coresNode);
                desenho.addCirculo(new Circulo(pontos.get(0), raioTotal, color));
                pontos.clear();
            }
        }
    }

    private void getRetas(Document doc) {
        NodeList retaNodeList = doc.getElementsByTagName("Reta");
        List<Ponto> pontos;
        Color color;
        for (int i = 0; i < retaNodeList.getLength(); i++) {
            Node retaNode = retaNodeList.item(i);
            if (retaNode.getNodeType() == Node.ELEMENT_NODE) {
                Element retaElemento = (Element) retaNode;
                NodeList pontosNode = retaElemento.getElementsByTagName("Ponto");
                pontos = getPontos(pontosNode);

                NodeList coresNode = retaElemento.getElementsByTagName("Cor");
                color = getColor(coresNode);
                desenho.addReta(new Reta(pontos, color));
                pontos.clear();
            }
        }
    }

    private void getPoligono(Document doc) {
        List<Ponto> pontos;
        Color color;
        List<Reta> retas = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("Poligono");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node figureNode = nodeList.item(i);

            if (figureNode.getNodeType() == Node.ELEMENT_NODE) {
                Element figureElement = (Element) figureNode;

                NodeList pontosNode = figureElement.getElementsByTagName("Ponto");
                pontos = getPontos(pontosNode);

                NodeList coresNode = figureElement.getElementsByTagName("Cor");
                color = getColor(coresNode);
                for (int k = 0; k < pontos.size(); k++) {
                    if (k % 2 != 0) {
                        retas.add(new Reta(pontos.get(k), pontos.get(k - 1), color));
                    }
                }
                desenho.addPoligano(new Poligano(retas));
                retas.clear();
                pontos.clear();
            }
        }
    }

    private List<Ponto> getPontos(NodeList pontosNode) {
        List<Ponto> pontos = new ArrayList<>();
        for (int k = 0; k < pontosNode.getLength(); k++) {
            Element pontoElement = (Element) pontosNode.item(k);
            Node xFile = pontoElement.getElementsByTagName("x").item(0);
            double x = Double.parseDouble(xFile.getTextContent()) * canvas.getWidth();
            Node yFile = pontoElement.getElementsByTagName("y").item(0);
            double y = Double.parseDouble(yFile.getTextContent()) * canvas.getHeight();
            pontos.add(new Ponto(x, y));
        }
        return pontos;
    }

    private Color getColor(NodeList coresNode) {
        Color color = null;
        for (int k = 0; k < coresNode.getLength(); k++) {
            Element corElement = (Element) coresNode.item(k);

            Node rFile = corElement.getElementsByTagName("R").item(0);
            Integer red = Integer.parseInt(rFile.getTextContent());

            Node gFile = corElement.getElementsByTagName("G").item(0);
            Integer green = Integer.parseInt(gFile.getTextContent());

            Node bFile = corElement.getElementsByTagName("B").item(0);
            Integer blue = Integer.parseInt(bFile.getTextContent());
            color = Color.rgb(red, green, blue);
        }
        return color;
    }

    protected void replicateEvent() {
        replicarDesenho(controller, this.desenho);
    }
}
