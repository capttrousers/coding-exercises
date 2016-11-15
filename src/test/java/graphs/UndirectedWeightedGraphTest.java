package graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UndirectedWeightedGraphTest {

    private Node<String> nodeA;
    private Node<String> nodeB;
    private Node<String> nodeC;
    private Node<String> nodeD;
    private Node<String> nodeE;
    private Node<String> nodeF;
    private Node<String> nodeG;
    private Node<String> nodeH;
    private Node<String> nodeZ;

    private Graph UndirectedWeightedGraph11,
                  UndirectedWeightedGraph12,
                  UndirectedWeightedGraph13;



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

        Edge edgeBetweenAandB = new Edge(nodeA, nodeB);
        Edge edgeBetweenBandC = new Edge(nodeB, nodeC);

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
        Edge edgeBetweenGandD = new Edge(nodeG,nodeD);
        Edge edgeBetweenZandG = new Edge(nodeZ,nodeG);
        Edge edgeBetweenZandD = new Edge(nodeZ,nodeD);
        Edge edgeBetweenFandB = new Edge(nodeF,nodeB);
        Edge edgeBetweenDandC = new Edge(nodeD,nodeC);
        Edge edgeBetweenEandD = new Edge(nodeE,nodeD);
        Edge edgeBetweenGandA = new Edge(nodeG, nodeA);
        Edge edgeBetweenFandA = new Edge(nodeF, nodeA);
        Edge edgeBetweenZandC = new Edge(nodeZ, nodeC);
        Edge edgeBetweenGandE = new Edge(nodeG, nodeE);
        Edge edgeBetweenEandB = new Edge(nodeE, nodeB);
        Edge edgeBetweenDandZ = new Edge(nodeD, nodeZ);


        /*
         * graph 8 but weighted
         * 12 edges
         * a-d
         * b-d
         * g-d
         * z-g
         * z-d 2, rest 1
         * h-z
         * b-h
         * f-b
         * c-e
         * d-c
         * e-d
         * d-f
         *
         *
         */
        List<Edge> edgesForGraph11 = new LinkedList<Edge>();
        edgesForGraph11.add(edgeBetweenAandD.setWeight(1));
        edgesForGraph11.add(edgeBetweenZandD.setWeight(2));
        edgesForGraph11.add(edgeBetweenBandD.setWeight(1));
        edgesForGraph11.add(edgeBetweenHandZ.setWeight(1));
        edgesForGraph11.add(edgeBetweenBandH.setWeight(1));
        edgesForGraph11.add(edgeBetweenCandE.setWeight(1));
        edgesForGraph11.add(edgeBetweenGandD.setWeight(1));
        edgesForGraph11.add(edgeBetweenZandG.setWeight(1));
        edgesForGraph11.add(edgeBetweenFandB.setWeight(1));
        edgesForGraph11.add(edgeBetweenDandC.setWeight(1));
        edgesForGraph11.add(edgeBetweenEandD.setWeight(1));
        edgesForGraph11.add(edgeBetweenDandF.setWeight(1));
        UndirectedWeightedGraph11 = new Graph(nodesForUndirectedUnweightedGraph2, edgesForGraph11, true);
        UndirectedWeightedGraph11.setWeighted(true);

        //
        // Graph #11: directed and weighted
        //

        /*
         * graph 9 but weighted
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
        List<Edge> edgesForGraph12 = new LinkedList<Edge>();
        edgesForGraph12.add(edgeBetweenAandB.setWeight(1));
        edgesForGraph12.add(edgeBetweenBandC.setWeight(1));
        edgesForGraph12.add(edgeBetweenCandE.setWeight(1));
        edgesForGraph12.add(edgeBetweenEandZ.setWeight(1));
        edgesForGraph12.add(edgeBetweenEandD.setWeight(2));
        edgesForGraph12.add(edgeBetweenGandD.setWeight(2));
        edgesForGraph12.add(edgeBetweenZandG.setWeight(1));
        edgesForGraph12.add(edgeBetweenHandZ.setWeight(1));
        edgesForGraph12.add(edgeBetweenFandH.setWeight(1));
        edgesForGraph12.add(edgeBetweenDandF.setWeight(1));
        edgesForGraph12.add(edgeBetweenGandA.setWeight(1));
        edgesForGraph12.add(edgeBetweenFandA.setWeight(1));
        UndirectedWeightedGraph12 = new Graph(nodesForUndirectedUnweightedGraph2, edgesForGraph12, true);
        UndirectedWeightedGraph12.setWeighted(true);

        //
        // Graph #12: directed and weighted
        //


        /*
         * graph 10 but weighted
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
         *
         */

        List<Edge> edgesForGraph13 = new LinkedList<Edge>();
        edgesForGraph13.add(edgeBetweenAandD.setWeight(1));
        edgesForGraph13.add(edgeBetweenAandC.setWeight(1));
        edgesForGraph13.add(edgeBetweenDandC.setWeight(1));
        edgesForGraph13.add(edgeBetweenBandF.setWeight(1));
        edgesForGraph13.add(edgeBetweenFandH.setWeight(1));
        edgesForGraph13.add(edgeBetweenZandC.setWeight(1));
        edgesForGraph13.add(edgeBetweenGandE.setWeight(2));
        edgesForGraph13.add(edgeBetweenEandB.setWeight(1));
        edgesForGraph13.add(edgeBetweenDandZ.setWeight(1));
        edgesForGraph13.add(edgeBetweenGandA.setWeight(1));


        UndirectedWeightedGraph13 = new Graph(nodesForUndirectedUnweightedGraph2, edgesForGraph13, true);
        UndirectedWeightedGraph13.setWeighted(true);

        //
        // Graph #13: directed and weighted
        //


    }

    @Test
    public void depthFirstSearchDirectedWeightedGraph11() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedWeightedGraph11, nodeH, nodeB);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("H"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
        Assert.assertTrue(path.get(5).getValue().equals("B"));
    }

    @Test
    public void depthFirstSearchRecursiveDirectedWeightedGraph11() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedWeightedGraph11, nodeH, nodeB);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("H"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
        Assert.assertTrue(path.get(5).getValue().equals("B"));
    }

    @Test
    public void breadthFirstSearchDirectedWeightedGraph11() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedWeightedGraph11, nodeH, nodeB);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("H"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("B"));
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph11() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedWeightedGraph11, nodeH, nodeB);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("H"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("B"));
    }

    @Test
    public void depthFirstSearchDirectedWeightedGraph12() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedWeightedGraph12, nodeE, nodeF);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchRecursiveDirectedWeightedGraph12() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedWeightedGraph12, nodeE, nodeF);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
    }

    @Test
    public void breadthFirstSearchDirectedWeightedGraph12() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedWeightedGraph12, nodeE, nodeF);
        Assert.assertEquals(path.size(), 3);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("D"));
        Assert.assertTrue(path.get(2).getValue().equals("F"));
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph12() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedWeightedGraph12, nodeE, nodeF);
        Assert.assertEquals(path.size(), 3);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("D"));
        Assert.assertTrue(path.get(2).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchDirectedWeightedGraph13() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedWeightedGraph13, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void depthFirstSearchRecursiveDirectedWeightedGraph13() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedWeightedGraph13, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph13() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedWeightedGraph13, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void breadthFirstSearchDirectedWeightedGraph13() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedWeightedGraph13, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    // same as graph 13, except start at e and look for c, un connected, will need to restart
    @Test
    public void depthFirstSearchDirectedWeightedGraph14() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedWeightedGraph13, nodeE, nodeC);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveDirectedWeightedGraph14() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedWeightedGraph13, nodeE, nodeC);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchDirectedWeightedGraph14() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedWeightedGraph13, nodeE, nodeC);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph14() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedWeightedGraph13, nodeE, nodeC);
        Assert.assertEquals(path.size(), 0);
    }

}