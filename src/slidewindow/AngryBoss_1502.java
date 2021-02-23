package slidewindow;

public class AngryBoss_1502 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int left=0;
        int right=X-1;
        int max=0;
        for (int i = 0; i <=right; i++) {
            max+=customers[i];
        }
        for (int i = X; i <customers.length ; i++) {
            if (grumpy[i]==0)
                max+=customers[i];
        }
        int temp=max;
        for (right=X;right<customers.length;right++){
            if (grumpy[left]==1)
                temp-=customers[left];
            if (grumpy[right]==1)
                temp+=customers[right];
            max=Math.max(max,temp);
            left++;
        }
        return max;

    }
}
