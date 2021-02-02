package array;

import com.sun.javafx.logging.JFRPulseEvent;

import java.util.Arrays;

public class FindMid_hard_4 {
    public static void main(String[] args){
        int[] a=new int[]{1,2};
        int[] b=new int[]{3,4};
        findMedianSortedArrays(a,b);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n=nums1.length+nums2.length;
        boolean isEven= (n%2==0);
        int mid=n/2;

        if (nums1.length==0&&isEven)
            return ((double) nums2[mid-1]+nums2[mid])/2;
        if (nums1.length==0&&!isEven)
            return nums2[mid];
        if (nums2.length==0&&isEven)
            return ((double) nums1[mid-1]+nums1[mid])/2;
        if (nums2.length==0&&!isEven)
            return nums1[mid];

        int count=-1;
        int[] array=new int[n];
        int i=0,j=0;
        while (i<nums1.length||j<nums2.length){
            count++;
            if (i==nums1.length){
                array[count]=nums2[j];
                j++;
            }else if (j== nums2.length){
                array[count]=nums1[i];
                i++;
            }else if (nums1[i]<nums2[j]){
                array[count]=nums1[i];
                i++;
            }else {
                array[count]=nums2[j];
                j++;
            }

        }
        if (isEven)
            return ((double) array[mid-1]+array[mid])/2;
        else
            return array[mid];

    }
}
