package Day01;

/**
 * Date: 2022/03/03
 * Author: zhangyuyang
 * Description:
 */
public class Basic_Sort {

    public static void Selection_sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                min = a[j] < a[min] ? j : min;
            }
            if (i != min) {
                util.Algorithms_Utils.Switch(a, i, min);
            }
        }
    }

    public static void Bubble_sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    util.Algorithms_Utils.Switch(a, j, j + 1);
                }
            }
        }
    }

    public static void Insertion_sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
                util.Algorithms_Utils.Switch(a,j,j+1);
            }
        }
    }

    public static void Shell_sort(int[] a) {
        int length = a.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = a[i];
                int j = i - step;
                while (j >= 0 && a[i] > temp) {
                    a[j + step] = a[j];
                    j -= step;
                }
                a[j + step] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = util.Algorithms_Utils.getArray();
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
//        Selection_sort(a);
//        Bubble_sort(a);
//        Insertion_sort(a);
        Shell_sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
