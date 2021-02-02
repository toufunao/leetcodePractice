package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class CourseSchedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //拓扑排序
        int[] res=new int[numCourses];
        int[] indegree=new int[numCourses];

        for (int[] pre:prerequisites){
            indegree[pre[0]]++;
        }

        Queue<Integer> queue=new ArrayDeque<>();
        for (int i=0;i<numCourses;i++){
            if (indegree[i]==0)
                queue.offer(i);
        }

        int count=0;
        while (!queue.isEmpty()){
            int temp=queue.poll();
            res[count]=temp;
            count++;

            for (int[] pre:prerequisites){
                if (pre[1]==temp){
                    int inNode=pre[0];
                    indegree[inNode]--;
                    if (indegree[inNode]==0)
                        queue.offer(inNode);
                }
            }
        }

        if (count==numCourses)
            return res;
        else
            return new int[]{};
    }
}
