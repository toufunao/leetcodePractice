package doublepointer;

public class MaxArea_11 {
    public int maxArea(int[] height) {
        //双指针
        /*
        int maxArea=0;
        int left=0;
        int right=height.length-1;
        while (left<right){
            int area=(right-left)*Math.min(height[left],height[right]);
            if (maxArea<area)
                maxArea=area;

            if (height[left]<height[right])
                left++;
            else
                right--;
        }
        return maxArea;
         */

        int max=0;
        int left=0;
        int right= height.length-1;
        while (left<right){
            int temp=(right-left)*Math.min(height[left],height[right]);
            if (temp>max)
                max=temp;

            if (height[left]<height[right])
                left++;
            else
                right--;
        }

        return max;
    }
}
