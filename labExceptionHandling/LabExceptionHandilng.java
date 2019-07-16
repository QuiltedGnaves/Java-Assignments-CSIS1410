package labExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LabExceptionHandilng
{
	public static void main(String[] args)
	{
		try {
			int digit = numberFromUser();
			int result = sevenModulusN(digit);
			System.out.printf("7 %% %d = %d", digit, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int numberFromUser() throws IllegalArgumentException
	{
		boolean valid = false;
		int returnVal = 0;
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("number: ");
			try {
				returnVal = input.nextInt();
				if (returnVal == 0) {
					throw new IllegalArgumentException();
				}
				valid = true;
			} catch (InputMismatchException|IllegalArgumentException e) {
				System.out.println("A problem occurred: " + e + "\nThe number entered needs to be a whole non-zero number.");
			}
			input.nextLine();
		} while (!valid);
		
		input.close();
		
		return returnVal;
	}

	private static int sevenModulusN(int number)
	{
		return 7 % number;
		
	}
}
