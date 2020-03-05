public class DoublyList{
    public Node head;
    
    
    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */ 
    public DoublyList(Object [] a){
        head = new Node(null, null, null);
        Node tail = head;
        
        for(int i = 0; i<a.length; i++){
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev=tail;
            tail=tail.next;
        }
        tail.next=head; // Making it circular
        head.prev=tail;
    }
    
    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public DoublyList(Node h){
        head = h;
    }
    
    /* Counts the number of Nodes in the list */
    public int countNode(){
      int i=0 ;
        if(head.next== null){
          i= -1;
        }
        else{
          for (Node n= head.next; n!= head; n=n.next){
            i+=1;
          }
        }
        
        return i;
    }
    
    /* prints the elements in the list */
    public void forwardprint(){
      
        
      for(Node n= head.next; n!=head; n=n.next){
        if(n.next == head){
          System.out.print(n.element+".");
        }
        else{
          System.out.print(n.element+",");
        }
      }
      System.out.println("");
      
      
    }
    
    
    
    public void backwardprint(){
      
        
      Node tail = head.prev;
      for(Node n= tail; n!=head; n=n.prev){
        if(n.prev == head){
          System.out.print(n.element+".");
        }
        else{
          System.out.print(n.element+",");
        }
      }
      System.out.println("");

        
    }
    
    
    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
      if(idx<-1 || idx>=countNode()){
        return null;
      }
      else{
        if(idx==-1){
          return head;
        }
        else{
          int i= 0;
          Node n;
          for(n= head.next; n!=head; n=n.next){
            if(idx==i){
              break;
            }
            i+=1;
          }
          return n;
        }
      }
    }
    
    
    
    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        int i= 0;        
        for(Node n=head.next; n!=head; n=n.next){
          if(n.element == elem){
            return i;
           // break;
          }
          i+=1;
        }
        return -1;
            
       
    }
    
    
    
    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx){
      if(idx<0 || idx>countNode()){
        System.out.println("Invalid index entered");
      }
      else{
        Node pred= nodeAt(idx-1);
        Node succ= pred.next;
        Node mn= new Node (elem,succ,pred);
        succ.prev=mn;
        pred.next=mn;
      }
        
    }
    
    
    
    
    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
      
      if(index<0 || index>=countNode()){
        return null;
      }
      else{
        Node rmv= nodeAt(index);
        Node pred = rmv.prev;
        Node succ = rmv.next;
        pred.next=succ;
        succ.prev=pred;
        Object show= rmv.element;
        rmv.next=null;
        rmv.prev=null;
        rmv=null;
        return show; 
      }

    }
    
    
    
}