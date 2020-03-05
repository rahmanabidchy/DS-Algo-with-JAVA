import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BFS_Traverse_2{
    static int size;
    static int [] dist;
    static int [] parent;
    static String [] color;
    
    public static void main (String [] args){
        
        try{            
            File file = new File ("input.txt");
            Scanner sc= new Scanner (file);
            Scanner inp = new Scanner(System.in);
            int i = sc.nextInt();
            int [][] array= new int [i][i]; 
            
            while(sc.hasNextLine()){                
                int j = sc.nextInt();
                int k = sc.nextInt();
                array[j][k]=1;
            }
            size = array.length;
            System.out.println("Please give a valid source node");
            int s= inp.nextInt();
            
            BFS(array, s);
            
            //prints the shortest path
            
                
            
            
        }
        
        catch(FileNotFoundException e){
            System.out.println("No input were found");
        }
    }
    
    
    public static void BFS(int[][]array,int source){
        color=new String [size];
        parent = new int [size];
        dist = new int [size];
        Queue list = new Queue();
        
         for(int i=0; i<size; i++){
            color[i]="white";
            parent[i]=-1;
            dist[i] =-1;
         }
         
         color[source] = "grey";
         dist[source] =0;
         parent[source]=-1;
         
         list.enqueue(source);
         
         while(!(list.isEmpty())){
             int u=list.dequeue();
             System.out.print(u+"("+dist[u]+") ");
             
             for(int i=0; i<size; i++){
                 if(array[u][i]==1 && color[i].equals("white")){
                     color[i] = "grey";
                     dist[i] = dist[u]+1;
                     parent[i]=u;
                     
                     list.enqueue(i);
                 }
             }
             
             color[u]="black";
         }
    }
}
         
        
        
        