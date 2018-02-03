import java.util.Scanner;

public class sum
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner (System.in);
    int first = sc.nextInt();
    int sum = 0;
    if (first>=1)
    {
    for (int i = 1; i <= first; i++)
      {
      sum=sum+i;
      }
    }
     if (first==0) {
      sum=1;


    }
    else if (first<=-1)
    {
      for (int i = 1; i >= first; i--)
        {
        sum=sum+i;
        }
    }
    System.out.print(sum);
  }
}
