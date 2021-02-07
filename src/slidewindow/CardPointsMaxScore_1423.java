package slidewindow;

import java.util.Arrays;

public class CardPointsMaxScore_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int sum=Arrays.stream(cardPoints).sum();
        int size=n-k;
        int subSum=0;
        for (int i = 0; i <size; i++) {
            subSum+=cardPoints[i];
        }
        int min=subSum;
        for (int i = n-k; i <n; i++) {
            subSum=subSum-cardPoints[i-size]+cardPoints[i];
            min=Math.min(min,subSum);
        }
        return sum-min;
    }
}
