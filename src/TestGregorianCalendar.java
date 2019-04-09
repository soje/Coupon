import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestGregorianCalendar {
	public static void main(String[] args){
		
		GregorianCalendar calendar = new GregorianCalendar();
		
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH)+1;
		int year = calendar.get(Calendar.YEAR);
		
		String tmp = year + "-" + month + "-" + day;
        
		System.out.println(tmp);
		
	}
}
