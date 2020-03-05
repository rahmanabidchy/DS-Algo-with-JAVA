public class ArrayQueue implements Queue{
    int size;
    int front;
    int rear;
    Object [] data;
    
    public ArrayQueue(){
        size=0;
        front = -1;
        rear = -1;
        data = new Object[5];
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
    

    public void enqueue(Object o) throws QueueOverflowException{
        
        if(size == data.length){
            throw new QueueOverflowException();
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
                
                
    public Object dequeue() throws QueueUnderflowException{
        if(size == 0){
            throw new QueueUnderflowException();
        }
        
        else{
            Object x = data[front];
            
            data[front] = null;
           
            front= (front +1)%data.length;
            size-=1;
            
            if(size == 0){
                front = -1;
                rear = -1;
            }
            
            return x;
        }
    }

    
    public Object peek() throws QueueUnderflowException{
        
        if(size == 0){
            throw new QueueUnderflowException();
        }
        else{
            return data[front];
        }
    }


    public String toString(){
        String s = "[ ";
        
        int x= front;
        for (int i= 0 ; i< size; i++){
            s= s+ data[x]+ " ";
            x++;
            if(x == data.length){
                x= x%data.length;
            }
        }
        
        s= s+"]";
        
        return s;
    }


    public Object[] toArray(){
        Object [] array = new Object[size];
        
        int x= front;
        
        for(int i= 0; i< size; i++){

            array[i] = data[x];
            x++;
            if(x == data.length){
                x= x%data.length;
            }
        }
        
        return array;
        
    }

    public int search(Object o){
        
        int offset= -1;
        int x= front;
        boolean y= false;
        
        for(int i= 0; i< size; i++){
            if(data[x].equals(o)){
                y = true;
                offset = i;
                break;
            }
            
            x=(x+1)%data.length;
        }

        if(y==true){
            return offset;
        }else{
            return -1;
        }
        
    }

    
//TO DO
    
}