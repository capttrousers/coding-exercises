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

    private GraphNode<String> nodeA;
    private GraphNode<String> nodeB;
    private GraphNode<String> nodeC;
    private GraphNode<String> nodeD;
    private GraphNode<String> nodeE;
    private GraphNode<String> nodeF;
    private GraphNode<String> nodeG;
    private GraphNode<String> nodeH;
    private GraphNode<String> nodeZ;

    private GraphClass UndirectedUnweightedgraph1,
                  UndirectedUnweightedgraph2,
                  UndirectedUnweightedgraph3,
                  UndirectedUnweightedgraph4,
                  UndirectedUnweightedgraph5,
                  UndirectedUnweightedgraph6,
                  UndirectedUnweightedgraph7,
                  DirectedUnweightedGraph8,
                  DirectedUnweightedGraph9,
                  DirectedUnweightedGraph10,
                  DirectedWeightedGraph11,
                  DirectedWeightedGraph12,
                  DirectedWeightedGraph13;



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

        List<GraphNode> nodesForUndirectedUnweightedGraph1 = new LinkedList<GraphNode>(Arrays.asList(
                nodeA,
                nodeB,
                nodeC,
                nodeD,
                nodeE,
                nodeF
        ));

        GraphEdge edgeBetweenAandB = new GraphEdge(nodeA, nodeB);
        GraphEdge edgeBetweenBandC = new GraphEdge(nodeB, nodeC);
        GraphEdge edgeBetweenCandD = new GraphEdge(nodeC, nodeD);
        GraphEdge edgeBetweenDandE = new GraphEdge(nodeD, nodeE);
        GraphEdge edgeBetweenEandF = new GraphEdge(nodeE, nodeF);

        List<GraphEdge> edgesForUndirectedUnweightedGraph1 = new LinkedList<GraphEdge>();
        edgesForUndirectedUnweightedGraph1.add(edgeBetweenAandB);
        edgesForUndirectedUnweightedGraph1.add(edgeBetweenBandC);
        edgesForUndirectedUnweightedGraph1.add(edgeBetweenCandD);
        edgesForUndirectedUnweightedGraph1.add(edgeBetweenDandE);
        edgesForUndirectedUnweightedGraph1.add(edgeBetweenEandF);
        //
        // Graph #1: Straight line (unweighted, undirected)
        //  A -> B -> C -> D -> E -> F
        //
        UndirectedUnweightedgraph1 = new GraphClass(nodesForUndirectedUnweightedGraph1, edgesForUndirectedUnweightedGraph1);


        List<GraphNode> nodesForUndirectedUnweightedGraph2 = new LinkedList<GraphNode>(Arrays.asList(
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

        GraphEdge edgeBetweenFandG = new GraphEdge(nodeF, nodeG);
        GraphEdge edgeBetweenGandH = new GraphEdge(nodeG, nodeH);
        GraphEdge edgeBetweenAandZ = new GraphEdge(nodeA, nodeZ);
        GraphEdge edgeBetweenHandZ = new GraphEdge(nodeH, nodeZ);

        List<GraphEdge> edgesForUndirectedUnweightedGraph2 = new LinkedList<GraphEdge>();
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
        UndirectedUnweightedgraph2 = new GraphClass(nodesForUndirectedUnweightedGraph2, edgesForUndirectedUnweightedGraph2);



        // graph 2 has all nodes A - H & Z
        List<GraphNode> nodesForUndirectedUnweightedGraph3 = nodesForUndirectedUnweightedGraph2;

//        GraphEdge edgeBetweenHandZ = new GraphEdge(nodeZ, nodeH);
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

        GraphEdge edgeBetweenEandZ = new GraphEdge(nodeE, nodeZ);
        GraphEdge edgeBetweenEandG = new GraphEdge(nodeE, nodeG);
        GraphEdge edgeBetweenDandH = new GraphEdge(nodeD, nodeH);
        GraphEdge edgeBetweenDandF = new GraphEdge(nodeD, nodeF);
        GraphEdge edgeBetweenBandD = new GraphEdge(nodeB, nodeD);
        GraphEdge edgeBetweenAandD = new GraphEdge(nodeA, nodeD);

        List<GraphEdge> edgesForUndirectedUnweightedGraph3 = new LinkedList<GraphEdge>();
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
        // Graph #3: see UndirectedUnweightedgraph3.png
        //
        UndirectedUnweightedgraph3 = new GraphClass(nodesForUndirectedUnweightedGraph3, edgesForUndirectedUnweightedGraph3);



        // graph 2 has all nodes A - H & Z
        List<GraphNode> nodesForUndirectedUnweightedGraph4 = nodesForUndirectedUnweightedGraph2;

//        GraphEdge edgeBetweenHandZ = new GraphEdge(nodeZ, nodeH);
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
        GraphEdge edgeBetweenBandE = new GraphEdge(nodeB, nodeE);
        GraphEdge edgeBetweenBandH = new GraphEdge(nodeB, nodeH);
        GraphEdge edgeBetweenCandF = new GraphEdge(nodeC, nodeF);


        List<GraphEdge> edgesForUndirectedUnweightedGraph4 = new LinkedList<GraphEdge>();
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
        // Graph #4: see UndirectedUnweightedgraph4.png
        //
        UndirectedUnweightedgraph4 = new GraphClass(nodesForUndirectedUnweightedGraph4, edgesForUndirectedUnweightedGraph4);


        // graph 2 has all nodes A - H & Z
        List<GraphNode> nodesForUndirectedUnweightedGraph5 = nodesForUndirectedUnweightedGraph2;
        //
        // Graph #5: graph with nodes from graph 2 and edges from graph 1
        //
        // start and target have no path, will return empty list
        UndirectedUnweightedgraph5 = new GraphClass(nodesForUndirectedUnweightedGraph5, edgesForUndirectedUnweightedGraph1);



        // graph 2 has all nodes A - H & Z
        List<GraphNode> nodesForUndirectedUnweightedGraph6 = nodesForUndirectedUnweightedGraph2;
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

        GraphEdge edgeBetweenCandE = new GraphEdge(nodeC, nodeE);
        GraphEdge edgeBetweenBandF = new GraphEdge(nodeB, nodeF);
        GraphEdge edgeBetweenAandF = new GraphEdge(nodeA, nodeF);
        GraphEdge edgeBetweenAandE = new GraphEdge(nodeA, nodeE);
        GraphEdge edgeBetweenAandC = new GraphEdge(nodeA, nodeC);


        List<GraphEdge> edgesForUndirectedUnweightedGraph6 = new LinkedList<GraphEdge>(edgesForUndirectedUnweightedGraph1);
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
        UndirectedUnweightedgraph6 = new GraphClass(nodesForUndirectedUnweightedGraph6, edgesForUndirectedUnweightedGraph6);



        // graph 2 has all nodes A - H & Z
        List<GraphNode> nodesForUndirectedUnweightedGraph7 = nodesForUndirectedUnweightedGraph2;
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


        GraphEdge edgeBetweenCandH = new GraphEdge(nodeC, nodeH);
        GraphEdge edgeBetweenBandG = new GraphEdge(nodeB, nodeG);
        GraphEdge edgeBetweenAandG = new GraphEdge(nodeA, nodeG);
        GraphEdge edgeBetweenGandZ = new GraphEdge(nodeG, nodeZ);
        GraphEdge edgeBetweenFandH = new GraphEdge(nodeF, nodeH);

        List<GraphEdge> edgesForUndirectedUnweightedGraph7 = new LinkedList<GraphEdge>();
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
        UndirectedUnweightedgraph7 = new GraphClass(nodesForUndirectedUnweightedGraph7, edgesForUndirectedUnweightedGraph7);



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


        GraphEdge edgeBetweenGandD = new GraphEdge(nodeG,nodeD);
        GraphEdge edgeBetweenZandG = new GraphEdge(nodeZ,nodeG);
        GraphEdge edgeBetweenZandD = new GraphEdge(nodeZ,nodeD);
        GraphEdge edgeBetweenFandB = new GraphEdge(nodeF,nodeB);
        GraphEdge edgeBetweenDandC = new GraphEdge(nodeD,nodeC);
        GraphEdge edgeBetweenEandD = new GraphEdge(nodeE,nodeD);

        List<GraphEdge> edgesForGraph8 = new LinkedList<GraphEdge>();
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
        DirectedUnweightedGraph8 = new GraphClass(nodesForUndirectedUnweightedGraph2, edgesForGraph8, true);
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

        GraphEdge edgeBetweenGandA = new GraphEdge(nodeG, nodeA);
        GraphEdge edgeBetweenFandA = new GraphEdge(nodeF, nodeA);

        List<GraphEdge> edgesForGraph9 = new LinkedList<GraphEdge>();
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


        DirectedUnweightedGraph9 = new GraphClass(nodesForUndirectedUnweightedGraph2, edgesForGraph9, true);
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

        GraphEdge edgeBetweenZandC = new GraphEdge(nodeZ, nodeC);
        GraphEdge edgeBetweenGandE = new GraphEdge(nodeG, nodeE);
        GraphEdge edgeBetweenEandB = new GraphEdge(nodeE, nodeB);
        GraphEdge edgeBetweenDandZ = new GraphEdge(nodeD, nodeZ);
        List<GraphEdge> edgesForGraph10 = new LinkedList<GraphEdge>();
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

        DirectedUnweightedGraph10 = new GraphClass(nodesForUndirectedUnweightedGraph2, edgesForGraph10, true);
        //
        // Graph #10: directed and unweighted
        //


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
        List<GraphEdge> edgesForGraph11 = new LinkedList<GraphEdge>();
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
        DirectedWeightedGraph11 = new GraphClass(nodesForUndirectedUnweightedGraph2, edgesForGraph11, true);
        DirectedWeightedGraph11.setWeighted(true);

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
        List<GraphEdge> edgesForGraph12 = new LinkedList<GraphEdge>();
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
        DirectedWeightedGraph12 = new GraphClass(nodesForUndirectedUnweightedGraph2, edgesForGraph12, true);
        DirectedWeightedGraph12.setWeighted(true);

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

        List<GraphEdge> edgesForGraph13 = new LinkedList<GraphEdge>();
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

        
        DirectedWeightedGraph13 = new GraphClass(nodesForUndirectedUnweightedGraph2, edgesForGraph13, true);
        DirectedWeightedGraph13.setWeighted(true);

        //
        // Graph #13: directed and weighted
        //


    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph01() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph1, nodeA, nodeF);
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
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph1, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("B"));
        Assert.assertTrue(path.get(2).getValue().equals("C"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("E"));
        Assert.assertTrue(path.get(5).getValue().equals("F"));
    }

    @Test
    public void breadthFirstSearchUndirectedUnweightedGraph01() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph1, nodeA, nodeF);
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
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph2, nodeA, nodeH);
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
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph2, nodeA, nodeH);
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
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph2, nodeA, nodeH);
        Assert.assertEquals(path.size(), 3);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("H"));
    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph03() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph3, nodeB, nodeE);
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
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph3, nodeB, nodeE);
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
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph3, nodeB, nodeE);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("D"));
        Assert.assertTrue(path.get(2).getValue().equals("H"));
        Assert.assertTrue(path.get(3).getValue().equals("Z"));
        Assert.assertTrue(path.get(4).getValue().equals("E"));
    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph04() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph4, nodeB, nodeF);
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
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph4, nodeB, nodeF);
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
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph4, nodeB, nodeF);
        Assert.assertEquals(path.size(), 4);
        Assert.assertTrue(path.get(0).getValue().equals("B"));
        Assert.assertTrue(path.get(1).getValue().equals("H"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph05() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph5, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveUndirectedUnweightedGraph05() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph5, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchUndirectedUnweightedGraph05() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph5, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph06() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph6, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void depthFirstSearchRecursiveUndirectedUnweightedGraph06() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph6, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void breadthFirstSearchUndirectedUnweightedGraph06() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph6, nodeA, nodeF);
        Assert.assertEquals(path.size(), 2);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchUndirectedUnweightedGraph07() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph7, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void depthFirstSearchRecursiveUndirectedUnweightedGraph07() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph7, nodeA, nodeF);
        Assert.assertEquals(path.size(), 6);
    }

    @Test
    public void breadthFirstSearchUndirectedUnweightedGraph07() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph7, nodeA, nodeF);
        Assert.assertEquals(path.size(), 4);
        Assert.assertTrue(path.get(0).getValue().equals("A"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchNullStartNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph5, null, nodeZ);
        // the expect message is thrown if the thrown var doesnt catch it's appropriate exception?
        // ie this message doesn't need to match the message of the thrown exception in GraphSearch.java, correct?
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveNullStartNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph5, null, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchNullStartNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph5, null, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchNullFinishNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph5, nodeA, null);
        // the expect message is thrown if the thrown var doesnt catch it's appropriate exception?
        // ie this message doesn't need to match the message of the thrown exception in GraphSearch.java, correct?
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveNullFinishNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph5, nodeA, null);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchNullFinishNode() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph5, nodeA, null);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchOutFinishNode() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph1, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveOutFinishNode() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph1, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchOutFinishNode() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph1, nodeA, nodeZ);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchOutStartNode() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(UndirectedUnweightedgraph1, nodeZ, nodeA);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveOutStartNode() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(UndirectedUnweightedgraph1, nodeZ, nodeA);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchOutStartNode() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(UndirectedUnweightedgraph1, nodeZ, nodeA);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchNullGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.depthFirstSearch(null, nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveNullGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(null, nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchNullGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.breadthFirstSearch(null, nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchEmptyGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.depthFirstSearch(new GraphClass(), nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchRecursiveEmptyGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(new GraphClass(), nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void breadthFirstSearchEmptyGraph() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        List<GraphNode> path = GraphSearch.breadthFirstSearch(new GraphClass(), nodeA, nodeZ);
        thrown.expectMessage("expect message");
    }

    @Test
    public void depthFirstSearchDirectedUnweightedGraph08() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(DirectedUnweightedGraph8, nodeH, nodeB);
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
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(DirectedUnweightedGraph8, nodeH, nodeB);
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
        List<GraphNode> path = GraphSearch.breadthFirstSearch(DirectedUnweightedGraph8, nodeH, nodeB);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("H"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("B"));
    }

    @Test
    public void depthFirstSearchDirectedUnweightedGraph09() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(DirectedUnweightedGraph9, nodeE, nodeF);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchRecursiveDirectedUnweightedGraph09() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(DirectedUnweightedGraph9, nodeE, nodeF);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
    }

    @Test
    public void breadthFirstSearchDirectedUnweightedGraph09() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(DirectedUnweightedGraph9, nodeE, nodeF);
        Assert.assertEquals(path.size(), 3);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("D"));
        Assert.assertTrue(path.get(2).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchDirectedUnweightedGraph10() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(DirectedUnweightedGraph10, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void depthFirstSearchRecursiveDirectedUnweightedGraph10() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(DirectedUnweightedGraph10, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void breadthFirstSearchDirectedUnweightedGraph10() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(DirectedUnweightedGraph10, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void depthFirstSearchDirectedWeightedGraph11() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(DirectedWeightedGraph11, nodeH, nodeB);
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
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(DirectedWeightedGraph11, nodeH, nodeB);
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
        List<GraphNode> path = GraphSearch.breadthFirstSearch(DirectedWeightedGraph11, nodeH, nodeB);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("H"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("D"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("B"));
    }

    @Test
    public void depthFirstSearchDirectedWeightedGraph12() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(DirectedWeightedGraph12, nodeE, nodeF);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchRecursiveDirectedWeightedGraph12() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(DirectedWeightedGraph12, nodeE, nodeF);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("Z"));
        Assert.assertTrue(path.get(2).getValue().equals("G"));
        Assert.assertTrue(path.get(3).getValue().equals("D"));
        Assert.assertTrue(path.get(4).getValue().equals("F"));
    }

    @Test
    public void breadthFirstSearchDirectedWeightedGraph12() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(DirectedWeightedGraph12, nodeE, nodeF);
        Assert.assertEquals(path.size(), 3);
        Assert.assertTrue(path.get(0).getValue().equals("E"));
        Assert.assertTrue(path.get(1).getValue().equals("D"));
        Assert.assertTrue(path.get(2).getValue().equals("F"));
    }

    @Test
    public void depthFirstSearchDirectedWeightedGraph13() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearch(DirectedWeightedGraph13, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void depthFirstSearchRecursiveDirectedWeightedGraph13() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(DirectedWeightedGraph13, nodeG, nodeH);
        Assert.assertEquals(path.size(), 5);
        Assert.assertTrue(path.get(0).getValue().equals("G"));
        Assert.assertTrue(path.get(1).getValue().equals("E"));
        Assert.assertTrue(path.get(2).getValue().equals("B"));
        Assert.assertTrue(path.get(3).getValue().equals("F"));
        Assert.assertTrue(path.get(4).getValue().equals("H"));
    }

    @Test
    public void breadthFirstSearchDirectedWeightedGraph13() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(DirectedWeightedGraph13, nodeG, nodeH);
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
        List<GraphNode> path = GraphSearch.depthFirstSearch(DirectedWeightedGraph13, nodeE, nodeC);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void depthFirstSearchRecursiveDirectedWeightedGraph14() throws Exception {
        List<GraphNode> path = GraphSearch.depthFirstSearchRecursive(DirectedWeightedGraph13, nodeE, nodeC);
        Assert.assertEquals(path.size(), 0);
    }

    @Test
    public void breadthFirstSearchDirectedWeightedGraph14() throws Exception {
        List<GraphNode> path = GraphSearch.breadthFirstSearch(DirectedWeightedGraph13, nodeE, nodeC);
        Assert.assertEquals(path.size(), 0);
    }

}