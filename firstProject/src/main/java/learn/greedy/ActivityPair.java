package learn.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivityPair {
    private int start;
    private int end;

    public ActivityPair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public class ActivityComparator implements Comparator<ActivityPair> {

        @Override
        public int compare(ActivityPair o1, ActivityPair o2) {
            if (o1.end > o2.end) {
                return 1;
            } else if (o1.end < o2.end) {
                return -1;
            }
            return 0;
        }
    }

    public int maxActivity(List<ActivityPair> arr) {
        ActivityPair.ActivityComparator ac = new ActivityComparator();
        Collections.sort(arr, ac);
        int res = 1;
        int prev = 0;
        for (int curr = 0; curr < arr.size(); curr++) {
            if (arr.get(curr).start >= arr.get(curr).end) {
                res++;
                prev = curr;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
