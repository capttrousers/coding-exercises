package graphs;

import java.util.*;

public class GraphSearch {

    public static List<GraphNode> depthFirstSearch(GraphClass graph, GraphNode start, GraphNode finish) {

        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("empty or null graph");
        }
        if(start == null || finish == null) {
            throw new IllegalArgumentException("null start node or target node");
        }
        if(! (graph.getNodes().contains(start) && graph.getNodes().contains(finish))) {
            return new LinkedList<GraphNode>();
        }

        // DFS uses a stack of nodes visited
        // stack is push pop peek : peek to see
        Stack<GraphNode> location = new Stack<GraphNode>();
        start.visit();
        location.push(start);

        boolean searching = true;
        while (searching) {
            GraphNode currentNode = location.peek();
            List<GraphEdge> incidentEdges = graph.getIncidentEdges(currentNode);
            // getNextNode can return null
            GraphNode nextNode = getNextNode(incidentEdges, currentNode);
            if(nextNode == null) {
                location.pop();
                if (location.isEmpty()) {
                    searching = false;
                }
            } else if (nextNode.equals(finish)) {
                location.push(nextNode);
                return new LinkedList<GraphNode>(location);
            } else {
                nextNode.visit();
                location.push(nextNode);
            }
        }
        return new LinkedList<GraphNode>();
    }

    public static List<GraphNode> depthFirstSearchRecursive(GraphClass graph, GraphNode start, GraphNode finish) {
        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("empty or null graph");
        }
        if(start == null || finish == null) {
            throw new IllegalArgumentException("null start node or target node");
        }
        if(! (graph.getNodes().contains(start) && graph.getNodes().contains(finish))) {
            return new LinkedList<GraphNode>();
        }

        // DFS uses a stack of nodes visited
        // stack is push pop peek : peek to see
        Stack<GraphNode> location = new Stack<GraphNode>();
        start.visit();
        location.push(start);
        return depthFirstSearchRecursive(graph, start, finish, location);
    }

    public static List<GraphNode> depthFirstSearchRecursive(GraphClass graph, GraphNode start, GraphNode finish, Stack<GraphNode> location) {

        GraphNode currentNode = location.peek();
        List<GraphEdge> incidentEdges = graph.getIncidentEdges(currentNode);
        // getNextNode can return null
        GraphNode nextNode = getNextNode(incidentEdges, currentNode);
        if (nextNode == null) {
            location.pop();
            if (location.isEmpty()) {
                // if search has not found finish, because stack has been filled and emptied
                return new LinkedList<GraphNode>();
            }
        } else if (nextNode.equals(finish)) {
            location.push(nextNode);
            return new LinkedList<GraphNode>(location);
        } else {
            nextNode.visit();
            location.push(nextNode);
        }
        return depthFirstSearchRecursive(graph, start, finish, location);
    }

    private static GraphNode<String> getNextNode(List<GraphEdge> incidentEdges, GraphNode<String> startingNode) {
        if (incidentEdges.isEmpty() || incidentEdges == null || startingNode == null) {
            return null;
        } else {
            for (GraphEdge edge : incidentEdges) {
                GraphNode<String> node = edge.getOtherNode(startingNode);
                if (!node.isVisited()) {
                    return node;
                }
            }
            return null;
        }
    }

    public static List<GraphNode> breadthFirstSearch(GraphClass graph,  GraphNode start, GraphNode finish) {
        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("empty or null graph");
        }
        if(start == null || finish == null) {
            throw new IllegalArgumentException("null start node or target node");
        }
        if(! (graph.getNodes().contains(start) && graph.getNodes().contains(finish))) {
            return new LinkedList<GraphNode>();
        }

        // BFS uses a queue of nodes to visit
        // queue is add poll to get and remove peek to see
        Queue<GraphNode> nodeQueue = new LinkedList<GraphNode>();
        start.visit();
        nodeQueue.add(start);

        // list of nodes in order to be returned
        LinkedList<GraphEdge> transitions = new LinkedList<GraphEdge>();

        GraphNode currentNode = nodeQueue.poll();
        double distance = 0;
        while (currentNode != null) {
            List<GraphEdge> incidentEdges = graph.getIncidentEdges(currentNode);
            // getNextNode can return null
            GraphNode nextNode = getNextNode(incidentEdges, currentNode);
            while (nextNode != null) {
                transitions.add(new GraphEdge(currentNode, nextNode));
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
        return new LinkedList<GraphNode>();
    }

    // start node is unused, as this helper assumes the front of transitions is start
    private static List<GraphNode> getPathHome(List<GraphEdge> transitions, GraphNode start, GraphNode finish) {
        GraphNode to = finish;
        GraphNode from;
        LinkedList<GraphNode> nodeList = new LinkedList<GraphNode>();
        nodeList.addFirst(to);

        while(! transitions.isEmpty()) {
            GraphEdge edge = transitions.remove(transitions.size() - 1);
            if(edge.getRightNode().equals(to)) {
                from = edge.getLeftNode();
                nodeList.addFirst(from);
                to = from;
            }
        }
        return nodeList;
    }
}
