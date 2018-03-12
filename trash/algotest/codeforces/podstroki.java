import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class podstroki {
	static Scanner in = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) {
		long ans = 0, arr[] = new long[3_000_000];
		String s = in.next();
		char[] bad = in.next().toCharArray();
		int k = in.nextInt(), p = 0;
		for (int l = 0; l < s.length(); l++) {
			long badChars = 0, h = 0;
			for (int j = l; j < s.length(); j++) {
				badChars += '1' - bad[s.charAt(j) - 'a'];
				h = (5381 * h) + s.charAt(j);
				if (badChars <= k) {
					arr[p++] = h;
				}
			}
		}
		Arrays.sort(arr, 0, p);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
