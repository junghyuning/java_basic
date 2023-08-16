package xyz.itwill10.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.itwill10.dto.RestMember;

//REST(Representational State Transfer) : 자원(Resource)의 표현에 의한 상태를 전달하는 것

@Controller
@RequestMapping("/rest")
public class RestfulController {
	
	
	@GetMapping(value="/join")
	public String join() {
		return "rest/input";
	}
	
	
//	@PostMapping("/join")
//	public String join(@RequestParam String id, @RequestParam String name, Model model) {
//		model.addAttribute("id", id);
//		model.addAttribute("name", name);
//		return "rest/output";
//	}
	
	
	@PostMapping("/join")
	@ResponseBody
	public String join(@RequestBody String input) {
		return "input";
	}
	
	
//	@RequestMapping("/member")
//	@ResponseBody
//	public RestMember restMember() {
//		return RestMember.builder().id("abc123").name("홍길동").email("abc@itwill.xyz").build();
//	}
	
	@RequestMapping("/member")
	public ResponseEntity<RestMember> restMember() {
		try {
			RestMember member = RestMember.builder().id("abc123").name("홍길동").email("abc@itwill.xyz").build();
			//클라이언트에게 응답코드 200과 실행결과를 텍스트로 응답처리
			return new ResponseEntity<RestMember>(member, HttpStatus.OK);
		} catch (Exception e) {
			//클라이언트에게 응답코드 400과 실행결과를 텍스트로 응답처리
			return new ResponseEntity<RestMember>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping("/member_list")
	@ResponseBody
	public List<RestMember> restMemberList() {
		List<RestMember> memberList = new ArrayList<RestMember>();
		memberList.add(RestMember.builder().id("abc123").name("홍길동").email("abc@itwill.xyz").build());
		memberList.add(RestMember.builder().id("opq456").name("임꺽정").email("opq@itwill.xyz").build());
		memberList.add(RestMember.builder().id("xyz789").name("전우치").email("xyz@itwill.xyz").build());
		
		return memberList;
	}
	
	
	@RequestMapping("/member_map")
	@ResponseBody
	public Map<String, Object> restMemberMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", "abc123");
		map.put("name", "홍길동");
		map.put("email", "abc@itwill.xyz");
		
		
		return map;
	}
	
	@GetMapping(value="/board")
	public String board() {
		return "rest/board";
	}
	
}
