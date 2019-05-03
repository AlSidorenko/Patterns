package bridge;

/**
 * Created on 03.05.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class BridgeApp {

    public static void main(String[] args) {
        CarR c = new Sedan(new Kia());
        c.showDetails();
        System.out.println();
        CarR c1 = new Hatchback(new Skoda());
        c1.showDetails();
        System.out.println();
        CarR c2 = new Coupe(new Mercedes());
        c2.showDetails();
    }
}

abstract class CarR {
    Make make;

    public CarR(Make make) {
        this.make = make;
    }
    abstract void showType();
    void showDetails() {
        showType();
        make.setMake();
    }
}

class Sedan extends CarR {
    public Sedan(Make make) {
        super(make);
    }
    void showType() {
        System.out.println("Sedan");
    }
}

class Hatchback extends CarR {
    public Hatchback(Make make) {
        super(make);
    }
    void showType() {
        System.out.println("Hatchback");
    }
}

class Coupe extends CarR {
    public Coupe(Make make) {
        super(make);
    }
    void showType() {
        System.out.println("Coupe");
    }
}

interface Make {
    void setMake();
}

class Kia implements Make {
    @Override
    public void setMake() {
        System.out.println("Kia");
    }
}

class Skoda implements Make {
    @Override
    public void setMake() {
        System.out.println("Skoda");
    }
}

class Mercedes implements Make {
    @Override
    public void setMake() {
        System.out.println("Mercedes");
    }
}