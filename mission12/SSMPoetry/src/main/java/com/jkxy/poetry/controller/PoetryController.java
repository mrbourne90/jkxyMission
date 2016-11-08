package com.jkxy.poetry.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jkxy.poetry.entity.Poetry;
import com.jkxy.poetry.service.PoetryService;
import com.jkxy.poetry.util.PageModel;

@Controller
public class PoetryController {

	@Resource
	private PoetryService poetryService;

	// 主页跳转
	@RequestMapping("/index")
	public String toIndex() {

		return "index";
	}

	// 页面跳转
	@RequestMapping("/toPage")
	public String toPage(String pageName) {

		return pageName;
	}

	// 查询诗歌
	@RequestMapping(value = "/findPoetry", method = RequestMethod.POST)
	public String findPoetry(HttpServletRequest request, @RequestParam String condition, @RequestParam String key,
			@RequestParam(value = "pageNo", required = false) Integer pageNo) {

		PageModel<Poetry> poetryPage = new PageModel<>();
		// 当有页码时赋值
		if (pageNo != null && pageNo != 0) {
			poetryPage.setPageNo(pageNo);
		}

		// 先查询记录数
		Long recordCount = poetryService.getRecordCount(condition, key);
		// 有记录再进一步查询内容
		if (recordCount > 0) {
			// 结果集page的记录数赋值
			poetryPage.setRecordCount(recordCount.intValue());
			// 调用service获取记录
			List<Poetry> poetryList = poetryService.getPoetry(condition, key, poetryPage.getPageNo(),
					poetryPage.getPageSize());
			// 有记录则给结果页赋值，并且把结果页和查询参数放入request中
			if (poetryList != null && poetryList.size() > 0) {
				poetryPage.setDatas(poetryList);
				request.setAttribute("poetryPage", poetryPage);
				request.setAttribute("condition", condition);
				request.setAttribute("key", key);
				return "displayContent";
			}

		}
		return "notFound";
	}
}
