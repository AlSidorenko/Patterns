package abstract_factory;

/**
 * Created on 25.04.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class AbstractFactoryApp {

    public static void main(String[] args) {

        DeviceFactory factory = getFactoryByCountryCode("EN");
        Mouse    m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        TouchPad t = factory.getTouchPad();

        m.click();
        k.print();
        k.println();
        t.track(10, 35);
    }
    private static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
                default:
                    throw new RuntimeException("Unsupported country code: " + lang);
        }
    }
}

interface Mouse {
    void click();
    void dblclick();
    void scroll(int direction);
}

interface Keyboard {
    void print();
    void println();
}

interface TouchPad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    TouchPad getTouchPad();
}

class RuMouse implements Mouse {
    public void click() { System.out.println("Щелчок мышью"); }
    public void dblclick() { System.out.println("Двойной щелчок мышью."); }
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Скроллим верх");
        } else if (direction < 0) {
            System.out.println("Скроллим вниз");
        } else {
            System.out.println("Не скролим");
        }
    }
}

class RuKeyboard implements Keyboard {
    public void print() { System.out.println("Печатаем строку"); }
    public void println() { System.out.println("Печатаем строку с переводом строки"); }
}

class RuTouchPad implements TouchPad {
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + s + " пикселей");
    }
}

class EnMouse implements Mouse {
    public void click() { System.out.println("Click mouse"); }
    public void dblclick() { System.out.println("Double click mouse"); }
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Scroll up");
        } else if (direction < 0) {
            System.out.println("Scroll down");
        } else {
            System.out.println("Not scrolling");
        }
    }
}

class EnKeyboard implements Keyboard {
    public void print() { System.out.println("Print line"); }
    public void println() { System.out.println("Print line with string feed"); }
}

class EnTouchPad implements TouchPad {
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved by " + s + " pixels");
    }
}

class EnDeviceFactory implements DeviceFactory {
    public Mouse getMouse() {
        return new EnMouse();
    }
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }
    public TouchPad getTouchPad() {
        return new EnTouchPad();
    }
}

class RuDeviceFactory implements DeviceFactory {
    public Mouse getMouse() {
        return new RuMouse();
    }
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }
    public TouchPad getTouchPad() {
        return new RuTouchPad();
    }
}