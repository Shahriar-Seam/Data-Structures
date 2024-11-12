package postfixEvaluation;
import stack.LinkedStack;

public class PostfixEvaluation {

	// This works only for expression having single digits.
	public static double evaluatePostfix(String expression) {
		LinkedStack<Double> stack = new LinkedStack<Double>();
		final String operator = "+-*/";
		Double A, B, result = 0d;
		for(char c : expression.toCharArray()) {
			if(operator.indexOf(c) != -1) {
				A = stack.pop();
				B = stack.pop();
				if(c == '+') {
					result = B + A;
				}
				else if(c == '-') {
					result = B - A;
				}
				else if(c == '*') {
					result = B * A;
				}
				else if(c == '/') {
					result = B / A;
				}
				stack.push(result);
			}
			else {
				// stack.push(Double.parseDouble(c + ""));
				stack.push((double)(c - '0'));
			}
		}
		return stack.pop();
		
	}
	
	public static void main(String[] args) {
		String expression = "562+*24/-";
		System.out.println("Result: "+ evaluatePostfix(expression));
	}
}
