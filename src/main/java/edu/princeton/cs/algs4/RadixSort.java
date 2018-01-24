package edu.princeton.cs.algs4;


/**
 * @author Mageek Chiu
 * @date 2018-01-24:19:12
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] data = new int[] { 73,22,532 ,93, 43, 55, 14, 28, 65, 39, 81,111 };
        show(data);
        radixSort(data, 1000);//关键字没超过1000但是超过100了
        show(data);
    }

    private static void radixSort(int[] array,int d){
        int n=1;//代表位数对应的数：1,10,100...
        int k=0;//保存每一位排序后的结果用于下一位的排序输入
        int length=array.length;
        int[][] bucket=new int[10][length];//二维数组排序桶，用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] order=new int[length];//用于保存每个桶里有多少个数字，默认初始化为0
        while(n<d){
            for(int num:array) {//将数组array里的每个数字放在相应的桶里
                int digit=(num/n)%10;
                bucket[digit][order[digit]]=num;
                order[digit]++;
            }
            for(int i=0;i<length;i++){//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
                if(order[i]!=0){//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                    for(int j=0;j<order[i];j++){
                        array[k]=bucket[i][j];
                        k++;
                    }
                }
                order[i]=0;//将桶里计数器置0，用于下一次位排序
            }
            n*=10;
            k=0;//将k置0，用于下一轮保存位排序结果
        }
    }

    public static void show(int[] data) {
        for (int aData : data) {System.out.print(aData + "\t"); }
        System.out.println();
    }
}