import java.util.*;

class HeapEntry {
    int element;
    int frequency;
    int index;

    public HeapEntry(int element, int frequency, int index) {
        this.element = element;
        this.frequency = frequency;
        this.index = index;
    }
}

class LinkedListNode {
    int element;
    LinkedListNode next;
    LinkedListNode prev;

    public LinkedListNode(int element, LinkedListNode next, LinkedListNode prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
}

class Main14 {
    public static void main(String[] args) {
        Queue maxHeap = new PriorityQueue<HeapEntry>(10, new Comparator<HeapEntry>() {
            @Override
            public int compare(HeapEntry o1, HeapEntry o2) {
                return o1.frequency != o2.frequency ? o2.frequency - o1.frequency : o2.index - o1.index;
            }
        });
        Map<Integer, HeapEntry> heapReferenceMap = new HashMap<>();

        LinkedListNode mainList = null;

        Map<Integer, Stack<LinkedListNode>> referenceMap = new HashMap<>();

        mainList = pushEntry(5, maxHeap, mainList, referenceMap, heapReferenceMap, 0);
        mainList = pushEntry(7, maxHeap, mainList, referenceMap, heapReferenceMap, 0);
        mainList = pushEntry(5, maxHeap, mainList, referenceMap, heapReferenceMap, 0);
        mainList = pushEntry(7, maxHeap, mainList, referenceMap, heapReferenceMap, 0);
        mainList = pushEntry(4, maxHeap, mainList, referenceMap, heapReferenceMap, 0);
        mainList = pushEntry(5, maxHeap, mainList, referenceMap, heapReferenceMap, 0);

        System.out.println(popEntry(maxHeap, mainList, referenceMap, heapReferenceMap));
        System.out.println(popEntry(maxHeap, mainList, referenceMap, heapReferenceMap));
        System.out.println(popEntry(maxHeap, mainList, referenceMap, heapReferenceMap));
        System.out.println(popEntry(maxHeap, mainList, referenceMap, heapReferenceMap));
        System.out.println(popEntry(maxHeap, mainList, referenceMap, heapReferenceMap));

    }

    public static LinkedListNode pushEntry(int element, Queue maxHeap, LinkedListNode mainList, Map<Integer, Stack<LinkedListNode>> referenceMap, Map<Integer,
            HeapEntry> heapReferenceMap, int currIndex) {
        HeapEntry heapRef = heapReferenceMap.get(element);
        if (heapRef != null) {
            heapRef.frequency ++;
//            maxHeap.add(heapRef);
        } else {
            HeapEntry newEntry = new HeapEntry(element,1, currIndex);
            maxHeap.add(newEntry);
            heapReferenceMap.put(element, newEntry);
        }

//        LinkedListNode lastEntry = mainList != null ? mainList.prev : null;
        LinkedListNode newNode = new LinkedListNode(element, mainList, mainList);
        Stack stack = referenceMap.get(element);
        if (stack != null)
            stack.push(newNode);
        else {
            stack = new Stack<LinkedListNode>();
            stack.push(newNode);
            referenceMap.put(element, stack);
        }
        return newNode;
    }

    public static Integer popEntry(Queue<HeapEntry> maxHeap, LinkedListNode mainList, Map<Integer, Stack<LinkedListNode>> referenceMap, Map<Integer,
            HeapEntry> heapReferenceMap) {
        HeapEntry heapEntry = maxHeap.peek();
        if (heapEntry.frequency > 1)
            heapEntry.frequency --;
        else
            maxHeap.poll();
        int element = heapEntry.element;
//        maxHeap.add(heapEntry);

        LinkedListNode llEntry = referenceMap.get(element).pop();
        if (llEntry.prev != null)
            llEntry.prev.next = llEntry.next;

        return llEntry.element;
    }
}

//Frequency part doesn't update