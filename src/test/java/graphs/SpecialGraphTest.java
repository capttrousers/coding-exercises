package graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SpecialGraphTest {

    private Node<String> nodeA;
    private Node<String> nodeB;
    private Node<String> nodeC;
    private Node<String> nodeD;
    private Node<String> nodeE;
    private Node<String> nodeF;
    private Node<String> nodeG;
    private Node<String> nodeH;
    private Node<String> nodeZ;

    private Graph UndirectedUnweightedgraph1,
                  UndirectedUnweightedgraph5;



    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        nodeA = new Node<String>("A");
        nodeB = new Node<String>("B");
        nodeC = new Node<String>("C");
        nodeD = new Node<String>("D");
        nodeE = new Node<String>("E");
        nodeF = new Node<String>("F");
        nodeG = new Node<String>("G");
        nodeH = new Node<String>("H");
        nodeZ = new Node<String>("Z");

        List<Node> nodesForUndirectedUnweightedGraph1 = new LinkedList<Node>(Arrays.asList(
                nodeA,
                nodeB,
                nodeC,
                nodeD,
                nodeE,
                nodeF
        ));

        Edge edgeBetweenAandB = new Edge(nodeA, nodeB);
        Edge edgeBetweenBandC = new Edge(nodeB, nodeC);
        Edge edgeBetweenCandD = new Edge(nodeC, nodeD);
        Edge edgeBetweenDandE = new Edge(nodeD, nodeE);
        Edge edgeBetweenEandF = new Edge(nodeE, nodeF);

        List<Edge> edgesForUndirectedUnweightedGraph1 = new LinkedList<Edge>();
        edgesForUndirectedUnweightedGraph1.add(edgeBetweenAandB);
        edgesForUndirectedUnweightedGraph1.add(edgeBetweenBandC);
        edgesForUndirectedUnweightedGraph1.add(edgeBetweenCandD);
        edgesForUndirectedUnweightedGraph1.add(edgeBetweenDandE);
        edgesForUndirectedUnweightedGraph1.add(edgeBetweenEandF);
        //
        // Graph #1: Straight line (unweighted, undirected)
        //  A -> B -> C -> D -> E -> F
        //
        UndirectedUnweightedgraph1 = new Graph(nodesForUndirectedUnweightedGraph1, edgesForUndirectedUnweightedGraph1);


        List<Node> nodesForUndirectedUnweightedGraph5  = new LinkedList<Node>(Arrays.asList(
                nodeA,
                nodeB,
                nodeC,
                nodeD,
                nodeE,
                nodeF,
                nodeG,
                nodeH,
                nodeZ
        ));

        //
        // Graph #5: graph with nodes from graph 2 and edges from graph 1
        //
        // start and target have no path, will return empty list
        UndirectedUnweightedgraph5 = new Graph(nodesForUndirectedUnweightedGraph5, edgesForUndirectedUnweightedGraph1);



    }

    @Test
    public void depthFirstSearchNullStartNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph5, null, nodeZ);
        // the expect message is thrown if the thrown var doesnt catch it's appropriate exception?
        // ie this message doesn't need to match the message of the thrown exception in GraphSearch.java, correct?
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveNullStartNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph5, null, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchNullStartNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph5, null, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchNullFinishNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph5, nodeA, null);
        // the expect message is thrown if the thrown var doesnt catch it's appropriate exception?
        // ie this message doesn't need to match the message of the thrown exception in GraphSearch.java, correct?
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveNullFinishNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph5, nodeA, null);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchNullFinishNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph5, nodeA, null);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchOutFinishNode() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph1, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveOutFinishNode() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph1, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchOutFinishNode() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph1, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchOutStartNode() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph1, nodeZ, nodeA);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveOutStartNode() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph1, nodeZ, nodeA);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchOutStartNode() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph1, nodeZ, nodeA);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchNullGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearch(null, nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveNullGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearchRecursive(null, nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchNullGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.breadthFirstSearch(null, nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchEmptyGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearch(new Graph(), nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveEmptyGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearchRecursive(new Graph(), nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchEmptyGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.breadthFirstSearch(new Graph(), nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

}