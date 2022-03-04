package util;

import java.util.Random;

/**
 * Date: 2022/03/03
 * Author: zhangyuyang
 * Description:
 */
public class Algorithms_Utils {
    public static int[] getArray() {
        Random generator = new Random();
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.nextInt(100);
        }
        return a;
    }

    public static int[] getArray(int seed) {
        Random generator = new Random(seed);
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.nextInt(100);
        }
        return a;
    }


    public static void Switch(int[] a, int p1, int p2) {
        int tmp = a[p1];
        a[p1] = a[p2];
        a[p2] = tmp;
    }

    public static void Exclusive_Switch(int[] a, int p1, int p2) {
        a[p1] = a[p1] ^ a[p2];
        a[p2] = a[p1] ^ a[p2];
        a[p1] = a[p1] ^ a[p2];
        // 异或， 相同为0 不同为1
        // 异或 交换可以实现的前提就是，有两个不同的内存地址。
        // 若 在数组中，p1 = p2 则，无法实现交换。 会将该位置的数，变为 0。
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - (int) (maxValue * Math.random()));
        }
        return arr;
    }

    public static int[] copyArray(int[] array) {
        if (array == null) {
            return null;
        }
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }
        return res;
    }


}
