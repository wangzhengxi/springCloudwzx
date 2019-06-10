package com.wzx.testSum;

/**
 * Created by wangzhengxi on 2019/5/13.
 */
public class sort {


    /*使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。

    如果两个指针指向元素的和 sum == target，那么得到要求的结果；
    如果 sum > target，移动较大的元素，使 sum 变小一些；
    如果 sum < target，移动较小的元素，使 sum 变大一些。*/

    public static void main(String []ars){

        int targe =9;
        int a[]={1,2,3,4,5,6,7,8,9,10};
        int i=0;
        int j=a.length-1;
        while (i<j){
            int sum =a[i]+a[j];
            if(sum==targe){
                
            }
        }

    }
}
