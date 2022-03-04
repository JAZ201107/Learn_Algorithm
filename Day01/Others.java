package Day01;

/**
 * Date: 2022/03/03
 * Author: zhangyuyang
 * Description:
 */
public class Others {
    /**
     * 面试 1： 要求 时间复杂度 O（N）， 空间复杂度 O（N）
     * 在一个数组中，已知只有 一 种数出现奇数次， 其他所有出现都是偶数次，如何找到出现奇数次的数？
     * 答： 通过异或的方式
     */
    public static void printOddTimeNum1(int[] array) {
        int eor = 0;
        for (int i : array) {
            eor ^= i;
        }
        System.out.println(eor);
    }


    /**
     * 面试 2： 要求 时间复杂度 O（N）， 空间复杂度 O（N）
     * 在一个数组中，已知只有 两 种数出现奇数次， 其他所有出现都是偶数次，如何找到出现奇数次的数？
     */
    public static void printOddTimeNum2(int[] array)
    {
        int eor =0, onlyOne = 0;
        for(int i:array)
        {
            eor ^= i;
        }

        int rightOne = eor  & (~eor+1);
        for(int i: array)
        {
            if((i & rightOne) == 0)
            {
                onlyOne ^= i;
            }
        }
        System.out.println(onlyOne+ " " + (eor^onlyOne));

    }
}
