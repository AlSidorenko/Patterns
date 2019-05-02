package iterator;

/**
 * Created on 02.05.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class IteratorApp {

    public static void main(String[] args) {
        Tasks c = new Tasks();
        Iterator it = c.getIterator();

        while (it.hasNext()) {
            System.out.println((String) it.next());
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator getIterator();
}

class Tasks implements Container {
    String[] tasks = {"To build a house", "Give birth to a son", "To plant a tree"};
    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }
    private class TaskIterator implements Iterator {
        int index = 0;
        @Override
        public boolean hasNext() {
            if (index < tasks.length) {
                return true;
            }
            return false;
        }
        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}