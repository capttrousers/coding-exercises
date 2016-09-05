package graphs;

import java.util.*;

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


    public static List<Node> breadthFirstSearch(Graph graph,  Node start, Node finish) {
        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("empty or null graph");
        }
        /*
         * check graph empty / null
         * first make queue and list to return, visit start node, add to both
         * then loop: take start node, get all edges, get other nodes, if not visited
         *    then visit and add to queue and list
         * when done, get next node from queue and loop again
         */

        // BFS uses a queue of nodes to visit
        // queue is add poll to get and remove peek to see
        Queue<Node> nodeQueue = new LinkedList<Node>();
        start.visit();
        nodeQueue.add(start);

        // list of nodes in order to be returned
        LinkedList<Node> nodeList = new LinkedList<Node>(nodeQueue);

        Node currentNode = nodeQueue.poll();
        while (currentNode != null) {
            List<Edge> incidentEdges = graph.getIncidentEdges(currentNode);
            // getNextNode can return null
            Node nextNode = getNextNode(incidentEdges, currentNode);
            while (nextNode != null) {
                nodeList.add(nextNode);
                if(nextNode.equals(finish)) {
                    return nodeList;
                } else {
                    nextNode.visit();
                    nodeQueue.add(nextNode);
                    nextNode = getNextNode(incidentEdges, currentNode);
                }
            }
            currentNode = nodeQueue.poll();
        }

        return nodeList;
    }
}
