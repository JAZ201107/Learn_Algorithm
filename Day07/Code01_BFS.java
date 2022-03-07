package Day07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2022/03/07
 * Author: zhangyuyang
 * Description:
 */
public class Code01_BFS {

    // 从node出发，进行宽度优先遍历： 将该节点的直接后继节点遍历完才遍历下一节点
    public static void bfd(Node node)
    {
        if(node == null)
        {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);


        // 遍历 无向图
        while ((!queue.isEmpty()))
        {
            Node cur = queue.poll();
            //
            System.out.println(cur);

            for(Node next: cur.nexts)
            {
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
