package seleniumTest;

public class Test
{
	public static void main(String args[])
	{
		int x = 2;
		int y = f(x);
		System.out.println(y);
	}
	
	public static int f(int x)
	{
		int y = x*3;
		return y;
	}
}