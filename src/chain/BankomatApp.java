package chain;

/**
 * Created on 30.04.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class BankomatApp {

    public static void main(String[] args) {
        NoteModule note500 = new NoteModule500();
        NoteModule note200 = new NoteModule200();
        NoteModule note100 = new NoteModule100();
        NoteModule note50 = new NoteModule50();
        note500.setNextMoneyModule(note200);
        note200.setNextMoneyModule(note100);
        note100.setNextMoneyModule(note50);

        note500.takeMoney(new Money(5_850));
    }
}

class Note {
    public static final int R50 = 50;
    public static final int R100 = 100;
    public static final int R200 = 200;
    public static final int R500 = 500;
}

class Money {
    private int amt;

    public Money(int amt) {
        this.amt = amt;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        if (amt > 0 && amt <= 200_000 && amt % Note.R50 == 0) {
            this.amt = amt;
        } else {
            throw new RuntimeException("Сумма должнп быть не более 100_000 и кратна 100");
        }
    }
}

abstract class NoteModule {

    protected NoteModule next;

    abstract void takeMoney(Money money);

    void setNextMoneyModule(NoteModule module) {
        next = module;
    }
}

class NoteModule500 extends NoteModule {
    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt() / Note.R500;
        int remind = money.getAmt() % Note.R500;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.R500);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule200 extends NoteModule {
    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt() / Note.R200;
        int remind = money.getAmt() % Note.R200;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.R200);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule100 extends NoteModule {
    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt() / Note.R100;
        int remind = money.getAmt() % Note.R100;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.R100);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}

class NoteModule50 extends NoteModule {
    @Override
    void takeMoney(Money money) {
        int countNote = money.getAmt() / Note.R50;
        int remind = money.getAmt() % Note.R50;
        if (countNote > 0) {
            System.out.println("Выдано " + countNote + " купюр достоинством " + Note.R50);
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind));
        }
    }
}