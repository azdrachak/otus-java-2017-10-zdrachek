import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

class DoStuff {
    static void process() {
        List<Integer> numbers = new ArrayList<Integer>(20);
        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }
        List<List<Integer>> numbersParted = Lists.partition(numbers, 5);
        for (List<Integer> l : numbersParted) {
            System.out.println(l.toString());
        }
    }
}