package graph;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule_I {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count=0;
        int[] inDegree=new int[numCourses];

        for (int[] pre:prerequisites){
            inDegree[pre[0]]++;
        }
        Queue<Integer> queue=new ArrayDeque<>();
        for (int i=0;i<numCourses;i++){
            if (inDegree[i]==0)
                queue.offer(i);
        }

        while (!queue.isEmpty()){
            int temp=queue.poll();
            count++;

            for (int[] pre:prerequisites){
                if (pre[1]==temp){
                    int node=pre[0];
                    inDegree[node]--;
                    if (inDegree[node]==0)
                        queue.offer(node);
                }
            }
        }
        if (count==numCourses)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        int[][] test=new int[10][2];
        test[0][0]=0;test[0][1]=1;
        test[1][0]=2;test[1][1]=3;
        test[2][0]=4;test[2][1]=5;
        test[3][0]=6;test[3][1]=7;

        System.out.println(test.length);
        for (int[] a:test){
            System.out.println(a[1]);
        }
    }
}
