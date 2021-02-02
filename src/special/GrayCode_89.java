package special;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> gray=new ArrayList<>();
        gray.add(0);

        for (int i=0;i<n;i++){
            int add=1<<i;
            for (int j=gray.size()-1;j>=0;j--){
                gray.add(gray.get(j)+add);
            }
        }
        return gray;
    }
}
