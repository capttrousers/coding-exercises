package graphs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        SpecialGraphTest.class,
        UndirectedUnweightedGraphTest.class,
        UndirectedWeightedGraphTest.class,
        DirectedUnweightedGraphTest.class,
        DirectedWeightedGraphTest.class
})

public class GraphTestSuite {

}
