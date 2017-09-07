package com.xz.spider.bilibili.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileUtil {
	
	//private static final String path = "D:/upload/";
	/**
	 * 生成文件
	 */
	public static void writeFile(String fileName, InputStreamReader in, String path){
		
		/** 读入输入流的数据长度 */
        int chByte = 0;
        
        
        /** 文件输出流 */
        FileOutputStream out = null;
        
        OutputStreamWriter osw = null;
		
		try {
			out = new FileOutputStream(new File(path+fileName));
			
			osw = new OutputStreamWriter(new FileOutputStream(path+fileName));
			
			chByte = in.read();
			
			while (chByte != -1)
			{
			    osw.write(chByte);
			    //System.out.println(chByte);
			    chByte = in.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try
            {
            	osw.close();
                out.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
		}
	}
	
	/** 
     * @功能 读取流 
     * @param inStream 
     * @return 字节数组 
     * @throws Exception 
     */  
    public static byte[] readStream(InputStream inStream) throws Exception {  
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len = -1;  
        while ((len = inStream.read(buffer)) != -1) {  
            outSteam.write(buffer, 0, len);  
        }  
        outSteam.close();  
        inStream.close();  
        return outSteam.toByteArray();  
    } 
}
