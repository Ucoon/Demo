package com.my.algorithm;

public class AlgorithmTest {
    public static void main(String[] args){
        AlgorithmTest.bubbleSort();
        AlgorithmTest.multiplicationTable();
        int[] a = new int[]{2,7,4,5,10,1,9,3,8,6};
        quitsort(a, 0, a.length-1);
        for (int x : a){
            System.out.print(x + "\t");
        }
    }

    //冒泡
    public static void bubbleSort(){
        int data[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int temp = 0;
        for (int i = 0; i< data.length - 1; i++){
            for (int j = 0; j < data.length -1 -i; j++){
                if (data[j] > data[j+1]) {
                    temp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = temp;
                }
            }
        }

        for (int i = 0; i<data.length -1; i++){
            System.out.print(data[i]+", ");
        }
    }

    public static void multiplicationTable(){
        for (int i=1; i<=9; i++){
            for (int j =1; j<=i; j++){
                System.out.print(j + "x" + i + "=" + i*j + "\t");
            }
            System.out.println();
        }
    }


    public static int divide(int[] data, int start, int end){
        //每次以最右边的元素作为基准值
        int base = data[end];
        //start一旦等于end，说明两个指针合并到了同一位置，可以结束此轮循环
        while (start < end){
            while (start < end && data[start] <= base)
                //从左边开始遍历，如果比基准值小，就继续往右走
                start++;
            //上面的while循环结束时，就说明当前的a[start]的值比基准值大，应与基准值进行交换
                 if (start < end){
                    int temp = data[start];
                    data[start] = data[end];
                    data[end] = temp;
                    //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
                    end--;
                }
            while (start < end && data[end] >= base)
                    //从右边开始遍历，如果比基准值大，就继续向左走
                    end--;
            //上面的while循环结束时，就说明当前的a[end]的值比基准值小，应与基准值进行交换
            if (start < end){
                    int temp = data[start];
                    data[start] = data[end];
                    data[end] = temp;
                    //交换后，此时的那个被调换的值也同时调到了正确的位置(基准值左边)，因此左边也要同时向后移动一位
                    start++;
                }
            }
        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }

    public static void quitsort(int[] data, int start, int end){
        if (start > end){
            return;
        }else {
            //如果不止一个元素，继续划分两边递归排序下去
            int partition = divide(data, start, end);
            quitsort(data, start, partition-1);
            quitsort(data, partition+1, end);
        }
    }
}
