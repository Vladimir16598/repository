import java.util.Scanner;


public class akula {
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		int n= sc.nextInt();
		int diff[]= new int [1999];
		int sum[]= new int [1999];
		int mid=999;
		for(int i=0; i<n ;i++){
			int r= sc.nextInt()-1;
			int c= sc.nextInt()-1;
			if(r-c<=0)
				diff[c-r]++;
			else
				diff[mid+(r-c)]++;
			sum[r+c]++;
		}
		long output=0L;
		for(int i=0; i<1999;i++){
			int x= diff[i];
			output+=(x*(x-1))/2;
			x= sum[i];
			output+=(x*(x-1))/2;
		}
		System.out.println(output);
	}

}
