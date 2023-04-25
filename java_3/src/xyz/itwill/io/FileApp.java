package xyz.itwill.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//파일 : 값 저장
//디렉토리 : 파일을 저장(폴더 / 경로)
public class FileApp {
	public static void main(String[] args) throws IOException{
		
		//경로표현방법 1.절대경로,  2.상대경로
		//1. 절대경로 : 최상위 디렉토리 기준 파일 위치를 표현하는 방법 (위도우:c,d 드라이브, 리눅스 : / (루트 디렉토리)
		//2. 상대경로 : 현재 실행 프로그램의 잡업 디렉토리를 기준으로 파일 위치를 표현
		File fileOne = new File("c:\\data");  // 파일 객체 생성. (파일 생성)
		
		if(fileOne.exists()) {
			System.out.println("c:\\data 폴더에 이미 존재합니다.");
		} else {
			fileOne.mkdir();
			System.out.println("c:\\data 폴더를 생성하였습니다.");
		}
		System.out.println("=====================================================");
//		File fileTwo = new File("c:\\data\\itwill.txt");
		File fileTwo = new File("c:/data/itwill.txt");
		if(fileTwo.exists()) {
			System.out.println("c:\\data\\itwill.txt 폴더에 이미 존재합니다.");
		} else {
			fileTwo.createNewFile();
			System.out.println("c:\\data\\itwill.txt 파일을 생성하였습니다.");
		}
		System.out.println("=====================================================");
		//File 클래스의 File(String parent, String child)의 생성자
		//부모 = 디렉토리 , 자식 = 파일 //폴더와 파일을 따로 전달받아 파일 경로가 저장된 File 객체를 생성함.
		File fileThree = new File("c:/data", "itwill.xyz");  // 경로, 파일명.
		fileThree.createNewFile();
		if(fileThree.exists()) {
			fileThree.delete();
			System.out.println("c:/data/itwill.xyz 파일을 삭제하였습니다.");
		} else System.out.println("c:/data/itwill.xyz 파일이 존재하지 않습니다.");
		System.out.println("=====================================================");
		
		File fileFour = new File("src");  //src라는 파일과 연결한다는 뜻.... //상대경로 가장 가까운 경로에 있는 것 찾음.
		
		if(fileFour.exists()) {
			System.out.println("file directory = "+ fileFour.toString());
			//상대경로를 절대경로로
			System.out.println("absolute path[src] =" + fileFour.getAbsolutePath());
		}
		
		else System.out.println("There's no [src] directory");
		System.out.println("=====================================================");
		File fileFive = new File("c:/");
		//
		if(fileFive.isDirectory()) {
			File[] subFiles = fileFive.listFiles(); // File타입 객체 배열로 만들라는 의미.
			//경로 "c:/"에있는 파일들을 모두 subFiles에 저장
			
			System.out.println(fileFive+ "폴더의 자식 목록 >> " );
			for(File file : subFiles) {
				if(file.isFile()) {
					System.out.println(file+ ": 파일 ");
				} else System.out.println(file +": 폴더(디렉토리)");
			}
		}
		System.out.println("========================================================");
		
	}
}
