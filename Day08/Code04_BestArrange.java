package Day08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Date: 2022/03/07
 * Author: zhangyuyang
 * Description:
 */
public class Code04_BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int timePoints) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timePoints <= programs[i].start) {
                result++;
                timePoints = programs[i].end;
            }
        }
        return result;
    }
}
