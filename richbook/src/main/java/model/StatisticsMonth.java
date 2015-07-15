package model;

import java.util.List;

public class StatisticsMonth {
	
	private int statisticsMonthList;
	private long statisticsInMonthSum;
	private long statisticsExMonthSum;
	private long statisticsTotalMonthSum;
	private List<StatisticsDay> statisticsDayPrint;
	
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
}
