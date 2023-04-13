package xyz.itwill.other;
import xyz.itwill.access.*;

public class PackageMemberOtherUse {
	public void run() {
		@SuppressWarnings("unused")
		PackageMember member = new PackageMember();

		// member.num=100;
		// member.display();
	}
}
