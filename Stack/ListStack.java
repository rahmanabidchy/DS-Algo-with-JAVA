public class ListStack implements Stack{
    int size;
    Node top;
  
    
    public ListStack(){
        size = 0;
        top = null;
    }
    
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(top==null){
            return true;
        }
        else{
            return false;
        }
    }

    public void push(Object e) throws StackOverflowException{
        Node n= new Node (e,null);
        n.next=top.next;
        top=n;
        size+=1;
    }

    public Object pop() throws StackUnderflowException{
        Object elem;
        if(top==null){
            throw new StackUnderflowException();
        }
        else{
            elem = top.val;
            Node rmv = top;
            top = top.next;
            rmv.val = null;
            rmv.next = null;
            rmv = null;
            size -=1;
        }
        return elem;
    }

    public Object peek() throws StackUnderflowException{
       Object elem;
        if(top==null){
            throw new StackUnderflowException();
        }
        else{
            elem = top.val;
        }
        return elem;
    }

    public String toString(){
        String s= "[";
        for(Node n= top; n!=null; n=n.next){
            s= s+" "+n.val;
        }
        s=s+" ]";
        return s;
    }

    public Object[] toArray(){
        Object [] stk = new Object [size];
        Node n;
        int i;
        for(n= top, i=0; n!=null && i<size; n=n.next, i++){
            stk[i] = n.val;
        }
        return stk;
    }

    public int search(Object e){
        int i = -1;
        boolean x= false;
        if(top==null){
            i = -1;
        }
        else{
            for(Node n= top; n!=null; n=n.next){
                i+=0;
                if(top.val == e){
                    x = true;
                    break;
                }
            }
        }
        
        if(x == true){
            return i;
        } else {
            return -1;
        }
    }
  
    

}