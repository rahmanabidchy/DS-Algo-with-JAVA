public class CircularArray{
  
  private int start;
  private int size;
  private Object [] cir;
  
  /*
   * if Object [] lin = {10, 20, 30, 40, null}
   * then, CircularArray(lin, 2, 4) will generate
   * Object [] cir = {40, null, 10, 20, 30}
   */
  public CircularArray(Object [] lin, int st, int sz){
    this.start = st;
    this.size= sz;
    
    cir = new Object [lin.length]; 
    int k= start;
    for(int i= 0; i< lin.length; i++){
        cir[k] = lin[i];
        k = (k+1) % lin.length;
    }
  }

  
  //Prints from index --> 0 to cir.length-1
  public void printFullLinear(){
      
      for(int i= 0; i< cir.length; i++){
          if(i == cir.length-1){
              System.out.print(cir[i]);
          }
          else{
              System.out.print(cir[i]+",");
          }          
      }
      System.out.println("");
          
  }
  
  // Starts Printing from index start. Prints a total of size elements
  public void printForward(){
      
      int k = start;
      for(int i= 0; i< size; i++){
          if(i == cir.length-1){
              System.out.print(cir[k]);
          }
          else{
              System.out.print(cir[k]+",");
          } 
          k= (k+1)%cir.length;
      }
      System.out.println("");
  }
  
  
  public void printBackward(){
   
      int k = (start + size-1) % cir.length;
      for(int i= 0; i< size; i++){
          if(k == -1){
              k = cir.length-1;
              if(i == cir.length-1){
                  System.out.print(cir[k]);
              }
              else{
                  System.out.print(cir[k]+",");
              } 
          }
          else{              
              if(i == cir.length-1){
                  System.out.print(cir[k]);
              }
              else{
                  System.out.print(cir[k]+",");
              } 
          }
          k--;
      }
      System.out.println("");
  }
  
  // With no null cells
  public void linearize(){
      Object [] temp = new Object [size];
      
      int k = start;
      for(int i= 0; i< size; i++){
          temp[i] = cir[k];
          cir[k] = null;
          k= (k+1)%cir.length;
      }
      
      cir = temp;       
  }
  
  // Do not change the Start index
  public void resizeStartUnchanged(int newcapacity){
      Object[] temp= new Object[newcapacity];
      int k = start;
      int t = start;
      for(int i= 0; i< cir.length; ++i){
          temp[t] = cir[k];
          k= (k+1) % cir.length;
          t= (t+1) % temp.length;
      }
      cir = temp;
          
  }
  
  // Start index becomes zero
  public void resizeByLinearize(int newcapacity){
    Object [] temp = new Object [newcapacity];
    
    int k = start;
    for(int i= 0; i< cir.length; i++){
        temp[i] = cir[k];
        k= (k+1) % cir.length;

    }
    
    cir = temp;
  }
  
  /* pos --> position relative to start. Valid range of pos--> 0 to size.
   * Increase array length by 3 if size==cir.length
   * use resizeStartUnchanged() for resizing.
   */
  public void insertByRightShift(Object elem, int pos){ //INCOMPLETE!     
      
      if(size == cir.length){
          resizeStartUnchanged(cir.length+3);
      }
      int nShift= size-pos;
      int to = (start + size)%cir.length;
      int from= to-1;
      
      for(int i= 0; i<nShift; i++){
          if(from< 0){
              from = cir.length-1;
          }
          cir[to] = cir[from];
          to = from;
          from -=1;
      }
      cir[(start+pos)%cir.length] = elem;
      size +=1;
  }
  
  public void insertByLeftShift(Object elem, int pos){
      
      if(size == cir.length){
          resizeStartUnchanged(cir.length+3);
      }
      
      int nShift = pos+1;
      int from = start;
      int to = from-1;
      
      if(to < 0){
          to = cir.length-1;
      }
      
      for(int i= 0; i< nShift; i++){

          cir[to] = cir[from];
          to = from;
          from = (from+1)%cir.length;
      }
      start -=1;
      cir[(start + pos)%cir.length] = elem;
      size+= 1;
    
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByLeftShift(int pos){
      boolean x= true;
      int to = (start + pos)%cir.length;
      int from = (to+1)%cir.length;
      int end = (start+size-1)%cir.length;
      
      while(x ==true){
          cir[to] = cir[from];
          to = from;
          from = (from+1)%cir.length;
          if(from == (end+1)%cir.length){
              break;
          }
      }
      cir[end] = null;
      size --;

      
      
      
//      int numberOfShifts = (size - pos +1);
//      int lastIdx = (start + size-1)% cir.length;
//      int copyTo = (start+pos)%cir.length;
//      int copyFrom = copyTo +1;
//      
//      if(copyFrom == cir.length){
//          copyFrom = 0;
//      }
//      
//      for(int i= 0; i< numberOfShifts; i++){
//          cir[copyTo] = cir[copyFrom];
//          copyTo = copyFrom;
//          copyFrom +=1;
//      }
//      
//      cir[lastIdx] = null;
//      size -=1;
         
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByRightShift(int pos){
      int copyTo = (start + pos)%cir.length;
      int copyFrom = copyTo-1;
      
      if(copyFrom < 0){
          copyFrom = cir.length-1;
      }
      
      for(int i= 0; i< pos; i++){
          cir[copyTo] = cir[copyFrom];
          copyTo = copyFrom;
          copyFrom -=1;
      }
      
      cir[start] = null;
      start = (start+1)%cir.length;
      size -= 1;
      
  }

  
}