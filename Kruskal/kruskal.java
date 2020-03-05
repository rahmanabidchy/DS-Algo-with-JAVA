import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;   


public class kruskal{
    
    static PriorityQueue<EdgesInfo> pq = new PriorityQueue<EdgesInfo>(); 
    public static int vertices;
    public static int wght =0;
    
    
    public static void main (String[] args){
        
        
        
        try{            
            File file = new File ("input.txt");
            Scanner sc= new Scanner (file);
            
            int i = sc.nextInt();
            vertices =i;
            
            
            while(sc.hasNextLine()){
                EdgesInfo temp = new EdgesInfo(sc.nextInt(),sc.nextInt(),sc.nextInt());
                pq.add(temp);
            }
            System.out.println(pq);
            System.out.println("--------------");
            mst();
            System.out.println("The weight of this minimum spannin tree is: "+wght);
            
            
            
        }
        catch(FileNotFoundException e){
            System.out.println("No input were found");
        }
    }
    
    public static void mst(){
        
        int[] lead= new int[vertices+1];
        for(int i=1; i<lead.length;i++){
            lead[i]=-1;
        }
        
        
        for(int i=0; i< vertices-1;){
            
            EdgesInfo x = pq.poll();
            
            if((lead[x.v1]==-1&&lead[x.v2]==-1)||lead[x.v1]!=lead[x.v2]){//then makeset
                
                if(lead[x.v1]==-1&&lead[x.v2]==-1){//make max value as the leader
                    if(x.v1>x.v2){
                        lead[x.v1]=x.v1;
                        lead[x.v2]=x.v1;
                    }
                    else{
                        lead[x.v1]=x.v2;
                        lead[x.v2]=x.v2;
                    }
                }
                        
                
                else if(lead[x.v1]>lead[x.v2]){
                    //put the greater value in all of its new followers
                    if(lead[x.v2]!=-1){//then replace all small values with greater value
                        int temp=lead[x.v2];
                        for(int j=1; j<lead.length;j++){
                            if(lead[j]==temp){
                                lead[j]=lead[x.v1];
                            }
                        }
                    }
                    else{
                        lead [x.v2]=lead[x.v1];
                    }
                }
                
                else if(lead[x.v2]>lead[x.v1]){
                    
                    if(lead[x.v1]!=-1){
                        int temp=x.v1;
                        for(int j=1; j<lead.length;j++){
                            if(lead[j]==temp){
                                lead[j]=lead[x.v2];
                            }
                        }
                    }
                    else{
                        lead[x.v1]=lead[x.v2];
                    }
                }
                        //replace the min value with the max value
                        
                    
                System.out.println("v1: "+x.v1+" v2: "+x.v2);
                System.out.println(x.val);

                wght=wght+x.val;
                i++;
                
            }
            for(int aa=1;aa<lead.length;aa++){
                System.out.print("["+lead[aa]+"]");
            }
           System.out.println("");
            
            //if(flag==true){
            //    wght=wght+x.val;
            //}
        }
    }
            
            
}