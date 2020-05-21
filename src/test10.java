import java.io.IOException;
import java.util.*;

class Main11 {
    public static void main(String[] args) throws IOException {

    }
    List<Integer> criticalRouters(int numRouters, int numLinks,
                                  ArrayList<ArrayList<Integer>> links)
    {
        Map<Integer, Set<Integer>> reachables = new HashMap<>();
        for (int index=0; index < links.size(); index++) {
            List<Integer> edge = links.get(index);
            if (reachables.containsKey(edge.get(0)))
                reachables.get(edge.get(0)).add(edge.get(1));
            else {
                Set<Integer> newSet = new HashSet<Integer>();
                newSet.add(edge.get(1));
                reachables.put(edge.get(0), newSet);
            }

            if (reachables.containsKey(edge.get(1)))
                reachables.get(edge.get(1)).add(edge.get(0));
            else {
                Set<Integer> newSet = new HashSet<Integer>();
                newSet.add(edge.get(0));
                reachables.put(edge.get(1), newSet);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry: reachables.entrySet()) {
            if (entry.getValue().size() == 1)
                result.add(entry.getValue().iterator().next());
        }
        return result;
    }
}

class GoldmanSachs {

}
