package flyweight;

import java.util.*;

/**
 * Created on 02.05.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class FlyweightApp {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shape> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getShapes("square"));
        shapes.add(shapeFactory.getShapes("circle"));
        shapes.add(shapeFactory.getShapes("circle"));
        shapes.add(shapeFactory.getShapes("point"));
        shapes.add(shapeFactory.getShapes("square"));
        shapes.add(shapeFactory.getShapes("circle"));

        Random rand = new Random();
        for (Shape shape : shapes) {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape.draw(x, y);
        }
    }
}
//Flyweight
interface Shape {
    void draw(int x, int y);
}
//Point Flyweight
class Point implements Shape {
    @Override
    public void draw(int x, int y) {
        System.out.println("("+x+","+y+"): drawing point ");
    }
}
//Circle Flyweight
class Circle implements Shape {
    int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + ","+y+"): drawing circle with radius " + r);
    }
}
//Square Flyweight
class Square implements Shape {
    int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("(" + x + ","+y+"): drawing square with side of the square " + a);
    }
}

class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap<>();

    public Shape getShapes(String shapeName) {
        Shape shape = shapes.get(shapeName);
        if (shape == null) {
            switch (shapeName) {
                case "circle":
                    shape = new Circle();
                    break;
                case "square":
                    shape = new Square();
                    break;
                case "point":
                    shape = new Point();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}