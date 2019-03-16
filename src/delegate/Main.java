package delegate;

/**
 * Created on 13.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Main {

    public static void main(String[] args) {

        Painter painter = new Painter();

        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Triangle());
        painter.draw();
    }
}
