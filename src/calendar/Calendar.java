package calendar;

public class Calendar {

	private static final int[] MAX_DAY_ARR = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAY_ARR = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int DAY_OF_WEEK = 7;

	public boolean isLeapYear(int year) {
		if( year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}
	
	public int getMaxDayOfMonth(int year, int month) {
		if( isLeapYear(year))
			return LEAP_MAX_DAY_ARR[month - 1];
		else
			return MAX_DAY_ARR[month - 1];
	}

	public void printCalendar(int year, int month) {
		System.out.printf("     <%dyear %dmonth>\n", year, month);
		System.out.println("SUN MON TUE WEN THU FRI SAT");
		System.out.println("---------------------------");
		int lastdayOfMonth = getMaxDayOfMonth(year, month);
		for (int i = 1; i <= lastdayOfMonth; i++) {
			System.out.printf("%3d ", i);

			if (i % DAY_OF_WEEK == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Prompt prompt = new Prompt();
		prompt.runPrompt();
	}

}
