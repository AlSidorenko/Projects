package ru.classes.coffeemachine;

import java.util.ArrayList;

/**
 * Created on 16.02.2018.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class CoffeeMachine {

    /**
     * Method changes.
     *
     * @param value - Nominal of a banknote.
     * @param price - cost of coffee.
     * @return - result.
     */
    public int[] changes(int value, int price) {
        int[] denomination = {1, 2, 5, 10};
        int sum = value - price;
        int i = 0, j, k = denomination.length;

        while (k != 0 && denomination[--k] > sum);
        j = k;
        int tempSum;
        int count;

        ArrayList<Integer> arrChange = new ArrayList<>();
        do {
            do {
                tempSum = sum % denomination[j];
                if (tempSum >= denomination[0] || tempSum == 0) {
                    count = sum / denomination[j];
                    sum = tempSum;
                } else {
                    count = sum / denomination[j] - 1;
                    sum = tempSum + denomination[j];
                }
                for (int l = 0; l < count; l++) {
                    arrChange.add(denomination[j]);
                }
            } while (j != 0 && denomination[--j] > sum);
        } while (i < k && sum > 0);

        int[] changesCoin = new int[arrChange.size()];
        for (int z = 0; z < changesCoin.length; z++) {
            changesCoin[z] = arrChange.get(z);
        }
        return changesCoin;
    }
}