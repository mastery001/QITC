package edu.train.chapter4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MultiCopyFileTest {
	public static void main(String[] args) throws IOException {
		String sourceFile = "Person.txt";
		String targetFile = "1.txt";
		// 记录开始时间
		long beginTime = System.currentTimeMillis();
		single(sourceFile, targetFile);
		// 计算耗时
		long endTime = System.currentTimeMillis();
		// 输出耗时
		System.out.println("共用时:" + (endTime - beginTime) + "ms");
	}

	/**
	 * 多线程复制
	 */
	public static void multi(String sourceFile , String targetFile) {
		int blockCount = 1;
		// 依次分块进行文件COPY
		for (int i = 0; i < blockCount; i++) {
			// 实例化文件复制对象
			MultiCopyFile copyFile = new MultiCopyFile(sourceFile, targetFile,
					blockCount, i);
			// 实例化线程
			Thread thread = new Thread(copyFile);
			// 开始线程
			thread.start();
			try {
				// 加入线程
				thread.join();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	/**
	 * 单线程复制
	 * @throws IOException 
	 */
	public static void single(String sourceFile , String targetFile) throws IOException {
		OutputStream os = new FileOutputStream(new File(targetFile));
		InputStream is = new FileInputStream(new File(sourceFile));
		int b = -1;
		while((b = is.read()) != -1) {
			os.write(b);
		}
		os.flush();
		os.close();
		is.close();
	}
}
