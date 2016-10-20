package graphs;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.LinkedList;
import java.util.Collections;


public class Graph {
    private List<Edge> edges;
    private List<Node> nodes;
    private boolean isDirected;
    private boolean isWeighted;

    public Graph() {
        edges = new ArrayList<Edge>();
        nodes = new ArrayList<Node>();
        setDirected(false);
        setWeighted(false);
    }

    public Graph(List<Node> nodes, List<Edge> edges) {
        // if no flag for isDirected, default false
        this(nodes, edges, false);
    }

    public Graph(List<Node> nodes, List<Edge> edges, boolean isDirected) {
        this.nodes = nodes;
        setDirected(isDirected);
        if(isDirected()) {
            this.edges = edges;
        } else {
            this.edges = new ArrayList<Edge>();
            for(Edge edge : edges) {
                addEdge(edge);
            }
        }
        setWeighted(false);
    }

    public Graph(Graph graph) {
        edges = graph.getEdges();
        nodes = graph.getNodes();
        isDirected = graph.isDirected();
        isWeighted = graph.isWeighted();
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
        if(! isDirected()) {
            edges.add(new Edge(edge.getRightNode(), edge.getLeftNode(), edge.getWeight()));
        }
    }

    //    public void addEdge(Node leftNode, Node rightNode) {
////         weight is the sqrt( ( left.x - right.x) ^ 2 + (left.y - right.y) ^ 2)
//        double weight = Math.sqrt(Math.pow(leftNode.getX() - rightNode.getX(), 2) + Math.pow((leftNode.getY() - rightNode.getY()),2));
//        edges.add(new Edge(leftNode, rightNode, weight));
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

    // set directed will work on graph and all edges so can be done at the end
    public void setDirected(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    // set weighted will only work on graph, is weighted on edges needs to be set individually with weight value
    public void setWeighted(boolean weighted) {
        isWeighted = weighted;
    }

    public List<Edge> getIncidentEdges(Node node) {
        List<Edge> incidentEdges = new LinkedList<Edge>();
        for(Edge edge : edges) {
            if(edge.getLeftNode().equals(node)) {
                incidentEdges.add(edge);
            }
        }
        if(isWeighted) {
            Collections.sort(incidentEdges);
        }
        return incidentEdges;
    }

    public boolean isEmpty() {
        return (edges.isEmpty() && nodes.isEmpty());
    }

}
