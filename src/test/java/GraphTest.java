import com.thoughtworks.shortestdistanceproblem.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    public void should_return_direct_route_distance_when_graph_has_single_and_direct_route() {
        Graph graph = new Graph("AB5");
        assertEquals(5, graph.getShortestDistance("A", "B"));
        graph = new Graph("AB5,AC3");
        assertEquals(5, graph.getShortestDistance("A", "B"));
    }
}

