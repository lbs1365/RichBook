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
	
	private List<StatisticsMonth> statisticsMonthPrint;

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

	public List<StatisticsMonth> getStatisticsMonthPrint() {
		return statisticsMonthPrint;
	}

	public void setStatisticsMonthPrint(List<StatisticsMonth> statisticsMonthPrint) {
		this.statisticsMonthPrint = statisticsMonthPrint;
	}	
}