package ch07;

import java.util.Random;
import java.util.stream.IntStream;

public class StreamExercise {
	public static void main(String[] args) {
		IntStream streamInt = new Random().ints(5);
		
		streamInt.forEach(System.out::println);
		
		IntStream streamI = new Random().ints();
		streamI.limit(5).forEach(System.out::println);
		
		
	}
}
