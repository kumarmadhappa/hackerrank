
import java.util.ArrayList;

public class StudentList<T> {

	ArrayList<T> studentData = new ArrayList<>();

	public void addElement(T e)
	{
		studentData.add(e);

	}

	public void removeElement(T e)
	{
		studentData.remove(e);

	}

	public T getElement(int i)
	{

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

	public String beginsWith(String query)
	{
		StringBuilder output =		new StringBuilder();
		String[] queryData=query.split(",");
		
		for (T ele:studentData) {
			if(queryData[1].equalsIgnoreCase(((String)ele).substring(0, 1)))
			{
				output.append(ele);
				output.append("\n");
			}
		}
		
		return output.toString();

	}

	public String bloodGroupOf(String query)
	{
		StringBuilder output =		new StringBuilder();
		String[] queryData=query.split(",");
		String[] bloodGroup=queryData[1].split(" ");
		String checkValue=queryData[2];
		
		for (int i=0;i<bloodGroup.length;i++) {
			
	
			if(checkValue.equalsIgnoreCase(bloodGroup[i]))
			{
				
				output.append(studentData.get(i));
				output.append("\n");
			}
		
		}
		
		return output.toString();

	

	}

	public String thresholdScore(String query)
	{
		StringBuilder output =		new StringBuilder();
		String[] queryData=query.split(",");
		int thresholdScore=Integer.parseInt(queryData[1]);
		int count=0;
		for (T ele:studentData) {
			if(Integer.parseInt((String) ele) >= thresholdScore)
			{
				count++;
			}
		}
		return count+" students scored "+thresholdScore+" above";

	}

}
