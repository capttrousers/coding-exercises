package graphs;

public interface Edge {
    Node getLeftNode();
    Node getRightNode();
    boolean contains(Node node);
}
