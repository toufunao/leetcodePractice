package array;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] strs=s.split(" ");
        List<char[]> list=new ArrayList<>();
        for (String str:strs){
            list.add(str.toCharArray());
        }
        List<char[]> reverse=new ArrayList<>();
        int n=strs.length;
        for (int i=0;i<n;i++){
            char[] tmp=list.get(i);
            int l=0;
            int r=tmp.length-1;
            char t;
            while (l<r){
                t=tmp[l];
                tmp[l]=tmp[r];
                tmp[r]=t;
                l++;
                r--;
            }
            reverse.add(tmp);
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<n;i++){
            stringBuilder.append(reverse.get(i));
            if (i!=n-1)
                stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
