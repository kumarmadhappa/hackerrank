package com.kumar.solutions;

import java.util.Arrays;

public class ClimbingTheLeaderBoard
{

	static int[] climbingLeaderboard(int[] scores, int[] alice)
	{
		int[] rank = new int[scores.length];
		int[] aliceRanks = new int[alice.length];
		for (int i = 0; i < scores.length; i++)
		{
			if (i == 0)
			{
				rank[i] = 1;
			}
			else
			{
				if (scores[i] < scores[i - 1])
				{
					rank[i] = rank[i - 1] + 1;
				}
				else if (scores[i] == scores[i - 1])
				{
					rank[i] = rank[i - 1];
				}
			}
		}
		System.out.println("Ranks Array " + Arrays.toString(rank));
		int viewedScore = scores.length - 1;
		for (int a = 0; a < alice.length; a++)
		{
			int points = alice[a];
			for (int i = viewedScore; i >= 0; i--)
			{
				viewedScore = i;
				if (i == scores.length - 1)
				{
					if (points < scores[i])
					{
						aliceRanks[a] = rank[i] + 1;
						break;
					}
					else if (points == scores[i])
					{
						aliceRanks[a] = rank[i];
						break;
					}
				}
				else if (points < scores[i] && points > scores[i + 1])
				{
					aliceRanks[a] = rank[i] + 1;
					break;
				}
				else if (points == scores[i])
				{
					aliceRanks[a] = rank[i];
					break;
				}
				else if (i == 0 && points >= scores[0])
				{
					aliceRanks[a] = rank[0];
					break;
				}
			}
		}
		return aliceRanks;
	}

	public static void main(String[] args)
	{
		int[] scores = { 47, 46, 46, 38, 30, 30, 30, 28, 25, 22, 15, 14, 12, 6, 4 };
		int[] alice = { 5, 5, 6, 14, 19, 20, 23, 38, 38, 38, 41, 41, 44 };
		int[] result = climbingLeaderboard(scores, alice);
		for (int i = 0; i < result.length; i++)
		{
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");
	}

}
