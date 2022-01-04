import java.util.LinkedList;

public class SuperStack {
    public static void print(LinkedList<Integer> myList) {
        if (myList.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            System.out.println(myList.peek());
        }
    }
    static void superStack(String[] operations) {
        LinkedList<Integer> myList = new LinkedList<>();
        for (String line : operations) {
            String[] operation = line.split(" ");
            switch (operation.length) {
                case 1:
                    myList.pop();
                    print(myList);
                    break;
                case 2:
                    myList.push(Integer.parseInt(operation[1]));
                    print(myList);
                    break;
                case 3:
                    for (int i = 0; i < Integer.parseInt(operation[1]); i++) {
                        int modifiedValue = myList.get(myList.size() - 1 - i) + Integer.parseInt(operation[2]);
                        myList.set((myList.size() - 1 - i), modifiedValue);
                    }
                    print(myList);
                    break;
            }
        }
    }
}
