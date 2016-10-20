package graphs;

public class Node<T> {

    private float x;
    private float y;
    private T value;
    private boolean visited;

    public Node(Node<T> node) {
        setX(node.getX());
        setY(node.getY());
        setValue(node.getValue());
    }

    public Node(float x, float y, T value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public Node(T value) {
        this.value = value;
    }

    public float getX() { return x; }

    public float getY() {
        return y;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void visit()   { this.visited = true;  }

    public void unvisit() { this.visited = false; }

    public void setX(float x) { this.x = x; }

    public void setY(float y) {
        this.y = y;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
