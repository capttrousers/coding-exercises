package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphSearch {

    public List<Node> depthFirstSearch(Graph g) {

        if(g == null || g.getNodes() == null || g.getEdges() == null) {
            throw new IllegalArgumentException("empty or null graph");
        }

        UndirectedGraph graph = new UndirectedGraph(g);

        // DFS uses a stack of nodes visited
        // stack is push pop peek : peek to see
        LinkedList<Node> locationStack = new LinkedList<Node>();
        Node startingNode = ((Node)graph.getNodes().toArray()[0]);
        locationStack.push(startingNode);
        LinkedList<Edge> incidentEdges;
        Node nextNode;

        boolean searching = true;
        while (searching) {
            incidentEdges = getIncidentEdges(graph.getEdges(), startingNode);
            // getNextNode can return null
            nextNode = getNextNode(incidentEdges, startingNode);
            if(nextNode == null) {
                locationStack.pop();
                if(locationStack.isEmpty()) {
                    searching = false;
                }
            } else {
                locationStack.push(nextNode);
            }
            startingNode = locationStack.peek();
        }
        return null;
    }

    private Node getNextNode(LinkedList<Edge> incidentEdges, Node startingNode) {
        if(incidentEdges.isEmpty() || incidentEdges == null) {
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

    private LinkedList<Edge> getIncidentEdges(Set<Edge> edges, Node node) {
        LinkedList<Edge> incidentEdges = new LinkedList<Edge>();
        for(Edge edge : edges) {
            if(edge.contains(node)) {
                edges.add(edge);
            }
        }
        // sort the incidentEdges by weight***
        // linked list so after we implement Comparable on Edges, we can return Collections.sort(incidentEdges)
        return incidentEdges;
    }


    public List<Node> breadthFirstSearch(Graph graph) {



        return null;
    }
}
