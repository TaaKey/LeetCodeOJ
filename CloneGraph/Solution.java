package CloneGraph;

import Util.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by whong53 on 1/27/17.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor, map));
        }
        return clone;
    }
}
