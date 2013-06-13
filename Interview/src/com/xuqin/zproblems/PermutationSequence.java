/**
 * 
 */
package com.xuqin.zproblems;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author xuqin
 * 
 * 
 */
public class PermutationSequence {

	public static int fact(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * fact(n - 1);
	}

	public static String getPermutation2(int n, int k) {

		String res = ""; // result
		int fact = fact(n); // n!
		int no = n;

		boolean[] used = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			used[i] = false;
		}

		while (res.length() < no) { // not finished
			fact /= n; // (n-1)!
			int j = 0;
			while (k > 0) {
				if (j != 0 && !used[j])
					k -= fact;
				j++;
			}
			used[j - 1] = true;
			k += fact;
			res += j - 1;
			n--;
		}
		return res;
	}

	public static String getPermutation3(int n, int k) {
		int nums[] = new int[n];
		int permCount = 1;
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
			permCount *= (i + 1);
		}
		// change K from (1,n) to (0, n-1) to accord to index
		k--;
		StringBuffer targetNum = new StringBuffer();
		for (int i = 0; i < n; i++) {
			permCount = permCount / (n - i);
			int choosed = k / permCount;
			targetNum.append(nums[choosed] + '0');
			for (int j = choosed; j < n - i; j++) {
				nums[j] = nums[j + 1];
			}
			k = k % permCount;
		}
		return targetNum.toString();
	}

	public String getPermutation(int n, int k) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= n; ++i) {
			sb.append(i);
		}
		List<String> results = getPermutation(sb.toString());
		return results.get(k - 1);
	}

	public static List<String> getPermutation(String str) {
		List<String> results = new ArrayList<String>();
		if (str.length() == 1) {
			results.add(str);
			return results;
		}
		for (int i = 0; i < str.length(); ++i) {
			String start = str.substring(i, i + 1);
			List<String> partList = getPermutation(str.substring(0, i)
					+ str.substring(i + 1));
			for (int j = 0; j < partList.size(); ++j) {
				partList.set(j, start + partList.get(j));
			}
			results.addAll(partList);
		}
		return results;
	}

	public static void main(String[] args) {
//		List<String> results = PermutationSequence.getPermutation("12345");
//		System.out.println("Size : " + results.size());
//		for (String result : results) {
//			System.out.println(result);
//		}
		
		System.out.println(getPermutation3(1,1));
	}

}
