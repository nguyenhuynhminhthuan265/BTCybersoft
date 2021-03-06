package com.cybersoft.stack;

public class KeyLogger {
	public static void main(String[] args) {
		String keyLogger1 = "generio1<3>2ghj---";
		String keyLogger2 = "ThisIsS3Cr3t";
		String keyLogger3 = "<<BP<A>>Cd-";
		char[] charKeyLogger = keyLogger3.toCharArray();

		MyStack<Character> stackBuffer = new MyStack<Character>();
		MyStack<Character> stackOutput = new MyStack<Character>();
		for (char c : charKeyLogger) {
			switch (c) {
			case '-':
				if (!stackOutput.isEmpty()) {
					stackOutput.pop();
				}
				break;

			case '<':
				if (!stackOutput.isEmpty()) {
					stackBuffer.push(stackOutput.pop());

				}
				break;

			case '>':
				if (!stackBuffer.isEmpty()) {
					stackOutput.push(stackBuffer.pop());
				}
				break;

			default:
				stackOutput.push(c);
				break;
			}
		}
		System.out.println(convertStackCharToString(stackOutput));
	}

	public static String convertStackCharToString(MyStack<Character> stack) {
		MyStack<String> reverseStack = new MyStack<String>();
		MyStack<Character> object = stack;
		String result = "";
		while (!object.isEmpty()) {
			reverseStack.push(object.pop().toString());

		}

		while (!reverseStack.isEmpty()) {
			result += reverseStack.pop();

		}

		return result;

	}
}
