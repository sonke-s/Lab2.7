//import java.util.Stack;
import java.util.Scanner;

public class Postfix {

	//this will only work with single digit numbers
	
	public StackAsList stack = new StackAsList();
	//public Stack<Double> stack = new Stack();
	public double rhs;
	public double lhs;
	public char operator;
	
	public static void main(String[] args) throws StringNotWellFormedException {
		
		Postfix post = new Postfix();
		String done = post.infixToPostfix("(1+2)*3+(4^(5-6))");
		System.out.println(done);
		
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			String input = scan.nextLine();
			post.calculateRPN(input);
		}
		
		
	}
	
	public double evaluate (String pfx) {
		double result = 0;
		for(int i = 0; i < pfx.length(); i++) {
			char c = pfx.charAt(i);
			if(Character.isDigit(c)) {
				double number = Character.getNumericValue(c);
				stack.push(number);
			} else {
				rhs = (double) stack.pop();		// cast to double
				lhs = (double) stack.pop();
				if(c == '+') {
					result = lhs + rhs;
					stack.push(result);
				}
				else if(c == '-') {
					result = lhs - rhs;
					stack.push(result);
				}
				else if(c == '*') {
					result = lhs * rhs;
					stack.push(result);
				}
				else if(c == '/') {
					result = lhs / rhs;
					stack.push(result);
				}
				else if(c == '^') {
					result = Math.pow(lhs, rhs);
					stack.push(result);
				}
			}
		}
		return (double) stack.pop();			//cast to double
	}
	
	public char topToChar() {
		String s = "" + stack.peek();
		char c = s.charAt(0);
		return c;
	}
	
	public boolean stringContains(String s) {
		if(s.contains(" ") ||
		   s.contains(":") ||
		   s.contains(",") ||
		   s.contains(".") ||
		   s.contains(";") ||
		   s.contains("=")) {
			return false;
		} else {
			return true;
		}
	}
	
	public void calculateRPN(String s) throws StringNotWellFormedException {
		String r = infixToPostfix(s);
		double d = evaluate(r);
		System.out.println(d);
	}
	
	public String infixToPostfix (String ifx) throws StringNotWellFormedException {
		if(stringContains(ifx)) {
		String r = "";
		for(int i = 0; i < ifx.length(); i++) {
			char c = ifx.charAt(i);
			if(Character.isDigit(c)) {
				r = r + c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while(topToChar() != '(') {
					r = r + stack.peek();
					stack.pop();
				}
				stack.pop();
			} else {
				while(checkPrecedence(c, topToChar())) {  
					r = r + stack.peek();	 
					stack.pop();
				}
				stack.push(c);
			}
		}
		while(!(stack.isEmpty())) {
			r = r + stack.pop();
		}
		return r;
		} else {
			throw new StringNotWellFormedException ("Your String is not well formed!");
		}
	}
	
	public boolean checkPrecedence(char s, char d) { 
		boolean prec = false;
		switch(d) {
			case '+':
				if(s == '-' || s == '+') {
					prec = true;
				} else {
					prec = false;
				}
				break;
			case '-':
				if(s == '-' || s == '+') {
					prec = true;
				} else {
					prec = false;
				}
				break;
			case '*':
				if(s == '*' || 
					s == '/' || 
					s == '+' || 
					s == '-') {
					prec = true;
				} else {
					prec = false;
				}
				break;
			case '/':
				if(s== '/' || 
					s == '*' || 
					s == '+' || 
					s == '-' ) {
					prec = true;
				} else {
					prec = false;
				}
				break;
			case '^':
				if(s == '^' || 
					s == '/' ||
					s == '*' || 
					s == '+' || 
					s == '-' ) {
					prec = true;
			} else {
					prec = false;
			}
				break;
		}
		return prec;
	}
}
