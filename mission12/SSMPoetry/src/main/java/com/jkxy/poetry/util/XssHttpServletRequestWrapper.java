package com.jkxy.poetry.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		return clearXss(super.getParameter(name));
	}

	@Override
	public String getHeader(String name) {
		return clearXss(super.getHeader(name));
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if (values != null) {
			String[] newValues = new String[values.length];

			for (int i = 0; i < values.length; i++) {
				newValues[i] = clearXss(values[i]);
			}
			return newValues;
		}
		return super.getParameterValues(name);

	}

	// 处理字符转义
	private String clearXss(String value) {

		if (value == null || "".equals(value)) {
			return value;
		}
		// 处理 < > ( ) ' . "
		value = value.replaceAll("<", "&lt").replaceAll(">", "&gt");
		value = value.replaceAll("\\(", "&#40").replaceAll("\\)", "&#41");
		value = value.replaceAll("'", "&#39");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		return value;
	}
}
