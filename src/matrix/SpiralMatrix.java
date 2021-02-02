package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        if (matrix.length==0)
            return ans;
        int nums=matrix.length*matrix[0].length;
        int left=0;
        int right=matrix[0].length-1;
        int top=0;
        int bottom=matrix.length-1;
        while (nums>0){
            for (int i=left;i<=right&& nums>0;i++){   //从左往右
                ans.add(matrix[top][i]);
                nums--;
            }
            top++;

            for (int i=top;i<=bottom && nums>0;i++){  //从上往下
                ans.add(matrix[i][right]);
                nums--;
            }
            right--;

            for (int i=right;i>=left&&nums>0;i--){    //从右往左
                ans.add(matrix[bottom][i]);
                nums--;
            }
            bottom--;

            for (int i=bottom;i>=top && nums>0;i--){   //从下往上
                ans.add(matrix[i][left]);
                nums--;
            }
            left++;
        }

        return ans;
    }
}
