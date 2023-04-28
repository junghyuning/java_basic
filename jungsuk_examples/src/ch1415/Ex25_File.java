package ch1415;
import java.io.File;
import java.io.IOException;
public class Ex25_File {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\user\\git\\java_basic\\jungsuk_examples\\src\\ch1415\\Ex25_File.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("경로를 제외한 파일 이름 - " + f.getName());
		System.out.println("확장자 제외 이름 : "+ fileName.substring(0,pos));
		System.out.println("확장자 : "+ fileName.substring(pos+1));
		
		System.out.println("경로포함 파일이름 : "+f.getPath());
		System.out.println("절대경로 : "+ f.getAbsolutePath());
		System.out.println("정규경로 :" + f.getCanonicalPath());
		System.out.println("파일이 속해있는 디렉토리 : "+f.getParent());
		System.out.println();
		
		
		
	}
}
