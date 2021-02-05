package slidewindow;

public class EqualSubString_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len=0;
        int n=s.length();
        int[] gap=new int[n];
        for (int i = 0; i < n; i++) {
            gap[i]=Math.abs(t.charAt(i)-s.charAt(i));
        }

        int left=0;
        int right=0;
        int sum=0;
        while (right<n){
            sum+=gap[right];
            while (sum>maxCost){
                sum-=gap[left];
                left++;
            }
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}
