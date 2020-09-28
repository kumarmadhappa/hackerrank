package cashregister.billing;

import java.util.ArrayList;
import java.util.List;

public class Bill
{
	public double billAmt;
	List<String> itemsBought = new ArrayList<String>();
	List<Double> costForItems = new ArrayList<Double>();

	public double getTotalBill()
	{
		System.out.println(itemsBought);
		System.out.println(costForItems);
		billAmt = 0;
		for (Double cost : costForItems)
		{
			billAmt += cost;
		}

		return billAmt;
	}

	public void addToBill(String item, double price)
	{
		System.out.println("Adding - " + item + " " + price);
		itemsBought.add(item);
		costForItems.add(price);
	}

}
