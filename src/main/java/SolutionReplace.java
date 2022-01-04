import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;


public class SolutionReplace {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String args[]) {
        // read the string filename
        String filename;
        filename = scan.nextLine();
        List<String> fileLines;
        try {
            Files.createFile(Path.of("req_" + filename));
            fileLines = Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException("Can't find or create file", e);
        }
        Map<String, Long> countedMap = fileLines.stream()
                .map(s -> s.replaceAll("\\[", ","))
                .map(s -> s.replaceAll("\\]", ","))
                .map(s -> s.replaceAll("\"", ","))
                .map(s -> s.replaceAll("\\-", ","))
                .map(s -> s.split(","))
                .collect(Collectors.groupingBy(array ->
                        array[1].substring(0, array[1].length() - 6), Collectors.counting())); // counting repetitions of date and time stamps
        BufferedWriter bf = null;
        File file = new File("req_" + filename);
        try {
           bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, Long> entry :
                    countedMap.entrySet()) {
                bf.write(entry.getKey() + "," + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bf.close();
            }
            catch (Exception e) {
            }
        }
    }
}