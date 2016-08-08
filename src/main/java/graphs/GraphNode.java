package graphs;

public class GraphNode<T> implements Node<T> {

    private float x;
    private float y;
    private T value;

    public GraphNode(float x, float y, T value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public float getX() { return x; }

    public float getY() {
        return y;
    }

    public T getValue() {
        return this.value;
    }

    public void setX(float x) { this.x = x; }

    public void setY(float y) {
        this.y = y;
    }
}
