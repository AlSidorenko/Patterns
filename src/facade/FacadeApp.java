package facade;

/**
 * Created on 16.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class FacadeApp {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer {

    Power power = new Power();
    DVDRoom dvd = new DVDRoom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        //dvd.unLoad();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("Electricity ON.");
    }
    void off() {
        System.out.println("Electricity OFF.");
    }
}

class DVDRoom {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }
    void load() {
        data = true;
    }
    void unLoad() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRoom dvd) {
        if (dvd.hasData()) {
            System.out.println("Copying data.");
        } else {
            System.out.println("Insert a data disc.");
        }
    }
}