package calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "> ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		boolean isLoop = true;

		printMenu();
		while (isLoop) {
			System.out.println("command (1, 2, 3, h, q)");
			printPrompt();
			String in_cmd = scanner.next();

			switch (in_cmd) {
			case "1":
				prompt_addPlan(scanner, cal);
				break;
			case "2":
				prompt_searchPlan(scanner, cal);
				break;
			case "3":
				printCalendar(scanner, cal);
				break;
			case "h":
				printHelpMsg();
				break;
			case "q":
				isLoop = false;
				System.out.println("Bye!");
				break;
			default:
				System.out.println("input the correct command!");
				break;
			}
		}

		scanner.close();

	}

	public void printPrompt() {
		System.out.print(PROMPT);
	}

	public void prompt_addPlan(Scanner s, Calendar c) {
		System.out.println("[Add Plan] input the date.");
		printPrompt();
		String in_date = s.next();

		System.out.println("input the plan.");
		printPrompt();
		s.nextLine(); // ignore newline
		String in_plan = s.nextLine();

		if (c.addPlan(in_date, in_plan)) {
			System.out.println("saved plan");
		}
		else {
			System.out.println("Fail to save plan!");
		}
	}

	public void prompt_searchPlan(Scanner s, Calendar c) {
		System.out.println("[Add Plan] input the date.");
		printPrompt();
		String in_date = s.next();

		System.out.println(c.searchPlan(in_date));
	}

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	public void printCalendar(Scanner s, Calendar c) {
		System.out.println("input the year and month");
		System.out.println("calendar search exit : year = -1");
		System.out.println("eX) 2021 1 / 2020 7");

		int input_month = 1;
		int input_year = 1;

		while (input_year != -1) {
			printPrompt();
			
			input_year = s.nextInt();
			if (input_year == -1) {
				System.out.println("Program exit!");
				break;
			}
			
			input_month = s.nextInt();
			if (input_year <= 0) {
				System.out.println("input the correct year!");
				continue;
			}

			if (input_month <= 0 || input_month > 12) {
				System.out.println("input the correct month!");
				continue;
			}

			c.printCalendar(input_year, input_month);
		}
	}

	public void printHelpMsg() {
		System.out.println("Help u");
	}

}
