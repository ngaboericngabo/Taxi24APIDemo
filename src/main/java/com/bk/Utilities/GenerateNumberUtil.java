package com.bk.Utilities;

import java.util.Random;

/**
 * @author Eric
 *
 */
public class GenerateNumberUtil {

	public static long getBillNumber() {

		Random rn = new Random();
		int range = 100 - 10 + 1;
		int randomNum = rn.nextInt(range) + 1000;
		long val = randomNum;

		return val;
	}

	public static long getPrice() {

		Random rn = new Random();
		int range = 10000 - 1000 + 1;
		int randomNum = rn.nextInt(range) + 1000;
		long val = randomNum;

		return val;

	}
}
