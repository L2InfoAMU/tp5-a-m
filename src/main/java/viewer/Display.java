package viewer;

import image.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Arnaud Labourel on 04/10/2018.
 */
public class Display implements Initializable {
    @FXML
    private Canvas canvas;

    private Image image;
    private ImageFactory imageFactory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Brute Image
        //imageFactory = new RasterUniformImageFactory(200, 200, Color.RED, RasterImageType.BRUTE);
        //imageFactory = new RasterFlagFactory(900, 600, Color.BLUE, Color.WHITE, Color.RED, RasterImageType.BRUTE);

        // Palette Image
        //imageFactory = new RasterUniformImageFactory(200, 200, Color.RED, RasterImageType.PALETTE);
        //imageFactory = new RasterFlagFactory(900, 600, Color.BLUE, Color.WHITE, Color.RED, RasterImageType.PALETTE);

        // SparseRaster Image
        //imageFactory = new RasterUniformImageFactory(200, 200, Color.RED, RasterImageType.SPARSE);
        //imageFactory = new RasterFlagFactory(900, 600, Color.BLUE, Color.WHITE, Color.RED, RasterImageType.SPARSE);

        // Display From imageFactory
        //this.image = imageFactory.makeImage();

        // Display from test file for VectorImage
        this.image = new LogoLISFactory().makeImage();

        render();
    }

    private void render() {
        int pixelWidth = image.getWidth();
        int pixelHeight = image.getHeight();

        canvas.setWidth(pixelWidth);
        canvas.setHeight(pixelHeight);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int i = 0; i < pixelWidth; i++) {
            for (int j = 0; j < pixelHeight; j++) {
                renderPixel(i, j, pixelWriter);
            }
        }
    }

    private void renderPixel(int x, int y, PixelWriter pixelWriter) {
        pixelWriter.setColor(x, y, image.getPixelColor(x, y));
    }

}
