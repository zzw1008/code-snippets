package zzw.image.conversion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

/**
 * 图片转换成byte数组然后转换成字符串
 * 字符串转换为byte数组然后转换为图片
 * @author zzw
 *
 */
public class Demo {

	public static void main(String[] args) {
		
		String path2 = System.getProperty("user.dir")+ "\\img";
		File file = new File(path2);
		if(!file.exists ()){
			file.mkdirs ();
		}
		System.out.println(path2);
		/** 图片路径 */
		String path = System.getProperty("user.dir")+"\\img\\vc.png";  
		/** 图片到数组转换 */
		byte[] imgArray = image2byte(path);
		System.out.println(imgArray);
		/** byte数组转换成字符串 */
		String temp = bytesToHexString(imgArray);
		System.out.println(temp);
		
		byte[] tempArray = hexStringToBytes(temp);
		
		
		/** 数组到图片转换 */
		String path1 = System.getProperty("user.dir")+ "\\img\\vc1.png"; 
		byte2image(tempArray,path1);
		System.out.println("done");
	}
	
	/**
	 * 图片转换成byte数组
	 * @param path 图片路径
	 * @return byte数组
	 */
	  public static byte[] image2byte(String path){
	    byte[] data = null;
	    FileImageInputStream input = null;
	    try {
	      input = new FileImageInputStream(new File(path));
	      ByteArrayOutputStream output = new ByteArrayOutputStream();
	      byte[] buf = new byte[1024];
	      int numBytesRead = 0;
	      while ((numBytesRead = input.read(buf)) != -1) {
	      output.write(buf, 0, numBytesRead);
	      }
	      data = output.toByteArray();
	      output.close();
	      input.close();
	    }
	    catch (FileNotFoundException ex1) {
	      ex1.printStackTrace();
	    }
	    catch (IOException ex1) {
	      ex1.printStackTrace();
	    }
	    return data;
	  }
	  
	  /**
	   * byte数组转换成图片
	   * @param data byte数字
	   * @param path 图片路径
	   */
	  public static void byte2image(byte[] data,String path){
	    if(data.length<3||path.equals("")) return;
	    try{
	    FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
	    imageOutput.write(data, 0, data.length);
	    imageOutput.close();
	    System.out.println("Make Picture success,Please find image in " + path);
	    } catch(Exception ex) {
	      System.out.println("Exception: " + ex);
	      ex.printStackTrace();
	    }
	  }
	  
	  /**
	   * byte数组转换成字符串
	   * @param src byte数组
	   * @return 字符串
	   */
	  public static String bytesToHexString(byte[] src){   
		    StringBuilder stringBuilder = new StringBuilder("");   
		    if (src == null || src.length <= 0) {   
		        return null;   
		    }   
		    for (int i = 0; i < src.length; i++) {   
		        int v = src[i] & 0xFF;   
		        String hv = Integer.toHexString(v);   
		        if (hv.length() < 2) {   
		            stringBuilder.append(0);   
		        }   
		        stringBuilder.append(hv);   
		    }   
		    return stringBuilder.toString();   
		}   
	  
	  
	  /**
	   * 字符串转换成byte数组
	   * @param hexString 字符串
	   * @return byte数组
	   */
	  public static byte[] hexStringToBytes(String hexString) {   
		    if (hexString == null || hexString.equals("")) {   
		        return null;   
		    }   
		    hexString = hexString.toUpperCase();   
		    int length = hexString.length() / 2;   
		    char[] hexChars = hexString.toCharArray();   
		    byte[] d = new byte[length];   
		    for (int i = 0; i < length; i++) {   
		        int pos = i * 2;   
		        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));   
		    }   
		    return d;   
		}   
	  private static byte charToByte(char c) {   
		    return (byte) "0123456789ABCDEF".indexOf(c);   
		}  

}
