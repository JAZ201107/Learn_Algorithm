package Day07;

import edu.princeton.cs.algs4.In;

/**
 * Date: 2022/03/07
 * Author: zhangyuyang
 * Description:
 */
public class GraphGenerator {

    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();

        for (int i = 0; i < matrix.length; i++) {
            // matrix[0][0], matrix[0][1], matrix[0][2]
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];

            // 把from的点加入 Graph里面
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            //  把to的点加入 Graph里面
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            Edge newEdge = new Edge(weight, fromNode, toNode);

            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;

            fromNode.edges.add(newEdge);
            toNode.edges.add(newEdge);
        }

        return graph;
    }
}
