package Day07;

import java.util.HashMap;

/**
 * Date: 2022/03/07
 * Author: zhangyuyang
 * Description:
 */
public class testHashMap {
    public static void main(String[] args) {
        HashMap<Integer,Node> nodes = new HashMap<>();
        nodes.put(1,new Node(10));
        nodes.put(2,new Node(20));
        nodes.put(3,new Node(30));
        nodes.put(4,new Node(40));

        Node node1 = nodes.get(1);
        node1.value = 100;
        System.out.println(nodes.get(1));
    }
}
