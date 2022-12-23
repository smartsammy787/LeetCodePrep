package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfDistancesInTree {

//	834
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SumOfDistancesInTree obj=new SumOfDistancesInTree();
		int n = 6;
		int [][]edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
		System.out.println(obj.sumOfDistancesInTree(n, edges));
	}
	
	
	

    int n;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n=n;
       List<Integer>[] graph =new ArrayList[n];
        
        for(int i=0;i<n;i++){
           graph[i]=new ArrayList<Integer>();
        }
        
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        
        int count[]=new int[n];
        int res[]=new int[n];
        
        Arrays.fill(count,1);
        
        postOrder(0,-1,graph,count,res);
        
        preOrder(0,-1,graph,count,res);
        
        
        return res;
    }
    
    
    void postOrder(int curNode,int prevNode,List<Integer>[] graph,int []count,int []res){
        
        for(int child:graph[curNode]){
            
            if(child!=prevNode){
            
            postOrder(child,curNode,graph,count,res);
            count[curNode]+=count[child];
            res[curNode]+= res[child] + count[child];
                
            }       
        
    }
    }
    
    void preOrder(int curNode,int prevNode,List<Integer> graph[],int []count,int []res){
        
        for(int child:graph[curNode]){
            if(child!=prevNode){
                res[child]=res[curNode]+ (n - count[child]) - count[child];
                preOrder(child,curNode,graph,count,res);
                //when root is changed to other node one side of nodes get closer to this new 
                //root while the other nodes get farther from this new node.
                //formula derived from this  idea
            }
        }
    }
}
