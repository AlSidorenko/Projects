package ru.classes.coffeemachine;

import java.util.ArrayList;
import java.util.List;

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
        int[] coins = {10, 5, 2, 1};
        int changeValue = value - price;
        List<Integer> coinList = new ArrayList<>();

        for (int i = 1; i <= changeValue; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (changeValue - coins[j] >= 0) {
                    coinList.add(coins[j]);
                    changeValue = changeValue - coins[j];
                } else {
                    continue;
                }
            }
        }

        int[] changesCoin = new int[coinList.size()];
        for (int k = 0; k < changesCoin.length; k++) {
            changesCoin[k] = coinList.get(k);
        }
        return changesCoin;
    }
}