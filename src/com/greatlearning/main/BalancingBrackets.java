package com.greatlearning.main;

import java.util.Stack;

public class BalancingBrackets {
	private static boolean isBalanced( String bracketExpression ) {
		Stack stack = new Stack();
		
		// iterate i : 0 -> end of string
		for( int i = 0; i < bracketExpression.length(); i++ ) {
			// c = String character at i - use charAt( i )
			Character c = bracketExpression.charAt( i );
			
			// check if the c if one of the opening brackets
			if( c == '{' || c == '[' || c == '(' ) {
				// push to the stack
				stack.push( c );
			} else { // else it is a closing bracket
				// if stack is empty (no corresponding opening bracket) -> not balanced
				if( stack.isEmpty() ) {
					return false;
				}
		
				// d = stack.pop()
				Character d = (Character) stack.pop();
						
				// Compare c and d, if match proceed, if not declare it is not balanced
				if( c == '}' && d != '{' || c == ']' && d != '[' || c == ')' && d != '(' ) {
					return false;
				}
			}
		}
		
		// check if stack is empty -> if yes then balanced, else not balanced
		return stack.isEmpty();
	}
	
	public static void main( String[] args ) {
		String bracketExpression = "([[{}]])";
		
		if( isBalanced( bracketExpression ) ) {
			System.out.println( "Balanced" );
		} else {
			System.out.println( "Not Balanced" );
		}
	}
}
