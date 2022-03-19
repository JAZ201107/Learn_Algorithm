package DP;

import edu.princeton.cs.algs4.In;

/**
 * Date: 2022/03/19
 * Author: zhangyuyang
 * Description:
 */
public class Cut_Rod {
    public static void main(String[] args) {
        /**
         *  length: 0 1 2 3 4 5  6  7  8  9  10
         *  price:  0 1 5 8 9 10 17 17 20 24 30
         */
        int price[] = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
//        System.out.println(Bottom_up_cut_rod(price, 4));
//        int[] s = new int[5];
//        int p = Extend_Bottom_up_cut_rod(price, 4, s);
        for (int i = 1; i <= 10; i++) {
            int[] s = new int[i+1];
            int p = Extend_Bottom_up_cut_rod(price, i, s);
            print_Info(p,s,i);
        }

    }


    public static void print_Info(int p, int[] s, int j)
    {
        System.out.println();
        System.out.println("Length: " + j);
        System.out.println("price: " + p);
        for (int i : s) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int cut_rod(int[] p, int n) {
        if (n == 0) return 0;

        int q = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + cut_rod(p, n - i));
        }
        return q;
    }


    // 自定向下，带备忘录
    public static int Memo_cut_rod(int[] p, int n) {
        int r[] = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            r[i] = Integer.MIN_VALUE;
        }
        return Memo_cur_rod_aux(p, n, r);
    }

    public static int Memo_cur_rod_aux(int[] p, int n, int[] r) {
        if (r[n] >= 0) return r[n];

        int q = Integer.MIN_VALUE;
        if (n == 0) {
            q = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i] + Memo_cur_rod_aux(p, n - i, r));
            }
        }
        r[n] = q;
        return q;
    }


    // 自底向上
    public static int Bottom_up_cut_rod(int[] p, int n) {
        int r[] = new int[n + 1];
        r[0] = 0;
        for (int i = 1; i <= n; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j] + r[i - j]);
            }
            r[i] = q;
        }
        return r[n];
    }

    public static int Bottom_up_cut_rod_2(int[] p, int n) {
        int r[] = new int[n + 1];
        r[0] = 0;
        for (int i = 1; i <= n; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j] + r[i - j]);
            }
            r[i] = q;
        }
        return r[n];
    }

    public static int Extend_Bottom_up_cut_rod(int[] p, int n, int[] s) {
        int r[] = new int[n + 1];
//        int s[] = new int[n + 1];
        r[0] = 0;
        for (int i = 1; i <= n; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if(q < p[j] + r[i - j]) {
                    q = p[j] + r[i - j];
                    s[i] = j;
                }
            }
            r[i] = q;
        }
        return r[n];
    }

    public static int Bottom_up_cut_rod_with_cost(int[] p, int n) {
        int cost = 2;
        int r[] = new int[n + 1];
        r[0] = 0;
        for (int i = 1; i <= n; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j] + r[i - j] - cost);
            }
            r[i] = q;
        }
        return r[n];
    }


}
