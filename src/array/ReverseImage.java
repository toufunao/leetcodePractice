package array;

public class ReverseImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        int left=0;
        int right=A[0].length;
        for (int i=0;i<A.length;i++){
            left=0;
            right=A[i].length-1;
            while (left<right){
                int t=A[i][left];
                A[i][left]=A[i][right];
                A[i][right]=t;
                left++;
                right--;
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j]==1)
                    A[i][j]=0;
                else if (A[i][j]==0)
                    A[i][j]=1;
            }
        }
        return A;
    }

    public static void main(String[] args){
        flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});

    }
}
