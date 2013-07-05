/**
 * 
 */
package com.xuqin.zproblems;

import java.util.Stack;

/**
 * @author xuqin
 *
 * 
 */
public class ValidParentheses {
	 public boolean isValid(String s) {
	    Stack<Character> stack = new Stack<Character>();
	    for(char str : s.toCharArray()) {
	    	if(str=='(' || str=='[' || str=='{') {
	    		stack.push(str);
	    	} else if(str==')') {
	    		if(!stack.isEmpty() && stack.peek()=='(') {
	    			stack.pop();
	    		} else {
	    			return false;
	    		}
	    	}  else if(str==']') {
	    		if(!stack.isEmpty() && stack.peek()=='[') {
	    			stack.pop();
	    		} else {
	    			return false;
	    		}
	    	}  else if(str=='}') {
	    		if(!stack.isEmpty() && stack.peek()=='{') {
	    			stack.pop();
	    		} else {
	    			return false;
	    		}
	    	}
	    }
	    return stack.isEmpty();
	}
	 
	 
	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses();
		System.out.println(validParentheses.isValid("([]"));
	}
}
