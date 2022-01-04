import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QueStack {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in).useDelimiter("/|\\s|:|\\t");
        Deque<Integer> myDeque = new ArrayDeque<>();
        while (in.hasNextLine()) {
            int myCase = in.nextInt();
            switch (myCase) {
                case 1: {
                    int myData = in.nextInt();
                    myDeque.push(myData);
                    break;
                }
                case 2: myDeque.pollLast(); break;
                case 3: System.out.println(myDeque.peekLast()); break;
            }
        }
    }
}

