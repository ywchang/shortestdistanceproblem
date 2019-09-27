import com.thoughtworks.shortestdistanceproblem.Graph;
import org.junit.jupiter.api.Disabled;
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

    @Test
    public void should_return_joining_distance_when_graph_has_single_and_non_direct_route() {
        Graph graph = new Graph("AC3,CB4");
        assertEquals(7, graph.getShortestDistance("A", "B"));
        graph = new Graph("AC3,CD4,DB5");
        assertEquals(12, graph.getShortestDistance("A", "B"));
    }

    @Test
    public void should_return_shorter_distance_when_graph_has_multiple_routes_available() {
        Graph graph = new Graph("AC3,CB4,AB5");
        assertEquals(5, graph.getShortestDistance("A", "B"));
        graph = new Graph("AB5,AB4,AB3");
        assertEquals(3, graph.getShortestDistance("A", "B"));
        graph = new Graph("AC3,CB4,AD2,DB2");
        assertEquals(4, graph.getShortestDistance("A", "B"));
    }
}

