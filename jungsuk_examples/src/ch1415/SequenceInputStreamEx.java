package ch1415;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class SequenceInputStreamEx {

	public static void main(String[] args) throws IOException {
		byte[] arr1 = {0,1,2};
		byte[] arr2 = {3,4,5};
		byte[] arr3 = {6,7,8};
		byte[] outsrc = null;
		
		Vector<ByteArrayInputStream> vector= new Vector<>();
		vector.add(new ByteArrayInputStream(arr1));
		vector.add(new ByteArrayInputStream(arr2));
		vector.add(new ByteArrayInputStream(arr3));
		
		SequenceInputStream sis = new SequenceInputStream(vector.elements());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int data=1;
		while((data=sis.read())!= -1) {
			baos.write(data);
		}

		outsrc = baos.toByteArray();
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(outsrc));
		
	}
}
