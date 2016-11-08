package com.jikexueyuan.usingxml;

import java.io.File;
import java.io.IOException;

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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ShoppingToOrder {

	private static int sum;
	private static double total;

	public static void main(String[] args) {

		// 读取shoppingXML
		File shopping = new File("shopping.xml");
		readXML(shopping);
		// 生成orderXML
		File order = new File("order.xml");
		writeXML(order);
	}

	/**
	 * 将一个文件读为XML
	 */
	public static void readXML(File src) {

		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src);
			// 获取根元素shopping
			Element shopping = document.getDocumentElement();
			// 获取子元素goods
			NodeList goods = shopping.getElementsByTagName("goods");
			for (int i = 0; i < goods.getLength(); i++) {
				Element good = (Element) goods.item(i);
				Element price = (Element) good.getElementsByTagName("price").item(0);
				Element number = (Element) good.getElementsByTagName("number").item(0);
				int num = Integer.parseInt(number.getTextContent());
				double goodPrice = Double.parseDouble(price.getTextContent());
				sum += num;
				total += goodPrice * num;
			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将XML写为一个文件
	 */
	public static void writeXML(File dest) {

		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			// 创建根节点
			Element order = document.createElement("order");
			// 创建子节点
			Element total = document.createElement("total");
			total.setTextContent(ShoppingToOrder.total + "");
			Element sums = document.createElement("sums");
			sums.setTextContent(sum + "");
			// 逐级添加节点
			order.appendChild(document.createTextNode("\n    "));  
			order.appendChild(total);
			order.appendChild(document.createTextNode("\n    "));  
			order.appendChild(sums);
			document.appendChild(order);
			// 写入文件
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
		    transformer.setOutputProperty(OutputKeys.INDENT, "yes");  
			transformer.transform(new DOMSource(document), new StreamResult(dest));
		} catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}
	}
}
