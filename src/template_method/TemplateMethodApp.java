package template_method;

/**
 * Created on 01.05.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class TemplateMethodApp {

    public static void main(String[] args) {
        C a = new A();
        a.templateMethod();
        System.out.println();
        C b = new B();
        b.templateMethod();
    }
}

abstract class C {
    void templateMethod() {
        System.out.print("1");
        different();
        System.out.print("3");
        different2();
    }
    abstract void different();
    abstract void different2();
}

class A extends C {
    @Override
    void different() {
        System.out.print("2");
    }
    @Override
    void different2() {
        System.out.print("5");
    }
}

class B extends C {
    @Override
    void different() {
        System.out.print("4");
    }

    @Override
    void different2() {
    }
}