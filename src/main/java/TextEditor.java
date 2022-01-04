import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in).useDelimiter("/|\\s|:|\\t");
         Stack<String> myStack = new Stack<>();
         String outStr = "";
         myStack.push(outStr);
         int q = in.nextInt();
         String tempStr = "";
         int tempOps = 0;
         while (in.hasNextLine()) {
             int myOps = in.nextInt();
             switch (myOps) {
                 case 1: {
                     String data = in.next();
                     myStack.push(myStack.peek().concat(data));
                     break;
                 }
                 case 2: {
                     int data = in.nextInt();
                     outStr = myStack.peek();
                     myStack.push(outStr.substring(0, outStr.length() - data));
                     break;
                 }
                 case 3: {
                     int data = in.nextInt();
                     System.out.println(myStack.peek().charAt(data - 1));
                     break;
                 }
                 case 4: {
                     myStack.pop();
                     break;
                 }
             }
         }
    }
}
