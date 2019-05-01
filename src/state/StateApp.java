package state;

/**
 * Created on 01.05.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class StateApp {

    public static void main(String[] args) {
        /*Station dfm = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(dfm);

        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }*/

        Human human = new Human();
        human.setState(new Work());

        for (int i = 0; i < 6; i++) {
            human.doSomething();
        }
    }
}
//Context
class Human {
    private Activity state;
    public void setState(Activity state) {
        this.state = state;
    }
    public void doSomething() {
        state.doSomething(this);
    }
}
//State
interface Activity {
    void doSomething(Human context);
}

class Work implements Activity {
    @Override
    public void doSomething(Human context) {
        System.out.println("Working!!!!");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity {
    private int count = 0;
    @Override
    public void doSomething(Human context) {
        //System.out.println("Relax!!!");
        //context.setState(new Work());
        if (count < 3) {
            System.out.println("Relax!!!");
            count++;
        } else {
            context.setState(new Work());
        }
    }
}

//State
interface Station {
    void play();
}

class Radio7 implements Station {
    @Override
    public void play() {
        System.out.println("Radio7 ... ");
    }
}

class RadioDFM implements Station {
    @Override
    public void play() {
        System.out.println("Radio DFM ... ");
    }
}

class VestiFM implements Station {
    @Override
    public void play() {
        System.out.println("Vesti FM ... ");
    }
}
//Context
class Radio {
    Station station;
    void setStation(Station st) {
        station = st;
    }
    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        } else if (station instanceof RadioDFM) {
            setStation(new VestiFM());
        } else if (station instanceof VestiFM) {
            setStation(new Radio7());
        }
    }
    void play() {
        station.play();
    }
}