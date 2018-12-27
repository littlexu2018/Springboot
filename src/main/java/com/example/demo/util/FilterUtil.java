package com.example.demo.util;


import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Author: xuhh
 * @Description:这个是用来过滤sql注入的字符串的
 *
[1] ;（分号）
[2] '（单引号）
[3] "（引号）
[4] <>（尖括号）
[5] ()（括号）
[6] ,（逗号）
[7] \（反斜杠）
[8] script
[9] svg
[10] alert
[11] confirm
[12] prompt
[13] onload
[14] onmouseover
[15] onfocus
[16] onerror
[17] xss
 * @Date: Created in 15:16 2018/12/14
 * @Modified By:
 */
public class FilterUtil {
	private static final Log log = LogFactory.getLog(FilterUtil.class);

	public static List<String>  init(){
		List<String> list =new ArrayList<>();
		list.add(";");		list.add("'");
		list.add("\"");		list.add("<>");
		list.add("()");		list.add(",");
		list.add("\\");
		list.add("script"); list.add("svg");
		list.add("alert");  list.add("confirm");
		list.add("prompt");    list.add("onload");
		list.add("onmouseover");    list.add("onfocus");
		list.add("onerror");    list.add("xss");
		return  list;
	}


	public static  String interceptChar(String str)
	{
		List<String> list=init();
		for (int i = 0; i <list.size() ; i++) {
			log.info("str: "+str);
			log.info("list.get(i): "+list.get(i));
			if(str.indexOf(list.get(i))>-1){
				log.info("before   :"+str);
				str =str.replaceAll(list.get(i),"");
				log.info("after    :"+str);
				//break;
			}
		}
		return str;
	}


	public static void  main(String args[]){
		String str = FilterUtil.interceptChar("p()");
		log.info("strFinal    :"+str);

	}


}
