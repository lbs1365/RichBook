package model;

import java.util.List;

public class StatisticsDay {
	private int statisticsDayList;
	private long statisticsInDaySum;
	private long statisticsExDaySum;
	private long statisticsTotalDaySum;
	private List<StatisticsList> statisticsList;
	
	public int getStatisticsDayList() {
		return statisticsDayList;
	}
	public void setStatisticsDayList(int statisticsDayList) {
		this.statisticsDayList = statisticsDayList;
	}
	public long getStatisticsInDaySum() {
		return statisticsInDaySum;
	}
	public void setStatisticsInDaySum(long statisticsInDaySum) {
		this.statisticsInDaySum = statisticsInDaySum;
	}
	public long getStatisticsExDaySum() {
		return statisticsExDaySum;
	}
	public void setStatisticsExDaySum(long statisticsExDaySum) {
		this.statisticsExDaySum = statisticsExDaySum;
	}
	public long getStatisticsTotalDaySum() {
		return statisticsTotalDaySum;
	}
	public void setStatisticsTotalDaySum(long statisticsTotalDaySum) {
		this.statisticsTotalDaySum = statisticsTotalDaySum;
	}
	public List<StatisticsList> getStatisticsList() {
		return statisticsList;
	}
	public void setStatisticsList(List<StatisticsList> statisticsList) {
		this.statisticsList = statisticsList;
	}
}
