package string;

import java.nio.charset.StandardCharsets;

public class StrMultiplyStr {
    public String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0"))
            return "0";
        int m=num1.length();
        int n=num2.length();
        int[] res=new int[m+n];

        for (int i=m-1;i>=0;i--){
            int x=num1.charAt(i)-'0';
            for (int j=n-1;j>=0;j--){
                int y=num2.charAt(j)-'0';
                res[i+j+1]+=x*y;
            }
        }

        for (int i=m+n-1;i>0;i--){
            res[i-1]+=res[i]/10;
            res[i]%=10;
        }
        int index;

        if (res[0]!=0)
            index=0;
        else
            index=1;

        StringBuilder stringBuilder=new StringBuilder();
        while (index<m+n){
            stringBuilder.append(res[index]);
            index++;
        }

        return stringBuilder.toString();
    }
}
