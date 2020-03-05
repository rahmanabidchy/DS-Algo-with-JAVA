public class ListQueue implements Queue{
    int size;
    Node front;
    Node rear;
    
    
    public ListQueue(){
        size = 0;
        front = null;
        rear = null;
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
        Node n = new Node(o, null);
        
        if(size == 0){
            front = n;
            rear = n;
            size+=1;
        }
        else{
            rear.next = n;
            rear = n;
            size+=1;
        }
    }
         
    
    public Object dequeue() throws QueueUnderflowException{
        
        if(size == 0){
            throw new QueueUnderflowException();
        }
        
        else{
            Object x = front.val;
            
            if(size == 1){
                front.val = null;
                front.next = null;
                size-=1;
            }
                
            else{
                Node rmv = front;
                front = front.next;
                rmv.val = null;
                rmv.next = null;
                rmv = null;
                size-=1;
            }
            return x;
        }
    }
    
    
    public Object peek() throws QueueUnderflowException{
        
        if(size == 0){
            throw new QueueUnderflowException();
        }
        
        else{
            Object x = front.val;
            return x;
        }
    }
        
    
    public String toString(){
        String s = "[ ";
        
        Node n = front;
        
        for(int i= 0; i<size; i++){
            s = s+ n.val+" ";
            
            if(n.next == null){
                break;
            }
            
            n = n.next;

        }
        
        s= s+ "]";
        return s;
    }
    
    
    public Object[] toArray(){
        Object [] array = new Object [size];
        Node n = front;
        
        for(int i= 0; i<size; i++){
            array[i] = n.val;
            
            if(n.next == null){
                break;
            }
            
            n = n.next;
        }
        
        return array;
    }    
    
    
    public int search(Object o){
        
        if(size == 0){
            return -1;
        }
        
        else{
            int i= -1;
            Node n = front;
            
            for(int k= 0; k<size; k++){
                
                if((n.val).equals(o)){
                    i = k;
                }
                
                if(n.next == null){
                    break;
                }
                
                n = n.next;
            }
            
            return i;
        }
    }
            
            
            
            
//TO DO
}