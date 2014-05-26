package mylibs;

import java.io.PrintStream;

public class PrintMain {
	public static void print(Object obj){
		System.out.println(obj);
	}
	public static void printf(){
		System.out.println();
	}
	public static void printb(Object obj){
		System.out.print(obj);
	}
	public static PrintStream
	printf(String format,Object ... args){
		return System.out.printf(format, args);
	}

}
