package com.example.common;

import com.example.common.exception.BusinessException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by zhuyy on 2017/3/24.
 */

public class MessageUtil {

    public static String getResponseMessage(String requestMessage) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(requestMessage.getBytes("UTF-8")))));
        } catch (DocumentException e) {
            throw new BusinessException("解析xml异常！", Constant.EXCEPTION_CODE);
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException("解析xml异常！", Constant.EXCEPTION_CODE);
        }
        String toUserName = ((Element) document.selectSingleNode("/xml/ToUserName")).getText();
        String fromUserName = ((Element) document.selectSingleNode("/xml/FromUserName")).getText();
        Element rootElement = document.getRootElement();
        List<Element> elementList = rootElement.elements();
        Element rootResponseElement = DocumentHelper.createElement("xml");
        Document responseDocument = DocumentHelper.createDocument(rootResponseElement);
        for (Element element : elementList) {
            if(element.getName().equals("ToUserName")){
                element.setText("");
                element.addCDATA(fromUserName);
            }
            else if (element.getName().equals("FromUserName")) {
                element.setText("");
                element.addCDATA(toUserName);
            }
            else if (element.getName().equals("Content")) {
                element.setText("");
                element.addCDATA("test");
            }
            else if (element.getName().equals("MsgId")) {
                rootElement.remove(element);
            }
            else if (element.getName().equals("CreateTime")) {
                element.setText(System.currentTimeMillis()+"");
            }
//            rootResponseElement.add(element);
        }
        return document.asXML();
    }
}
