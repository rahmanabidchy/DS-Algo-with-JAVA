public class recursionlab
{
  public static void main(String[]args)
  {
    System.out.println("fact"+" "+factorial(5));
    System.out.println("fibo"+" " +fibo(7));
    int [] a={1,2,3,4,5,6};
    System.out.println(bsearch(a,0,a.length-1,4));
    binary(2);
    System.out.println();
     System.out.println(pow(2,3));
      System.out.println(powless(2,3));
     
   
    
  }
  public static int factorial(int n)
  {
    if(n==0)
    {
      return 1;
    }
    else
    {
      return (n*factorial(n-1));
    }
  }
  
  public static int fibo(int n)
  {
    if(n==0)
    {
      return 0;
    }
     if(n==1)
    {
      return 1;
    }
    else
    {
      return (fibo(n-1)+fibo(n-2));
    }
  }

  public static int bsearch(int [] x, int l,int r,int n)
  {
       if(r>=l)
       {
       int mid=(l+r)/2;
      if(n==x[mid])
      {
        return mid;
      }
      else if (n>x[mid])
      {
        return bsearch(x,mid+1,r,n);
      }
      else
      {
       
       return bsearch(x,l,mid-1,n);
      }
       }
       return -1;
  }

  public static void binary( int n)
  {
    if(n==0)
    {
      return ;
    }
    else
    {
      binary(n/2);
      System.out.print(n%2);
    }
  }
 public static int pow(int m, int n)
 {
   if(n==1)
   {
     return m;
   }
   else
   {
     return (m*pow(m,n-1));
   }
 }
 public static int powless(int m,int n)
 {
   if(n==1)
   {
     return m;
   }
   
   if(n%2!=0)
   {
     return (m*powless(m,n/2)*powless(m,n/2));
   }
   else{
     return (powless(m,n/2)*powless(m,n/2));
   
 }
     
}
}