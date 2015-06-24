package service;

import java.util.Calendar;

import org.springframework.stereotype.Service;
@Service
public class CalService {
	int year;
	int month;
	int day;
	int lastDay;
	int calDay;
	int lastcalDay;
	public String inListPrintCal(String inListPrint) {
		if(inListPrint.equals("Week")){
			calDay = day - 6;
		}else if(inListPrint.equals("Month")){
			calDay = day - 29;
		}else {
			calDay = day - 89;
		}
		Calendar cal = Calendar.getInstance();
		day = cal.get(Calendar.DATE);
		if(calDay <= 0 && calDay > -30){
			month = cal.get(Calendar.MONTH);				
			year = cal.get(Calendar.YEAR);
			if(month == 0){
				year = year - 1;
				month = 12;
				lastDay = 31;
			}else{
				cal.set(Calendar.MONTH, month-1);
				lastDay = cal.getActualMaximum(Calendar.DATE);
			}
			lastcalDay = lastDay + calDay;			
		}else if(calDay <= -30){
			
		}else{
			year = cal.get(Calendar.YEAR);
			month = (cal.get(Calendar.MONTH)+1);				
			lastcalDay = calDay;
		}
		String inListPrintCal = year +"-"+ month +"-"+ lastcalDay;
		return inListPrintCal;
	}
}
