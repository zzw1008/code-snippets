package zzw.file.study;

import java.io.*;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriterStudy {
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir") + "/file/log.txt";
		File f = new File(path);
		if (!f.exists()) {
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(path, true);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()));
		BufferedWriter bw = new BufferedWriter(fw);

		fw.write(sdf.format(new Date()) + "：运行\r\n");

		bw.close();
		fw.close();

		// 向文件末尾加内容
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(path, true));
			out.write("aString\r\n");
		} catch (IOException e) {
			// error processing code
		} finally {
			if (out != null) {
				out.close();
			}
		}

		/** 使用NIO进行快速的文件拷贝 */
		String path1 = System.getProperty("user.dir") + "/file/log1.txt";
		File f1 = new File(path1);
		fileCopy(f, f1);

		/** 列出目录及文件 */
		String dirname = System.getProperty("user.dir");
		File dir = new File(dirname);
		if (dir.isDirectory()) {
			System.out.println("目录 " + dirname);
			String s[] = dir.list();
			for (int i = 0; i < s.length; i++) {
				File f3 = new File(dirname + "/" + s[i]);
				if (f.isDirectory()) {
					System.out.println(s[i] + " 是一个目录");
				} else {
					System.out.println(s[i] + " 是一个文件");
				}
			}
		} else {
			System.out.println(dirname + " 不是一个目录");
		}
	}

	/** 使用NIO进行快速的文件拷贝 */
	public static void fileCopy(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			// magic number for Windows, 64Mb - 32Kb)
			int maxCount = (64 * 1024 * 1024) - (32 * 1024);
			long size = inChannel.size();
			long position = 0;
			while (position < size) {
				position += inChannel.transferTo(position, maxCount, outChannel);
			}
		} finally {
			if (inChannel != null) {
				inChannel.close();
			}
			if (outChannel != null) {
				outChannel.close();
			}
		}
	}
}
