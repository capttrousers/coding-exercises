package graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DirectedUnweightedGraphTest {

    private Node<String> nodeA;
    private Node<String> nodeB;
    private Node<String> nodeC;
    private Node<String> nodeD;
    private Node<String> nodeE;
    private Node<String> nodeF;
    private Node<String> nodeG;
    private Node<String> nodeH;
    private Node<String> nodeZ;

    private Graph DirectedUnweightedGraph8,
                  DirectedUnweightedGraph9,
                  DirectedUnweightedGraph10;



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


        List<Node> nodesForUndirectedUnweightedGraph2 = new LinkedList<Node>(Arrays.asList(
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

        Edge edgeBetweenAandB = new Edge(nodeA, nodeB);
        Edge edgeBetweenBandC = new Edge(nodeB, nodeC);
        Edge edgeBetweenHandZ = new Edge(nodeH, nodeZ);
        Edge edgeBetweenEandZ = new Edge(nodeE, nodeZ);
        Edge edgeBetweenDandF = new Edge(nodeD, nodeF);
        Edge edgeBetweenBandD = new Edge(nodeB, nodeD);
        Edge edgeBetweenAandD = new Edge(nodeA, nodeD);
        Edge edgeBetweenBandH = new Edge(nodeB, nodeH);
        Edge edgeBetweenCandE = new Edge(nodeC, nodeE);
        Edge edgeBetweenBandF = new Edge(nodeB, nodeF);
        Edge edgeBetweenAandC = new Edge(nodeA, nodeC);
        Edge edgeBetweenFandH = new Edge(nodeF, nodeH);

        /*
         * graph 8
         * 12 edges
         * a-d ~
         * b-d ~
         * g-d
         * z-g
         * z-d
         * h-z ~
         * b-h ~
         * f-b
         * c-e ~
         * d-c
         * e-d
         * d-f
         */


        Edge edgeBetweenGandD = new Edge(nodeG,nodeD);
        Edge edgeBetweenZandG = new Edge(nodeZ,nodeG);
        Edge edgeBetweenZandD = new Edge(nodeZ,nodeD);
        Edge edgeBetweenFandB = new Edge(nodeF,nodeB);
        Edge edgeBetweenDandC = new Edge(nodeD,nodeC);
        Edge edgeBetweenEandD = new Edge(nodeE,nodeD);

        List<Edge> edgesForGraph8 = new LinkedList<Edge>();
        edgesForGraph8.add(edgeBetweenAandD);
        edgesForGraph8.add(edgeBetweenBandD);
        edgesForGraph8.add(edgeBetweenHandZ);
        edgesForGraph8.add(edgeBetweenBandH);
        edgesForGraph8.add(edgeBetweenCandE);
        edgesForGraph8.add(edgeBetweenGandD);
        edgesForGraph8.add(edgeBetweenZandG);
        edgesForGraph8.add(edgeBetweenZandD);
        edgesForGraph8.add(edgeBetweenFandB);
        edgesForGraph8.add(edgeBetweenDandC);
        edgesForGraph8.add(edgeBetweenEandD);
        edgesForGraph8.add(edgeBetweenDandF);


        // use nodes from graph 2
        DirectedUnweightedGraph8 = new Graph(nodesForUndirectedUnweightedGraph2, edgesForGraph8, true);
        //
        // Graph #8: directed and unweighted
        //


        /*
         * graph 9
         * 12 edges
         * a-b
         * b-c
         * c-e
         * e-d
         * g-d
         * g-a
         * z-g
         * h-z
         * f-h
         * d-f
         * e-z
         * f-a
         *
         */

        Edge edgeBetweenGandA = new Edge(nodeG, nodeA);
        Edge edgeBetweenFandA = new Edge(nodeF, nodeA);

        List<Edge> edgesForGraph9 = new LinkedList<Edge>();
        edgesForGraph9.add(edgeBetweenAandB);
        edgesForGraph9.add(edgeBetweenBandC);
        edgesForGraph9.add(edgeBetweenCandE);
        edgesForGraph9.add(edgeBetweenEandZ);
        edgesForGraph9.add(edgeBetweenEandD);
        edgesForGraph9.add(edgeBetweenGandD);
        edgesForGraph9.add(edgeBetweenZandG);
        edgesForGraph9.add(edgeBetweenHandZ);
        edgesForGraph9.add(edgeBetweenFandH);
        edgesForGraph9.add(edgeBetweenDandF);
        edgesForGraph9.add(edgeBetweenGandA);
        edgesForGraph9.add(edgeBetweenFandA);


        DirectedUnweightedGraph9 = new Graph(nodesForUndirectedUnweightedGraph2, edgesForGraph9, true);
        //
        // Graph #9: directed and unweighted
        //


        /*
         * graph 10
         * 10 edges
         * a-d
         * a-c
         * d-c
         * z-c
         * g-e
         * e-b
         * b-f
         * f-h
         * d-z
         * g-a
         */

        Edge edgeBetweenZandC = new Edge(nodeZ, nodeC);
        Edge edgeBetweenGandE = new Edge(nodeG, nodeE);
        Edge edgeBetweenEandB = new Edge(nodeE, nodeB);
        Edge edgeBetweenDandZ = new Edge(nodeD, nodeZ);
        List<Edge> edgesForGraph10 = new LinkedList<Edge>();
        edgesForGraph10.add(edgeBetweenAandD);
        edgesForGraph10.add(edgeBetweenAandC);
        edgesForGraph10.add(edgeBetweenDandC);
        edgesForGraph10.add(edgeBetweenBandF);
        edgesForGraph10.add(edgeBetweenFandH);
        edgesForGraph10.add(edgeBetweenZandC);
        edgesForGraph10.add(edgeBetweenGandE);
        edgesForGraph10.add(edgeBetweenEandB);
        edgesForGraph10.add(edgeBetweenDandZ);
        edgesForGraph10.add(edgeBetweenGandA);

        DirectedUnweightedGraph10 = new Graph(nodesForUndirectedUnweightedGraph2, edgesForGraph10, true);
        //
        // Graph #10: directed and unweighted
        //



    }

    @Test
    public void depthFirstSearchDirectedUnweightedGraph08() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(DirectedUnweightedGraph8, nodeH, nodeB);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("H"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
        Assert.assertTrue(path.get(5).getValue().equals("B"));
    }

    @Test
    public void depthFirstSearchRecursiveDirectedUnweightedGraph08() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(DirectedUnweightedGraph8, nodeH, nodeB);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("H"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
        Assert.assertTrue(path.get(5).getValue().equals("B"));
    }

    @Test
    public void breadthFirstSearchDirectedUnweightedGraph08() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(DirectedUnweightedGraph8, nodeH, nodeB);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("H"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("B"));
    }

    @Test
    public void djikstraShortestPathDirectedWeightedGraph08() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(DirectedUnweightedGraph8, nodeH, nodeB);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("H"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("B"));
    }

    @Test
    public void depthFirstSearchDirectedUnweightedGraph09() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(DirectedUnweightedGraph9, nodeE, nodeF);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchRecursiveDirectedUnweightedGraph09() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(DirectedUnweightedGraph9, nodeE, nodeF);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
    }

    @Test
    public void breadthFirstSearchDirectedUnweightedGraph09() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(DirectedUnweightedGraph9, nodeE, nodeF);
        Assert.assertEquals(path.size(), 3);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("D"));
        Assert.assertTrue(path.get(2).getValue().equals("F"));
    }

    @Test
    public void djikstraShortestPathDirectedWeightedGraph09() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(DirectedUnweightedGraph9, nodeE, nodeF);
        Assert.assertEquals(path.size(), 3);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("D"));
        Assert.assertTrue(path.get(2).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchDirectedUnweightedGraph10() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(DirectedUnweightedGraph10, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void depthFirstSearchRecursiveDirectedUnweightedGraph10() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(DirectedUnweightedGraph10, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void breadthFirstSearchDirectedUnweightedGraph10() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(DirectedUnweightedGraph10, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void djikstraShortestPathDirectedWeightedGraph10() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(DirectedUnweightedGraph10, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

}