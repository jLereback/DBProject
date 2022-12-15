package tools;

import java.util.Scanner;

public class Tools {

	public static int getInt123(Scanner sc) {
		int n = 0;
		boolean is123 = false;
		while (!is123) {
			try {
				n = Integer.parseInt(sc.nextLine());
				if (n == 1 || n == 2 || n == 3)
					is123 = true;
				else
					throw new Exception();
			} catch (Exception e) {
				System.out.println("Enter 1, 2 or 3");
			}
		}
		return n;
	}

	public static int getInt(Scanner sc) {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Enter number:");
			}
		}
	}

	public static byte getBoolean(Scanner sc) {
		do {
			String answer = sc.nextLine().toLowerCase();
			if (answer.equals("true"))
				return 1;
			else if (answer.equals("false"))
				return 0;
			else
				incorrectInput();
		} while (true);
	}

	public static String getInputToLowerCase(Scanner sc) {
		return sc.nextLine().toLowerCase();
	}

	public static void incorrectInput() {
		System.out.println("Incorrect input, please try again!");
	}

}
