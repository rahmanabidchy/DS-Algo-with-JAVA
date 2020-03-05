import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class quickSort{
    
    public static void main (String [] args){
        
        try{
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);
            int i= sc.nextInt();
            int[] arr = new int [i];
            
            for(int j= 0; j<i; j++){
                arr[j] = sc.nextInt();
            }
            
            sorting(arr,0,i-1);
            
            for(int j= 0; j<i; j++){
                System.out.print(arr[j]+" ");
            }
            
        }
        catch(FileNotFoundException e){
            System.out.println("file was not found");
        }
    }
    
    

    
    public static void sorting(int[] arr, int left, int right){
        
        if(left>=right){
            return;
        }
        else{
            int l=left, r=right;
            int pivot = left;
            
            while(true){
                if(left>=right){
                    break;
                }
                
                if(pivot==left){
                    if(arr[pivot]>arr[right]){
                        //we need to swap
                        
                        int temp= arr[pivot];
                        arr[pivot]=arr[right];
                        arr[right]=temp;
                        pivot = right;
                        left++;
                    }
                    else{
                        right--;
                    }
                }
                
                
                if(pivot==right){
                    if(arr[pivot]<arr[left]){
                        //we need to swap
                        
                        int temp= arr[pivot];
                        arr[pivot]=arr[left];
                        arr[left]=temp;
                        pivot = left;
                        right--;
                    }
                    else{
                        left++;
                    }
                }
                
            }
            
            sorting(arr,l,pivot-1);
            sorting(arr,pivot+1,r);
        }
    }
            
            
            
            
            
                
        
    
    
    
}



    
    
        
        