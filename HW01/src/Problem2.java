import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		System.out.println("Enter the radius of a circle");
		Scanner input = new Scanner(System.in);
		int radius = input.nextInt();
		final double PI = 3.14;
		double area = radius * radius * PI;
		System.out.println("The area of the circle is " + area);
	}
}
