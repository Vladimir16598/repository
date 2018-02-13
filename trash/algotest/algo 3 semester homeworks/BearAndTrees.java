import java.util.*;
public class BearAndTrees {
	static int n,d,h,a,b,c,ans;

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();d=in.nextInt();
		h=in.nextInt();
		if(n<d+1||d>2*h||h>d||(d==1&&n>2)) System.out.println(-1);//d>2*h||...
		else
		{
			a=d-h;
			for(int i=2;i<=h+1;i++)
				System.out.println((i-1)+" "+i);
			b=1;
			for(int i=h+2;i<=h+1+a;i++)
			{
				System.out.println(b+" "+i);
				b=i;
			}
			if(h>=2)
			{
				for(int i=h+2+a;i<=n;i++)
					System.out.println(2+" "+i);
			}
			else
			{
				for(int i=h+2+a;i<=n;i++)
					System.out.println(1+" "+i);
			}
		}
	}
}
