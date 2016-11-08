package com.jikexueyuan.findmax;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2016/5/7 0007.
 * 求整数数组的最大值
 */
public class FindMax {

    public static void main(String[] args){

        int[] array = new int[10];
        fillRandom(array,100);

        System.out.println("数组：" + Arrays.toString(array));
        System.out.println("其中最大值为：" + findMax(array));
    }

    /**@
     * 查找并返回数组中的最大值
     * @param array 传入数组
     * @return
     */
    public static int findMax(int[] array){

        int max = array[0];
        for(int i = 1; i < array.length; i ++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    /**@
     * 填充数组
     * @param array 传入数组
     * @param bound 随机数范围
     */
    public static void fillRandom(int[] array, int bound){

        for(int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(bound);
        }
    }

}
