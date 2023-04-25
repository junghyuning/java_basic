package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

public class ObjectInputStreamApp {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:/data/object.txt"));
		String string = (String)in.readObject();
		Date date = (Date) in.readObject();
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>)in.readObject();
		
		System.out.println(string);
		System.out.println(date);
		System.out.println(list);
				
	}
}
