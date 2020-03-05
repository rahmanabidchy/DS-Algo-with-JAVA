import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BFS_Traverse{
    
    public static void main (String [] args){
            
        try{            
            File file = new File ("input.txt");
            Scanner sc= new Scanner (file);
            
            int i = sc.nextInt();
            int [][] array= new int [i][i]; 
            
            while(sc.hasNextLine()){                
                int j = sc.nextInt();
                int k = sc.nextInt();
                array[j][k]=1;
            }
            
            BFS(array);
        }
        catch(FileNotFoundException e){
            System.out.println("No input were found");
        }
    }
     
    public static void BFS(int [][] array){
        int element;
        int timestamp=0;
        boolean x = true;
        boolean [] visited = new boolean [array.length];
        for(int i=0; i<visited.length; i++){
            visited[i] = false;
        }
        
       
        int k;
        Stack node = new Stack();
        
        
        for(k=0; k<visited.length; k++){
            if(visited[k] == false){
                
                node.push(k);
                
                visited[k] = true;
                while(!(node.isEmpty())){
                    element=node.pop();
                    timestamp++;
                    System.out.print(element+"==>");
                    

                    for(int i=0; i<array.length; i++){
                        if(array[element][i] ==1 && visited[i] == false){
                            visited[i] = true;
                            node.push(i);
                            
                        }
                    }
                    
                }
            }
        }
    }
}
        
            
        
        
        
        
        
        