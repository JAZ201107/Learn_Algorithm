package Day07;

import edu.princeton.cs.algs4.Stack;

import java.util.HashSet;

/**
 * Date: 2022/03/07
 * Author: zhangyuyang
 * Description:
 */
public class Code02_DFS {

    public static void dfs(Node node)
    {
        if(node == null)
        {
            return;
        }

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);

        //
        System.out.println(node);

        while(!stack.isEmpty())
        {
            Node cur = stack.pop();
            for(Node next: cur.nexts)
            {
                 if(!set.contains(next))
                 {
                     stack.push(cur);
                     stack.push(next);
                     set.add(next);
                     //
                     System.out.println(next);
                     break;
                 }
            }
        }
    }
}
