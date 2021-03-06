package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] LASTDAY_OF_MONTH_ARR = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LASTDAY_OF_MONTH_LEAP_ARR = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int DAY_OF_WEEK = 7;

	private HashMap<Date, String> planMap;

	public Calendar() {
		planMap = new HashMap<Date, String>();
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}

	public int getLastDayOfMonth(int year, int month) {
		if (isLeapYear(year))
			return LASTDAY_OF_MONTH_LEAP_ARR[month];
		else
			return LASTDAY_OF_MONTH_ARR[month];
	}

	// STANDARD DAY = Thursday JAN 1st 1970
	public int getWeekDay(int year, int month, int day) {
		int standard_year = 1970;
		int standard_dayweek = 4; // 1970 JAN 1st => Thursday
		int day_count = 0;

		for (int i = standard_year; i < year; i++) {
			day_count += isLeapYear(i) ? 366 : 365;
		}

		for (int i = 1; i < month; i++) {
			day_count += getLastDayOfMonth(year, i);
		}

		day_count += day - 1;

		return (day_count + standard_dayweek) % DAY_OF_WEEK;
	}

	public void printCalendar(int year, int month) {
		System.out.printf("     <%dyear %dmonth>\n", year, month);
		System.out.println("SUN MON TUE WED THU FRI SAT");
		System.out.println("---------------------------");
		int lastdayOfMonth = getLastDayOfMonth(year, month);
		int cur_dayWeek = getWeekDay(year, month, 1);

		for (int i = 0; i < cur_dayWeek; i++) {
			System.out.print("    ");
		}

		for (int i = 1; i <= lastdayOfMonth; i++) {
			System.out.printf("%3d ", i);

			cur_dayWeek++;

			if (cur_dayWeek % DAY_OF_WEEK == 0) {
				System.out.println();
				cur_dayWeek = 0;
			}
		}
		System.out.println();
	}

	public boolean addPlan(String Date, String Plan) {
		planMap.put(getDateFromString(Date), Plan);
		return true;
	}

	public String searchPlan(String Date) {
		return planMap.get(getDateFromString(Date));
	}

	public static Date getDateFromString(String Date) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static void main(String[] args) {
		Prompt prompt = new Prompt();
		prompt.runPrompt();
	}

}
