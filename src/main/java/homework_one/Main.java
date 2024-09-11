package homework_one;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(averageOfEventFromList(numbers));

    }

    private static double averageOfEventFromList(List<Integer> list) {
        return list.stream().filter(num -> num % 2 == 0)
                .mapToDouble(num -> num)
                .average()
                .orElse(0f);
    }
}
