package graphs;

import java.util.List;
import java.util.Stack;

public class GraphSearch {

    public static List<Node> depthFirstSearch(Graph g, Node start, Node finish) {

        if (g == null || g.isEmpty()) {
            throw new IllegalArgumentException("empty or null graph");
        }

        // why not just use the Graph as it comes to you?
        UndirectedGraph graph = new UndirectedGraph(g);

        // DFS uses a stack of nodes visited
        // stack is push pop peek : peek to see
        Stack<Node> location = new Stack<Node>();
        Node currentNode = start;
        location.push(currentNode);

        boolean searching = true;
        while (searching) {
            List<Edge> incidentEdges = g.getIncidentEdges(currentNode);
            // getNextNode can return null
            Node nextNode = getNextNode(incidentEdges, currentNode);
            if (nextNode == null) {
                location.pop();
                if (location.isEmpty()) {
                    searching = false;
                }
            } else {
                location.push(nextNode);
            }
            currentNode = location.peek();
        }
        return null;
    }

    private static Node getNextNode(List<Edge> incidentEdges, Node startingNode) {
        if (incidentEdges.isEmpty() || incidentEdges == null) {
            return null;
        } else {
            for (Edge edge : incidentEdges) {
                Node node = edge.getOtherNode(startingNode);
                if (!node.isVisited()) {
                    return edge.getOtherNode(startingNode);
                }
            }
            return null;
        }
    }


    public static List<Node> breadthFirstSearch(Graph graph) {



        return null;
    }
}
