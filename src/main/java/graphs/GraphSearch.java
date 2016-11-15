package graphs;

import java.util.*;
import java.util.stream.Collectors;

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
                    return node;
                }
            }
            return null;
        }
    }

    public static List<Node> breadthFirstSearch(Graph graph, Node start, Node finish) {
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
            List<Edge> incidentEdges = graph.getIncidentEdges(currentNode);
            // getNextNode can return null
            Node nextNode = getNextNode(incidentEdges, currentNode);
            while (nextNode != null) {
                transitions.add(new Edge(currentNode, nextNode));
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


    /*
        djikstras algo:
        takes: graph, source, target

        map of V to distance from source
            - instantiate at MAX_INT
        map of V's previous node

        set of V

        // set source distance to zero
        distanceMap.put(source, 0)
        while(! setOfV.isEmpty())

            Node currentNode = setOfV.pop()
            update distance values for all nodes from nextNode
            ie get incident edges and
            update distance for each node = min(distance(node), distance(currentNode) + edge(currentNode, nextNode).getWeight())
                if distance < current distance + edge weight
                    update distance
                    update previous node

            // sort algo that takes list of nodes and map to their current distances and sorts nodes
            find next node that is ! in settled and shortest distance (ie distance(currentNode) + edge(currentNode, nextNode).getWeight())
            shortest distance nextNode gets added to settled

        eventually every node will have a non infinite distance from source


     */

    public static List<Node> djikstraShortestPath(Graph graph, Node start, Node finish) {
        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("empty or null graph");
        }
        if(start == null || finish == null) {
            throw new IllegalArgumentException("null start node or target node");
        }
        if(! (graph.getNodes().contains(start) && graph.getNodes().contains(finish))) {
            throw new IllegalArgumentException("either start node or target node are not contained in graph");
        }

        LinkedList<Node> nodes = new LinkedList<>(graph.getNodes());

        HashMap<Node, Double> distanceMap = new HashMap<>();
        for(Node node : nodes) {
            distanceMap.put(node, Double.valueOf(Double.MAX_VALUE));
        }
        HashMap<Node, Node> previousNodeMap = new HashMap<>();

        distanceMap.put(start, Double.valueOf(0));
        while(! distanceMap.isEmpty()) {
            Node currentNode = getShortestDistanceNode(distanceMap);
            if(currentNode.equals(finish)) {
                break;
            }
            double currentDistance = distanceMap.get(currentNode);
            distanceMap.remove(currentNode);
            List<Edge> incidentEdges = graph.getIncidentEdges(currentNode);
            for(Edge edge : incidentEdges) {
                Node nextNode = edge.getRightNode();
                if(distanceMap.containsKey(nextNode)){
                    double newDistance = currentDistance + edge.getWeight();
                    if(newDistance < distanceMap.get(nextNode)) {
                        distanceMap.put(nextNode, newDistance);
                        previousNodeMap.put(nextNode, currentNode);
                    }
                }
            }
        }
        if(! previousNodeMap.containsKey(finish)) {
            return new LinkedList<Node>();
        }
        LinkedList<Edge> transitions = new LinkedList<Edge>();
        HashSet<Node> keys = new HashSet<Node>(previousNodeMap.keySet());
        Node nextNode = finish;
        keys.remove(nextNode);
        while(! keys.isEmpty()) {
            Node currentNode = previousNodeMap.get(nextNode);
            transitions.addFirst(new Edge(currentNode, nextNode));
            if(currentNode.equals(start)) {
                break;
            }
            nextNode = currentNode;
            keys.remove(nextNode);
        }
        return getPathHome(transitions, start, finish);
    }

    private static Node getShortestDistanceNode(HashMap<Node, Double> nodeMap) {
        return nodeMap.entrySet()
               .stream()
               .sorted(Map.Entry.comparingByValue())
               .findFirst().get().getKey();

    }
}
