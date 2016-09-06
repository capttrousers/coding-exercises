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
    private Graph graph3;
    private Graph graph4;

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
        Edge edgeBetweenHandZ = new UnweightedEdge(nodeZ, nodeH);

        List<Edge> edgesForGraph2 = new LinkedList<Edge>();
        edgesForGraph2.add(edgeBetweenAandB);
        edgesForGraph2.add(edgeBetweenBandC);
        edgesForGraph2.add(edgeBetweenCandD);
        edgesForGraph2.add(edgeBetweenDandE);
        edgesForGraph2.add(edgeBetweenEandF);
        edgesForGraph2.add(edgeBetweenFandG);
        edgesForGraph2.add(edgeBetweenGandH);
        edgesForGraph2.add(edgeBetweenAandZ);
        edgesForGraph2.add(edgeBetweenHandZ);

        //
        // Graph #2: Different solutions for DFS and BFS (unweighted, undirected)
        //  A -> B -> C -> D -> E -> F -> G -> H
        //    \                               /
        //     \------------> Z -------------/
        //
        graph2 = new UndirectedGraph(edgesForGraph2, nodesForGraph2);


        // graph 2 has all nodes A - H & Z
        List<Node> nodesForGraph3 = nodesForGraph2;

//        Edge edgeBetweenHandZ = new UnweightedEdge(nodeZ, nodeH);
        /*
         * make edges, then make edge list:
         * graph 3 has edges:
         * A - D
         * B - D
         * B - C ~
         * C - D ~
         * D - F
         * D - H
         * H - Z ~
         * E - Z
         * E - G
         */
        Edge edgeBetweenEandZ = new UnweightedEdge(nodeZ, nodeE);
        Edge edgeBetweenEandG = new UnweightedEdge(nodeG, nodeE);
        Edge edgeBetweenDandH = new UnweightedEdge(nodeD, nodeH);
        Edge edgeBetweenDandF = new UnweightedEdge(nodeD, nodeF);
        Edge edgeBetweenBandD = new UnweightedEdge(nodeB, nodeD);
        Edge edgeBetweenAandD = new UnweightedEdge(nodeA, nodeD);

        List<Edge> edgesForGraph3 = new LinkedList<Edge>();
        edgesForGraph3.add(edgeBetweenBandC);
        edgesForGraph3.add(edgeBetweenCandD);
        edgesForGraph3.add(edgeBetweenHandZ);
        edgesForGraph3.add(edgeBetweenEandZ);
        edgesForGraph3.add(edgeBetweenEandG);
        edgesForGraph3.add(edgeBetweenDandH);
        edgesForGraph3.add(edgeBetweenDandF);
        edgesForGraph3.add(edgeBetweenBandD);
        edgesForGraph3.add(edgeBetweenAandD);



        //
        // Graph #3: see graph3.png
        //
        graph3 = new UndirectedGraph(edgesForGraph3, nodesForGraph3);


        // graph 2 has all nodes A - H & Z
        List<Node> nodesForGraph4 = nodesForGraph2;

//        Edge edgeBetweenHandZ = new UnweightedEdge(nodeZ, nodeH);
        /*
         * make edges, then make edge list:
         * graph 4 has edges:
         * a-b ~
         * b-e
         * b-h
         * e-g ~
         * g-h ~
         * h-z ~
         * h-d ~
         * d-f ~
         * d-c ~
         * c-f
         *
         */
        Edge edgeBetweenBandE = new UnweightedEdge(nodeB, nodeE);
        Edge edgeBetweenBandH = new UnweightedEdge(nodeB, nodeH);
        Edge edgeBetweenCandF = new UnweightedEdge(nodeC, nodeF);


        List<Edge> edgesForGraph4 = new LinkedList<Edge>();
        edgesForGraph4.add(edgeBetweenCandD);
        edgesForGraph4.add(edgeBetweenHandZ);
        edgesForGraph4.add(edgeBetweenEandG);
        edgesForGraph4.add(edgeBetweenDandH);
        edgesForGraph4.add(edgeBetweenDandF);
        edgesForGraph4.add(edgeBetweenAandB);
        edgesForGraph4.add(edgeBetweenGandH);
        edgesForGraph4.add(edgeBetweenBandE);
        edgesForGraph4.add(edgeBetweenBandH);
        edgesForGraph4.add(edgeBetweenCandF);


        //
        // Graph #4: see graph4.png
        //
        graph4 = new UndirectedGraph(edgesForGraph4, nodesForGraph4);

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
    public void depthFirstSearchRecursiveGraph01() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph1, nodeA, nodeF);
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
    public void depthFirstSearchRecursiveGraph02() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph2, nodeA, nodeH);
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
        Assert.assertEquals(path.size(), 3);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("H"));
    }

    @Test
    public void depthFirstSearchGraph03() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(graph3, nodeB, nodeE);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("C"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("H"));
        Assert.assertTrue(path.get(4).getValue().equals("Z"));
        Assert.assertTrue(path.get(5).getValue().equals("E"));
    }

    @Test
    public void depthFirstSearchRecursiveGraph03() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph3, nodeB, nodeE);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("C"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("H"));
        Assert.assertTrue(path.get(4).getValue().equals("Z"));
        Assert.assertTrue(path.get(5).getValue().equals("E"));
    }

    @Test
    public void breadthFirstSearchGraph03() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(graph3, nodeB, nodeE);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("D"));
        Assert.assertTrue(path.get(2).getValue().equals("H"));
        Assert.assertTrue(path.get(3).getValue().equals("Z"));
        Assert.assertTrue(path.get(4).getValue().equals("E"));
    }

    @Test
    public void depthFirstSearchGraph04() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(graph4, nodeB, nodeF);
        Assert.assertEquals(path.size(), 7);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("H"));
        Assert.assertTrue(path.get(4).getValue().equals("D"));
        Assert.assertTrue(path.get(5).getValue().equals("C"));
        Assert.assertTrue(path.get(6).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchRecursiveGraph04() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph4, nodeB, nodeF);
        Assert.assertEquals(path.size(), 7);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("H"));
        Assert.assertTrue(path.get(4).getValue().equals("D"));
        Assert.assertTrue(path.get(5).getValue().equals("C"));
        Assert.assertTrue(path.get(6).getValue().equals("F"));
    }

    @Test
    public void breadthFirstSearchGraph04() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(graph4, nodeB, nodeF);
        Assert.assertEquals(path.size(), 4);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("H"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
    }
}