package onedayoneproblem;

public class fib_21_01_04 {
    public int fib(int n) {

        //递归
//        if (n==0)
//            return 0;
//        if (n==1)
//            return 1;
//        return fib(n-1)+fib(n-2);


        //回溯
        int[] dp=new int[n+1];
        if (n<=1)
            return n;

        dp[0]=0;
        dp[1]=1;

        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
