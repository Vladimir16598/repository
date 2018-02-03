import java.util.*;
public class registration{
    public static void main(String args[]){
        String s;
        int n;
        Scanner in = new Scanner(System.in);
        Map<String, Integer> hm= new HashMap<String, Integer>();
        n=in.nextInt();
        for(int i=0;i<n;i++){
        s=in.next();
        if(!hm.containsKey(s)){
        hm.put(s,0);
        System.out.println("OK");
        }
        else{
        hm.put(s,hm.get(s)+1);
       System.out.println(s+hm.get(s));
        }
      }
    }
    }
