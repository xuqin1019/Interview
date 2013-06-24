package com.xuqin.zproblems;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		StringBuffer pathStr = new StringBuffer(path);
		if(pathStr.toString().startsWith("/")) {
			pathStr.deleteCharAt(0);
		}
		if(pathStr.toString().endsWith("/")) {
			pathStr.deleteCharAt(pathStr.length()-1);
		}
		
		Stack<String> stack = new Stack<String>();
		
		String [] parts = pathStr.toString().split("/");
		for(String part : parts) {
			if(!part.equals("") && !part.equals(".")) {
				if(part.equals("..")) {
					if(!stack.isEmpty()) {
						stack.pop();
					} 
				} else {
					stack.push(part);
				}
			}
		}
		
		StringBuffer result = new StringBuffer();
		
		while(!stack.isEmpty()) {
			result.insert(0, "/" + stack.pop());
		}
		
		if(result.toString().equals("")) {
			return "/";
		}
		
		return result.toString();
		
    }
	
	public static void main(String[] args) {
		SimplifyPath simplifyPath = new SimplifyPath();
		System.out.println(simplifyPath.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
	}
}
