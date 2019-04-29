package adapter;

/**
 * Created on 29.04.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class AdapterApp {

    public static void main(String[] args) {
        // 1-й способ через наследование.
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();
        // 2-й способ через композицию.
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster();
        g2.drawLine();
        g2.drawSquare();
    }
}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Draw line");
    }
    void drawRasterSquare() {
        System.out.println("Draw square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {
    @Override
    public void drawLine() {
        drawRasterLine();
    }
    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    RasterGraphics raster = new RasterGraphics();
    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }
    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}