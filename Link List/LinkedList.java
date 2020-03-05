public class LinkedList
{
  public Node head;
  
  
  /* First Constructor:
   * Creates a linked list using the values from the given array. head will refer
   * to the Node that contains the element from a[0]
   */ 
  public LinkedList(Object [] a)
  {
    head = new Node(a[0], null);
    Node T = head;
    for (int i=1; i<a.length; i++)
    {
      Node n=new Node(a[i], null);
      T.next=n;
      T=n;
    }
    
    // TO DO
  }
  
  /* Second Constructor:
   * Sets the value of head. head will refer
   * to the given LinkedList
   */
  public LinkedList(Node h)
  {
    head = h;
    
    // TO DO
  }
  
  /* Counts the number of Nodes in the list */
  public int countNode()
  {
    int C=0; 
    for (Node n=head; n!=null; n=n.next)
    {
      C++;
    }
    return C;
    
    // TO DO
    // please remove this line!
  }
  
  /* prints the elements in the list */
  public void printList()
  {
      int c = countNode()-1;
      int t= 0;
      for (Node n=head; n!=null; n=n.next){
          if(t==c){
              System.out.print(n.element);
          }
          else{
              System.out.print(n.element+",");
          }
          t+=1;
      }
      System.out.println();

  }
  
  // returns the reference of the Node at the given index. For invalid index return null.
  public Node nodeAt(int idx)
  {
    if (idx<0 || idx >= countNode())
    {
      return null;
    }
    else
    {
      Node n=head; 
      for (int i=0; i<idx; i++)
      {
        n=n.next;
      }
      return n;
    }
    
    // TO DO
    // please remove this line!
  }
  
  
// returns the element of the Node at the given index. For invalid idx return null.
  public Object get(int idx)
  {
    if (idx<0 || idx>=countNode())
    {
      return null;
    }
    else
    {
      Node n=head; 
      for (int i=0; i<idx; i++)
      {
        n=n.next;
      }
      return n.element;
    }
    
    // TO DO
    // please remove this line!
  }
  
  
  
  /* updates the element of the Node at the given index. 
   * Returns the old element that was replaced. For invalid index return null.
   * parameter: index, new element
   */
  public Object set(int idx, Object elem)
  {

      if (idx < 0 || idx >= countNode() ){
      return null;
      }
      else{    
      Node n = head;
      for (int i= 0; i< idx; i++){
          n = n.next;
      }
      
      Object old = n.element;
      n.element = elem;
      return old;
    }

  }
  
  
  /* returns the index of the Node containing the given element.
   if the element does not exist in the List, return -1.
   */
  public int indexOf(Object elem){
      int idx= 0;
      boolean p= false;
      
      for(Node n= head; n!=null; n=n.next){
          if(n.element == elem){
              break;
          }
          idx ++;
      }
      if(p == false){
          return -1;
      }
      else{
          return idx;
      }
      
  }
  
  // returns true if the element exists in the List, return false otherwise.
  public boolean contains(Object elem){
      boolean p = false;
      
      for(Node n= head; n!=null; n=n.next){
          
          if(n.element == elem){
              p = true;
              break;
          }
  
      }
      
      return p;
          
  }
  
  // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
  public Node copyList(){ 
      Node head1 = new Node (head.element, null);
      Node tail1 = head1;
      
      for(Node n= head.next; n!=null; n=n.next){
          Node mn = new Node(n.element, null);
          tail1.next=mn;
          tail1 = mn;
      }
      
      return head1;
  }
  
  // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
  public Node reverseList(){
      Node headR = new Node (head.element, null);
      
      for(Node n= head.next; n!= null; n=n.next){
          Node nm = new Node(n.element, null);
          nm.next = headR;
          headR = nm;
      }
      
      return headR;

  }
  
  /* inserts Node containing the given element at the given index
   * Check validity of index.
   */
  public void insert(Object elem, int idx){
      if(idx<0 || idx> countNode()){
          System.out.println("You have entered an invalid index");
      }
      else{
          Node mn = new Node(elem,null);
          if(idx== 0){
              mn.next = head;
              head=mn;
          }
          else{
              Node pred = nodeAt(idx-1);
              mn.next = pred.next;
              pred.next=mn;
          }
      }
  }
  
  
  /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
   */
  public Object remove(int idx){
      Object bin = null;
      Node rmv= null;
      
      if(idx<0 || idx>= countNode()){
          System.out.println("You have entered an invalid index");
      }
      else{
          rmv = nodeAt(idx);
          
          if(idx==0){
              head = rmv.next;
          }
          else{
              Node pred = nodeAt(idx-1);
              pred.next = rmv.next;
          }
      }
      bin = rmv.element;
      rmv.element = null;
      rmv.next= null;
      rmv = null;
      
      return bin;
  }

  // Rotates the list to the left by 1 position.
  public void rotateLeft()
  {

  }
  
  // Rotates the list to the right by 1 position.
  public void rotateRight()
  {


  }
  
}