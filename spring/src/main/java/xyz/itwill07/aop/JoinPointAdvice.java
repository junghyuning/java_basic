package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;

//횡단관심모듈 - Advice 클래스
public class JoinPointAdvice {
	//Around Advice Method를 제외한 나머지 Advice Method는 일반적으로 반환형을 void로 작성하고
	//매개변수를 작성하지 않거나 JoinPoint 인터페이스로 작성된 매개변수 선언 가능
	//=>Advice 클래스의 메서드를 작성규칙에 맞지 않게 작성할 경우 IllegalArgumentException 발생
	//JoinPoint 객체 : 타겟 메서드 관련 정보가 저장된 객체
	
	//Before Advice Method
	public void beforeDisplay(JoinPoint joinPoint) {
		//System.out.println("### [before]핵심관심코드 실행 전 삽입되어 실행될 횡단관심코드 ###");
		
//		System.out.println(joinPoint.getTarget().getClass().getName());
		
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		Object[] params = joinPoint.getArgs();
		
		System.out.print("### [before]"+className+ " 클래스의 "+methodName+"(");
		for(int i=0; i<params.length;i++) {
			System.out.print(params[i]);
			if(i<params.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println(") 메서드 호출###");
	}
	
	public void displayMessage(JoinPoint joinPoint) {
		//System.out.println("### [after]핵심관심코드 실행 후 무조건 삽입되어 실행될 횡단관심코드 ###");
		
		Object[] params=joinPoint.getArgs();
		System.out.println("###[after]사원번호가 "+params[0]+"인 사원정보를 삭제하였습니다.");
	}

}