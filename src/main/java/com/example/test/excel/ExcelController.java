package com.example.test.excel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("excel")
public class ExcelController {

	@RequestMapping("test")
	public void test() throws Exception {
		ExcelParser.validate();
	}
}
