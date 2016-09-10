package graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    private Graph graph1,
                  graph2,
                  graph3,
                  graph4,
                  graph5,
                  graph6,
                  graph7;


    @Rule
    public ExpectedException thrown = ExpectedException.none();

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


        // graph 2 has all nodes A - H & Z
        List<Node> nodesForGraph5 = nodesForGraph2;
        //
        // Graph #5: graph with nodes from graph 2 and edges from graph 1
        //
        // start and target have no path, will return empty list
        graph5 = new UndirectedGraph(edgesForGraph1, nodesForGraph5);



        // graph 2 has all nodes A - H & Z
        List<Node> nodesForGraph6 = nodesForGraph2;
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

        Edge edgeBetweenCandE = new UnweightedEdge(nodeC, nodeE);
        Edge edgeBetweenBandF = new UnweightedEdge(nodeB, nodeF);
        Edge edgeBetweenAandF = new UnweightedEdge(nodeA, nodeF);
        Edge edgeBetweenAandE = new UnweightedEdge(nodeA, nodeE);
        Edge edgeBetweenAandC = new UnweightedEdge(nodeA, nodeC);


        List<Edge> edgesForGraph6 = new LinkedList<Edge>(edgesForGraph1);
        edgesForGraph6.add(edgeBetweenCandF);
        edgesForGraph6.add(edgeBetweenAandB);
        edgesForGraph6.add(edgeBetweenAandD);
        edgesForGraph6.add(edgeBetweenBandC);
        edgesForGraph6.add(edgeBetweenBandD);
        edgesForGraph6.add(edgeBetweenBandE);
        edgesForGraph6.add(edgeBetweenCandD);
        edgesForGraph6.add(edgeBetweenCandE);
        edgesForGraph6.add(edgeBetweenDandE);
        edgesForGraph6.add(edgeBetweenDandF);
        edgesForGraph6.add(edgeBetweenEandF);
        edgesForGraph6.add(edgeBetweenBandF);
        edgesForGraph6.add(edgeBetweenAandF);
        edgesForGraph6.add(edgeBetweenAandE);
        edgesForGraph6.add(edgeBetweenAandC);

        //
        // Graph #6: graph with nodes from graph 1, fully connected
        //
        graph6 = new UndirectedGraph(edgesForGraph6, nodesForGraph6);

        // graph 2 has all nodes A - H & Z
        List<Node> nodesForGraph7 = nodesForGraph2;
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


        Edge edgeBetweenCandH = new UnweightedEdge(nodeC, nodeH);
        Edge edgeBetweenBandG = new UnweightedEdge(nodeB, nodeG);
        Edge edgeBetweenAandG = new UnweightedEdge(nodeA, nodeG);
        Edge edgeBetweenGandZ = new UnweightedEdge(nodeG, nodeZ);
        Edge edgeBetweenFandH = new UnweightedEdge(nodeF, nodeH);

        List<Edge> edgesForGraph7 = new LinkedList<Edge>();
        edgesForGraph7.add(edgeBetweenAandB);
        edgesForGraph7.add(edgeBetweenAandE);
        edgesForGraph7.add(edgeBetweenAandZ);
        edgesForGraph7.add(edgeBetweenBandE);
        edgesForGraph7.add(edgeBetweenCandD);
        edgesForGraph7.add(edgeBetweenCandF);
        edgesForGraph7.add(edgeBetweenDandE);
        edgesForGraph7.add(edgeBetweenDandF);
        edgesForGraph7.add(edgeBetweenDandH);
        edgesForGraph7.add(edgeBetweenEandG);
        edgesForGraph7.add(edgeBetweenEandZ);
        edgesForGraph7.add(edgeBetweenHandZ);
        edgesForGraph7.add(edgeBetweenCandH);
        edgesForGraph7.add(edgeBetweenBandG);
        edgesForGraph7.add(edgeBetweenAandG);
        edgesForGraph7.add(edgeBetweenGandZ);
        edgesForGraph7.add(edgeBetweenFandH);
        
        graph7 = new UndirectedGraph(edgesForGraph7, nodesForGraph7);
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

    @Test
    public void depthFirstSearchGraph05() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(graph5, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveGraph05() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph5, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchGraph05() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(graph5, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchGraph06() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(graph6, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void depthFirstSearchRecursiveGraph06() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph6, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void breadthFirstSearchGraph06() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(graph6, nodeA, nodeF);
        Assert.assertEquals(path.size(), 2);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchGraph07() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(graph7, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void depthFirstSearchRecursiveGraph07() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph7, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void breadthFirstSearchGraph07() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(graph7, nodeA, nodeF);
        Assert.assertEquals(path.size(), 4);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchNullStartNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearch(graph5, null, nodeZ);
        // the expect message is thrown if the thrown var doesnt catch it's appropriate exception?
        // ie this message doesn't need to match the message of the thrown exception in GraphSearch.java, correct?
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveNullStartNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph5, null, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchNullStartNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.breadthFirstSearch(graph5, null, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchNullFinishNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearch(graph5, nodeA, null);
        // the expect message is thrown if the thrown var doesnt catch it's appropriate exception?
        // ie this message doesn't need to match the message of the thrown exception in GraphSearch.java, correct?
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveNullFinishNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph5, nodeA, null);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchNullFinishNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.breadthFirstSearch(graph5, nodeA, null);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchOutFinishNode() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(graph1, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveOutFinishNode() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph1, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchOutFinishNode() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(graph1, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchOutStartNode() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearch(graph1, nodeZ, nodeA);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveOutStartNode() throws Exception {
        List<Node> path = GraphSearch.depthFirstSearchRecursive(graph1, nodeZ, nodeA);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchOutStartNode() throws Exception {
        List<Node> path = GraphSearch.breadthFirstSearch(graph1, nodeZ, nodeA);
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
        List<Node> path = GraphSearch.depthFirstSearch(new UndirectedGraph(), nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveEmptyGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.depthFirstSearchRecursive(new UndirectedGraph(), nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchEmptyGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<Node> path = GraphSearch.breadthFirstSearch(new UndirectedGraph(), nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }
}