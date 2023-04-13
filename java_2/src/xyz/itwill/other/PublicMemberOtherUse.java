package xyz.itwill.other;

import xyz.itwill.access.PublicMember;

public class PublicMemberOtherUse {
	public void run() {
		PublicMember publicMember = new PublicMember();
		
		publicMember.num =100;
		publicMember.display();
	}
}
