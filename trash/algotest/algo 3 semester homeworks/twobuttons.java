import java.util.*;
public class twobuttons {
public static void main(String [] args){
	Scanner in=new Scanner(System.in);
	int n=in.nextInt();
	int m=in.nextInt();
	int cnt=0;
	while(m > n){
	cnt++;
	if(m%2==1)m++;
	else m/=2;
	}
	cnt+=n-m;
	System.out.print(cnt);
}
}