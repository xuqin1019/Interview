/**
 * 
 */
package com.xuqin.zproblems;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author xuqin
 *
 * 
 */
public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if(triangle.size()==1) {
			return triangle.get(0).get(0);
		}
		
		int [][] minPath = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
		minPath[0][0] = triangle.get(0).get(0);
		for(int i=1;i<triangle.size();++i) {
			for(int j=0;j<triangle.get(i).size();++j) {
				if(j==0) {
					minPath[i][j] = minPath[i-1][j]+triangle.get(i).get(j);
				} else if(j==triangle.get(i).size()-1) {
					minPath[i][j] = minPath[i-1][j-1]+triangle.get(i).get(j);
				} else {
					minPath[i][j] = Math.min(minPath[i-1][j], minPath[i-1][j-1]) + triangle.get(i).get(j);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<minPath[minPath.length-1].length;++i) {
			if(minPath[minPath.length-1][i]<min) {
				min = minPath[minPath.length-1][i];
			}
		}
		return min;
	}
	
	
	public int minimumTotalSpaceN(ArrayList<ArrayList<Integer>> triangle) {  //use roll array
		if(triangle.size()==1) {
			return triangle.get(0).get(0);
		}
		
		int [] preMinPath = new int[triangle.get(triangle.size()-1).size()];
		int [] minPath = new int[triangle.get(triangle.size()-1).size()];
		preMinPath[0] = triangle.get(0).get(0);
		for(int i=1;i<triangle.size();++i) {
			for(int j=0;j<triangle.get(i).size();++j) {
				if(j==0) {
					minPath[j] = preMinPath[j]+triangle.get(i).get(j);
				} else if(j==triangle.get(i).size()-1) {
					minPath[j] = preMinPath[j-1]+triangle.get(i).get(j);
				} else {
					minPath[j] = Math.min(preMinPath[j], preMinPath[j-1]) + triangle.get(i).get(j);
				}
			}
			System.arraycopy(minPath, 0, preMinPath, 0, minPath.length);
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<minPath.length;++i) {
			if(minPath[i]<min) {
				min = minPath[i];
			}
		}
		return min;
	}
	
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(2));
		ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(3,4));
		ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(6,5,7));
		ArrayList<Integer> list4 = new ArrayList<Integer>(Arrays.asList(4,1,8,3));
		data.add(list1);
		data.add(list2);
		data.add(list3);
		data.add(list4);
		Triangle triangle = new Triangle();
		System.out.println(triangle.minimumTotalSpaceN(data));
	}
}
