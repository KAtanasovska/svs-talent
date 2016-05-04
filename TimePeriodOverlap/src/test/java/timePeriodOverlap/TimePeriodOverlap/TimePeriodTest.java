package timePeriodOverlap.TimePeriodOverlap;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

public class TimePeriodTest {
	
	
	
	@Test 
	public void equalTimePeriods(){
	LocalTime startA = LocalTime.of(8,8);
	LocalTime endA = LocalTime.of(9,9);
	TimePeriod timePeriod = new TimePeriod(startA, endA);
	TimePeriod timePeriodTest = new TimePeriod(startA, endA);
	
	Assert.assertEquals(true, timePeriod.overlapsWith(timePeriodTest));
	
	

}
	@Test 
	public void firstEndsSecondStarts(){
		LocalTime startA = LocalTime.of(8,8);
		LocalTime endA = LocalTime.of(9,9);
		TimePeriod timePeriod = new TimePeriod(startA, endA);
		TimePeriod timePeriodTest = new TimePeriod(endA, LocalTime.of(10,10));
		Assert.assertEquals(false, timePeriod.overlapsWith(timePeriodTest));
		
	}
	@Test
	public void secondEndsFirstStarts(){
		LocalTime startA = LocalTime.of(8,8);
		LocalTime endA = LocalTime.of(9,9);
		TimePeriod timePeriod = new TimePeriod(startA, endA);
		TimePeriod timePeriodTest = new TimePeriod(LocalTime.of(7,7), startA);
		Assert.assertEquals(false, timePeriod.overlapsWith(timePeriodTest));
		
	}
	
	@Test
	public void secondStartsBeforeFirstEnds(){
		LocalTime startA = LocalTime.of(8,8);
		LocalTime endA = LocalTime.of(10,10);
		TimePeriod timePeriod = new TimePeriod(startA, endA);
		TimePeriod timePeriodTest = new TimePeriod(LocalTime.of(9,9), LocalTime.of(11,11));
		Assert.assertEquals(true, timePeriod.overlapsWith(timePeriodTest));
	
	}
	
	@Test(expected = WrongParametarException.class )
	public void startDateLaterThenEndDateOfFirstPeriod(){
		LocalTime startA = LocalTime.of(8,8);
		LocalTime endA = LocalTime.of(10,10);
		TimePeriod timePeriod = new TimePeriod(endA, startA);
		TimePeriod timePeriodTest = new TimePeriod(LocalTime.of(9,9), LocalTime.of(11,11));
		
		
	}
	@Test(expected = WrongParametarException.class )
	public void startDateLaterThenEndDateOfSecondPeriod(){
		LocalTime startA = LocalTime.of(8,8);
		LocalTime endA = LocalTime.of(10,10);
		TimePeriod timePeriod = new TimePeriod(startA, endA);
		TimePeriod timePeriodTest = new TimePeriod(LocalTime.of(11,11), LocalTime.of(9,9));
		
		
	}

}