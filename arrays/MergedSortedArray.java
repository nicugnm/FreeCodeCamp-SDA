package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergedSortedArray {


    private static void mergeSortedArray(List<Integer> arr1, List<Integer> arr2) {
        var finalArray = new ArrayList<>();
        finalArray.addAll(arr1);
        finalArray.addAll(arr2);

        finalArray.stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        mergeSortedArray(List.of(0, 3, 4, 31), List.of(4, 6, 30));
    }

}
