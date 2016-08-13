package graphs;

public interface Node<T> {
    float getX();
    float getY();
    T getValue();
    boolean isVisited();
}
