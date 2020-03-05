public class Heap{
    
    public static void main (String [] args){
        int [] array = new int[] {0,4,1,3,2,16,9,10,14,8,7,5,11,6,13,12,15};
        heapSort(array);
        
    }
    
    
    public static void maxHeapify(int[]array, int i, int n){
        
        int l = (2*i);
        int r = (2*i)+1;
        
        int largest;
        if((l<n) && (array[l]>array[i])){
            //System.out.print("l");
            largest = l;
        }
        
        else{
            //System.out.print("i");
            largest = i;
        }
        
        if((r<n) && (array[r]>array[largest])){
            //System.out.print("r");
            largest = r;
        }
        
        if(largest!=i){
            
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            //System.out.print("swap happened, "+array[i]+"--->"+array[largest]+" ");
            
            maxHeapify(array, largest, n);
        }
        
        return;
    }
    
    
    public static void buildMaxHeap(int [] array){
        
        int n = array.length;
        
        for(int i= (n/2); i>=1; i--){
            //System.out.println(i);
            maxHeapify(array, i, n);
            //System.out.println("kaj shesh");
        }
    }
     
    
    public static void heapSort(int [] array){
        buildMaxHeap(array);
        int n= array.length; 
        
        int i;
        for(i= n-1; i>1; i--){
            int temp = array[i];
            array[i] = array[1];
            array[1] = temp;
            
            System.out.print("["+array[i]+"]");            
            maxHeapify(array, 1, i);
        }
        
         System.out.println("["+array[i]+"]");
    }
    
            
        
        
        
        
        
            
            
            
            

}
        