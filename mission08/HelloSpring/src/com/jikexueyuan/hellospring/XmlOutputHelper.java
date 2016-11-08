package com.jikexueyuan.hellospring;

import java.io.ByteArrayOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlOutputHelper implements IOutputHelper {

	private Employee employee;

	public XmlOutputHelper() {

	}

	public XmlOutputHelper(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String getFormatedString() {

		String formatString = null;
		try {
			// 创建一个DOM文档
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			// 创建根节点
			Element root = document.createElement("employee");
			// 创建子节点
			Element name = document.createElement("name");
			name.setTextContent(employee.getName());
			Element age = document.createElement("age");
			age.setTextContent(String.valueOf(employee.getAge()));
			Element gender = document.createElement("gender");
			gender.setTextContent(employee.getGender());
			Element address = document.createElement("address");
			address.setTextContent(employee.getAddress());
			Element phoneNum = document.createElement("phoneNum");
			phoneNum.setTextContent(employee.getPhoneNum());

			// 逐级添加节点
			root.appendChild(document.createTextNode("\n    "));
			root.appendChild(name);
			root.appendChild(document.createTextNode("\n    "));
			root.appendChild(age);
			root.appendChild(document.createTextNode("\n    "));
			root.appendChild(gender);
			root.appendChild(document.createTextNode("\n    "));
			root.appendChild(address);
			root.appendChild(document.createTextNode("\n    "));
			root.appendChild(phoneNum);
			document.appendChild(root);

			// 格式化字符串
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(document), new StreamResult(bos));
			formatString = bos.toString();

		} catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}

		return formatString;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
