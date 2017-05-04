package com.yikouliang.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDUtil {
	
	/**
	 * 16位id 时间戳+UUID 
	 */
	public static String getId(){
		return UUIDUtil.strTime()+UUIDUtil.generateShortUuid();
	}
	
	/**
	 * 获取指定数目的 时间戳+UUID
	 * @param number
	 * @return
	 */
	public static String[] getId(int number){
		if(number<1){
			return null;
		}
		String[] ids = new String[number];
		for(int i=0;i<number;i++){
			ids[i] = UUIDUtil.getId();
		}
		return ids;
	}
	
	/**
	 *  时间戳+UUID+文件名
	 */
	public static String getFileId(File file){
		return UUIDUtil.getId()+UUIDUtil.getFileName(file);
	}
	
	/**
	 * 获取文件名
	 */
	public static String getFileName(File file){
		String name = file.getName() .substring(0,file.getName() .lastIndexOf("."));
		return name;
	}
	
	/**
	 * 字符集
	 */
	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",  
        "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",  
        "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
        "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",  
        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
        "W", "X", "Y", "Z" }; 
	
	/**
	 * 时间戳
	 */
	public static String strTime(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	/**
	 * 原始UUID
	 */
	public static String strUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}
	
	 /**
     * 八位数UUID
     * @return
     */
	public static String generateShortUuid() {  
		StringBuffer shortBuffer = new StringBuffer(); 
		//不能静态变量UUID
		String uuid = UUIDUtil.strUUID(); 
		for (int i = 0; i < 8; i++) {  
			//0-4 4-8 8-12 12-16 16-20 20-24 24-28 28-32
		    String str = uuid.substring(i * 4, i * 4 + 4);  
		    //把传入string当成16进制来处理返回一个字符
		    int x = Integer.parseInt(str, 16);  
		    shortBuffer.append(chars[x % 0x3E]);  
		}  
		return shortBuffer.toString();  
	}  
		
	
	/*//Test
	public static void main(String[] args) {
		//System.out.println(id);
		//String name = UUIDUtil.getFileName(new File("test.txt"));
			String[] ids = UUIDUtil.getId(12);
			for(int i=0;i<12;i++){
				System.out.println(ids[i]);
			}
			System.out.println("\n"+UUIDUtil.getId());
		//System.out.println(UUIDUtil.getFileId(new File("tedsast.dsadmp3")));
		
	}*/
	
}
