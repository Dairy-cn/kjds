package com.cross.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.*;

public class XmlAndbeanUtils {

    private static final Logger log = LoggerFactory.getLogger(XmlAndbeanUtils.class);
    /**
     * @param obj
     * @param ignoreNullValue ：true 忽略空值  false 不忽略空值
     * @return
     */
    public  static Map<String, String> bean2Map(Object obj, boolean ignoreNullValue) {
        if(obj == null){
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (!key.equals("class")) {
                    Method getter = property.getReadMethod();
                    String value = getter.invoke(obj)==null?"":getter.invoke(obj).toString();
                    if(ignoreNullValue&&value==null)continue;
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            log.error("bean to map fail:{}",e);
        }
        return map;

    }

    /** xml->bean
     * @param rootName : xml的根标签名称
     * @param charset 字符集
     * @param isUpper:是否转大写
     * @return
     * @throws Exception
     */
    public static String createXmlFromBean(String rootName, Object o, String charset,Boolean isUpper) throws Exception {
        Map<String, String> elements=bean2Map(o,true);
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding(charset);
        Element rootElement = document.addElement(rootName);

        Set<Map.Entry<String, String>> elementsSet = elements.entrySet();
        Iterator<Map.Entry<String, String>> elementsIterator = elementsSet.iterator();
        while(elementsIterator.hasNext())
        {
            Map.Entry<String, String> elementEntry = elementsIterator.next();
            String elementName = elementEntry.getKey();
            if(isUpper){
                elementName = elementEntry.getKey().toUpperCase();
            }
            String elementValue = elementEntry.getValue();
            Element element = rootElement.addElement(elementName);
            element.addText(elementValue);
        }

        return document.asXML();
    }



    /**
     * xml转变为bean
     * @param xmlData
     * @param unique
     * @param charset
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T parseXmlToBean(String xmlData, boolean unique, String charset,Class<T> clazz) throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        InputStream is = new ByteArrayInputStream(xmlData.getBytes(charset));
        SAXReader sax = new SAXReader(false);
        Document document = sax.read(is);

        Element rootElement = document.getRootElement();
        map = parseElements(map, rootElement, unique ? null : rootElement.getName().toLowerCase());
        T t=clazz.newInstance();
        BeanUtils.populate(t, map);
        return t;
    }




    /**
     * XML节点元素数据解析为Map<String, String>
     *
     * @param map 返回map
     * @param element 节点元素
     * @param name 节点元素名
     * @return Map<String, String>
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    private static Map<String, String> parseElements(Map<String, String> map, Element element, String name) throws Exception {
        List<Element> elementList = element.elements();

        if(elementList.isEmpty())
        {
            map.put(StringUtils.isBlank(name) ? element.getName().toLowerCase() : name, element.getText());
        }
        else
        {
            for(Element _element : elementList)
            {
                map = parseElements(map, _element, StringUtils.isBlank(name) ? null : (name + "." +_element.getName().toLowerCase()));
            }
        }

        return map;
    }



    /**
     * 生成XML数据
     *
     * @param rootName 根元素名
     * @param rootAttributes 根元素数据
     * @param elements 元素数据
     * @param charset 字符集
     * @return XML数据
     * @throws Exception
     */
    public static String create(String rootName,  Map<String, Object> rootAttributes, Map<String, List<Map<String, Object>>> elements, String charset) throws Exception {
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding(charset);
        Element rootElement = document.addElement(rootName);

        if(rootAttributes != null && !rootAttributes.isEmpty())
        {
            Set<Map.Entry<String, Object>> rootAttributesSet = rootAttributes.entrySet();
            Iterator<Map.Entry<String, Object>> rootAttributesIterator = rootAttributesSet.iterator();
            while(rootAttributesIterator.hasNext())
            {
                Map.Entry<String, Object> rootAttributeEntry = rootAttributesIterator.next();
                rootElement.addAttribute(rootAttributeEntry.getKey(), rootAttributeEntry.getValue().toString());
            }
        }

        Set<Map.Entry<String, List<Map<String, Object>>>> elementsSet = elements.entrySet();
        Iterator<Map.Entry<String, List<Map<String, Object>>>> elementsIterator = elementsSet.iterator();
        while(elementsIterator.hasNext())
        {
            Map.Entry<String, List<Map<String, Object>>> elementEntry = elementsIterator.next();
            String elementName = elementEntry.getKey();
            List<Map<String, Object>> elementAttributes = elementEntry.getValue();
            Element element = rootElement.addElement(elementName + "s");

            for(Map<String, Object> attributes : elementAttributes)
            {
                Element subElement = element.addElement(elementName);
                Set<Map.Entry<String, Object>> attributesSet = attributes.entrySet();
                Iterator<Map.Entry<String, Object>> attributesIterator = attributesSet.iterator();
                while(attributesIterator.hasNext())
                {
                    Map.Entry<String, Object> attributeEntry = attributesIterator.next();
                    subElement.addAttribute(attributeEntry.getKey(), attributeEntry.getValue().toString());
                }
            }
        }

        return document.asXML();
    }


    /**
     * xml 头部  及根元素必须先拼接好后用此工具
     * @param map
     * @param str
     */
    public static void mapToXML(Map<String,List<Map<String, Object>>> map, StringBuilder str) {
        Set set = map.keySet();
        for (Iterator it = set.iterator(); it.hasNext();) {
            String key = (String) it.next();
            Object value = map.get(key);
            if (null == value)
                value = "";
            if (value.getClass().getName().equals("java.util.ArrayList")) {
                ArrayList list = (ArrayList) map.get(key);
                str.append("<" + key + ">");
                for (int i = 0; i < list.size(); i++) {
                    HashMap hm = (HashMap) list.get(i);
                    mapToXML(hm, str);
                }
                str.append("</" + key + ">");

            } else {
                if (value instanceof HashMap) {
                    str.append("<" + key + ">");
                    mapToXML((HashMap) value, str);
                    str.append("</" + key + ">");
                } else {
                    str.append("<" + key + ">" + value + "</" + key + ">");
                }

            }

        }

    }

}
