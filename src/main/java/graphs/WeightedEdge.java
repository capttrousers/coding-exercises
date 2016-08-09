package graphs;

public class WeightedEdge implements Edge {
    private Node leftNode;
    private Node rightNode;
    private double weight;

    public WeightedEdge(Node leftNode, Node rightNode, double weight) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.weight = weight;
    }

    public WeightedEdge(WeightedEdge edge){
        this.leftNode = edge.getLeftNode();
        this.rightNode = edge.getRightNode();
        this.weight = edge.getWeight();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public boolean contains(Node node) {
        return leftNode.equals(node) || rightNode.equals(node);
    }

    // will return null if node is not in edge, else returns opposite node
    public Node getOtherNode(Node node) {
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
}
