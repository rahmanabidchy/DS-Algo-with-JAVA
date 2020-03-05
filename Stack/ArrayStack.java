public class ArrayStack implements Stack{
    int size;
    int top;
    Object [] data;
    
    public ArrayStack(){
        size=0;
        top =-1;
        data = new Object[5];
    }
    
    public int size(){
      return size;
    }
   
    public boolean isEmpty(){
      if(size==0){
        return true;
      }
      else{
        return false;
      }
    }
    
    public void push(Object e) throws StackOverflowException{
        if(size==data.length){
            throw new StackOverflowException();
        }
        else{
            top+=1;
            size = top+1;
            data[top]=e;
        }
    }
    
    public Object pop() throws StackUnderflowException{
        if(size==0){
            throw new StackUnderflowException();
        }
        else{
            top-=1;
            size = top+1;
            return data[top];
        }
    }
    
    public Object peek() throws StackUnderflowException{
        if(size==0){
            throw new StackUnderflowException();
        }
        else{
            return data[top];
        }
    }
    
    public String toString(){
        String stk  ="[";
        for(int i=top; i>=0; i--){
            if(i==0){
                stk = stk+data[i]+"]";
            }
            else{
                stk= stk+data[i]+",";
            }
        }
        return stk;
    }
    
    public Object[] toArray(){
        
        Object[]arr = new Object [size];
        for(int i=top,j=0; i>=0 && j<size; i--,j++){
            arr[j] = data[i];
        }
        return arr;
    }
      
    
    public int search(Object e){
        int x=-1;
        
        for(int i= top; i>= 0; i--){
            if (e == data[i]){
                x= top-i;
                break;
            }
        }
        return x;
    }                
            
    
    
}