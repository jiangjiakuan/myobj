package com.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtil {
	/**
	 * 传入要读取的xml文件路径，即可读出文件内所有元素及属性
	 * @param filePath
	 */
	public static void readXml(String filePath) {
		File file = new File(filePath);
		SAXReader read = new SAXReader();
		try {
			Document doc = read.read(file);
			// 得到根节点
			Element d = doc.getRootElement();
			// 得到子节点
			Iterator ds = d.elementIterator();
			while (ds.hasNext()) {
				Element zys = (Element) ds.next();
				// 得到子节点里面的属性及属性值
				Iterator attr = zys.attributeIterator();
				while (attr.hasNext()) {
					Attribute a = (Attribute) attr.next();
					System.out.println(a.getName() + ":" + a.getValue());
				}
				// 得到子节点里面的元素及元素值
				Iterator ele = zys.elementIterator();
				while (ele.hasNext()) {
					Element zy = (Element) ele.next();
					System.out.println(zy.getName() + ":" + zy.getText());
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("文件路径不正确："+filePath);
		}
	}
	/**
	 * 创建xml空树，并返回创建好的document对像
	 * @return doc
	 */
	public static Document getDocument(){
		Document doc = DocumentHelper.createDocument();//创建xml空树
		return doc;
	}
	/**
	 *传入文件创建好的document对象，及要写到的路径；
	 * @param path
	 * @param document
	 * @throws Exception
	 */
	public static void writeXML(String path,Document document) throws Exception {

		File file = new File(path);//輸出文件的路徑

		OutputStream out = new FileOutputStream(file);

		XMLWriter xmlWriter = new XMLWriter(out);

		try {
			xmlWriter.write(document);
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			xmlWriter.close(); 
		}

	}
}
