package cgpi.vtec.exporter;

import cgpi.figuras.model.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * @author vitor.alves
 */
public class XmlDesenhoExporter implements Exporter {

    private Desenho desenho;

    private Canvas canvas;

    public XmlDesenhoExporter(Desenho desenho, Canvas canvas) {
        this.desenho = desenho;
        this.canvas = canvas;
    }

    public void setDesenho(Desenho desenho) {
        this.desenho = desenho;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void export() {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("FIGURAS");
            doc.appendChild(rootElement);

            createRetas(doc, rootElement);

            createCirculos(doc, rootElement);

            createRetangulos(doc, rootElement);

            createPoliganos(doc, rootElement);

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("figuras.xml"));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(source, result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createPoliganos(Document doc, Element rootElement) {
        for (Poligano poligano : desenho.getPoliganos()) {
            Element poliganosTag = doc.createElement("Poliganos");

            for (Reta reta : poligano.getRetas()) {

                createPontoTag(doc, poliganosTag, reta.getPointA(), canvas.getWidth(), canvas.getHeight());


                createPontoTag(doc, poliganosTag, reta.getPointB(), canvas.getWidth(), canvas.getHeight());
            }


            rootElement.appendChild(poliganosTag);
        }
    }

    private void createPontoTag(Document doc, Element tag, Ponto pointA, double width, double height) {
        Element pontoTag = doc.createElement("Ponto");
        createPonto(doc, tag, pontoTag, "x", getPorporcao(pointA.getX(), width));
        createPonto(doc, tag, pontoTag, "y", getPorporcao(pointA.getY(), height));
    }

    private void createRetangulos(Document doc, Element rootElement) {
        for (Retangulo retangulo : desenho.getRetangulos()) {
            Element retanguloTag = doc.createElement("Retangulos");

            createPontoTag(doc, retanguloTag, retangulo.getPointA(), canvas.getHeight(), canvas.getWidth());


            createPontoTag(doc, retanguloTag, retangulo.getPointB(), canvas.getWidth(), canvas.getHeight());

            Element cor = doc.createElement("Cor");
            Color color = retangulo.getColor();
            createColor(doc, retanguloTag, cor, "R", (int) color.getRed());
            createColor(doc, retanguloTag, cor, "G", (int) color.getGreen());
            createColor(doc, retanguloTag, cor, "B", (int) color.getBlue());

            rootElement.appendChild(retanguloTag);
        }
    }

    private void createCirculos(Document doc, Element rootElement) {
        for (Circulo circulo : desenho.getCirculos()) {
            Element circuloTag = doc.createElement("Circulo");

            createPontoTag(doc, circuloTag, circulo.getCentro(), canvas.getWidth(), canvas.getHeight());

            createRaio(doc, circuloTag, circulo.getRaio());

            Element cor = doc.createElement("Cor");
            Color color = circulo.getColor();
            createColor(doc, circuloTag, cor, "R", (int) color.getRed());
            createColor(doc, circuloTag, cor, "G", (int) color.getGreen());
            createColor(doc, circuloTag, cor, "B", (int) color.getBlue());

            rootElement.appendChild(circuloTag);
        }
    }

    private void createRetas(Document doc, Element rootElement) {
        for (Reta reta : desenho.getRetas()) {
            Element retaTag = doc.createElement("Reta");

            createPontoTag(doc, retaTag, reta.getPointA(), canvas.getWidth(), canvas.getHeight());


            createPontoTag(doc, retaTag, reta.getPointB(), canvas.getWidth(), canvas.getHeight());

            Element cor = doc.createElement("Cor");
            Color color = reta.getColor();
            createColor(doc, retaTag, cor, "R", (int) color.getRed());
            createColor(doc, retaTag, cor, "G", (int) color.getGreen());
            createColor(doc, retaTag, cor, "B", (int) color.getBlue());

            rootElement.appendChild(retaTag);
        }
    }

    private double getPorporcao(double valeu, double width) {
        return valeu / width;
    }

    private void createPonto(Document doc, Element retaTag, Element retaPonto, String point, double value) {
        Element ponto = doc.createElement(point);
        ponto.setTextContent(String.valueOf(value));
        retaPonto.appendChild(ponto);
        retaTag.appendChild(retaPonto);
    }

    private void createColor(Document doc, Element retaTag, Element retaCor, String colorType, int value) {
        Element cor = doc.createElement(colorType);
        cor.setTextContent(String.valueOf(value));
        retaCor.appendChild(cor);
        retaTag.appendChild(retaCor);
    }

    private void createRaio(Document doc, Element retaTag, double value) {
        Element raio = doc.createElement("Raio");
        raio.setTextContent(String.valueOf(value));
        retaTag.appendChild(raio);
    }
}
