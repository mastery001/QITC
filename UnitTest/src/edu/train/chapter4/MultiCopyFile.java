package edu.train.chapter4;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class MultiCopyFile implements Runnable {

	// ��Դ�ļ�
	private String sourceFileName;
	// Ŀ���ļ�
	private String targetFileName;
	// �ֿ�����
	private int blockCount;
	// ��ʼCOPY�Ŀ����
	private int blockNo;
	// �����С
	private int maxBuffSize = 1024;

	public MultiCopyFile(String sourceFileName, String targetFileName,
			int blockCount, int blockNo) {
		this.sourceFileName = sourceFileName;
		this.targetFileName = targetFileName;
		this.blockCount = blockCount;
		this.blockNo = blockNo;
	}

	public void run() {
		// �õ���Դ�ļ�
		File file = new File(sourceFileName);
		// �õ���Դ�ļ��Ĵ�С
		long size = file.length();
		// �����ļ���С���ֿ��������������Ĵ�С
		long blockLenth = size / blockCount;
		// �����ǰ��ʼCOPY��λ��
		long startPosition = blockLenth * blockNo;
		// ʵ��������
		byte[] buff = new byte[maxBuffSize];
		try {
			// ��Դ�ļ��õ�������
			InputStream inputStream = new FileInputStream(sourceFileName);
			// �õ�Ŀ���ļ���������ʶ���
			RandomAccessFile raf = new RandomAccessFile(targetFileName, "rwd");
			// ��Ŀ���ļ���ָ��ƫ������ʼλ��
			raf.seek(startPosition);
			// ��ǰ��ȡ���ֽ���
			int curRedLength;
			// �ۼƶ�ȡ�ֽ����ĺ�
			int totalRedLength = 0;
			// ����Դ�ļ���ָ��ƫ������ʼλ��
			inputStream.skip(startPosition);
			// ���ηֿ��ȡ�ļ�
			while ((curRedLength = inputStream.read(buff)) > 0
					&& totalRedLength < blockLenth) {
				// �������е��ֽ�д���ļ�?Ŀ���ļ���
				raf.write(buff, 0, curRedLength);
				// �ۼƶ�ȡ���ֽ���
				totalRedLength += curRedLength;
			}
			// �ر������Դ
			raf.close();
			inputStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
