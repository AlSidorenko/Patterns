package strategy;

import java.util.Arrays;

/**
 * Created on 01.05.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class StrategyApp {

    public static void main(String[] args) {
        StrategyClient sc = new StrategyClient();

        int[] array0 = {2, 25, 8, 3};
        sc.setStrategy(new SelectionSort());
        sc.executeStrategy(array0);

        int[] array1 = {-2, 5, 80, 31};
        sc.setStrategy(new InsertingSort());
        sc.executeStrategy(array1);

        int[] array2 = {-25, -52, 180, 31};
        sc.setStrategy(new BabbleSort());
        sc.executeStrategy(array2);
    }
}
//Context
class StrategyClient {
    Sorting strategy;
    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}
//Strategy
interface Sorting {
    void sort(int[] arr);
}
//Babble sorting strategy.
class BabbleSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sorting.");
        System.out.println("Before:\t" + Arrays.toString(arr));
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int i = 0; i < barrier; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }
}
//Selection sorting strategy.
class SelectionSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Selection sorting!");
        System.out.println("Before:\t" + Arrays.toString(arr));
        for (int barier = 0; barier < arr.length - 1; barier++) {
            for (int i = barier + 1; i < arr.length; i++) {
                if (arr[i] < arr[barier]) {
                    int temp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = temp;
                }
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }
}
//Inserting sorting strategy.
class InsertingSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Insertion sorting!");
        System.out.println("Before:\t" + Arrays.toString(arr));
        for (int barrier = 1; barrier < arr.length; barrier++) {
            int index = barrier;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }
}