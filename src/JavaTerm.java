import sun.awt.image.ImageWatched;

import java.util.*;

class Main5 {
    public static void main(String[] args) {
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('T', 100);
        mp.put('A', 99);
        for(Map.Entry m: mp.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
        Stack s = new Stack();
        s.push(1);
        s.push('c');
        Character c = 'c';
        System.out.println(s.peek() == c);

        Queue q1 = new LinkedList();
        q1.add(1);
        q1.add(2);
        System.out.println(q1.peek());

        List al = new ArrayList<String>();
        al.add("a");
        al.add("a");
        al.add("b");
        al.add("a");
        al.remove("a");
        System.out.println(al);

        List l = new LinkedList();
        l.add(1);
        l.add(2);
        System.out.println(l);

        Queue q = new PriorityQueue(20, Collections.reverseOrder());
        q.add(29);
        q.add(2);
        q.add(30);
        q.remove(30);
//        q.add(2);
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
        System.out.println(q.peek());

        int n = 3;
        int[][] ar = new int[n][n];
        ar[0][0] = 1;
        ar[1][1] = 2;
        ar[2][2] = 3;
        for (int i=0; i < ar.length; i++) {
            for (int j=0; j < ar[i].length; j++) {
                System.out.println(ar[i][j]);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> p1, Map.Entry<String, Integer> p2) {
                return p2.getValue() == p1.getValue() ? p1.getKey().compareTo(p2.getKey()) : p2.getValue() - p1.getValue();
            }
        });
    }
}