import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class FindLCS{
    
   static char[] arr1; 
   static char[] arr2;
   static CharInfo[][] array;
   static int row;
   static int col;
   static Stack st = new Stack();
    
    
    public static void main (String[] args){
        
        try{
            File file = new File("input.txt");
            Scanner sc= new Scanner (file);
            
            
            String st1= sc.nextLine();
            String st2= sc.nextLine();
            //System.out.println(st1.length());
            //System.out.println(st2.length());
            arr1 = new char[st1.length()+1];
            arr1[0]='X';
            arr2 = new char[st2.length()+1];
            arr2[0]='X';

            for(int i=1; i<arr1.length; i++){
                arr1[i]= st1.charAt(i-1);
                //System.out.println(arr1[i]);
            }
            row=arr1.length;
            for(int i=1; i<arr2.length; i++){
                arr2[i]= st2.charAt(i-1);
                //System.out.println(arr2[i]);
            }
            col=arr2.length;
            array = new CharInfo [row][col];
            lcs_length();
            
            while (!st.isEmpty()){
                System.out.print(st.pop());
            }
            System.out.println("");
        }
        
        catch(FileNotFoundException e){
            System.out.println("No input were found");
        }
        
    }
    
    public static void lcs_length(){
        int i=0;
        int j=0;
        for(i=0; i<row; i++){
            for(j= 0; j<col; j++){
                if(i==0 || j==0){
                    array[i][j] =new CharInfo(0,'X');
                    //System.out.print(array[i][j].x+" "+array[i][j].y);
                }
                else if(arr1[i]==arr2[j]){
                    array[i][j]=new CharInfo((array[i-1][j-1]).x+1,'D');
                }
                else if((array[i-1][j]).x>(array[i][j-1]).x){
                    array[i][j] = new CharInfo ((array[i-1][j]).x, 'U');
                }
                else if((array[i-1][j]).x<=(array[i][j-1]).x){
                    array[i][j] = new CharInfo ((array[i][j-1]).x, 'L');
                }
            } 
        }
        System.out.print("Number of lcs's are: ");
        System.out.println(array[i-1][j-1].x);
        lcs(i-1,j-1);
    } 
    static int count =0;    
    public static void lcs(int i, int j){
        //count++;
        //System.out.println(count);
        
        if(i==0 || j==0){
            return;
        }
        else if((array[i][j]).y=='D'){
            st.push(new Character (arr1[i]));
            lcs(i-1, j-1);
        }
        else if((array[i][j]).y=='L'){
            lcs(i,j-1);
        }
        else if((array[i][j]).y=='U'){
            lcs(i-1,j);
        }
    }
    
    
    
}
        
        
            
                    
    
        
    