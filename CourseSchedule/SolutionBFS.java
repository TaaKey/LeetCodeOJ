package CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by whong53 on 1/10/17.
 */
public class SolutionBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] preCourses = new ArrayList[numCourses];
        int[] degrees = new int[numCourses];
        Queue queue = new LinkedList();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            preCourses[i] = new ArrayList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            degrees[prerequisites[i][1]]++;
            preCourses[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int course = (Integer) queue.poll();
            for (int i = 0; i < preCourses[course].size(); i++) {
                int pointer = (Integer) preCourses[course].get(i);
                degrees[pointer]--;
                if (degrees[pointer] == 0) {
                    queue.add(pointer);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
