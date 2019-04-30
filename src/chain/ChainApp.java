package chain;

/**
 * Created on 29.04.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class ChainApp {

    public static void main(String[] args) {
        Logger logger0 = new SMSLogger(Level.ERROR);
        Logger logger1 = new FileLogger(Level.DEBUG);
        Logger logger2 = new EmailLogger(Level.INFO);
        logger0.setNext(logger1);
        logger1.setNext(logger2);

        logger0.writeMessage("All right!", Level.INFO);
        logger0.writeMessage("Режим отладки", Level.DEBUG);
        logger0.writeMessage("Система упала", Level.ERROR);
    }
}
class Level {
    static final int ERROR = 1;
    static final int DEBUG = 2;
    static final int INFO = 3;
}
abstract class Logger {
    int priority;
    Logger(int priority) {
        this.priority = priority;
    }
    Logger next;
    void setNext(Logger next) {
        this.next = next;
    }
    void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
    abstract void write(String message);
}
class SMSLogger extends Logger {
    SMSLogger(int priority) {
        super(priority);
    }
    @Override
    void write(String message) {
        System.out.println("SMS: " + message);
    }
}
class FileLogger extends Logger {
    FileLogger(int priority) {
        super(priority);
    }
    @Override
    void write(String message) {
        System.out.println("Record into file: " + message);
    }
}
class EmailLogger extends Logger {
    EmailLogger(int priority) {
        super(priority);
    }
    @Override
    void write(String message) {
        System.out.println("E-mail message: " + message);
    }
}