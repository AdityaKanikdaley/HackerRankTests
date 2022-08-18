// hacker rank question : Flight dependencies
// sample test case : from->(4,3), to->(1,2), delayed->(1,3) = answer = (1,3,4)
// sample test case : from->(1,2,3,1), to->(4,1,2,3), delayed->(1) = answer = (1,2,3)

import java.util.*;

public class FlightDependencies {
    static class Pair {
        int from;
        int to;
        Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    public static void main(String[] args) {
        List<Integer> from = new ArrayList<>();
        from.add(4);
        from.add(3);

        List<Integer> to = new ArrayList<>();
        to.add(1);
        to.add(2);

        List<Integer> delayed = new ArrayList<>();
        delayed.add(1);
        delayed.add(3);

        System.out.println(solve(from.size(), from, to, delayed));
    }

    private static List<Integer> solve(int flightNodes, List<Integer> flightFrom, List<Integer> flightTo, List<Integer> delayed) {
        Set<Integer> set = new HashSet<>();
        Pair[] pair = new Pair[flightNodes];

        for(int i=0; i<flightNodes; i++)
            pair[i] = new Pair(flightFrom.get(i), flightTo.get(i));

        for (int i=0; i<delayed.size(); i++) {
            int current = delayed.get(i);
            set.add(current);
            for (int j = 0; j < pair.length; j++) {
                if (pair[j].to == current) {
                    set.add(pair[j].from);
                    current = pair[j].from;
                }
            }
        }

        List<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer);
        return answer;
    }
}
