package model;

import java.util.List;

public class StatisticsMonth {
	
	private int statisticsMonthList;
	private long statisticsInMonthSum;
	private long statisticsExMonthSum;
	private long statisticsTotalMonthSum;
	private List<StatisticsDay> statisticsDayPrint;
	private int dayStart;
	private int dayEnd;
	private int dayIndex;
	
	public int getStatisticsMonthList() {
		return statisticsMonthList;
	}
	public void setStatisticsMonthList(int statisticsMonthList) {
		this.statisticsMonthList = statisticsMonthList;
	}
	public long getStatisticsInMonthSum() {
		return statisticsInMonthSum;
	}
	public void setStatisticsInMonthSum(long statisticsInMonthSum) {
		this.statisticsInMonthSum = statisticsInMonthSum;
	}
	public long getStatisticsExMonthSum() {
		return statisticsExMonthSum;
	}
	public void setStatisticsExMonthSum(long statisticsExMonthSum) {
		this.statisticsExMonthSum = statisticsExMonthSum;
	}
	public long getStatisticsTotalMonthSum() {
		return statisticsTotalMonthSum;
	}
	public void setStatisticsTotalMonthSum(long statisticsTotalMonthSum) {
		this.statisticsTotalMonthSum = statisticsTotalMonthSum;
	}
	public List<StatisticsDay> getStatisticsDayPrint() {
		return statisticsDayPrint;
	}
	public void setStatisticsDayPrint(List<StatisticsDay> statisticsDayPrint) {
		this.statisticsDayPrint = statisticsDayPrint;
	}
	public int getDayStart() {
		return dayStart;
	}
	public void setDayStart(int dayStart) {
		this.dayStart = dayStart;
	}
	public int getDayEnd() {
		return dayEnd;
	}
	public void setDayEnd(int dayEnd) {
		this.dayEnd = dayEnd;
	}
	public int getDayIndex() {
		return dayIndex;
	}
	public void setDayIndex(int dayIndex) {
		this.dayIndex = dayIndex;
	}
	
}
