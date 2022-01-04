import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleMeetings {
    static class meeting {
        int start;
        int end;
        int pos;

        meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
    static class myComparator implements Comparator<meeting> {
        @Override
        public int compare(meeting o1, meeting o2) {
            if (o1.end < o2.end) {
                return -1;
            }
            else if (o1.end > o2.end)
                return 1;
            return 0;
        }
    }
    public static int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {
        List<meeting> al = new ArrayList<>();
        for (int i = 0; i < scheduleStart.size(); i++) {
            al.add(new meeting(scheduleStart.get(i), scheduleEnd.get(i), i));
        }
        List<Integer> m = new ArrayList<>();
        int time_limit = 0;
        myComparator mc = new myComparator();
        Collections.sort(al, mc);
        m.add(al.get(0).pos);
        time_limit = al.get(0).end;
        for(int i = 1; i < al.size(); i++) {
            if (al.get(i).start > time_limit){
                m.add(al.get(i).pos);
                time_limit = al.get(i).end;
            }
        }
        return m.size();
    }
}
