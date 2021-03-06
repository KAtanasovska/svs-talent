package timePeriodOverlap.TimePeriodOverlap;

import java.time.LocalTime;

public class TimePeriod {
	
	private LocalTime startDate;
	private LocalTime endDate;

	public TimePeriod(LocalTime startDate, LocalTime endDate){
		this.startDate = startDate;
		this.endDate = endDate;
		
	}
	public boolean overlapsWith(TimePeriod timePeriod){
		if((startDate.isBefore(timePeriod.endDate))&(endDate.isAfter(timePeriod.startDate))){
			return true;
		}
			return false;
	}
	
}
