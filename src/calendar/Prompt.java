package calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal > ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		int input_month = 1;
		int input_year = 1;

		System.out.println("*****input the year and month*****");
		System.out.println("program exit : year = -1");
		System.out.println("eX) 2021 1 / 2020 7");
		while (input_year != -1) {
			System.out.print(PROMPT);

			input_year = scanner.nextInt();
			input_month = scanner.nextInt();

			if (input_year == -1) {
				System.out.println("Program exit!");
				break;
			}

			if (input_year <= 0) {
				System.out.println("input the correct year!");
				continue;
			}

			if (input_month <= 0 || input_month > 12) {
				System.out.println("input the correct month!");
				continue;
			}

			cal.printCalendar(input_year, input_month);
		}

		scanner.close();

	}

}
