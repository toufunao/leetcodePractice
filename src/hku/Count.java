package hku;

public class Count {
    public int maxCount(int[] a){
        int[] count=new int[10];
        for (int i=0;i<a.length;i++){
            switch (a[i]){
                case 0:count[0]++; break;
                case 1:count[1]++; break;
                case 2:count[2]++; break;
                case 3:count[3]++; break;
                case 4:count[4]++; break;
                case 5:count[5]++; break;
                case 6:count[6]++; break;
                case 7:count[7]++; break;
                case 8:count[9]++; break;
                case 9:count[9]++; break;
            }
        }
        int max=count[0];
        for (int i=0;i<10;i++){
            if (max<count[i])
                max=count[i];
        }

        return max;
    }
}
