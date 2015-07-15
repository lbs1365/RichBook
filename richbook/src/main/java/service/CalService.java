package service;

public interface CalService {
	String inListPrintCal(String inListPrint);
	int inYearMonthListPrintCal(String YearMonth);
	String exListPrintCal(String exListPrint);
	int exYearMonthListPrintCal(String YearMonth);
	
	int statisticsDay(int statisticsMonth, int statisticsYear); 
}


