package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@RequestMapping("/")// "/sample/"를 입력하면 뜨는것을 표시한다
	public void basic() {
		log.info("basic.....");
	}
	
	@GetMapping("/basicOnlyGet")
	public void baiscGet2() {
		log.info("basicOnlyGet.....");
	}
	
	@GetMapping("/ex01")
	
}
