package graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shalka on 8/14/16.
 */
public class GraphSearchTest {

    private Node<String> nodeA;
    private Node<String> nodeB;
    private Node<String> nodeC;
    private Node<String> nodeD;
    private Node<String> nodeE;
    private Node<String> nodeF;
    private Node<String> nodeG;
    private Node<String> nodeH;
    private Node<String> nodeZ;

    private Graph graph1;
    private Graph graph2;

    @Before
    public void setUp() throws Exception {
        nodeA = new GraphNode<String>("A");
        nodeB = new GraphNode<String>("B");
        nodeC = new GraphNode<String>("C");
        nodeD = new GraphNode<String>("D");
        nodeE = new GraphNode<String>("E");
        nodeF = new GraphNode<String>("F");
        nodeG = new GraphNode<String>("G");
        nodeH = new GraphNode<String>("H");
        nodeZ = new GraphNode<String>("Z");

        List<Node> nodesForGraph1 = new LinkedList<Node>(Arrays.asList(
                nodeA,
                nodeB,
                nodeC,
                nodeD,
                nodeE,
                nodeF
        ));

        Edge edgeBetweenAandB = new UnweightedEdge(nodeA, nodeB);
        Edge edgeBetweenBandC = new UnweightedEdge(nodeB, nodeC);
        Edge edgeBetweenCandD = new UnweightedEdge(nodeC, nodeD);
        Edge edgeBetweenDandE = new UnweightedEdge(nodeD, nodeE);
        Edge edgeBetweenEandF = new UnweightedEdge(nodeE, nodeF);

        List<Edge> edgesForGraph1 = new LinkedList<Edge>();
        edgesForGraph1.add(edgeBetweenAandB);
        edgesForGraph1.add(edgeBetweenBandC);
        edgesForGraph1.add(edgeBetweenCandD);
        edgesForGraph1.add(edgeBetweenDandE);
        edgesForGraph1.add(edgeBetweenEandF);
        //
        // Graph #1: Straight line (unweighted, undirected)
        //  A -> B -> C -> D -> E -> F
        //
        graph1 = new UndirectedGraph(edgesForGraph1, nodesForGraph1);

        List<Node> nodesForGraph2 = new LinkedList<Node>(Arrays.asList(
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

        Edge edgeBetweenFandG = new UnweightedEdge(nodeF, nodeG);
        Edge edgeBetweenGandH = new UnweightedEdge(nodeG, nodeH);
        Edge edgeBetweenAandZ = new UnweightedEdge(nodeA, nodeZ);
        Edge edgeBetweenZandH = new UnweightedEdge(nodeZ, nodeH);

        List<Edge> edgesForGraph2 = new LinkedList<Edge>();
        edgesForGraph2.add(edgeBetweenAandB);
        edgesForGraph2.add(edgeBetweenBandC);
        edgesForGraph2.add(edgeBetweenCandD);
        edgesForGraph2.add(edgeBetweenDandE);
        edgesForGraph2.add(edgeBetweenEandF);
        edgesForGraph2.add(edgeBetweenFandG);
        edgesForGraph2.add(edgeBetweenGandH);
        edgesForGraph2.add(edgeBetweenAandZ);
        edgesForGraph2.add(edgeBetweenZandH);

        //
        // Graph #2: Different solutions for DFS and BFS (unweighted, undirected)
        //  A -> B -> C -> D -> E -> F -> G -> H
        //    \                               /
        //     \------------> Z -------------/
        //
        graph2 = new UndirectedGraph(edgesForGraph2, nodesForGraph2);

    }

    @Test
    public void depthFirstSearchGraph01() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(graph1, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("B"));
        Assert.assertTrue(path.get(2).getValue().equals("C"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("E"));
        Assert.assertTrue(path.get(5).getValue().equals("F"));
    }

    @Test
    public void breadthFirstSearchGraph01() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(graph1, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("B"));
        Assert.assertTrue(path.get(2).getValue().equals("C"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("E"));
        Assert.assertTrue(path.get(5).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchGraph02() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(graph2, nodeA, nodeH);
        Assert.assertEquals(path.size(), 8);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("B"));
        Assert.assertTrue(path.get(2).getValue().equals("C"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("E"));
        Assert.assertTrue(path.get(5).getValue().equals("F"));
        Assert.assertTrue(path.get(6).getValue().equals("G"));
        Assert.assertTrue(path.get(7).getValue().equals("H"));
    }

    @Test
    public void breadthFirstSearchGraph02() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(graph2, nodeA, nodeH);
        Assert.assertEquals(path.size(), 2);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("H"));
    }
}