package datastructure.util;

public class Util {
	
	public static <T> void print_r(T[] arrs) {
		StringBuilder sb = new StringBuilder("[");
		for(T arr : arrs) {
			sb.append(arr + ",");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]");
		System.out.println(sb);
	}
}
