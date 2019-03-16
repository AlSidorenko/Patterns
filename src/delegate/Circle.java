package delegate;

/**
 * Created on 13.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Circle implements Graphics {

    @Override
    public void draw() {
        System.out.println("Draw a Circle.");
    }
}
