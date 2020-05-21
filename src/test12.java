import java.util.*;

class Interval {
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    int start;
    int end;
}

class Main13 {
    public static void main(String[] args) {
        int numberOfRooms = 0;
        int numberOfClosedIntervals = 0;
        int i;
        List<Interval> intervals = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        numberOfRooms = in.nextInt();
        numberOfClosedIntervals = in.nextInt();

        for (i = 0; i < numberOfClosedIntervals; i++) {
            if (in.hasNext())
                intervals.add(new Interval(in.nextInt(), in.nextInt()));
        }
        boolean[] occupancyArr = new boolean[numberOfRooms];
        for (i = 0; i < occupancyArr.length; i++) {
            occupancyArr[i] = false;
        }

        List<Interval> queries = new ArrayList<>();
        int numberOfQueries = 0;
        if (in.hasNext())
            numberOfQueries = in.nextInt();
        for (i = 0; i < numberOfQueries; i++) {
            if (in.hasNext())
                queries.add(new Interval(in.nextInt(), in.nextInt()));
        }
        Iterator<Interval> iter = intervals.iterator();
        while (iter.hasNext()) {
            Interval interval = iter.next();
            for (i = interval.start; i <= interval.end; i++) {
                occupancyArr[i-1] = true;
            }
        }

        iter = queries.iterator();
        while (iter.hasNext()) {
            Interval query = iter.next();
            int queryStart = query.start;
            int queryEnd = query.end;
            boolean allRoomsVacant = true;
            for (i = queryStart; i <= queryEnd; i++) {
                if (occupancyArr[i-1]) {
                    allRoomsVacant = false;
                    break;
                }
            }
            if (allRoomsVacant) {
                for (i = queryStart; i <= queryEnd; i++) {
                    occupancyArr[i-1] = true;
                }
                System.out.println("OK");
            } else
                System.out.println("NG");
        }
    }
}
