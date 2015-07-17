package edu.train.chapter1;

import org.junit.Test;

public class OperatorTest {
	
	@Test
	public void testUnsignedRightOperation() {
		System.out.println(Integer.toBinaryString(-3));
		System.out.println(-3>>2);
		System.out.println(-3>>>2);
	}
	
	@Test
	public void testXOROperation() {
		String str = "test";
		String cypStr = cypher(str.getBytes());
		System.out.println(cypStr);
		System.out.println(cypher(cypStr.getBytes()));
	}
	
	public String cypher(byte[] bytes) {
		byte[] newBytes = new byte[bytes.length];
		for(int i = 0 ; i < bytes.length ; i ++) {
			newBytes[i] = (byte)(bytes[i] ^ 12);
		}
		return new String(newBytes);
	}
}
