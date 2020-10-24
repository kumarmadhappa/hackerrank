
import java.text.DecimalFormat;
import java.util.*;


public class ScoreList<T>  {
    
	 ArrayList<T> studentData=new ArrayList<>();
	    
	    
	    public void addElement(T e) {
	    	studentData.add(e);
	    	
	    }
	    public  void removeElement(T e) {
	    	studentData.remove(e);
	    	
	    }
	    public  T getElement(int i) {
	    	
	    	return studentData.get(i);
	    	
	    }
	    
	    public void populateStringData(String studentData)
		{
			String[] dataArray = studentData.split(" ");

			for (int i = 0; i < dataArray.length; i++)
			{
				this.addElement((T) dataArray[i]);
			}

		}

		public void populateIntegerData(String studentData)
		{
			String[] dataArray = studentData.split(" ");
			for (int i = 0; i < dataArray.length; i++)
			{

				this.addElement((T) Integer.valueOf(dataArray[i]));

			}

		}
		
		public void populateDoubleData(String studentData)
		{
			String[] dataArray = studentData.split(" ");
			for (int i = 0; i < dataArray.length; i++)
			{

				this.addElement((T) Double.valueOf(dataArray[i]));

			}

		}
	
	public String averageValues(String query){
		
		double avg=0;
		for (int i=0;i<studentData.size();i++) {
			if(query.equals("4")) {
				avg=avg+(Integer)studentData.get(i);
			}
			else {
				avg=avg+(Double)studentData.get(i);
			}
		
		}
		avg=avg/studentData.size();
		DecimalFormat df = new DecimalFormat("#.##");
		
		String value = String.format("%.2f", avg);
		
		//return df.format(avg);
		return value;
	}
	
}