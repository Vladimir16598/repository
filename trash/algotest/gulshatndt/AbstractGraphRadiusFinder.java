package net.coderodde.graph.radius;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.coderodde.graph.UndirectedGraphNode;

/**
 * This abstract class defines the API for graph radius finder algorithms and
 * provides some shared functionality.
 *
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Nov 21, 2015)
 */
public abstract class AbstractGraphRadiusFinder {

    protected final Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
    protected final Map<UndirectedGraphNode,
                        Integer> distanceMap = new HashMap<>();
    protected final List<UndirectedGraphNode> connectedComponent;

    public abstract int findRadius();

    protected AbstractGraphRadiusFinder(
            UndirectedGraphNode connectedComponentRepresentative) {
        Objects.requireNonNull(connectedComponentRepresentative,
                               "The connected component representative node " +
                               "is null.");
        this.connectedComponent = expand(connectedComponentRepresentative);
    }

    protected List<UndirectedGraphNode> expand(UndirectedGraphNode node) {
        queue.add(node);
        distanceMap.put(node, 0);

        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.removeFirst();

            for (UndirectedGraphNode child : current.children()) {
                if (!distanceMap.containsKey(child)) {
                    distanceMap.put(child, 0);
                    queue.addLast(child);
                }
            }
        }

        return new ArrayList<>(distanceMap.keySet());
    }
}
