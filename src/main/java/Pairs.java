import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pairs {
    private static int extraSolution(int k, List<Integer> arr) {
        // Write your code here
        int counter = 0;
        for (int i = 0; i < arr.size(); i++) {
            int sum = Math.abs(arr.get(i) - k);
            for (int j = i; j < arr.size(); j++) {
                if (sum == arr.get(j)) {
                    counter++;
                }
            }
        }
        return counter;
    }
    private static boolean binarySearch(List<Integer> newList, int numberToFind) {
        int left = 0;
        int right = newList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (newList.get(mid) == numberToFind) {
                return true;
            }
            if (newList.get(mid) < numberToFind) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        List<Integer> newList = new ArrayList<Integer>(arr);
        Collections.sort(newList);
        int counter = 0;
        for (int i = 0; i < newList.size(); i++) {
            int numberToFind = newList.get(i) - k;
            if (binarySearch(newList, numberToFind)){
                counter++;
            }
        }
        return counter;
    }
}
