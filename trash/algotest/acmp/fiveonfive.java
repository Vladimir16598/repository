import java.util.*;

public class fiveonfive
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    int number = sc.nextInt();
    int nofive = number/10;
    int result = nofive * (nofive+1);
    if(number>14)
    {
      System.out.println(result+"25");
    }
    if(number==5)
    {
      System.out.println(25);
    }
  }
}
