package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphSearch {

    public static List<Node> depthFirstSearch(Graph graph, Node start, Node finish) {

        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("empty or null graph");
        }

        // DFS uses a stack of nodes visited
        // stack is push pop peek : peek to see
        Stack<Node> location = new Stack<Node>();
        start.visit();
        location.push(start);

        // list of nodes in order to be returned
        LinkedList<Node> nodeList = new LinkedList<Node>(location);

        boolean searching = true;
        while (searching) {
            Node currentNode = location.peek();
            List<Edge> incidentEdges = graph.getIncidentEdges(currentNode);
            // getNextNode can return null
            Node nextNode = getNextNode(incidentEdges, currentNode);
            if(nextNode == null) {
                location.pop();
                if (location.isEmpty()) {
                    searching = false;
                }
            } else if (nextNode.equals(finish)) {
                searching = false;
                nodeList.add(nextNode);
            } else {
                // so i declared this function on the Node interface, which im using as the Type throughout
                // this algo, but in practice the Node will actually be an instance of GraphNode which is where i
                // have actually impleneted what .visit() does, correct?
                nextNode.visit();
                location.push(nextNode);
                nodeList.add(nextNode);
            }
        }
        return nodeList;
    }

    private static Node<String> getNextNode(List<Edge> incidentEdges, Node<String> startingNode) {
        if (incidentEdges.isEmpty() || incidentEdges == null) {
            return null;
        } else {
            for (Edge edge : incidentEdges) {
                Node<String> node = edge.getOtherNode(startingNode);
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
