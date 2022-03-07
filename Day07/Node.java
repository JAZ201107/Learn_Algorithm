package Day07;

import java.util.ArrayList;

/**
 * Date: 2022/03/07
 * Author: zhangyuyang
 * Description:
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts; // 从自己出发，与自己相邻的点
    public ArrayList<Edge> edges; // 自己拥有的边

    public Node(int value)
    {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
