package Algorithm_4th.Chapter_3;

import static edu.princeton.cs.algs4.BinaryStdIn.isEmpty;

/**
 * Date: 2022/03/18
 * Author: zhangyuyang
 * Description:
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size()
    {
        return N;
    }

//    public Value get(Key key){
//        if(isEmpty())
//    }
}
