package factory;

import java.util.Date;

/**
 * Created on 18.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class FactoryMethodApp {

    public static void main(String[] args) {
        //Watch watch = new DigitalWatch();
        //Watch watch = new RomeWatch();
        //watch.showTime();

        WatchMaker maker = getMakerByName("Digital");
        //WatchMaker maker = new DigitalWatchMaker();
        //WatchMaker maker = new RomeWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String maker) {
        if (maker.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if (maker.equals("Rome")) {
            return new RomeWatchMaker();
        } else {
            throw new RuntimeException("No production line." + maker);
        }
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}