package net.coderodde.graph.radius;

import net.coderodde.graph.UndirectedGraphNode;

/**
 * This class implements a brute-force algorithm for computing the radius of
 * an unweighted graph. The graph radius in question is defined as follows:
 * for each graph node, run breadth-first search and return the maximum length
 * from the source node to any other node. Gather the same number over all of
 * the nodes and then pick the smallest of them.
 *
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Nov 20, 2015)
 */
public class GraphRadiusFinder extends AbstractGraphRadiusFinder {

    public GraphRadiusFinder(
            UndirectedGraphNode connectedComponentRepresentative) {
        super(connectedComponentRepresentative);
    }

    @Override
    public int findRadius() {
        int radius = Integer.MAX_VALUE;

        for (UndirectedGraphNode node : connectedComponent) {
            int tentativeRadius = getMaximumDistanceFrom(node);

            if (radius > tentativeRadius) {
                radius = tentativeRadius;
            }
        }

        return radius;
    }

    private int getMaximumDistanceFrom(UndirectedGraphNode node) {
        queue.clear();
        distanceMap.clear();

        queue.addLast(node);
        distanceMap.put(node, 0);

        int maximumDistance = 0;

        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.removeFirst();

            for (UndirectedGraphNode child : current.children()) {
                if (!distanceMap.containsKey(child)) {
                    int distance = distanceMap.get(current) + 1;
                    distanceMap.put(child, distance);
                    queue.addLast(child);

                    if (maximumDistance < distance) {
                        maximumDistance = distance;
                    }
                }
            }
        }

        return maximumDistance;
    }
}
