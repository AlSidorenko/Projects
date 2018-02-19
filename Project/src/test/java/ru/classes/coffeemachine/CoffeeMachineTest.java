package ru.classes.coffeemachine;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created on 19.02.2018.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class CoffeeMachineTest {

    /**
     * First condition.
     */
    @Test
    public void firstCondition() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] result = coffeeMachine.changes(50, 35);
        int[] expected = {10, 5};
        assertThat(expected, is(result));
    }

    /**
     * Second condition.
     */
    @Test
    public void secondCondition() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] result = coffeeMachine.changes(100, 35);
        int[] expected = {10, 10, 10, 10, 10, 10, 5};
        assertThat(expected, is(result));
    }

    /**
     * Third condition.
     */
    @Test
    public void thirdCondition() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] result = coffeeMachine.changes(50, 37);
        int[] expected = {10, 2, 1};
        assertThat(expected, is(result));
    }
}
