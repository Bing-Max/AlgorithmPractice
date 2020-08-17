package structure.stack.calculate;

import java.util.ArrayList;
import java.util.List;

public class PolandNotation {
	public static void main(String[] args) {
		
		// ( 3 + 4 ) * 5 - 6 => 3 4 + 5 * 6 -
//		String expression = "3 4 + 5 * 6 -";
		// 22 + 3 * ( 6 + 2 ) - 5 / 5 => 22 3 6 2 + * + 5 5 / -
//		String expression = " 22 3 6 2 + * + 5 5 / - ";
		String expression = " 22 + 3 * ( 6 + 2 ) - 5 / 5 ";
		System.out.println(getExpList(expression));
		System.out.println(convertToPoland(getExpList(expression)));
		System.out.println(cal(convertToPoland(getExpList(expression))));
	}
	
	public static List<String> getExpList(String expression){
		List<String> list = new ArrayList<String>();
		// 表达式有要求，要求数字与运算符之间需要空格隔开
		//trim() remove leading and tailing whitespace;
		String strs[] = expression.trim().split(" ");
		for(String s: strs) {
			list.add(s);
		}
		
		return list;
	}
	
	public static int cal(List<String> list) {
		
		OperatorStack stack = new OperatorStack(list.size());
		// 要求不能出现未定义的操作符和符号
		for(String s : list) {
			if(stack.isOptr(s.charAt(0))) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				
				char opr = s.charAt(0);
				stack.push(stack.calculate(num1, num2, opr));
			}else {
				stack.push(Integer.valueOf(s));
			}
		}
		
		int res = stack.pop();
		
		if(! stack.isEmpty()) {
			throw new RuntimeException("invalid expression!");
		}
		return res;
	}
	
	public static List<String> convertToPoland(List<String> list){
		// 模拟第二个栈，因为栈最后需要逆序，所以直接添加到list即可
		List<String> poland = new ArrayList<String>();

		OperatorStack oprs = new OperatorStack(list.size());
		
		for(String s : list) {
			if(s == null || s.equals("")) {
				continue;
			}
			char val = s.charAt(0);
			// 如果是符号则直接入栈
			if(val == '(') {
				oprs.push(val);
			} else if(val == ')') {
				try {
					while(oprs.peak() != '(') {
						poland.add(""+(char)oprs.pop());
					}
					
					// 遇到左括号，弹出，开始处理 右括号后的下一元素
					oprs.pop();
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("mismatching ()...");
				}
			} else if(oprs.isOptr(val)) {
				// 如果是运算符
				// 运算符栈其实就是就是按照ascii码进行存储
				if(oprs.isEmpty() || oprs.peak() == '(') {
					oprs.push(val);
				} else if(oprs.priority(val) > oprs.priority((char) oprs.peak())) {
					// 如果栈顶的运算符优先级低，那么运算符直接入栈
					oprs.push(val);
				} else if(oprs.priority(val) <= oprs.priority((char) oprs.peak())) {
					//如果栈顶的运算符优先级高或者相等，那么栈顶运算符直接加入到最后 表达式 循环过程直到遇到栈顶 ( 或者 栈空 或者 栈顶较小优先级的操作符，
					while(!oprs.isEmpty() && oprs.peak() != '(' && oprs.priority(val) <= oprs.priority((char) oprs.peak())) {
						poland.add(""+(char)oprs.pop());
					}
					
					// 最后将符号入栈，非常容易忘记!!!
					oprs.push(val);
				} 
			} else {
				//如果是数字
				//直接加入到poland中
				poland.add(s);
			}
		}
		
		// 最后，把符号栈中的元素都弹出到结果中
		while(!oprs.isEmpty()) {
			poland.add(""+(char)oprs.pop());
		}
		
		return poland;
	}

}
