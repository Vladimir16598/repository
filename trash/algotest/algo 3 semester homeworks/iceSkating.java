import java.util.*;

public class iceSkating {
	static int [] x = new int [100];
	static int [] y = new int[100];
	static boolean [] bool = new boolean[100];
	static int n, sum = -1;


	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		for(int i = 0 ; i < n ; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}

		for(int i = 0 ; i < n ; i++) {
			if(!bool[i]) {
				dfs(i);
				sum++;
			}
		}System.out.println(sum);
	}

	public static void dfs(int input) {
		bool[input] = true;
		for(int i = 0 ; i < n ; i++) {
			if(!bool[i])
				if(x[input] == x[i] || y[input] == y[i])
			dfs(i);
		}

	}
}
