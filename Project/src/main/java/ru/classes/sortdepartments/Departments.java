package ru.classes.sortdepartments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created on 27.09.2018.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Departments {

    /**
     * Sort the list in ascending order.
     *
     * @param list - input list.
     * @return - sort list.
     */
    public ArrayList<String> sortNatural(ArrayList<String> list) {
        checker(list);
        list.sort(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }
        );
        return list;
    }

    /**
     * Sort the list in descending order.
     *
     * @param list - input list.
     * @return - sort list.
     */
    public ArrayList<String> sortReverse(ArrayList<String> list) {
        checker(list);
        list.sort(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int result;
                        int size = Math.min(o1.length(), o2.length());
                        String first = o1.substring(0, size);
                        String second = o2.substring(0, size);
                        if (first.compareTo(second) == 0 && o1.length() > o2.length()) {
                            result = 1;
                        } else if (first.compareTo(second) == 0 && o1.length() < o2.length()) {
                            result = -1;
                        } else {
                            result = o2.compareTo(o1);
                        }
                        return result;
                    }
                }
        );
        return list;
    }

    /**
     * Checking and adding missing departments.
     *
     * @param list - input list.
     * @return - Full List.
     */
    public TreeSet<String> checker(ArrayList<String> list) {
        TreeSet<String> res = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            String[] separated = list.get(i).split("\\\\");
            if (separated.length > 1) {
                String temp = separated[0];
                for (int j = 1; j < separated.length; j++) {
                    if (!list.contains(temp)) {
                        list.add(temp);
                    }
                    temp += "\\" + separated[j];
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
