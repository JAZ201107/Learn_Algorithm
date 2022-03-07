package Day08;

/**
 * Date: 2022/03/07
 * Author: zhangyuyang
 * Description:
 */
public class Code01_TrieTree {
    public static class TireNode {
        public int pass;    // 这个节点到达过多少次
        public int end;     // 这个节点，是否是结尾节点
        public TireNode[] nexts; // HashMap<Char, Node> nexts; 到需要表达的字符特别多的时候，
        // HasMap
        // TreeMap

        public TireNode() {
            pass = 0;
            end = 0;
            /**
             * nexts[0] != null 有a
             * nexts[0] = null 没有a的节点
             */
            nexts = new TireNode[26];
        }
    } // end TireNode

    public static class Trie {
        private TireNode root;

        public Trie() {
            root = new TireNode(); //  根节点表示加入了多少以 空值为开头的字符串，即有多少字符串
        }

        public void insert(String word) {
            if (word == null) return;
            char[] chs = word.toCharArray();
            TireNode node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a'; // 由字符，对应走向那一条路
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TireNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            // 最后的 node
            node.end++;
        } // end insert

        public int search(String word) {
            if (word == null) return 0;
            char[] chs = word.toCharArray();
            TireNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null)
                {
                    return  0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }// end search

        public int prefixNumber(String pre)
        {
            if (pre == null) return 0;
            char[] chs = pre.toCharArray();
            TireNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index] == null)
                {
                    return  0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        } // prefixNumber

        public void delete(String word)
        {
            if(search(word) != 0)
            {
                char[] chs = word.toCharArray();
                TireNode node = root;
                node.pass--;
                int index = 0;
                for(int i= 0; i<chs.length;i++)
                {
                    index = chs[i] -'a';
                    if(--node.nexts[index].pass ==0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        } // delete
    } // end Trie
}
