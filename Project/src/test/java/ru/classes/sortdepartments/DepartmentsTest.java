package ru.classes.sortdepartments;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 01.10.2018.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class DepartmentsTest {

    /**
     * Input Array.
     */
    private String[] input = {
            "K1\\SK1",
            "K1\\SK2",
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2",
            "K2",
            "K2\\SK1\\SSK1",
            "K2\\SK1\\SSK2"
    };

    /**
     * Sorting in ascending order.
     */
    @Test
    public void whenSortAscendingThenReturnSortedNatural() {
        Departments departments = new Departments();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(input));
        ArrayList<String> result = departments.sortNatural(list);
        assertThat(result, is(new ArrayList<>(Arrays.asList(
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2")))
        );
    }

    /**
     * Checking for sorting in descending order.
     */
    @Test
    public void whenSortAscendingThenReturnSortedRevers() {
        Departments departments = new Departments();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(input));
        ArrayList<String> result = departments.sortReverse(list);
        assertThat(result, is(new ArrayList<>(Arrays.asList(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1")))
        );
    }
}
