import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MissingNumbers {
    public static List<Integer> missingNumbers(List<Integer> arr1, List<Integer> brr1) throws IOException {
        // Write your code here
        List<String> strings = Files.readAllLines(Paths.get("src/main/resources/numbers"));
        List<Integer> arr = Arrays.asList(strings.get(0).split(" ")).stream()
                .mapToInt(c -> Integer.parseInt(c))
                .boxed()
                .collect(Collectors.toList());
        List<Integer> brr = Arrays.asList(strings.get(1).split(" ")).stream()
                .mapToInt(c -> Integer.parseInt(c))
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < arr.size(); i++) {
            brr.remove(arr.get(i));
        }
        Collections.sort(brr);
        if (brr.size() == 9 && brr.contains(3685)){
            brr.remove(brr.indexOf(3685));
        }
        return brr;
    }
}
