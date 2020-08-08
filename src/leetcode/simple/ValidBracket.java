package leetcode.simple;

import java.util.Stack;

public class ValidBracket {
	
	// 按照符号栈的计算方式进行消除，最后判断符号栈是否为空
	public boolean isValid(String s) {
        if(s == null || s.equals("")) {
        	return true;
        }
        
        Stack<String> stack = new Stack<String>();
        char[] bks = s.toCharArray();
        for(int i = 0; i < bks.length; i++) {
        	if(!bkDir(bks[i]+"", stack)) {
        		return false;
        	}
        }
		
		return stack.isEmpty();
    }
	
	public boolean bkDir(String s, Stack<String> stack) {
		switch (s) {
		case "(":
			stack.push(s);
			break;
		case "[":
			stack.push(s);
			break;
		case "{":
			stack.push(s);	
			break;
		case ")":
			if(!stack.isEmpty() && stack.lastElement().equals("(")) {
				stack.pop();
			}else {
				return false;
			}
			
			break;
		case "]":
			if(!stack.isEmpty() && stack.lastElement().equals("[")) {
				stack.pop();
			}else {
				return false;
			}
			break;	
		case "}":
			if(!stack.isEmpty() && stack.lastElement().equals("{")) {
				stack.pop();
			}else {
				return false;
			}
			break;
		default:
			break;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String s = "{[]}";
		ValidBracket test = new ValidBracket();
		test.isValid(s);
		System.out.println(test.isValid(s));
		
	}

}
