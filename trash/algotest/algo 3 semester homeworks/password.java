import java.util.Scanner;

public class password {
	static int[] cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String match = sc.nextLine();
		int[] arr = new int[match.length()];
		cnt = new int[match.length()];
		prefix(match,arr);
		int len = arr[match.length()-1];
		if(len>0 && cnt[len]<2)
			len = arr[len-1];
		if(len==0)
			System.out.println("Just a legend");
		else
			System.out.println(match.substring(0,len));
		sc.close();
	}

	public static boolean KMP(String str,String match,int[] arr){
		int i=0;
		int j=0;
		while(i<str.length() && j<match.length())
		{
			if(str.charAt(i)==match.charAt(j))
			{
				i++;
				j++;
			}
			else
			{
				if(j!=0)
					j = arr[j-1];
				else
					i++;
			}
			if(j==match.length())
				return true;
		}
		return false;
	}

	public static void prefix(String match,int[] arr)
	{
		arr[0] = 0;
		int index = 0;
		for(int i=1;i<match.length();)
		{
			if(match.charAt(i)==match.charAt(index))
			{
				arr[i] = index+1;
				index++;
				i++;
				cnt[index]++;
			}
			else
			{
				if(index!=0)
					index = arr[index-1];
				else
				{
					arr[i] = 0;
					i++;
					cnt[0]++;
				}
			}
		}
	}
}
