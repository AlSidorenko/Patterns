package singleton;

/**
 * Created on 02.05.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class SingletonApp {

    public static void main(String[] args) throws InterruptedException {

        final int SIZE = 1000;

        /*Singleton[] arr = new Singleton[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = Singleton.getInstance();
        }*/

        Thread[] t = new Thread[SIZE];
        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            t[i].join();
        }
        System.out.println(Singleton.counter);
    }
}

class R implements Runnable {
    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton {
    public static int counter = 0;
    //private static Singleton instance = new Singleton();
    private static volatile Singleton instance = null;
    private Singleton() {
        counter++;
    }

    /*public static Singleton getInstance() {
        return instance;
    }*/

    /*public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }*/

    /*public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }*/

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}