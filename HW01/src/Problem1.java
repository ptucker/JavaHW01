import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		System.out.println("Enter a number from 10-100");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		if (number >= 10 || number <= 100) {
			for(int i =1; i<=number; i++) {
				System.out.print(i);
				if (i%2 == 0)
					System.out.println(" Even");
				else
					System.out.println(" Odd");
			}
		}
		else
			//PT -- loop on invalid numbers so the user has another chance. -1
			System.out.println("That is not a valid number");
	}
}
