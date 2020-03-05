public class Stack{
    int size;
    int top;
    int [] data;
    
    public Stack(){
        size =0;
        top =-1;
        data = new int [10];
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void push(int e){
        if(size==data.length){ // create a bigger array
            int [] copy = new int [size*2];
            
            for(int i =0; i<data.length; i++){
                copy[i] = data[i];
            }
            data=copy;
            
            top+=1;
            data[top]=e;
            size = top+1;
            
        }
        else{
            top+=1;            
            data[top]=e;
            size = top+1;
        }
    }
    
    
    public int pop(){
        if(size==0){
            System.out.println("The stack is empty");
            return -1;
        }
        else{
            top-=1;
            size = top+1;
            return data[top+1];
        }
    }
    
}

