package Algorithm_4th.Chapter_3;

/**
 * Date: 2022/03/22
 * Author: zhangyuyang
 * Description:
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root; // 根节点


    // 私有类
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        // 构造节点

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }


    // 得到数量
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) return 0;
        else return root.N;
    }


    // 获取值
    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(key, x.left);
        else if (cmp > 0) return get(key, x.right);

        return x.value;
    }

    // 更新值
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        // 经过的节点 N + 1；
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    // 获得最小节点
    public Key min() {
        return min(root);
    }

    public Key min(Node x) {
        if (x.left == null) return x.key;
        return min(x.left);
    }

    // floor 小于等于 key的最大整数键
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        // 比较大小
        int cmp = key.compareTo(x.key);
        // 说明相等
        if (cmp == 0) return x;
        // 说明Key小，在左树找
        if (cmp < 0) return floor(x.left, key);

        // 说明Key大
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }


    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k);
        else return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }
}
