package delegate;

/**
 * Created on 13.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Painter {

    Graphics graphics;

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void draw() {
        graphics.draw();
    }
}
