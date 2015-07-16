package model;

import java.util.List;

public class Statistics {
	private int memNo;
	
	private int statisticsYear;
	private String statisticsMonth;
	private int statisticsMonthList;
	private int statisticsDay;
	
	private long statisticsInYearSum;
	private long statisticsExYearSum;
	private long statisticsTotalYearSum;
	
	private int imtNo;	
	private long inSum;
	private String inCon;
	private String inEtc;
	
	private int emtNo;	
	private long exSum;
	private String exCon;
	private String exEtc;
		
	private List<StatisticsMonth> statisticsMonthPrint;
	
	private String statsListMonth;

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
	
	public int getStatisticsMonthList() {
		return statisticsMonthList;
	}

	public void setStatisticsMonthList(int statisticsMonthList) {
		this.statisticsMonthList = statisticsMonthList;
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

	public int getImtNo() {
		return imtNo;
	}

	public void setImtNo(int imtNo) {
		this.imtNo = imtNo;
	}

	public long getInSum() {
		return inSum;
	}

	public void setInSum(long inSum) {
		this.inSum = inSum;
	}

	public String getInCon() {
		return inCon;
	}

	public void setInCon(String inCon) {
		this.inCon = inCon;
	}

	public String getInEtc() {
		return inEtc;
	}

	public void setInEtc(String inEtc) {
		this.inEtc = inEtc;
	}

	public int getEmtNo() {
		return emtNo;
	}

	public void setEmtNo(int emtNo) {
		this.emtNo = emtNo;
	}

	public long getExSum() {
		return exSum;
	}

	public void setExSum(long exSum) {
		this.exSum = exSum;
	}

	public String getExCon() {
		return exCon;
	}

	public void setExCon(String exCon) {
		this.exCon = exCon;
	}

	public String getExEtc() {
		return exEtc;
	}

	public void setExEtc(String exEtc) {
		this.exEtc = exEtc;
	}

	public String getStatsListMonth() {
		return statsListMonth;
	}

	public void setStatsListMonth(String statsListMonth) {
		this.statsListMonth = statsListMonth;
	}
	
}