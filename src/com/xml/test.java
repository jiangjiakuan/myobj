package com.xml;

import org.dom4j.Document;
import org.dom4j.Element;

public class test {
	public static void main(String[] args) {
		//解析xml文件
		XMLUtil.readXml("D:/new.xml");
		
		//写入xml文件
//		Document doc = XMLUtil.getDocument();
//		
//		Element e = doc.addElement("users");
//		
//		Element user = e.addElement("user");
//		
//		user.addAttribute("id", "1");
//		
//		user.addElement("userName").setText("zhangsan");
//		
//		try {
//			XMLUtil.writeXML("D:/new.xml", doc);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}
}
