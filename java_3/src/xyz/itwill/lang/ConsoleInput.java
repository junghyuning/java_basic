package xyz.itwill.lang;

import java.util.Scanner;

//계산기의 입력을 받는 class
public class ConsoleInput {
	private String input;

	public ConsoleInput() {
		// TODO Auto-generated constructor stub
	}

	public ConsoleInput(String input) {
		super();
		this.input = input;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void input() {
		System.out.print("계산할 값을 입력하시요 >>");
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine().replace(" ", "");
		boolean b = false;
		if(input.contains("+")||input.contains("-")||input.contains("*")||input.contains("/")) {
			b = true;
		}
		while(b) {
			
		}
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) > '9' && input.charAt(i) < '1') {
				if (input.charAt(i) != '+' || input.charAt(i) != '-' || input.charAt(i) != '*'|| input.charAt(i) != '/') {
					System.out.println("형식에 맞지않는 값입니다. 프로그램을 종료합니다.");
					System.exit(0);
				}
			}
		}
		split(input);
		System.out.print(input);
	}

	public void split(String input) {
		
	}

}
