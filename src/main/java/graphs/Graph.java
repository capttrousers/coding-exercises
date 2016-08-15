package graphs;

import java.util.List;

public interface Graph {
    public List<Edge> getEdges();
    public List<Node> getNodes();
    public List<Edge> getIncidentEdges(Node node);
    public boolean isEmpty();
    public boolean isDirected();
}
