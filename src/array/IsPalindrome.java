package array;

public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x<0)
            return false;
        int a=x;
        int b=x;
        int res=0;
        while (b!=0){
            a=b%10;
            b=b/10;
            res=res*10+a;
        }
        if (res==x)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome(1001));
        System.out.println(isPalindrome(-100));
    }
}
