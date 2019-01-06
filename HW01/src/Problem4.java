import java.util.Scanner;

public class Problem4 {
	public static void main(String[] args) {
		System.out.println("Enter your weight in pounds");
		Scanner wInput = new Scanner(System.in);
		double weight = wInput.nextInt();
		System.out.println("Enter your height in inches");
		Scanner hInput = new Scanner(System.in);
		double height = hInput.nextInt();
		//PT -- name these numbers:
		//   final double KG_TO_POUND = 2.205;
		double metricWeight = weight/2.205;
		double metricHeight = height/39.37;
		double BMI = metricWeight/(metricHeight*metricHeight);
		System.out.println("Your BMI is " + BMI);
	}
}
