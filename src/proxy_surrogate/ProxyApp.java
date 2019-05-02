package proxy_surrogate;

/**
 * Created on 02.05.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class ProxyApp {

    public static void main(String[] args) {
        //Image image = new RealImage("D:/images/my.jpg");
        Image image = new ProxyImage("D:/images/my.jpg");
        image.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    String file;
    public RealImage(String file) {
        this.file = file;
        load();
    }
    void load() {
        System.out.println("Load " + file);
    }
    @Override
    public void display() {
        System.out.println("View " + file);
    }
}

class ProxyImage implements Image {
    String file;
    RealImage image;
    public ProxyImage(String file) {
        this.file = file;
    }
    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(file);
        }
        image.display();
    }
}