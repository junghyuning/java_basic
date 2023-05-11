package ch1415;

public class Ex37_FileSplit {
	public static void main(String[] args) {
		if(args.length<2) {
			System.out.println("usage : java FileSplit filename SIZE_KB");
			System.exit(0);
		}
		
		final int VOLUMN= Integer.parseInt(args[1]);
	}
}
