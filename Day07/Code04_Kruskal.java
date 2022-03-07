package Day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 2022/03/07
 * Author: zhangyuyang
 * Description:
 */
public class Code04_Kruskal {

    public static class Mysets {
        public HashMap<Node, List<Node>> setMap;
        public Mysets(List<Node> nodes)
        {
            for(Node cur: nodes)
            {
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur,set);
            }
        }

        public boolean isSameSet(Node from, Node to)
        {
            List<Node> fromSet  = setMap.get(from);
            List<Node> toSet  = setMap.get(to);
            return fromSet == toSet;
        }
    }
}
