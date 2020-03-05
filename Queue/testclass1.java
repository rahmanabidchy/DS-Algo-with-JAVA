public class testclass1{
    
    public static void main (String [] args){
        
        ArrayQueue l1 = new ArrayQueue();
        
        System.out.println("========================Test 01========================");
        try{
            l1.enqueue(45);
            l1.enqueue(44);
            l1.enqueue(39);
            l1.enqueue(27);            
        }
        catch(QueueOverflowException e){
            System.out.println("Caught QueueOverflowException ");
        }
        
        System.out.println(l1.toString());
        System.out.println("========================Test 02========================");
        
        try{
            l1.dequeue();
            l1.dequeue();  
            l1.dequeue();
            l1.dequeue();
            l1.dequeue();
        }
        catch(QueueUnderflowException e){
            System.out.println("Caught QueueUnderflowException");
        }
        System.out.println(l1.toString());
        
        
        System.out.println("========================Test 03========================");
        ArrayQueue l2 = new ArrayQueue();
        try{
            l2.enqueue(55);
            l2.enqueue(54);
            l2.enqueue(56);
            l2.enqueue(57);            
        }
        catch(QueueOverflowException e){
            System.out.println("Caught QueueOverflowException ");
        }
        
        Object [] x= l2.toArray();
        for(int i= 0; i< x.length; i++){
            System.out.println("x["+i+"] "+x[i]);
        }
        System.out.println(l2.search(56));
        
        System.out.println("========================Test 04========================");
        ArrayQueue l3 = new ArrayQueue();
        System.out.println(l3.size());
        System.out.println(l3.isEmpty());
        
         try{
            l3.enqueue("A");
            l3.enqueue("U");
            l3.enqueue("D");
            l3.enqueue("I");            
        }
        catch(QueueOverflowException e){
            System.out.println("Caught QueueOverflowException ");
        }
        
        System.out.println(l3.size());
        System.out.println(l3.isEmpty());
        System.out.println(l3.search("D"));
        
        try{
            System.out.println(l3.peek());
        }
        catch(QueueUnderflowException e){
            System.out.println("Caught QueueOverflowException ");
        }
            
        
        System.out.println(l3.toString());
        
        System.out.println("========================Test 05========================");
        ArrayQueue l4 = new ArrayQueue();
        
        try{
            l4.enqueue('C');
            l4.enqueue('H');
            l4.enqueue('I');
            l4.enqueue('T');  
            l4.enqueue('T');
            l4.enqueue('A');
            l4.enqueue('G');
            l4.enqueue('O');
            l4.enqueue('N');
            l4.enqueue('G');

        }
        catch(QueueOverflowException e){
            System.out.println("Caught QueueOverflowException ");
        }
        System.out.println(l4.toString());
        
         try{
            l4.dequeue();
            l4.dequeue();  
            l4.dequeue(); 

        }
        catch(QueueUnderflowException e){
            System.out.println("Caught QueueUnderflowException");
        }
        System.out.println(l4.toString());
        System.out.println("size = " +l4.size());
        try{
            l4.enqueue('-');
            l4.enqueue('R');
            l4.enqueue('S');

        }
        catch(QueueOverflowException e){
            System.out.println("Caught QueueOverflowException ");
        }
        
        System.out.println(l4.toString());
        
        try{
            l4.enqueue('A');
            l4.enqueue('B');
            l4.enqueue('C');

        }
        catch(QueueOverflowException e){
            System.out.println("Caught QueueOverflowException ");
        }
    }
}
        