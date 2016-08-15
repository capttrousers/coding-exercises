package graphs;

public interface Edge {
    Node getLeftNode();
    Node getRightNode();
    boolean contains(Node node);
    boolean isWeighted();
    Node getOtherNode(Node node);
}
