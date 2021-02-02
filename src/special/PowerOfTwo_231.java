package special;

public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
//        for (int i=0;i<=Math.log(n)/Math.log(2);i++){
//            if (Math.pow(2,i)==n){
//                return true;
//            }
//        }
//        return false;

        //位运算
        if (n==0)
            return false;
        long x=(long) n;
        return (x&(-x))==0;
    }
}
