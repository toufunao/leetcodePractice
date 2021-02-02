package onedayoneproblem;

public class Domino {
    public int numEquivDominoPairs(int[][] dominoes) {

        int[] sum=new int[100];
        int ans=0;
        for (int[] domino:dominoes){
            int val=0;
            if (domino[0]<domino[1])
                val=domino[0]*10+domino[1];
            else
                val=domino[1]*10+domino[0];

            ans+=sum[val];
            sum[val]++;
        }
        return ans;
    }
}
