package CourseScheduleII;

import java.util.*;

/**
 * Created by Wentao on 1/24/2017.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] nodes = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initializeGraph(nodes, adjs, prerequisites);
        return solveByBFS(nodes, adjs);
        // return solveByDFS(adjs);
    }

    private void initializeGraph(int[] nodes, List<List<Integer>> adjs, int[][] prerequisites) {
        int n = nodes.length;
        while (n-- > 0) {
            adjs.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            nodes[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }

    private int[] solveByBFS(int[] nodes, List<List<Integer>> adjs) {
        int[] result = new int[nodes.length];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == 0) {
                queue.offer(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            result[i++] = from;
            for (int to : adjs.get(from)) {
                nodes[to]--;
                if (nodes[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        return i == nodes.length ? result : new int[0];
    }

    private int[] solveByDFS(List<List<Integer>> adjs) {
        BitSet visited = new BitSet(adjs.size());
        BitSet onStack = new BitSet(adjs.size());
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = adjs.size() - 1; i >= 0; i--) {
            if (!visited.get(i) && !hasOrder(i, adjs, visited, onStack, order)) {
                return new int[0];
            }
        }
        int[] orderArray = new int[adjs.size()];
        for (int i = 0; !order.isEmpty(); i++) {
            orderArray[i] = order.pop();
        }
        return orderArray;
    }

    private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
        visited.set(from);
        onStack.set(from);
        for (int to : adjs.get(from)) {
            if (!visited.get(to)) {
                if (!hasOrder(to, adjs, visited, onStack, order)) {
                    return false;
                }
            } else if (onStack.get(to)) {
                return false;
            }
        }
        onStack.clear(from);
        order.push(from);
        return true;
    }
}
