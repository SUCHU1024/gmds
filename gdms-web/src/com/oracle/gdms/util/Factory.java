package com.oracle.gdms.util;

import java.util.ResourceBundle;


public class Factory {

	private static ResourceBundle rb; //定义一个资源绑定对象
	static {
		rb = ResourceBundle.getBundle("config/application");
	}
	
	private Factory() {}  ///构造单例构造方法
	
	private static Factory fac ;  //构造静态私有定义对象
	
	public static Factory getInstance() {   //返回类型，返回方法  名
		fac = fac == null ? new Factory() : fac ;
		return fac;
	}
	
	public Object getObject(String key) {
	//读取配置文件，从配置文件中找到key对应的class路径和名称
		String classname = rb.getString(key);
		Object o = null;
		try {
			o = Class.forName(classname).newInstance();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return o;
	}

}
