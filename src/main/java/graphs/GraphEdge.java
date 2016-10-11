package graphs;

public class GraphEdge implements Comparable<GraphEdge> {
    private GraphNode leftNode;
    private GraphNode rightNode;
    private double weight;
    private boolean isWeighted;
    private boolean isDirected;

    public GraphEdge(GraphNode leftNode, GraphNode rightNode, double weight) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        setWeight(weight);
        setWeighted(true);
        setDirected(false);
    }

    public GraphEdge(GraphNode leftNode, GraphNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.isWeighted = false;
        setDirected(false);
    }

    public GraphEdge(GraphEdge edge) {
        this.leftNode = edge.getLeftNode();
        this.rightNode = edge.getRightNode();
        this.weight = edge.getWeight();
    }

    public double getWeight() {
        if (!isWeighted) {
            // i should throw an exception here?
        }
        return weight;
    }

    // the way this is written, taking an GraphEdge that is unweighted
    // first need to setWeighted(true) then setWeight(weight)
    public GraphEdge setWeight(double weight) {
        if (isWeighted) {
            this.weight = weight;
        }
        return this;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public GraphEdge setWeighted(boolean weighted) {
        this.isWeighted = weighted;
        return this;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        this.isDirected = directed;
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
        if (isWeighted && edge.isWeighted()) {
            // is it necessary to specify "this." ?
            if(edge.getWeight() > this.getWeight()) {
                return -1;
            } else if (this.getWeight() > edge.getWeight()){
                return 1;
            }
        }
        return 0;
    }

}
