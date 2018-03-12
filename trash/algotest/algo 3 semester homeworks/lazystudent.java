import java.util.*;
import java.math.*;
import java.io.*;



public class lazystudent {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
    static class P implements Comparable{

        private int w, t,in;

        public P(int x, int y,int in) {
            this.w = x;
            this.t = y;
            this.in=in;
        }

        public int hashCode() {
            return (w * 31) ^ t;
        }

        public boolean equals(Object o) {
            if (o instanceof P) {
                P other = (P) o;
                return (w == other.w && t == other.t&&in==other.in);
            }
            return false;
        }
        public int compareTo(Object obj) {
		P l = (P) obj;
		if (this.w == l.w){
			if (this.t == l.t) return 0;
			return (this.t < l.t)? 1: -1;
		}
		return (this.w < l.w)? -1: 1;
	}
    }

    public static void main(String[] args){

    FastScanner s = new FastScanner(System.in);
    StringBuilder op=new StringBuilder();
    int n=s.nextInt();
    int m=s.nextInt();
    P[] e=new P[m];
    for(int i=0;i<m;i++)
        e[i]=new P(s.nextInt(),s.nextInt(),i);
    Arrays.sort(e);
    int fr=2;
    int to=3;
    int cv=2;
    HashMap<Integer,P> G=new HashMap<>();
    for(int i=0;i<m;i++){
        if(e[i].t==1){
            G.put(e[i].in,new P(1,cv,0));
            cv++;
        }
        else{
            if(fr==cv||to==cv)
            {
                System.out.println(-1);return;
            }
            else{
                G.put(e[i].in, new P(fr,to,0));
                fr++;
                if(fr==to)
                {fr=2;to++;}
            }
        }
    }

    for(int i=0;i<m;i++)
        System.out.println(G.get(i).w + " " +G.get(i).t);










    }


}
