package visitor;

/**
 * Created on 02.05.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class VisitorApp {

    public static void main(String[] args) {
        /*Element body = new BodyElement();
        Element engine = new EngineElement();
        //Visitor hooligan = new HooluganVisitor();
        Visitor mechanic = new MechanicVisitor();

        //body.accept(hooligan);
        //engine.accept(hooligan);
        body.accept(mechanic);
        engine.accept(mechanic);*/

        Element car = new CarElement();
        car.accept(new HooluganVisitor());

        System.out.println();
        car.accept(new MechanicVisitor());
    }
}

//Visitor
interface Visitor {
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(CarElement car);
    void visit(WheelElement wheel);
}

//Элемент
interface Element {
    void accept(Visitor visitor);
}

//Кузов
class BodyElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//Двигатель
class EngineElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//Колесо
class WheelElement implements Element {
    String name;
    public WheelElement(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element {
    Element[] elements;
    public CarElement() {
        this.elements = new Element[] {new WheelElement("front left"),
            new WheelElement("front right"), new WheelElement("rear left"),
            new WheelElement("rear right"), new BodyElement(), new EngineElement()};
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }
}
class HooluganVisitor implements Visitor {
    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Push " + wheel.getName() + " wheel");
    }
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Started the engine");
    }
    @Override
    public void visit(BodyElement body) {
        System.out.println("Knocked on the body");
    }
    @Override
    public void visit(CarElement car) {
        System.out.println("Smoked inside the car");
    }
}

class MechanicVisitor implements Visitor {
    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Pumped up " + wheel.getName() + " wheel");
    }
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Checked engine");
    }
    @Override
    public void visit(BodyElement body) {
        System.out.println("Polished body");
    }
    @Override
    public void visit(CarElement car) {
        System.out.println("Checked the appearance of the car");
    }
}