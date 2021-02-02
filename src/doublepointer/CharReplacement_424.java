package doublepointer;

public class CharReplacement_424 {
    public int characterReplacement(String s, int k) {
        int[] num=new int[26];
        int n=s.length();
        int maxn=0;
        int left=0,right=0;

        while (right<n){
            int valueRight=s.charAt(right)-'A';
            int valueLeft=s.charAt(left)-'A';
            num[valueRight]++;
            maxn=Math.max(maxn,num[valueRight]);
            if (right-left+1-maxn>k){
                num[valueLeft]--;
                left++;
            }
            right++;
        }
        return right-left;
    }
}
