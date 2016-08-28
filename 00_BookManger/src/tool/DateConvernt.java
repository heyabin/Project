package tool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.SimpleAttributeSet;

/**
 * ��yyyy-MM-dd��ʽ���ַ���ת��Ϊ����
 * @param dateStr
 * @return
 */


public class DateConvernt {
	
	public static String getNowDateStr(String pattern){
		Date nowDate = new Date();
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(nowDate);
	}
	
	public static Date ConvertToDate(String str){
		Date date = null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = format.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		return date; 
		
	}
	public static Date ConvertToDate(String str,String pattern){
		Date date = null;
		DateFormat format = new SimpleDateFormat(pattern);
			try {
				date = format.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		return date; 
		
	}
	/**
	 * ������ת��Ϊyyyy-MM-dd��ʽ���ַ���
	 * @param date
	 * @return
	 */
	public static String ConvertToString (Date date){
		String str = null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 str =	format.format(date);
		return str;
		
	}
	/**
	 * ������ת��Ϊpattern��ʽ���ַ���
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String ConvertToString (Date date,String pattern){
		String str = null;
		DateFormat format = new SimpleDateFormat( pattern);
		 str =	format.format(date);
		return str;
		
	}
}

