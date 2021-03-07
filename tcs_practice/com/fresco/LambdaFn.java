package com.fresco;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaFn {

	public List<Long> functionalProgtamming(List<String> listOfIntegers)
	{
		List<Long> outputList = listOfIntegers.stream().map(s -> Long.parseLong(s)).filter(n -> check(n))
				.collect(Collectors.toList());
		return outputList;
	}

	private boolean check(Long n)
	{

		// 2025 = 4/2 =2 right =25, left =20
		// 12345 = 5/2 =2 , right = 345, left = 12

		// char[] digits = Integer.toString(n).toCharArray();

		boolean flag;

		long square = n * n;
		String num = Long.toString(square);
		String rightString = num.substring(num.length() / 2);
		rightString = (rightString != null && !rightString.isEmpty()) ? rightString : "0";
		String leftString = num.substring(0, (num.length() / 2));
		leftString = (leftString != null && !leftString.isEmpty()) ? leftString : "0";
		long sum = Long.parseLong(rightString) + Long.parseLong(leftString);
		flag = (sum == n) ? true : false;
		return flag;
	}

	public static void main(String[] args)
	{
		LambdaFn fn = new LambdaFn();
		List<String> listOfNumbers = new ArrayList<String>();
		listOfNumbers.add("45");
		listOfNumbers.add("50");
		listOfNumbers.add("99");
		long a, b;
		a = 1;
		b = 100;
		List<String> listOfIntegers = new ArrayList<>();
		for (long i = a; i <= b; i++)
		{
			listOfIntegers.add(i + "");
		}
		System.out.println(Arrays.toString(fn.functionalProgtamming(listOfIntegers).toArray()));
	}

}