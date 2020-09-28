package cashregister;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cashregister.billing.Bill;
import cashregister.billingExceptions.InvalidItemScanException;


/*
 * 
 * cd /projects/challenge && cd src/ && javac Register.java && if [[ $(java Register "apples" 30 "orange" 10 "mango" 20 | grep 99.0 | wc -l) -eq 1 ]];then echo "Test Case Passed" ;else echo "Test Case Failed"; fi

*/

public class Register
{

	private static Register register_inst = null;
	private static Map<String, Double> itemPrice = new HashMap<>();

	/* implement required methods */

	private Register()
	{
		itemPrice.put("Apple", new Double(2.0));
		itemPrice.put("Apples", new Double(2.0));
		itemPrice.put("Orange", new Double(1.5));
		itemPrice.put("Oranges", new Double(1.5));
		itemPrice.put("Mango", new Double(1.2));
		itemPrice.put("Mangoes", new Double(1.2));
		itemPrice.put("Grape", new Double(1.0));
		itemPrice.put("Grapes", new Double(1.0));

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Map<String, Integer> myItems = new HashMap<String, Integer>();
		String testargs="apples 30 orange 10 mngo 20";
		args = testargs.split(" ");

		for (int i = 0; i < args.length; i += 2)
		{
			myItems.put(args[i], Integer.parseInt(args[i + 1]));
		}

		/*
		 * create this Register instance and call the appropriate method print the
		 * total_bill from the bill class
		 */
		Register r = Register.getInstance();
		Bill b=new Bill();
		try
		{
			r.startCheckout(myItems,b);
			r.finishCheckout(b);
		}
		catch (InvalidItemScanException e)
		{
			System.err.println(e.getMessage());
		}

	}

	public void startCheckout(Map<String, Integer> myItems,Bill b) throws InvalidItemScanException
	{
		Iterator<Entry<String, Integer>> keys = myItems.entrySet().iterator();
		while (keys.hasNext())
		{
			Entry<String, Integer> item = keys.next();
			double priceForEach = scanItem(item.getKey());
			System.out.println("Item="+item.getKey()+" "+item.getValue()+" nos"+";Price for each="+priceForEach);
			double costToCustomer=priceForEach*item.getValue();
			b.addToBill(item.getKey(), costToCustomer);
		}
	}

	public void finishCheckout(Bill b)
	{
		
		System.out.println(b.getTotalBill());

	}

	public double scanItem(String scannedItem) throws InvalidItemScanException
	{
		double price = 0;
		System.out.println("Scanning "+scannedItem);

		Iterator<Entry<String, Double>> keys = itemPrice.entrySet().iterator();
		while (keys.hasNext())
		{
			Entry<String, Double> item = keys.next();
			if (item.getKey() != null && item.getKey().equalsIgnoreCase(scannedItem))
			{
				price = item.getValue();
				return price;
			}

		}
		throw new InvalidItemScanException(scannedItem+" not found in store");
	}


	public static Register getInstance()
	{
		if (register_inst == null)
		{
			register_inst = new Register();
		}
		return register_inst;
	}

}
