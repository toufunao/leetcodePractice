package array;

public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        int[] ans=new int[m+n];
        int count=0;
        while (i<m && j<n){
            if (nums1[i]<nums2[j]){
                ans[count]=nums1[i];
                i++;
            }
            else {
                ans[count]=nums2[j];
                j++;
            }
            count++;
        }
        if (i<m&&j==n){
            while (i<m){
                ans[count]=nums1[i];
                i++;
                count++;
            }
        }
        if (j<n&&i==m){
            while (j<n){
                ans[count]=nums2[j];
                j++;
                count++;
            }
        }
        for (int k=0;k<m+n;k++){
            nums1[k]=ans[k];
        }
    }
    public static void main(String[] args){
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}
