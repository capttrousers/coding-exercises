package graphs;

public class GraphEdge implements Comparable<GraphEdge> {
    private GraphNode leftNode;
    private GraphNode rightNode;
    private double weight;

    public GraphEdge(GraphNode leftNode, GraphNode rightNode, double weight) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        setWeight(weight);
    }

    public GraphEdge(GraphNode leftNode, GraphNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        setWeight(1);
    }

    public GraphEdge(GraphEdge edge) {
        this.leftNode = edge.getLeftNode();
        this.rightNode = edge.getRightNode();
        this.weight = edge.getWeight();
    }

    public double getWeight() {
        return weight;
    }

    public GraphEdge setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public GraphNode getLeftNode() {
        return leftNode;
    }

    public GraphNode getRightNode() {
        return rightNode;
    }

    public void setLeftNode(GraphNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(GraphNode rightNode) {
        this.rightNode = rightNode;
    }

    public boolean contains(GraphNode node) {
        return leftNode.equals(node) || rightNode.equals(node);
    }

    // will return null if node is not in edge, else returns opposite node
    public GraphNode getOtherNode(GraphNode node) {
        if(contains(node)) {
            if(node.equals(getRightNode())) {
                return getLeftNode();
            } else {
                return getRightNode();
            }
        } else {
            return null;
        }
    }

    // "Note: this class has a natural ordering that is inconsistent with equals."
    public int compareTo(GraphEdge edge) {
        // is it necessary to specify "this." ?
        if(edge.getWeight() > this.getWeight()) {
            return -1;
        } else if (this.getWeight() > edge.getWeight()){
            return 1;
        }
        return 0;
    }

}
