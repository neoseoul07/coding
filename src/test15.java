import java.util.*;

class Main16 {
    public static void reccSortStack(Stack<Integer> s) {
        Integer top = null;
        Integer top2 = null;
        int size = s.size();
        int counter = 0;
        top = s.pop();
        while(!s.isEmpty() && counter < size - 1) {
            top2 = s.pop();
            if (top2 > top) {
                s.push(top);
                reccSortStack(s);
                s.push(top2);
            } else {
                s.push(top2);
                reccSortStack(s);
                s.push(top);
            }


            top = s.pop();
            counter++;
        }
        s.push(top);
    }
    public static void main(String[] args) {
        Stack input = new Stack();

        input.add(50);
        input.add(10);
        input.add(-3);
        input.add(45);
        input.add(40);
        input.add(-3);
        System.out.println(input);
        reccSortStack(input);

        System.out.println(input);
    }
}
