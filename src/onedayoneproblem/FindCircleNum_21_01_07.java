package onedayoneproblem;

public class FindCircleNum_21_01_07 {
    public int findCircleNum(int[][] isConnected) {
        int provinces=isConnected.length;
        boolean[] isVisted=new boolean[provinces];
        int circles=0;

        for (int i=0;i<provinces;i++){
            if (!isVisted[i]){
                dfs(isConnected,isVisted,provinces,i);
                circles++;
            }
        }
        return circles;
    }

    public void dfs(int[][] isConnected,boolean[] isVisted,int provinces,int i){
        for (int j=0;j<provinces;j++){
            if (!isVisted[j]&&isConnected[i][j]==1){
                isVisted[j]=true;
                dfs(isConnected,isVisted,provinces,j);
            }
        }
    }
}
