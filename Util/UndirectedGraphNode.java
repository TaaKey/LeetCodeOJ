package Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whong53 on 1/27/17.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
