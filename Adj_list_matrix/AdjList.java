
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AdjList{
    
    public static void main (String [] args){
        int n;
        Node [] list;
        //Scanner sc;
        //Scanner line;
        
        try{
            
            File file = new File("input.txt"); 
            Scanner sc = new Scanner (file);            
            
            n = sc.nextInt();
            list = new Node[n+1];
            
            for(int i= 1; i< list.length; i++){
                list[i] = new Node(i,null);
            }
            
 
              
            
            while(sc.hasNextLine()){
                int i= sc.nextInt();
                int j= sc.nextInt();
                //System.out.println(i+","+j);
                add(list[i], j);                
            }
            
            //print 
            
            for(int i= 1; i< list.length; i++){
                System.out.print("["+list[i].value+"]");
                
                while(list[i].next!= null){
                    list[i] = list[i].next;
                    System.out.print( " -->"+list[i].value);
                }
                System.out.println("");
            }
            
            
        }
        
        catch(FileNotFoundException e){
            System.out.println("No input were found");
        }
        
    }
    
    public static void add(Node e, int v){
        Node j = new Node (v, null);
        Node head;
        for(head= e; head.next!= null; head = head.next){            
        }
        head.next = j;
    }
        
}

                
 
                
                
                
                
            
            
            
            