package graphs;

import java.util.*;

public class GraphClass {
    private List<GraphEdge> edges;
    private List<GraphNode> nodes;
    private boolean isDirected;
    private boolean isWeighted;

    public GraphClass() {
        edges = new ArrayList<GraphEdge>();
        nodes = new ArrayList<GraphNode>();
        setDirected(false);
        setWeighted(false);
    }

    public GraphClass(List<GraphNode> nodes, List<GraphEdge> edges) {
        this.edges = edges;
        this.nodes = nodes;
        setDirected(false);
        setWeighted(false);
    }

    public GraphClass(GraphClass graph) {
        edges = graph.getEdges();
        nodes = graph.getNodes();
        isDirected = graph.isDirected();
        isWeighted = graph.isWeighted();
    }

    public List<GraphEdge> getEdges() {
        return edges;
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void addNode(GraphNode node) {
        nodes.add(node);
    }

    public void addEdge(GraphEdge edge) {
        edges.add(edge);
    }

//    public void addEdge(GraphNode leftNode, GraphNode rightNode) {
////         weight is the sqrt( ( left.x - right.x) ^ 2 + (left.y - right.y) ^ 2)
//        double weight = Math.sqrt(Math.pow(leftNode.getX() - rightNode.getX(), 2) + Math.pow((leftNode.getY() - rightNode.getY()),2));
//        edges.add(new GraphEdge(leftNode, rightNode, weight));
//    }

    // returns removed node for chaining
    public GraphNode removeNode(GraphNode node) {
        Set<GraphEdge> toRemove = new HashSet<GraphEdge>();
        for(GraphEdge edge : edges) {
            if(edge.contains(node)) {
                toRemove.add(edge);
            }
        }
        edges.removeAll(toRemove);
        nodes.remove(node);
        return node;
    }

    public void removeEdge(GraphEdge edge) {
        edges.remove(edge);
    }

    // set directed will work on graph and all edges so can be done at the end
    public void setDirected(boolean directed) {
        isDirected = directed;
        for(GraphEdge edge : edges) {
            edge.setDirected(directed);
        }
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

    public List<GraphEdge> getIncidentEdges(GraphNode node) {
        List<GraphEdge> incidentEdges = new LinkedList<GraphEdge>();
        for(GraphEdge edge : edges) {
            if(edge.getLeftNode().equals(node) || (edge.getRightNode().equals(node)  && ! isDirected)) {
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
