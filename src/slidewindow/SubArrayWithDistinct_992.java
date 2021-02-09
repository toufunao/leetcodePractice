package slidewindow;

public class SubArrayWithDistinct_992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostWithDistinct(A,K)-atMostWithDistinct(A,K-1);
    }

    /**
     * 最多包含k个不同整数的子区间的个数
     * @param a
     * @param k
     * @return
     */

    private int atMostWithDistinct(int[] a, int k) {
        int len=a.length;
        int[] freq=new int[len+1];
        int left=0;
        int right=0;

        //left,right中不同整数的个数
        int count=0;
        int res=0;

        while (right<len){
            if(freq[a[right]]==0){
                count++;
            }
            freq[a[right]]++;
            right++;

            while (count>k){
                freq[a[left]]--;
                if (freq[a[left]]==0){
                    count--;
                }
                left++;
            }
            res+=right-left;
        }
        return res;
    }
}
