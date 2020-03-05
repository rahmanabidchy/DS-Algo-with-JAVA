import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
  
public class AdjMatrix{
  
  public static void main (String [] args){
    
    
    try{
      File file = new File("input.txt"); 
      Scanner sc = new Scanner (file);
      
      int i = sc.nextInt();
      int [][] array= new int [i+1][i+1];
      
      while(sc.hasNextLine()){
        int j = sc.nextInt();
        int k = sc.nextInt();
        array[j][k]=1;
      }
      
      System.out.println("_____________________");
      
      for(int l= 1; l< array.length;l++){
         
        
        for (int m= 1; m < array.length; m++){
          System.out.print("|"+array[l][m]+"|");
        }
        System.out.println("");
      }
      System.out.println("_____________________");
      
    }
    
    catch(FileNotFoundException e){
      System.out.println("No input were found");
    }
  }
}
    
    