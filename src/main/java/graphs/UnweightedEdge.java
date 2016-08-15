package graphs;

public class UnweightedEdge implements Edge {
    private Node leftNode;
    private Node rightNode;

    public UnweightedEdge(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public UnweightedEdge(UnweightedEdge edge) {
        this.leftNode = edge.getLeftNode();
        this.rightNode = edge.getRightNode();
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

    public boolean isWeighted() {
        return false;
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
