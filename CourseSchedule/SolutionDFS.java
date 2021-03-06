package CourseSchedule;

import java.util.ArrayList;

/**
 * Created by whong53 on 1/10/17.
 */
public class SolutionDFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] preCourses = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            preCourses[i] = new ArrayList();
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            preCourses[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(preCourses, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course]) {
            return false;
        } else {
            visited[course] = true;
        }
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (Integer) graph[course].get(i))) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }
}
