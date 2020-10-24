

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeTesting {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		try
		{
			Date d1= sdf.parse("12:44:00");
			System.out.println(d1.getTime());
			Date d2 = sdf.parse("01:44:00");
			System.out.println(d2.getTime());
			
			System.out.println((d2.getTime()-d1.getTime())/(1000*60));
			Date d = new Date();
			System.out.println(d.getTime());
			//Thread.sleep(2000);
			d = new Date();
			SimpleDateFormat sdf2= new SimpleDateFormat("yyyyMMdd-HH:mm:ss.SSS");
			sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
			System.out.println(d);
			System.out.println("GMT TIME-"+sdf2.format(d));
			System.out.println(d.getTime());
			//Thread.sleep(5000);
			System.out.println(new Date(d.getTime()));
			int num;
			if ((num=2)!=2){
				System.out.println("if Num="+num);
			}
			else
				System.out.println("else Num="+num);
			
			
			
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
