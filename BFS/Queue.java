public class Queue{
    int size;
    int front;
    int rear;
    int [] data;
    
    public Queue(){
        size=0;
        front = -1;
        rear = -1;
        data = new int[5];
    }
    
    public int size(){
        return size;
    } 
    

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    } 
    

    public void enqueue(int o){
        
        if(size == data.length){ //increase queue capacity
            int [] copy= new int [size*2];  
            for(int i=0; i<size; i++){
                copy[i] = data[i];
            }
            data=copy;
        }
        
        else{
            if(size == 0){
                front = 0;
                rear = 0;
                data[rear] = o;
                size += 1;
            }
            
            else{
                rear = (rear+1)%data.length;
                data[rear] = o;
                size +=1;
            }
                        
        } 
    }
                
                
    public int dequeue(){
        if(size == 0){
            return -1;
        }
        
        else{
            int x = data[front];
            
            data[front] = 0;
           
            front= (front +1)%data.length;
            size-=1;
            
            if(size == 0){
                front = -1;
                rear = -1;
            }
            
            return x;
        }
    }

    
}