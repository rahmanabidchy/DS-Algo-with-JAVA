public class EdgesInfo implements Comparable<EdgesInfo>{
    
    int v1;
    int v2;
    int val;
    
    public EdgesInfo(int v1, int v2, int val){
        this.v1=v1;
        this.v2=v2;
        this.val=val;
    }
    
    public int compareTo(EdgesInfo other){
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than 
        // other and 0 if they are supposed to be equal
        if(this.val>other.val){
            return 1;
        }
        else if(this.val<other.val){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    public String toString(){
        return "v1: "+v1+", v2: "+v2+", val: "+val+"\n";
    }
}
    