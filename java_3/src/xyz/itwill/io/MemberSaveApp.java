package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


//회원정보(member 객체)를 파일에 전달하여 저장하는 프로그램을 작성

public class MemberSaveApp {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/data/member.txt"));  // 원시데이터를 전달할 수있는 출력스트림(FileOutputStream)을 ObjectOutputStream으로 확장
		
		//out.writeObject 호출시 NotSerializableException 발생가능
		//ObjectOutputStreamApp에서 사용한 int, string, date, list 자료형의 경우 이미 해당 클래스들이 Serializable 인터페이스를 상속받고있어 별도의 implements가 없어도 오류가 발생하지 않았음.
		out.writeObject(new Member("abc123","홍길동","010-3174-1234"));
		out.writeObject(new Member("def456","임꺽정","010-2145-8741"));
		out.writeObject(new Member("ghi789","전우치","010-9813-6547"));
		
		out.close();
		
		System.out.println("\"c:/data/member.txt\"에 회원정보를 저장하였습니다.");
		
	}
}
