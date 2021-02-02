package string;

public class MyAtoi_8 {
    public static int myAtoi(String s) {
        int result=0;
        int flag=1;
        int length=s.length();
        int count=0;
        if (length==0)
            return 0;
        while (count<length&&Character.isSpaceChar(s.charAt(count))){
            count++;
        }
        if (count<length&&s.charAt(count)=='-')
            flag=-1;
        if (count<length&&(s.charAt(count)=='-'||s.charAt(count)=='+'))
            count++;
        while (count<length&&s.charAt(count)>='0'&&s.charAt(count)<='9'){
            int t=s.charAt(count)-'0';
            if (result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&t>7))
                return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            result=result*10+t;
            count++;
        }
        return flag>0?result:-result;
    }
    public static void main(String[] args){
       int a= myAtoi(" ");
        System.out.println(a);
    }
}
