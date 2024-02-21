import java.time.DayOfWeek;
import java.util.Scanner;
public class Assignment {

	/*
        Write a program to demonstrate compatible type conversions. 
	       For eg., float to int, double to float, int to short
	 */
	public static void typeCan(double val)
	{
		float x=(float)val;
		System.out.println(x);
		
		int y=(int) x;
		
		short z=(short)y;
		
		System.out.println("double to float:"+x+"\nfloat to int:"+y+"\nint to short:"+z);
	}
	
    //Write a program to print a random number
	
	public static void printRandomNumber()
	{
     	System.out.println(Math.random());
	}
	
	/*
	 * Write a Java program 
	 * that gets a number from the user and displays the name of the weekday.
        Use enum.
	 */
	public static void findWeekDay()
	{
	   Scanner scan=new Scanner(System.in);
       System.out.print("enter the day");
       int n=scan.nextInt();
 
	 DayOfWeek d=DayOfWeek.of(n);
      System.out.println("day of week:"+d);
	}
    
	//Write a program to swap the two given numbers.​
	public static void swabNum(int a,int b)
	{
		int temp=a;
		a=b;
		b=temp;
		System.out.println("after swab:"+a+" "+b);
	}		
	
}
