import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dijkstra{
    
    //global variables
    static int[][]array;
    static int size;
    static int[]dist; //array that holds the shortest distance
    static int[]parent; //array that holds the parent nodes
    static boolean[]visited; //holds all the visited nodes
    static boolean[]unvisited; //holds all the invisited nodes
    
    
    public static void main (String[] args){
        try{
            
            File file= new File("input.txt");
            Scanner sc= new Scanner(file);
            Scanner inp= new Scanner(System.in);
            
            size= sc.nextInt();
            array=new int[size][size];
            
            while(sc.hasNextLine()){
                int s= sc.nextInt();
                int d= sc.nextInt();
                int w= sc.nextInt();
                array[s][d] = w;
            }
            
            System.out.println("Please give a valid source node");
            int source = inp.nextInt();
            shortPath(source);
            
            //print the value of short path for all nodes from source.
            for(int i=0 ;i<size; i++){
                System.out.println(i+"-["+dist[i]+"]");
            }
            
            
        }
        catch(FileNotFoundException e){
            System.out.println("The file has not been found");
        }
    }

    public static void shortPath(int source){
        
        dist= new int [size]; //array that holds the shortest distance
        parent= new int[size]; //array that holds the parent nodes
        visited = new boolean[size]; //holds all the visited nodes
        unvisited = new boolean[size]; //holds all the invisited nodes
        
        for(int i=0; i<size; i++){
            dist[i]=10000;
            parent[i]=-1;
            unvisited[i]= true;
            visited[i]=false;
            
            
        }
        
        parent[source]=-1;
        dist[source]=0;
        
        while(!isEmpty()){
            unvisited[source]=false;
            findShort(source);
            
            source = findMinDistNode();
            
        }
        
    }
    
    
    public static void findShort(int node){
        for(int i=0; i<size; i++){
            if(array[node][i]!=0 && visited[i]!=true){
                int alt= dist[node]+array[node][i];
                
                if(dist[i]>alt){
                    dist[i]=alt;
                    parent[i]=node;
                }
            }
        }
        visited[node]=true;
    }
    
    
    
    public static boolean isEmpty(){
        boolean flag=true;
        for(int i=0; i<unvisited.length; i++){
            if(unvisited[i]==true){
                flag=false;
            }
        }
        return flag;
    }
    
    
    public static int findMinDistNode(){
        int min=100000;
        int idx=100000;
        for(int i=0; i<size; i++){        
            if(dist[i]<min && visited[i]==false){
                min = dist[i];
                idx=i;
            }
        }
        
        return idx;
    }
    
}