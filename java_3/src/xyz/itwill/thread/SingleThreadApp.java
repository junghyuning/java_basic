package xyz.itwill.thread;



//단일 스레드 :JVM에 의해 생성된 main 스레드를 이용하여 main() 메서드 호출하여 명령 실행
//=> main() 메서드 종료시, 스레드 자동소멸
public class SingleThreadApp {
	public static void main(String[] args) {
		System.out.println("SingleThreadApp 클래스의 main() 메서드 시작");
		//Thread.currentTread() : 현재 명령을 읽어 처리하는 스레드에 대한 Thread 객체를 반환하는 메서드
		//Thread.getName() : Thread 객체 된 스레드의 이름(고유값)을 반환하는 메서드
		System.out.println("["+Thread.currentThread().getName()+"] 스레드에 의해 main() 메서드의 명령 실행.");
		
		
//		객체생성 -> 메서드 호출 : 메서드로 이동하여 명령실행 -> 명령 모두 실행 -> 다시 돌아옴.
		new SingleThread().display(); // 객체생성하여 직접 메서드 호출
		
		System.out.println("SingleThreadApp 클래스의 main() 메서드 종료");
	}
}
