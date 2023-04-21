package ch07;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExercise {
	public static void main(String[] args) {
		IntStream streamInt = new Random().ints(5);
		
		streamInt.forEach(System.out::println);
		
		IntStream streamI = new Random().ints();
		streamI.limit(5).forEach(System.out::println);
		
		Stream<String[]> strArrStrmStream = Stream.of(new String[]{"abc","def","ghi"}, new String[] { "ABC","GHI","JKLMN"});
		Stream <Stream<String>> strStrString = strArrStrmStream.map(Arrays::stream);
		System.out.println("=============================================================================");
		
		
		Stream<String[]> strArrStrmStream2 = Stream.of(new String[]{"abc","def","ghi"}, new String[] { "ABC","GHI","JKLMN"});
		strArrStrmStream2.flatMap(Arrays::stream).map(String::toLowerCase).distinct().forEach(System.out::println);
		System.out.println("=============================================================================");
		
		
		
		Stream<String[]> strArrStrmStream3 = Stream.of(new String[]{"abc","def","ghi"}, new String[] { "ABC","GHI","JKLMN"});
		Stream <String> strString = strArrStrmStream3.flatMap(Arrays::stream);
		strString.forEach(System.out::println);
		System.out.println("=============================================================================");
		
		
	}
}
