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
		// ��¼��ʼʱ��
		long beginTime = System.currentTimeMillis();
		single(sourceFile, targetFile);
		// �����ʱ
		long endTime = System.currentTimeMillis();
		// �����ʱ
		System.out.println("����ʱ:" + (endTime - beginTime) + "ms");
	}

	/**
	 * ���̸߳���
	 */
	public static void multi(String sourceFile , String targetFile) {
		int blockCount = 1;
		// ���ηֿ�����ļ�COPY
		for (int i = 0; i < blockCount; i++) {
			// ʵ�����ļ����ƶ���
			MultiCopyFile copyFile = new MultiCopyFile(sourceFile, targetFile,
					blockCount, i);
			// ʵ�����߳�
			Thread thread = new Thread(copyFile);
			// ��ʼ�߳�
			thread.start();
			try {
				// �����߳�
				thread.join();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	/**
	 * ���̸߳���
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
