package Day07;

/**
 * Date: 2022/03/07
 * Author: zhangyuyang
 * Description:
 */
public class Edge {

    public int weight; // 边的权值
    public Node from; // 从哪个边出来
    public Node to; // 到哪个边

    public Edge(int weight, Node from, Node to)
    {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
