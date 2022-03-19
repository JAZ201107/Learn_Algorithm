package Algorithm_4th.Chapter_3;

/**
 * Date: 2022/03/18
 * Author: zhangyuyang
 * Description:
 */
public class SequentialSearchST<Key, Value> {
    private class Node{
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Node first;

    public Value get(Key key){
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key)){
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value val){
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key)){
                x.value = val;
            }
        }
        first = new Node(key,val,first);
    }

    public int size(){
        int out = 0;
        for(Node x = first; x != null; x = x.next,out ++);
        return out;
    }
}
