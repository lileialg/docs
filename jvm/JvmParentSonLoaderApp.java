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
 * 调用子，会先初始化父
 * 
 * 假如调用常量，则不进行初始化
 * 
 * 假如非常量，则初始化
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