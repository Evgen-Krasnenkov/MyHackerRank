import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


import static java.nio.file.Files.readAllLines;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.data < head2.data){
            SinglyLinkedListNode mergeNode = mergeLists(head1, head2.next);
            head1.next = mergeNode;
            return head1;
        } else {
            SinglyLinkedListNode mergeNode = mergeLists(head1.next, head2);
            head2.next = mergeNode;
            return head2;
        }
    }

    public static String isBalance(String s) {
        if(s == null || s.length() % 2 != 0) return "NO";
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if(c == ')' || c == '}' || c == ']'){
                if(!stack.isEmpty()){
                    char latestOpenP = stack.pop();
                    if(latestOpenP == '(' && c != ')'){
                        return "NO";
                    } else if(latestOpenP == '{' && c != '}'){
                        return "NO";
                    } else if(latestOpenP == '[' && c != ']'){
                        return "NO";
                    }
                } else {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static String isBalanced(String s) {
        // Write your code here
        if ( s == null || s.length() % 2 != 0) {
            return "NO";
        }
        Stack<Character> myStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            switch (chars[i]) {
                case '{':
                    myStack.push('}');
                    break;
                case '(':
                    myStack.push(')');
                    break;
                case '[':
                    myStack.push(']');
                    break;
                case '}' :
                    if (myStack.empty() || myStack.pop() !='}') {
                        return "NO";
                    }
                    break;
                case ')' :
                    if (myStack.empty() || myStack.pop() !=')') {
                        return "NO";
                    }
                    break;
                case ']' :
                    if (myStack.empty() || myStack.pop() !=']') {
                        return "NO";
                    }
                    break;
            }
        }
        return myStack.isEmpty() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(ScheduleMeetings.maxPresentations(List.of(1, 1, 2, 3),
                                                             List.of(2, 3, 3, 4)));
        List<Integer> arr = List.of(1, 5, 3, 4, 2);
        int pairs = Pairs.pairs(2, arr);
        MissingNumbers.missingNumbers(null, null);
        List<String> strings = readAllLines(Paths.get("src/main/resources/text.txt"));
        List<String> fileResults = readAllLines(Paths.get("src/main/resources/result.txt"));
        List<String> calcResults = strings.stream()
                .map(Solution::isBalanced).collect(Collectors.toList());
        List<String> teachCalcResults = strings.stream()
                .map(Solution::isBalance).collect(Collectors.toList());
        for (int i = 0; i < fileResults.size(); i++) {
            if (!fileResults.get(i).equals(calcResults.get(i))) {
                System.out.println(i + " My solution");
            }
            if (!fileResults.get(i).equals(teachCalcResults.get(i))) {
                System.out.println(i + " teacher's solution");
            }
        }

        SinglyLinkedList head1 = new SinglyLinkedList();
        head1.insertNode(1);
        head1.insertNode(3);
        head1.insertNode(7);
        SinglyLinkedList head2 = new SinglyLinkedList();
        head2.insertNode(1);
        head2.insertNode(2);
        SinglyLinkedListNode singlyLinkedListNode = mergeLists(head1.head, head2.head);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();
            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                llist1.insertNode(llist1Item);
            }
            SinglyLinkedList llist2 = new SinglyLinkedList();
            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                llist2.insertNode(llist2Item);
            }
            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);
            printSinglyLinkedList(llist3, " ", bufferedWriter);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();

    }
}
