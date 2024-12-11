package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 화면으로 가는 컨트롤러
@Controller // spring bean으로 등록, @ResponseBody가 있으면 절대 안됨!!! => @RestController도 절대 안됨!!!
public class Lesson01Ex02Controller {
	
	// http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // 얘는 주소임. 밑에랑 전혀 상관 없음 => request
	public String ex02() {
		// 원래 경로: return "/templates/lesson01/ex02.html"
		// "/templates/   lesson01/ex02   .html" => 가운데 lesson01/ex02 부분만 쓰기!!!
		return "lesson01/ex02"; // => response
	}
}
