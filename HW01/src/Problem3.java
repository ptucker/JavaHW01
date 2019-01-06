import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		System.out.println("Enter a number");
		Scanner input = new Scanner(System.in);
		String number = input.nextLine();
		
		char Char;
		boolean isNumber=true;
		
		for (int i = 0; i <number.length(); i++) {
			Char = number.charAt(i);
			//PT -- more readable: if (Char < '0' || Char > '9')
			if (Char < 48 || Char > 57) {
				System.out.println("You did not enter a number");
				isNumber = false;
				break;
			}
		}
		if (isNumber == true) {
			convertStringToInt(number);
		}
		//PT -- why call convertStringToInt twice? -1
		System.out.println(convertStringToInt(number));
		
		
		
	}
	public static int convertStringToInt(String s) {
		int integer = 0, factor = 1;
		for (int i = s.length()-1;i >=0;i--) {
			integer += (s.charAt(i) - '0') * factor;
			factor *= 10;
		}
		return integer;
	}
}
