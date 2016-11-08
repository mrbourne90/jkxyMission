package com.jikexueyuan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jikexueyuan.entity.Poetry;
import com.jikexueyuan.service.PoetryService;
import com.jikexueyuan.util.Page;

public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String condition = "";
		String key = "";
		List<Poetry> poetries = null;
		PoetryService pService = new PoetryService();
		int pageIndex = 1; // 当前页码
		
		// 从请求中接收查询参数
		condition = request.getParameter("searchCondition");
		key = request.getParameter("searchKey");

		if (request.getParameter("index") != null) {
			pageIndex = Integer.parseInt(request.getParameter("index")); // 获取当前页码
		}
		// 新建一个用于分页的Page
		System.out.println(key);
		System.out.println(condition);
		int totalRow = pService.getPoetriesAmount(key, condition);
		Page page = new Page(totalRow, pageIndex, 10);
		System.out.println(page.getCount());
		System.out.println(page.getTotal());
		System.out.println(page.getBeginIndex());
		System.out.println(page.getEndIndex());
		// 查询分页数据
		poetries = pService.query(condition, key, page);
		// 将结果和关键字放到request对象中去
		request.setAttribute("poetries", poetries);
		request.setAttribute("searchKey", key);
		System.out.println("Seachkey:" + request.getAttribute("searchKey"));
		
		request.setAttribute("searchCondition", condition);
		request.setAttribute("page", page);
		// 如果查询到结果，那么跳转到结果显示页面
		if (!poetries.isEmpty()) {
			RequestDispatcher rDispatcher = request.getRequestDispatcher("/displayContent.jsp");
			rDispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/notFound.jsp");
		}

	}

}
