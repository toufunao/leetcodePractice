package onedayoneproblem;

public class Points2Line {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX=coordinates[0][0], deltaY=coordinates[0][1];
        int len=coordinates.length;
       for (int[] cor:coordinates){
           cor[0]-=deltaX;
           cor[1]-=deltaY;
       }

       int a=coordinates[1][1], b=-coordinates[1][0];
       for (int i=2;i<len;i++){
           int x=coordinates[i][0];
           int y=coordinates[i][1];
           if (a*x+b*y!=0)
               return false;
       }
       return true;
    }
}
