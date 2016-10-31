package graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UndirectedUnweightedGraphTest {

    private Node<String> nodeA;
    private Node<String> nodeB;
    private Node<String> nodeC;
    private Node<String> nodeD;
    private Node<String> nodeE;
    private Node<String> nodeF;
    private Node<String> nodeG;
    private Node<String> nodeH;
    private Node<String> nodeZ;

    private Graph UndirectedUnweightedGraph1,
                  UndirectedUnweightedGraph2,
                  UndirectedUnweightedGraph3,
                  UndirectedUnweightedGraph4,
                  UndirectedUnweightedGraph5,
                  UndirectedUnweightedGraph6,
                  UndirectedUnweightedGraph7;



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
        UndirectedUnweightedGraph1 = new Graph(nodesForUndirectedUnweightedGraph1, edgesForUndirectedUnweightedGraph1);


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

        Edge edgeBetweenFandG = new Edge(nodeF, nodeG);
        Edge edgeBetweenGandH = new Edge(nodeG, nodeH);
        Edge edgeBetweenAandZ = new Edge(nodeA, nodeZ);
        Edge edgeBetweenHandZ = new Edge(nodeH, nodeZ);

        List<Edge> edgesForUndirectedUnweightedGraph2 = new LinkedList<Edge>();
        edgesForUndirectedUnweightedGraph2.add(edgeBetweenAandB);
        edgesForUndirectedUnweightedGraph2.add(edgeBetweenBandC);
        edgesForUndirectedUnweightedGraph2.add(edgeBetweenCandD);
        edgesForUndirectedUnweightedGraph2.add(edgeBetweenDandE);
        edgesForUndirectedUnweightedGraph2.add(edgeBetweenEandF);
        edgesForUndirectedUnweightedGraph2.add(edgeBetweenFandG);
        edgesForUndirectedUnweightedGraph2.add(edgeBetweenGandH);
        edgesForUndirectedUnweightedGraph2.add(edgeBetweenAandZ);
        edgesForUndirectedUnweightedGraph2.add(edgeBetweenHandZ);

        //
        // Graph #2: Different solutions for DFS and BFS (unweighted, undirected)
        //  A -> B -> C -> D -> E -> F -> G -> H
        //    \                               /
        //     \------------> Z -------------/
        //
        UndirectedUnweightedGraph2 = new Graph(nodesForUndirectedUnweightedGraph2, edgesForUndirectedUnweightedGraph2);



        // graph 2 has all nodes A - H & Z
        List<Node> nodesForUndirectedUnweightedGraph3 = nodesForUndirectedUnweightedGraph2;

//        Edge edgeBetweenHandZ = new Edge(nodeZ, nodeH);
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

        Edge edgeBetweenEandZ = new Edge(nodeE, nodeZ);
        Edge edgeBetweenEandG = new Edge(nodeE, nodeG);
        Edge edgeBetweenDandH = new Edge(nodeD, nodeH);
        Edge edgeBetweenDandF = new Edge(nodeD, nodeF);
        Edge edgeBetweenBandD = new Edge(nodeB, nodeD);
        Edge edgeBetweenAandD = new Edge(nodeA, nodeD);

        List<Edge> edgesForUndirectedUnweightedGraph3 = new LinkedList<Edge>();
        edgesForUndirectedUnweightedGraph3.add(edgeBetweenBandC);
        edgesForUndirectedUnweightedGraph3.add(edgeBetweenCandD);
        edgesForUndirectedUnweightedGraph3.add(edgeBetweenHandZ);
        edgesForUndirectedUnweightedGraph3.add(edgeBetweenEandZ);
        edgesForUndirectedUnweightedGraph3.add(edgeBetweenEandG);
        edgesForUndirectedUnweightedGraph3.add(edgeBetweenDandH);
        edgesForUndirectedUnweightedGraph3.add(edgeBetweenDandF);
        edgesForUndirectedUnweightedGraph3.add(edgeBetweenBandD);
        edgesForUndirectedUnweightedGraph3.add(edgeBetweenAandD);

        //
        // Graph #3: see UndirectedUnweightedGraph3.png
        //
        UndirectedUnweightedGraph3 = new Graph(nodesForUndirectedUnweightedGraph3, edgesForUndirectedUnweightedGraph3);



        // graph 2 has all nodes A - H & Z
        List<Node> nodesForUndirectedUnweightedGraph4 = nodesForUndirectedUnweightedGraph2;

//        Edge edgeBetweenHandZ = new Edge(nodeZ, nodeH);
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
        Edge edgeBetweenBandE = new Edge(nodeB, nodeE);
        Edge edgeBetweenBandH = new Edge(nodeB, nodeH);
        Edge edgeBetweenCandF = new Edge(nodeC, nodeF);


        List<Edge> edgesForUndirectedUnweightedGraph4 = new LinkedList<Edge>();
        edgesForUndirectedUnweightedGraph4.add(edgeBetweenCandD);
        edgesForUndirectedUnweightedGraph4.add(edgeBetweenHandZ);
        edgesForUndirectedUnweightedGraph4.add(edgeBetweenEandG);
        edgesForUndirectedUnweightedGraph4.add(edgeBetweenDandH);
        edgesForUndirectedUnweightedGraph4.add(edgeBetweenDandF);
        edgesForUndirectedUnweightedGraph4.add(edgeBetweenAandB);
        edgesForUndirectedUnweightedGraph4.add(edgeBetweenGandH);
        edgesForUndirectedUnweightedGraph4.add(edgeBetweenBandE);
        edgesForUndirectedUnweightedGraph4.add(edgeBetweenBandH);
        edgesForUndirectedUnweightedGraph4.add(edgeBetweenCandF);


        //
        // Graph #4: see UndirectedUnweightedGraph4.png
        //
        UndirectedUnweightedGraph4 = new Graph(nodesForUndirectedUnweightedGraph4, edgesForUndirectedUnweightedGraph4);


        // graph 2 has all nodes A - H & Z
        List<Node> nodesForUndirectedUnweightedGraph5 = nodesForUndirectedUnweightedGraph2;
        //
        // Graph #5: graph with nodes from graph 2 and edges from graph 1
        //
        // start and target have no path, will return empty list
        UndirectedUnweightedGraph5 = new Graph(nodesForUndirectedUnweightedGraph5, edgesForUndirectedUnweightedGraph1);



        // graph 2 has all nodes A - H & Z
        List<Node> nodesForUndirectedUnweightedGraph6 = nodesForUndirectedUnweightedGraph2;
        /*
         * make edges, then make edge list:
         * graph 6 nodes A-F, and all edges (15)
         * a-b ~
         * a-c
         * a-d ~
         * a-e
         * a-f
         * b-c ~
         * b-d ~
         * b-e ~
         * b-f
         * c-d ~
         * c-e
         * c-f ~
         * d-e ~
         * d-f ~
         * e-f ~
         *
         */

        Edge edgeBetweenCandE = new Edge(nodeC, nodeE);
        Edge edgeBetweenBandF = new Edge(nodeB, nodeF);
        Edge edgeBetweenAandF = new Edge(nodeA, nodeF);
        Edge edgeBetweenAandE = new Edge(nodeA, nodeE);
        Edge edgeBetweenAandC = new Edge(nodeA, nodeC);


        List<Edge> edgesForUndirectedUnweightedGraph6 = new LinkedList<Edge>(edgesForUndirectedUnweightedGraph1);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenCandF);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenAandB);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenAandD);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenBandC);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenBandD);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenBandE);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenCandD);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenCandE);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenDandE);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenDandF);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenEandF);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenBandF);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenAandF);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenAandE);
        edgesForUndirectedUnweightedGraph6.add(edgeBetweenAandC);

        //
        // Graph #6: graph with nodes from graph 1, fully connected
        //
        UndirectedUnweightedGraph6 = new Graph(nodesForUndirectedUnweightedGraph6, edgesForUndirectedUnweightedGraph6);



        // graph 2 has all nodes A - H & Z
        List<Node> nodesForUndirectedUnweightedGraph7 = nodesForUndirectedUnweightedGraph2;
        // edges needed (17):
        /*
         * a-b ~
         * a-e ~
         * a-z ~
         * a-g
         * b-g
         * b-e ~
         * e-g ~
         * g-z
         * e-z ~
         * d-e ~
         * h-z ~
         * d-h ~
         * c-d ~
         * d-f ~
         * c-h
         * c-f ~
         * f-h
         *
         */


        Edge edgeBetweenCandH = new Edge(nodeC, nodeH);
        Edge edgeBetweenBandG = new Edge(nodeB, nodeG);
        Edge edgeBetweenAandG = new Edge(nodeA, nodeG);
        Edge edgeBetweenGandZ = new Edge(nodeG, nodeZ);
        Edge edgeBetweenFandH = new Edge(nodeF, nodeH);

        List<Edge> edgesForUndirectedUnweightedGraph7 = new LinkedList<Edge>();
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenAandB);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenAandE);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenAandZ);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenBandE);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenCandD);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenCandF);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenDandE);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenDandF);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenDandH);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenEandG);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenEandZ);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenHandZ);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenCandH);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenBandG);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenAandG);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenGandZ);
        edgesForUndirectedUnweightedGraph7.add(edgeBetweenFandH);
        //
        //  Graph #7: graph7.png
        //
        UndirectedUnweightedGraph7 = new Graph(nodesForUndirectedUnweightedGraph7, edgesForUndirectedUnweightedGraph7);



    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph01() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedGraph1, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("B"));
        Assert.assertTrue(path.get(2).getValue().equals("C"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("E"));
        Assert.assertTrue(path.get(5).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchRecursiveUndirectedUnweightedGraph01() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedGraph1, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("B"));
        Assert.assertTrue(path.get(2).getValue().equals("C"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("E"));
        Assert.assertTrue(path.get(5).getValue().equals("F"));
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph01() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedUnweightedGraph1, nodeA, nodeF);
        Assert.assertEquals(path.size(), 5);
    }

    @Test
    public void breadthFirstSearchUndirectedUnweightedGraph01() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedGraph1, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("B"));
        Assert.assertTrue(path.get(2).getValue().equals("C"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("E"));
        Assert.assertTrue(path.get(5).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph02() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedGraph2, nodeA, nodeH);
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
    public void depthFirstSearchRecursiveUndirectedUnweightedGraph02() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedGraph2, nodeA, nodeH);
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
    public void breadthFirstSearchUndirectedUnweightedGraph02() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedGraph2, nodeA, nodeH);
        Assert.assertEquals(path.size(), 3);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("H"));
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph02() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedUnweightedGraph2, nodeA, nodeH);
        Assert.assertEquals(path.size(), 3);
    }


    @Test
    public void depthFirstSearchUndirectedUnweightedGraph03() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedGraph3, nodeB, nodeE);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("C"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("H"));
        Assert.assertTrue(path.get(4).getValue().equals("Z"));
        Assert.assertTrue(path.get(5).getValue().equals("E"));
    }

    @Test
    public void depthFirstSearchRecursiveUndirectedUnweightedGraph03() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedGraph3, nodeB, nodeE);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("C"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("H"));
        Assert.assertTrue(path.get(4).getValue().equals("Z"));
        Assert.assertTrue(path.get(5).getValue().equals("E"));
    }

    @Test
    public void breadthFirstSearchUndirectedUnweightedGraph03() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedGraph3, nodeB, nodeE);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("D"));
        Assert.assertTrue(path.get(2).getValue().equals("H"));
        Assert.assertTrue(path.get(3).getValue().equals("Z"));
        Assert.assertTrue(path.get(4).getValue().equals("E"));
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph03() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedUnweightedGraph3, nodeB, nodeE);
        Assert.assertEquals(path.size(), 5);
    }


    @Test
    public void depthFirstSearchUndirectedUnweightedGraph04() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedGraph4, nodeB, nodeF);
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
    public void depthFirstSearchRecursiveUndirectedUnweightedGraph04() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedGraph4, nodeB, nodeF);
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
    public void breadthFirstSearchUndirectedUnweightedGraph04() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedGraph4, nodeB, nodeF);
        Assert.assertEquals(path.size(), 4);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("H"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph04() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedUnweightedGraph4, nodeB, nodeF);
        Assert.assertEquals(path.size(), 4);
    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph05() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedGraph5, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveUndirectedUnweightedGraph05() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedGraph5, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchUndirectedUnweightedGraph05() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedGraph5, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph05() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedUnweightedGraph5, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph06() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedGraph6, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void depthFirstSearchRecursiveUndirectedUnweightedGraph06() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedGraph6, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph06() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedUnweightedGraph6, nodeA, nodeF);
        Assert.assertEquals(path.size(), 2);
    }

    @Test
    public void breadthFirstSearchUndirectedUnweightedGraph06() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedGraph6, nodeA, nodeF);
        Assert.assertEquals(path.size(), 2);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph07() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(UndirectedUnweightedGraph7, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void depthFirstSearchRecursiveUndirectedUnweightedGraph07() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedGraph7, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void breadthFirstSearchUndirectedUnweightedGraph07() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedGraph7, nodeA, nodeF);
        Assert.assertEquals(path.size(), 4);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
    }

    @Test
    public void djikstraShortestPathUndirectedUnweightedGraph07() throws Exception {
        List<Node> path = GraphSearch.djikstraShortestPath(UndirectedUnweightedGraph7, nodeA, nodeF);
        Assert.assertEquals(path.size(), 4);
    }



}