package graphs;

import java.util.*;

public class GraphClass implements Graph {
    private List<Edge> edges;
    private List<Node> nodes;
    boolean isDirected;

    public GraphClass() {
        edges = new ArrayList<Edge>();
        nodes = new ArrayList<Node>();
        setDirected(false);
    }

    public GraphClass(List<Node> nodes, List<Edge> edges) {
        this.edges = edges;
        this.nodes = nodes;
        setDirected(false);
    }

    public GraphClass(Graph graph) {
        edges = graph.getEdges();
        nodes = graph.getNodes();
        isDirected = graph.isDirected();
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

//    public void addEdge(GraphNode leftNode, GraphNode rightNode) {
////         weight is the sqrt( ( left.x - right.x) ^ 2 + (left.y - right.y) ^ 2)
//        double weight = Math.sqrt(Math.pow(leftNode.getX() - rightNode.getX(), 2) + Math.pow((leftNode.getY() - rightNode.getY()),2));
//        edges.add(new WeightedEdge(leftNode, rightNode, weight));
//    }

    // returns removed node for chaining
    public Node removeNode(Node node) {
        Set<Edge> toRemove = new HashSet<Edge>();
        for(Edge edge : edges) {
            if(edge.contains(node)) {
                toRemove.add(edge);
            }
        }
        edges.removeAll(toRemove);
        nodes.remove(node);
        return node;
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    public List<Edge> getIncidentEdges(Node node) {
        List<Edge> incidentEdges = new LinkedList<Edge>();
        List<WeightedEdge> edges = new LinkedList<WeightedEdge>();
        boolean weighted = false;
        for(Edge edge : edges) {
            if(edge.getLeftNode().equals(node) || (edge.getRightNode().equals(node)  && ! isDirected)) {
                if(edge.isWeighted()) {
                    if(! weighted) {
                        weighted = true;
                    }
                    edges.add((WeightedEdge) edge);
                } else {
                    incidentEdges.add(edge);
                }
            }
        }
        // sort the incidentEdges by weight***
        // linked list so after we implement Comparable on Edges, we can return Collections.sort(incidentEdges)
        if(weighted) {
            Collections.sort(edges);
            return new LinkedList<Edge>(edges);
        }
        return incidentEdges;
    }

    public boolean isEmpty() {
        return (edges.isEmpty() && nodes.isEmpty());
    }

    public boolean isDirected() {
        // for now this is just going to return false in class GraphClass but could be abstracted to field
        return isDirected;
    }
}
