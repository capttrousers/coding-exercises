package graphs;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UndirectedGraph implements Graph{
    private Set<Edge> edges;
    private Set<Node> nodes;

    public UndirectedGraph() {
        edges = new HashSet<Edge>();
        nodes = new HashSet<Node>();
    }

    public UndirectedGraph(Set<Edge> edges, Set<Node> nodes) {
        this.edges = edges;
        this.nodes = nodes;
    }

    public UndirectedGraph(UndirectedGraph graph) {
        edges = graph.getEdges();
        nodes = graph.getNodes();
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(GraphNode leftNode, GraphNode rightNode) {
//         weight is the sqrt( ( left.x - right.x) ^ 2 + (left.y - right.y) ^ 2)

        double weight = Math.sqrt(Math.pow(leftNode.getX() - rightNode.getX(), 2) + Math.pow((leftNode.getY() - rightNode.getY()),2));
        edges.add(new WeightedEdge(leftNode, rightNode, weight));
    }

    public void removeNode(Node node) {
        nodes.remove(node);
        Set<Edge> toRemove = new HashSet<Edge>();
        for(Edge edge : edges) {
            if(edge.contains(node)) {
                toRemove.add(edge);
            }
        }
        edges.removeAll(toRemove);
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

}
