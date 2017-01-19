package foundation;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		short s = 1;
//		s += 1;
//		System.out.println(s);
		
//		Integer a = new Integer(3);
//		Integer b = 3;
//		int c = 3;
//		System.out.println(a == b);  //false 两个引用没有引用同一个对象
//		System.out.println(a == c);  //true a 自动拆箱成int类型再和c比较。
//		System.out.println(b == c);
		
		//给Integer对象赋值时，会调用Integer类的静态方法valueOf，其源码如下
		/*
		 * public static Integer valueOf(int i) {
		 *     if (i >= IntegerCache.low && i <= IntegerCache.high) 
		 *         return IntegerCache.cache[i + (-IntegerCache.low)];
		 *     return new Integer(i);
		 * }
		 * 简单的说，如果整型字变量的值在-128到127之间，那么不会new 新的Integer对象，
		 * 而是直接引用常量池中的Integer对象，所以f1==f2返回true， f3==f4返回false；
		 */
//		Integer f1 = 127, f2 = 127, f3 = 128, f4 = 128, f5 = -129, f6 = -129, f7 = -128, f8 = -128;
//		System.out.println(f1 == f2); //true;
//		System.out.println(f3 == f4); //false; 见上面解析；
//		System.out.println(f5 == f6); //false;
//		System.out.println(f7 == f8); //true;
		
//		System.out.println(Math.round(11.5));
//		System.out.println(Math.round(-11.5)); //+0.5再向下取整
		
		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program";
		String s4 = "ming";
		String s5 = "Program" + "ming";
		String s6 = s3 + s4;
		System.out.println(s1 == s2);
		System.out.println(s1 == s5);
		System.out.println(s1 == s6);
		System.out.println(s1 == s6.intern());
		System.out.println(s2 == s2.intern());
		System.out.println(s6);
	}

}
