package com.oracle.gdms.util;

import java.util.ResourceBundle;


public class Factory {

	private static ResourceBundle rb; //����һ����Դ�󶨶���
	static {
		rb = ResourceBundle.getBundle("config/application");
	}
	
	private Factory() {}  ///���쵥�����췽��
	
	private static Factory fac ;  //���쾲̬˽�ж������
	
	public static Factory getInstance() {   //�������ͣ����ط���  ��
		fac = fac == null ? new Factory() : fac ;
		return fac;
	}
	
	public Object getObject(String key) {
	//��ȡ�����ļ����������ļ����ҵ�key��Ӧ��class·��������
		String classname = rb.getString(key);
		Object o = null;
		try {
			o = Class.forName(classname).newInstance();
		} catch (InstantiationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return o;
	}

}
