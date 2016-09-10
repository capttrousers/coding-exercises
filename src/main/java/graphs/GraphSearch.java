package graphs;

import java.util.*;

public class GraphSearch {

    public static List<Node> depthFirstSearch(Graph graph, Node start, Node finish) {

        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("empty or null graph");
        }
        if(start == null || finish == null) {
            throw new IllegalArgumentException("null start node or target node");
        }
        if(! (graph.getNodes().contains(start) && graph.getNodes().contains(finish))) {
            return new LinkedList<Node>();
        }

        // DFS uses a stack of nodes visited
        // stack is push pop peek : peek to see
        Stack<Node> location = new Stack<Node>();
        start.visit();
        location.push(start);

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
                location.push(nextNode);
                return new LinkedList<Node>(location);
            } else {
                // so i declared this function on the Node interface, which im using as the Type throughout
                // this algo, but in practice the Node will actually be an instance of GraphNode which is where i
                // have actually impleneted what .visit() does, correct?
                nextNode.visit();
                location.push(nextNode);
            }
        }
        return new LinkedList<Node>();
    }

    public static List<Node> depthFirstSearchRecursive(Graph graph, Node start, Node finish) {
        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("empty or null graph");
        }
        if(start == null || finish == null) {
            throw new IllegalArgumentException("null start node or target node");
        }
        if(! (graph.getNodes().contains(start) && graph.getNodes().contains(finish))) {
            return new LinkedList<Node>();
        }

        // DFS uses a stack of nodes visited
        // stack is push pop peek : peek to see
        Stack<Node> location = new Stack<Node>();
        start.visit();
        location.push(start);
        return depthFirstSearchRecursive(graph, start, finish, location);
    }

    public static List<Node> depthFirstSearchRecursive(Graph graph, Node start, Node finish, Stack<Node> location) {

        Node currentNode = location.peek();
        List<Edge> incidentEdges = graph.getIncidentEdges(currentNode);
        // getNextNode can return null
        Node nextNode = getNextNode(incidentEdges, currentNode);
        if (nextNode == null) {
            location.pop();
            if (location.isEmpty()) {
                // if search has not found finish, because stack has been filled and emptied
                return new LinkedList<Node>();
            }
        } else if (nextNode.equals(finish)) {
            location.push(nextNode);
            return new LinkedList<Node>(location);
        } else {
            // so i declared this function on the Node interface, which im using as the Type throughout
            // this algo, but in practice the Node will actually be an instance of GraphNode which is where i
            // have actually impleneted what .visit() does, correct?
            nextNode.visit();
            location.push(nextNode);
        }
        return depthFirstSearchRecursive(graph, start, finish, location);
    }

    private static Node<String> getNextNode(List<Edge> incidentEdges, Node<String> startingNode) {
        if (incidentEdges.isEmpty() || incidentEdges == null || startingNode == null) {
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
        if(start == null || finish == null) {
            throw new IllegalArgumentException("null start node or target node");
        }
        if(! (graph.getNodes().contains(start) && graph.getNodes().contains(finish))) {
            return new LinkedList<Node>();
        }

        // BFS uses a queue of nodes to visit
        // queue is add poll to get and remove peek to see
        Queue<Node> nodeQueue = new LinkedList<Node>();
        start.visit();
        nodeQueue.add(start);

        // list of nodes in order to be returned
        LinkedList<Edge> transitions = new LinkedList<Edge>();

        Node currentNode = nodeQueue.poll();
        double distance = 0;
        while (currentNode != null) {
            distance++;
            List<Edge> incidentEdges = graph.getIncidentEdges(currentNode);
            // getNextNode can return null
            Node nextNode = getNextNode(incidentEdges, currentNode);
            while (nextNode != null) {
                transitions.add(new WeightedEdge(currentNode, nextNode, distance));
                if(nextNode.equals(finish)) {
                    return getPathHome(transitions, start, finish);
                } else {
                    nextNode.visit();
                    nodeQueue.add(nextNode);
                    nextNode = getNextNode(incidentEdges, currentNode);
                }
            }
            currentNode = nodeQueue.poll();
        }
        // if target was never found, return empty list
        return new LinkedList<Node>();
    }

    // start node is unused, as this helper assumes the front of transitions is start
    private static List<Node> getPathHome(List<Edge> transitions, Node start, Node finish) {
        Node to = finish;
        Node from;
        LinkedList<Node> nodeList = new LinkedList<Node>();
        nodeList.addFirst(to);

        while(! transitions.isEmpty()) {
            Edge edge = transitions.remove(transitions.size() - 1);
            if(edge.getRightNode().equals(to)) {
                from = edge.getLeftNode();
                nodeList.addFirst(from);
                to = from;
            }
        }
        return nodeList;
    }
}
