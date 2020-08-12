package structure.sparsearray.stack.calculate;

import structure.sparsearray.stack.ArrayStack;

public class Calculator {
	
	public static void main(String[] args) {
		
		String expression = "700+4*6/3-8-40";
		
		OperatorStack optrStack = new OperatorStack(10);
		ArrayStack numStack = new ArrayStack(11);
		
		System.out.println(cal1(expression, numStack, optrStack));
	}
	
	/**
	 * 支持多位数的四则运算，直接中缀式进行计算
	 * @param expression
	 * @param numStack
	 * @param optrStack
	 * @return
	 */
	public static int cal1(String expression, ArrayStack numStack, OperatorStack optrStack) {
		
		char chars[] = expression.toCharArray();
		
		for(int i = 0; i < chars.length; i++ ) {
			// 如果扫描到的字符是操作符
			if(optrStack.isOptr(chars[i])) {
				// 如果操作符栈空，直接进栈
				if(optrStack.isEmpty()) {
					optrStack.push(chars[i]);
				} else {
					
					// 与栈顶元素进行比较，如果优先级大于栈顶操作符，入栈
					if(optrStack.priority(chars[i]) > optrStack.priority((char)optrStack.peak()) ) {
						optrStack.push(chars[i]);
					} else {
						// 从栈顶弹出数字和操作符进行计算,一直计算到出现优先级小于它的操作符
						while(!optrStack.isEmpty() && optrStack.priority(chars[i]) <= optrStack.priority((char)optrStack.peak()) ) {							
							int num2 = numStack.pop();
							int num1 = numStack.pop();
							
							char opr = (char) optrStack.pop();
							numStack.push(optrStack.calculate(num1, num2, opr));
						}
						optrStack.push(chars[i]);
					}
				}
			} else {
				//数字 则直接入数栈
//				if(!numStack.isFull()) {					
//					numStack.push(chars[i] - '0'); // char - '0' || char - 48
//				}
				
				// 如果是数字，那么就循环向后扫描，一直扫完连续数字组成完整的数字
				if(!numStack.isFull()) {
					int start = i;
					while(i < chars.length - 1 && chars[i+1] >= '0' && chars[i] <= '9') {
						i++;
					}
					
					numStack.push(Integer.valueOf(String.valueOf(chars, start, i - start + 1)));
				}
				
				
				
				
				// 在处理数组时，需要向后继续匹配一直到不是数字（而且没有考虑小数的情况）
			}
		}
		
		while(!optrStack.isEmpty()) {
			char opr = (char) optrStack.pop();
			int num2 = numStack.pop();
			int num1 = numStack.pop();
			
			numStack.push(optrStack.calculate(num1, num2, opr));
		}
		
		int res = numStack.pop();
		
		//多位数处理的问题？
		return numStack.isEmpty() ? res : null;
	}

}
