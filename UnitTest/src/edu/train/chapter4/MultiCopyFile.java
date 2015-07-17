package edu.train.chapter4;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class MultiCopyFile implements Runnable {

	// 来源文件
	private String sourceFileName;
	// 目标文件
	private String targetFileName;
	// 分块总数
	private int blockCount;
	// 开始COPY的块序号
	private int blockNo;
	// 缓存大小
	private int maxBuffSize = 1024;

	public MultiCopyFile(String sourceFileName, String targetFileName,
			int blockCount, int blockNo) {
		this.sourceFileName = sourceFileName;
		this.targetFileName = targetFileName;
		this.blockCount = blockCount;
		this.blockNo = blockNo;
	}

	public void run() {
		// 得到来源文件
		File file = new File(sourceFileName);
		// 得到来源文件的大小
		long size = file.length();
		// 根据文件大小及分块总数算出单个块的大小
		long blockLenth = size / blockCount;
		// 算出当前开始COPY的位置
		long startPosition = blockLenth * blockNo;
		// 实例化缓存
		byte[] buff = new byte[maxBuffSize];
		try {
			// 从源文件得到输入流
			InputStream inputStream = new FileInputStream(sourceFileName);
			// 得到目标文件的随机访问对象
			RandomAccessFile raf = new RandomAccessFile(targetFileName, "rwd");
			// 将目标文件的指针偏移至开始位置
			raf.seek(startPosition);
			// 当前读取的字节数
			int curRedLength;
			// 累计读取字节数的和
			int totalRedLength = 0;
			// 将来源文件的指针偏移至开始位置
			inputStream.skip(startPosition);
			// 依次分块读取文件
			while ((curRedLength = inputStream.read(buff)) > 0
					&& totalRedLength < blockLenth) {
				// 将缓存中的字节写入文件?目标文件中
				raf.write(buff, 0, curRedLength);
				// 累计读取的字节数
				totalRedLength += curRedLength;
			}
			// 关闭相关资源
			raf.close();
			inputStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
