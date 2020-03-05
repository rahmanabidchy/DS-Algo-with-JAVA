public class RecursionExample{
    public static void main(String [] args){
      A(1);
      System.out.println("End");
      System.out.println("================[      ]================");
      System.out.println(fact(5));
      System.out.println(fib(5));
      System.out.println("================[      ]================");
      int [] x = new int [] {5,7,8,12,19,26,32,47};
      System.out.println(binSearch(x, 0, 7, 19));
      System.out.println("================[      ]================");
      binary(4);
      System.out.println("");
      System.out.println("================[      ]================");
      Node n4 = new Node(40,null);
      Node n3 = new Node(30,n4);
      Node n2 = new Node(20,n3);
      Node n = new Node(10,n2);
      System.out.println(printNode(n));
          
          
      
    }
    
    public static void A(int x){
        System.out.println(x);
        x= x+1;
        if(x<5){
            A(x);
        }
        System.out.println(x);
    }
    
    
    //task 01
    public static int fact(int n){ //n*(n-1)*(n-2)*....*(1)
      
      if(n==0){
        return 1;
      }
      else{
        return (n*fact(n-1));
      }
      
    }
    
    
    //task 02
     public static int fib(int n){// 0 1 1 2 3 5 8.....
       
       if(n==0){
         return 0;
       }
       else if(n==1){
         return 1;
       }
       
       else{
         return (fib(n-1) + fib(n-2));
       }
     }
        
     
     //task 03
     // a sorted array given, find the idx of the value
     //x, the array...l, leftmost idx.....r, rightmost idx....n,the element
     public static int binSearch(int [] x, int l, int r, int n){
       
       if(r>=l){
         int m = (l+r)/2;
         
         if(n==x[m]){
           return m;
         }
         
         else if(n >x[m]){
           return binSearch(x, m+1, r, n);
         }
         
         else if(n <x[m]){
           return binSearch(x, l, m-1, n);
         }
         
         else{
           return -1;
         }
       }
       
       else{
         return -1;
       }
       
     }
     
     
     //tasl 04
     public static void binary(int n){
       
       if(n == 0){
         return;
       }
       else{
         binary (n/2);
         System.out.print(n%2);
       }
       
     }
     
     //task 05
     public static int nodeIdx(Node head, Object element){
         
         if(head == null){
             return -1;
         }
         
         else{
             
             Node n = head;
         
             if (element.equals(n.val)){
                 return 0;
             }
             
             else{
                 return 1+ nodeIdx(head.next, element);
             }
         }
     }
             
     
     
     //task 06
     public static int  pow(int m, int n){
       
       if(n==1){
         return m;
       }
       else{
         return (m*pow(m,n-1));
       }
     }
     
     
     //task 07
     public static int powless(int m, int n){
         
         if(n==1){
             return m;
         }
         
         else if(n%2!=0){
             return m*powless(m,n/2)*powless(m,n/2);
         }
         
         else{
             return powless(m,n/2)*powless(m,n/2);
         }
     }
     
     //task 09
     public static String printNode(Node head){
         
         if(head==null){
             return "";
         }
         
         else{
             return printNode(head.next)+" "+head.val;
         }
     }
         
         
         
}