package observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 01.05.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class MeteoApp {

    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());

        station.setMeasurements(25, 760);
        station.setMeasurements(-5, 745);
    }
}

interface Observed {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserves();
}

class MeteoStation implements Observed {
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();
    public void setMeasurements(int t, int p) {
        temperature = t;
        pressure = p;
        notifyObserves();
    }
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObserves() {
        for (Observer observer : observers) {
            observer.handleEvent(temperature, pressure);
        }
    }
}
interface Observer {
    void handleEvent(int temp, int presser);
}
class ConsoleObserver implements Observer {
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.printf("The weather has changed. Temperature: %s, Pressure: %s.\n", temp, presser);
    }
}
class FileObserver implements Observer {
    @Override
    public void handleEvent(int temp, int presser) {
        File f;
        try {
            f = File.createTempFile("TempPressure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.printf("The weather has changed. Temperature: %s, Pressure: %s.\n", temp, presser);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}