import java.util.*;

public class statistics
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a= new int [n];
    int three=0;
    int four=0;
    for (int i = 0; i < n; i++)
    {
      a[i] = sc.nextInt();
      if (a[i]%2!=0)
      {
        System.out.print(a[i] + " ");
        three++;
      }
    }
    System.out.println();
    for (int i = 0; i < n; i++)
    {

      if (a[i]%2==0)
      {
        System.out.print(a[i] + " ");
        four++;
      }
    }
    System.out.println();
    if(four>=three)
    {
      System.out.print("YES ");
    }
    else
    {
      System.out.println("NO ");
    }
  }
}
