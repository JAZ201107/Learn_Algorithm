package DP;

/**
 * Date: 2022/03/20
 * Author: zhangyuyang
 * Description:
 */
public class Matrix_Chain {

//    static int[][] dp = new int[100][100];
//
//    public static int matrixChainMemoised(int[]p){
//        int i = 1;
//        int j = p.length -1;
//
//        if(i==j) return 0;
//
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//        dp[i][j] = Integer.MAX_VALUE;
//        for(int k = i; k<j;k++){
//            dp[i][j] = Math.min(
//                    dp[i][j],matrixChainMemoised()
//            )
//        }
//
//
//    }


    public static int Matrix_Chain_Order(int[] p) {
        int n = p.length - 1;

        int m[][] = new int[n + 1][n + 1];
        int s[][] = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l < n + 1; l++) {
            for(int i =1;i<n-l+2;i++){
                int j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {// 如果计算得到的q值比初始化的MAX小，表示此值有效，则保存起来
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        return m[0][n];

    }
}
