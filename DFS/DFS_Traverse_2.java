import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DFS_Traverse_2{
    static int time=-1;
    static int size;
    static String [] color;
    static int [] dv;
    static int [] fv;
    static int [] parent;
    
    
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
            DFS(array,s);
            
            System.out.println("Start time");
            for(int x=0; x<size; x++){
                System.out.print(x +"( "+dv[x]+")");
            }
            System.out.println("");
            System.out.println("End time");
            for(int x=0; x<size; x++){
                System.out.print(x +"( "+fv[x]+")");
            }
            System.out.println("");
        }
        catch(FileNotFoundException e){
            System.out.println("No input were found");
        }
    }
    
    public static void DFS(int [][] array, int source){
        color = new String [size];
        dv = new int [size];
        fv = new int [size];
        parent = new int [size];
        
        for(int i=0; i<size; i++){
            color[i]="white";
            parent[i]=-1;
            dv[i] =time;
            fv[i]=time;
        }
        //time =0;
        
        int z=source;
        for(int i=0 ; i<size; i++){                  //here we have a circular array
            
            if(color[z].equals("white")){
                DFS_Visit(array,z);
                System.out.println("");
            }
            
            z=(z+1)%size;
        }
    }
    
    
    public static void DFS_Visit(int[][]array,int source){
        color[source]="grey";
        System.out.print(source+"==>");
        time++;
        dv[source]=time;
        
        //for each vertex adjacent to source
        for(int i=0; i<size; i++){
            if((array[source][i]==1) && (color[i].equals("white"))){
                //System.out.print("i was here");
                parent[i]=source;
                DFS_Visit(array,i);
                break;
            }
        }
        
        color[source]="black";
        time++;
        fv[source]=time;
    }
    
}