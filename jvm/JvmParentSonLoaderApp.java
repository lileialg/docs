package com;

public class JvmParentSonLoaderApp {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Son.var);
	}

}

/**
 * �����ӣ����ȳ�ʼ����
 * 
 * ������ó������򲻽��г�ʼ��
 * 
 * ����ǳ��������ʼ��
 * @author lilei3774
 *
 */
class Parent{
	
	static{
		System.out.println("I am parent");
	}
	
}

class Son extends Parent{
	static{
		System.out.println("I am son");
	}
	
//	public static final String var = "ABC";
	public static  String var = "ABC";
}