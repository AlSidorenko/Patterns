package prototype;

/**
 * Created on 26.04.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class PrototypeApp {

    public static void main(String[] args) {
        Humane origin = new Humane(18, "Basil");
        System.out.println(origin);

        Humane copy = (Humane) origin.copy();
        System.out.println(copy);

        HumanFactory factory = new HumanFactory(copy);
        Humane h1 = factory.makeCopy();
        System.out.println(h1);

        factory.setProperty(new Humane(30, "Valery"));
        Humane h2 = factory.makeCopy();
        System.out.println(h2);
    }
}

interface Copyable {
    Object copy();
}

class Humane implements Copyable {
    int age;
    String name;
    public Humane(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public Object copy() {
        Humane copy = new Humane(age, name);
        return copy;
    }
    @Override
    public String toString() {
        return "Humane{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class HumanFactory {
    Humane humane;
    public HumanFactory(Humane humane) {
        setProperty(humane);
    }
    public void setProperty(Humane humane) {
        this.humane = humane;
    }
    Humane makeCopy() {
        return (Humane) humane.copy();
    }
}