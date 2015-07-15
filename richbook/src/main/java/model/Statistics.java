package model;

import java.util.List;

public class Statistics {
	private int memNo;
	
	private int statisticsYear;
	private String statisticsMonth;
	private int statisticsDay;
	
	private long statisticsInYearSum;
	private long statisticsExYearSum;
	private long statisticsTotalYearSum;
	
	private List<String> statisticsMonthPrint;
	private List<Long> statisticsMonthSum;
		
	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getStatisticsYear() {
		return statisticsYear;
	}

	public void setStatisticsYear(int statisticsYear) {
		this.statisticsYear = statisticsYear;
	}

	public String getStatisticsMonth() {
		return statisticsMonth;
	}

	public void setStatisticsMonth(String statisticsMonth) {
		this.statisticsMonth = statisticsMonth;
	}

	public int getStatisticsDay() {
		return statisticsDay;
	}

	public void setStatisticsDay(int statisticsDay) {
		this.statisticsDay = statisticsDay;
	}

	public long getStatisticsInYearSum() {
		return statisticsInYearSum;
	}

	public void setStatisticsInYearSum(long statisticsInYearSum) {
		this.statisticsInYearSum = statisticsInYearSum;
	}

	public long getStatisticsExYearSum() {
		return statisticsExYearSum;
	}

	public void setStatisticsExYearSum(long statisticsExYearSum) {
		this.statisticsExYearSum = statisticsExYearSum;
	}

	public long getStatisticsTotalYearSum() {
		return statisticsTotalYearSum;
	}

	public void setStatisticsTotalYearSum(long statisticsTotalYearSum) {
		this.statisticsTotalYearSum = statisticsTotalYearSum;
	}

	public List<String> getStatisticsMonthPrint() {
		return statisticsMonthPrint;
	}

	public void setStatisticsMonthPrint(List<String> statisticsMonthPrint) {
		this.statisticsMonthPrint = statisticsMonthPrint;
	}

	public List<Long> getStatisticsMonthSum() {
		return statisticsMonthSum;
	}

	public void setStatisticsMonthSum(List<Long> statisticsMonthSum) {
		this.statisticsMonthSum = statisticsMonthSum;
	}
	
	
}