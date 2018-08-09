package com.example.moj.lib;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myClass {
    public static void main(String[] args){
//        for (int i=1;i<100;i++)
        long a = System.currentTimeMillis();
        System.out.println(find132pattern(new int[]{3,1,4,2}));
        System.out.print(System.currentTimeMillis()-a);
    }

    public static boolean find132pattern(int[] nums) {
        int ii = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length-2; i++) {
            if(ii>nums[i]){
                ii = nums[i];
            }else{
                continue;
            }
            int jj = Integer.MIN_VALUE;
            for (int j=i+1; j< nums.length-1;j++) {
                if(jj<nums[j]){
                    jj = nums[j];
                }else{
                    continue;
                }
                for (int k = j+1;k<nums.length;k++) {

                    if (nums[i] < nums[j] && nums[k]<nums[j] && nums[i]<nums[k]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canMeasureWater(int x, int y, int z) {
        return true;
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        for (int i=citations.length;i>0;i--){
            if(citations[i-1]<=count){
                return count;
            }
            count++;
        }
        return count;
    }

    public static void moveZeroes(int[] nums) {
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0){
                for(int j = i;j<nums.length-1;j++){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static boolean isFullSqrt(int t){
        return Math.pow((int)Math.sqrt(t),2)==t;
    }

    //计算两矩形相交后的总面积
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int aArea   = (C-A) * (D-B);
        int bArea   = (G-E) * (H-F);
        int sWidth  = 0;
        int sHeight = 0;
        if(A < E){
            if(C < G){
                sWidth = C < E ? 0 : C - E;
            }else {
                sWidth = G - E;
            }
        }else{
            if(C < G){
                sWidth = C - A;
            }else{
                sWidth = G < A ? 0 : G - A;
            }
        }
        if(B < F){
            if(D < H){
                sHeight = D < F ? 0 : D - F;
            }else{
                sHeight = H - F;
            }
        }else{
            if(D < H){
                sHeight = D - B;
            }else{
                sHeight = H < B ? 0 : H - B;
            }
        }
        return aArea + bArea - (sWidth * sHeight);
    }

    //丢失的数字
    public static int missingNumber(int[] nums) {
        int m = ((nums.length+1) * nums.length)/2;
        int n=0;
        for (int i = 0; i < nums.length; i++) {
            n+=nums[i];
        }
//        System.out.print(m+","+n);
        return m-n;
    }

    public static int nthUglyNumber(int n) {
        int i=0;
        while (n>0){
            if(isUgly(++i)){
                n--;
            }
        }
        return i;
    }

    //判断丑数
    public static boolean isUgly(int num) {
        if(num < 1){
            return false;
        }
        while (num > 0){
            if(num % 5 ==0){
                num = num/5;
            }else if(num % 3 == 0){
                num = num/3;
            }else if(num % 2 == 0){
                num = num/2;
            }else{
                return num==1;
            }
        }
        return num==0;
    }

    //爬楼梯
    public static int climbStairs(int n) {
        if(n<3)return n;
        int[] result = new int[n];
        result[0]=1;
        result[1]=2;
        for (int i = 2; i < n; i++) {
            result[i]=result[i-1]+result[i-2];
        }
        return result[n-1];
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    //合并区间
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                if(interval==null || t1==null){
                    return 0;
                }
                return interval.start - t1.start;
            }
        });
        int i=0;
        while (true){
            if(i+1>=intervals.size()){
                return intervals;
            }
            if(intervals.get(i).end >= intervals.get(i+1).start){
                intervals.get(i).end = Math.max(intervals.get(i).end,intervals.get(i+1).end);
                intervals.remove(i+1);
            }else{
                i++;
            }
        }
    }

    //能否到达最后一个点
    public static boolean canJump(int[] nums){
        int i=0;
        int max=0;

        while (i<nums.length){
            int temp = i;
            for (int j=1;j<=nums[i];j++){
                if(i+j>=nums.length){
                    return true;
                }
//                System.out.println(temp+","+nums[temp]+","+(i+j)+","+nums[i+j]);
                if(temp+nums[temp]<i+j+nums[i+j]){
                    temp = i+j;
                }
            }

            if(i==temp){
                return i+nums[i]>=nums.length-1;
            }
            i=temp;

        }
        return i>=nums.length;
    }

    public static int[] plusOne(int[] digits) {
        int[] temp = new int[digits.length+1];
        temp[0]=1;
        int n=1;
        for (int i=digits.length-1;i>=0;i--){
            if(n>0) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                    n=1;
                }else{
                    digits[i]+=n;
                    n=0;
                }
            }
            temp[i+1]=digits[i];
        }
        return n==1?temp:digits;
    }

    //找出一个没有出现在数组里的最小正整数
    public int firstMissingPositive(int[] nums) {
        int min = 1;
        int max = 1;
        boolean b= false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>min){
                if(nums[i]>max){
                    max = nums[i];
                }else {
                    b=true;
                    min = nums[i];
                }
            }
        }
        return b?min+1:max-min==1?max+1:min;
    }

    //自己实现indexf函数
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        int result = -1;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        for (int i=0;i<h.length;i++){
            if(h.length-i < n.length){
                break;
            }
            else if(h[i] == n[0]){
                boolean b = true;
                for (int j=1;j<n.length;j++){
                    if(h[i+j] != n[j]){
                        b=false;
                    }
                }
                if(b){
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    //报数数列
    public static String countAndSay(int n) {
        String result = "1";
        for (int i=2;i<=n;i++){
            StringBuilder builder = new StringBuilder();
            int temp=1;
            for(int j=result.length()-1;j>=0;j--){
                if(j>0 && result.charAt(j) == result.charAt(j-1)){
//                    builder.insert(0,"21");
                    temp++;
                }else{
                    builder.insert(0,temp+""+result.charAt(j));
                    temp=1;
                }
            }
            result = builder.toString();
        }
        return result;
    }

    //求最大雨水容量
    public static int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        while (i<j){
//            System.out.println(i+","+j+","+max);
            int t = Math.min(height[i],height[j])*(j-i);
            if(max<t){
                max = t;
            }
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
