package com.epat2.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.epat2.EPAT2Constants;

public class EPAT2Util {

	/** The Logger. */
	
	

    	/**
    	 * This Method is used to get the List from the String
    	 * @param dataList
    	 * @return
    	 */
    	public static String listToString(List<String> dataList){
    		String str = null;
    		if(dataList!=null && dataList.size()>0){
    			StringBuffer sb = new StringBuffer();
    			for(String s:dataList){
    				sb.append(s.trim());
    				sb.append(";");
    			}
    			str = sb.substring(0, sb.length()-1);
    		}
    		return str;
    	}
    	
    	/**
    	 * This Method is used to get the List from the String
    	 * @param dataList
    	 * @return
    	 */
    	public static String deepToString(List dataList){
    		String str = null;
    		if(dataList!=null && dataList.size()>0){
    			StringBuffer sb = new StringBuffer();
    			for(Object s:dataList){
    				sb.append("'"+s+"'");
    				sb.append(",");
    			}
    			str = sb.substring(0, sb.length()-1);
    		}
    		return str;
    	}
    	
    	/**
    	 * This Method is used to Get the Date from String
    	 * @param number
    	 * @return
    	 * @throws ParseException 
    	 */
    	public static Date GetExpirationDate(String number) throws ParseException
    	{		
    		StringTokenizer tokens = new StringTokenizer(number, "_", false);
    		int i = 0;
    		String token = null;
    		while (tokens.hasMoreElements()) {
    		     token = (String)tokens.nextElement();		    
    		     i++;
    		     if(i == 3)
    		    	break;
    		}
    		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy:hh:mm");
    		Date expirationDate = null;
    		expirationDate = dateFormat.parse(token);
    		return expirationDate;
    	}
    	
    	
    	/**
    	 * Thie method takes in a String version of a field that has a format of ccyy-mm-dd-hh:min:ss and converts it to
    	 * a java.util.GregorianCalendar.
    	 */
    	public static GregorianCalendar stringToGregorianCalendar(String aString) {
    		GregorianCalendar aCalendar = null;
    		if (isNotNullAndEmpty(aString)){
    			int year = new Integer(aString.substring(0, 4)).intValue();
    			int month = new Integer(aString.substring(5, 7)).intValue()-1;
    			int dayOfMonth = new Integer(aString.substring(8, 10)).intValue();
    			int hours = new Integer(aString.substring(11, 13)).intValue();
    			int minutes = new Integer(aString.substring(14, 16)).intValue();
    			int seconds = new Integer(aString.substring(17, 19)).intValue();
    			aCalendar = new GregorianCalendar(year, month, dayOfMonth,hours,minutes,seconds);
    		}
    		return aCalendar;
    	}
    	
    	/**
    	 * Thie method takes in a Calendar Object and returns the Gregorian Calendar Object
    	 * a java.util.GregorianCalendar.
    	 */
    	public static GregorianCalendar calendarToGregorianCalendar(Calendar calendar) {
    		GregorianCalendar aCalendar = null;
    		if(calendar!=null){
    			aCalendar = new GregorianCalendar();
    			aCalendar.setTime(calendar.getTime());
    		}
    		return aCalendar;
    	}
        
        
        /**
         * Converts Gregorian Calendar to String
         */
    	
        public static String convertGregorianCalendarToString(GregorianCalendar aCalendar) {
    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy'-'MM'-'dd'-'HH'.'mm'.'ss");
    		String date = null;
        	if (aCalendar != null){
        		date = formatter.format(aCalendar.getTime()) + ".000000";
    		}
    		return date;
    	}
        
        /**
         *  Verify whether the List is null and empty with not empty string
         */
        public static boolean isNotNullAndEmptyAndEmptyString(Set<String> hashSet) {
        	boolean isNotNullAndEmpty = false;
        	if(hashSet!=null && hashSet.size()>0 ){
        		
        		for(String strPin:hashSet){
    				if(!("".equals(strPin.trim())))
    				{
    					isNotNullAndEmpty = true;
    					break;
    				}
    			}
        		
        	}
        	return isNotNullAndEmpty;
        }
        
        /**
         *  Verify whether the List is null and empty 
         */
        public static boolean isNotNullAndEmpty(List list) {
        	return list!=null && list.size()>0;
        }
        
        /**
         *  Verify whether the List is null and empty with not empty string
         */
        public static boolean isNotNullAndEmptyAndEmptyString(List<String> list) {
        	boolean isNotNullAndEmpty = false;
        	if(list!=null && list.size()>0 ){
        		
        		for(String strPin:list){
    				if(!("".equals(strPin.trim())))
    				{
    					isNotNullAndEmpty = true;
    					break;
    				}
    			}
        		
        	}
        	return isNotNullAndEmpty;
        }

        /**
         *  Verify whether the String[] is null and empty 
         */
        public static boolean isNotNullAndEmpty(String[] array) {
        	return array!=null && array.length>0;
        }
        
        /**
         *  Verify whether the String[] is null and empty 
         */
        public static boolean isNotNullAndEmpty(byte[] array) {
        	return array!=null && array.length>0;
        }
        public static boolean isNotNullAndEmpty(Map map) {
        	return (map!=null && !map.isEmpty());
        }
        /**
         *  Verify whether the Object is null and empty 
         */
        public static boolean isNotNullAndEmpty(Object obj) {
        	return (obj!=null && !obj.equals(""));
        }
        
        /**
         *  Verify whether the Object is null and empty 
         */
        public static boolean isNull(Object obj) {
        	return (obj==null);
        }
        
        /**
         *  Verify whether the String is null and empty 
         */
        public static boolean isNotNullAndEmpty(Character obj) {
        	return obj!=null && !("".equals(obj) && !("null".equals(obj)));
        }
        
        /**
         *  Verify whether the String is null and empty 
         */
        public static boolean isNotNullAndEmpty(String str) {
        	return str!=null && !("".equals(str.trim())) && !("null".equals(str.trim()));
        }
        
        /**
         *  converts String Array to List
         */
        
        public static List<String> stringArrayToList(String[] array){
        	List<String> stringList = new ArrayList<String>();
        	if(isNotNullAndEmpty(array)){
        		for(String s : array){
        			stringList.add(s);	
        		}
        	}
        	return stringList;
        }
        
        public static List<Integer> commaSeparatedStringToIntegerList(String str){
        	List<Integer> intList =new ArrayList<Integer>();
			 for (String id:str.split(","))
				 intList.add(new Integer(id));
        	return intList;
        }
        
        /**
         * This Method is used to retun String[] from String
         * @param str
         * @return
         */
        public static String[] stringToStringArray(String str){
        	return isNotNullAndEmpty(str) ? str.split(",") : null;
        }
        
        /**
         * This Method is used to return string from String[]
         * @param strArray
         * @return
         */
        
        public static String stringArrayToString(String[] strArray){
        	return (strArray!=null ? Arrays.deepToString(strArray) : null);
        }
        
        /**
         * This Method is used to 
         * @param strArray
         * @return
         */
        public static String stringArrayToUpperString(String[] strArray){
        	String str = null;
        	if(strArray!=null){
        		StringBuffer sb = new StringBuffer();
        		for(String s : strArray){
        			sb.append("'"+s.toUpperCase()+"',");
        		}
        		str = sb.substring(0, sb.length()-1);
        	}
        	return str;
        }
        
        /**
         * This Method is used to 
         * @param IntegerArray
         * @return
         */
        public static String integerArrayToString(Integer[] integerArray){
        	String str = null;
        	if(EPAT2Util.isNotNullAndEmpty(integerArray)){
        		StringBuffer sb = new StringBuffer();
        		for(Integer i : integerArray){
        			sb.append(i+",");
        		}
        		str = sb.substring(0, sb.length()-1);
        	}
        	return str;
        }
        
        /**
         * This Method is used to 
         * @param IntegerArray
         * @return
         */
        public static String integerListToString(List<Integer> integerlst){
        	String str = null;
        	if(EPAT2Util.isNotNullAndEmpty(integerlst)){
        		StringBuffer sb = new StringBuffer();
        		for(Integer i : integerlst){
        			sb.append(i+",");
        		}
        		str = sb.substring(0, sb.length()-1);
        	}
        	return str;
        }

        
    	public static Calendar getCurrentTime() {
    		Calendar currentTS = Calendar.getInstance();
    		return currentTS;
    	}
    	
    	
    	/**
    	 * This method takes in a GregorianCalendar and creates a  String version of a field
    	 * that has a Oracle column type of Timestamp. 
    	 */
    	public static String FormatDateTime(Calendar aCalendar) {
    		String date = null;
    		if (isNotNullAndEmpty(aCalendar)){
    			//Verify the hour and set it to 12 Hr Format 
    			int hours = aCalendar.get(Calendar.HOUR_OF_DAY);
    			String AM_PM = " AM";
    			if(hours>12){
    				aCalendar.set(Calendar.HOUR_OF_DAY, hours-12);
    				AM_PM = " PM";
    			}
    			if(hours<1){
    				aCalendar.set(Calendar.HOUR_OF_DAY, 1);
    			}
    			java.text.SimpleDateFormat formatter =
    				new java.text.SimpleDateFormat("dd'-'MMM'-'yyyy' 'HH'.'mm");
    			date = formatter.format(aCalendar.getTime())+AM_PM;
    		}
    		return date;
    	}
    	
    	/**
    	 * This method takes in a GregorianCalendar and creates a  String version of a field
    	 * that has a Oracle column type of Timestamp. 
    	 */
    	public static String FormatDateTime(Calendar aCalendar,int offSet) {
    		String date = null;
    		if (isNotNullAndEmpty(aCalendar)){
    			//Verify the hour and set it to 12 Hr Format 
    			int hours = aCalendar.get(Calendar.HOUR_OF_DAY);
    			String AM_PM = " AM";
    			if(hours>12){
    				aCalendar.set(Calendar.HOUR_OF_DAY, hours-12);
    				AM_PM = " PM";
    			}
    			if(hours<1){
    				aCalendar.set(Calendar.HOUR_OF_DAY, 1);
    			}
    			java.text.SimpleDateFormat formatter =
    				new java.text.SimpleDateFormat("dd'-'MMM'-'yyyy'-'HH'.'mm'.'ss'.'SS");
    			aCalendar.set(Calendar.MILLISECOND, (aCalendar.get(Calendar.MILLISECOND)+offSet));
    			date = formatter.format(aCalendar.getTime())+AM_PM;
    		}
    		return date;
    	}
    	
        /**
         * Method is used to pad spaces for the string
         * 
         * @param stringValue
         * @param totalLength
         * @return String
         */
        public static String padRight(String stringValue, int totalLength) {
        	StringBuffer tempString = null;
        	if(isNotNullAndEmpty(stringValue)){
        		tempString = new StringBuffer(stringValue.trim());
                while (tempString.length() < totalLength) {
                    tempString.insert(tempString.length(), " ");
                }
        	}
            return isNotNullAndEmpty(tempString)?tempString.toString():null; 
        }
        
        /**
         * Method is used to pad spaces for the string
         * 
         * @param stringValue
         * @param totalLength
         * @return String
         */
        public static String[] padRight(String[] stringArray, int totalLength) {
        	StringBuffer tempString = null;
        	String[] paddedArray = null;
        	String stringValue;
        	if(isNotNullAndEmpty(stringArray)){
        		paddedArray = new String[stringArray.length];
        		for(int i = 0; i< stringArray.length ; i++){
        			stringValue = stringArray[i];
            		tempString = new StringBuffer(stringValue.trim());
                    while (tempString.length() < totalLength) {
                        tempString.insert(tempString.length(), " ");
                    }
                    paddedArray[i] = tempString.toString();
        		}
        	}
            return paddedArray; 
        }
        
    	/**
    	 * This method takes in a Calendar and creates a  String version of a field
    	 */
    	public static String FormatDateCCYYMMDD(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}
    	
    	/**
    	 * This method takes in a Calendar and creates a  String version of a field
    	 */
    	public static String FormatDateDDMMCCYY(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("ddMMyyyy");
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}
    	
    	public static String FormatDateYYYYMMDD(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd");
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}
    	/**
    	 * This method takes in a Calendar and creates a  String version of a field
    	 */
    	public static String FormatDateCCYYMMDDHHMMSS(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}
    	
    	/**
    	 * This method takes in a Calendar and creates a  String version of a field
    	 */
    	public static String FormatDateCCYYMMDDHHMMSSsss(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}
    	
    	public static String FormatDateCCYYMMDDHHMMSSsssz(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
    		formatter.setTimeZone(TimeZone.getTimeZone(EPAT2Constants.CST));
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}
    	
    	/**
    	 * This method takes in a Calendar and creates a  String version of a field
    	 */
    	public static String FormatDateDDMMYYHHMMSS(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}
    	
    	/**
    	 * This method takes in a Calendar and creates a  String version of a field
    	 */
    	public static String FormatDateDDMMYYHHMMSSAMPMUTC(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss aaa");
    		formatter.setTimeZone(TimeZone.getTimeZone(EPAT2Constants.UTC));
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}
    	
    	/**
    	 * This method takes in a Calendar and creates a  String version of a field
    	 */
    	public static String FormatDateDDMMMYYHHMMSSAMPM(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH.mm.ss");
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}

    	/**
    	 * This method takes in a Calendar and creates a  String version of a field
    	 */
    	public static String FormatDateDDMMYYYYHHMMSS(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}
    	
    	/**
    	 * This method takes in a Calendar and creates a  String version of a field
    	 */
    	public static String FormatDateMMDDYYYYHHMMSS(Calendar aCalendar) {
    		java.text.SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy:HH:mm:ss");
    		String formattedDate = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			formattedDate = formatter.format(aCalendar.getTime());
    		}
    		return formattedDate;
    	}
    	
    	/**
    	 * This method takes in a Calendar and creates a  String version of a field
    	 */
    	public static Date getDate(String dateStr) throws ParseException {
    		Date date = null;
    		if(EPAT2Util.isNotNullAndEmpty(dateStr)){
    			java.text.SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy:HH:mm:ss");
    			date = formatter.parse(dateStr);
    		}
    		return date;
    	}
    	public static String FormatDateAsCST(Calendar aCalendar) {
    		String CSTTimestamp = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			CSTTimestamp=EPAT2Util.FormatDateCCYYMMDDHHMMSSsssz(aCalendar);
    		}
    		return CSTTimestamp;
    	}
    	public static String FormatDate(Calendar aCalendar) {
    		String CSTTimestamp = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			CSTTimestamp=EPAT2Util.FormatDateCCYYMMDDHHMMSSsss(aCalendar);
    		}
    		return CSTTimestamp;
    	}
    	
    	public static String FormatDateDDMMYYHHMMSSCST(Calendar aCalendar) {
    		String CSTTimestamp = "";
    		if(EPAT2Util.isNotNullAndEmpty(aCalendar)){
    			String UTCTimestamp=EPAT2Util.FormatDateCCYYMMDDHHMMSSsss(aCalendar);
    			CSTTimestamp=convert_TIMEZONE(UTCTimestamp,EPAT2Constants.CST);
    		}
    		return CSTTimestamp;
    	}

    	public static boolean isValidEmailAddress(String emailAddress){
    		if(isNotNullAndEmpty(emailAddress)&&(emailAddress.indexOf("_")==0 || emailAddress.indexOf(".")==0)){
    			return false;
    		}
    	   /*String  expression= "^([A-Za-z0-9_\\.])+@([A-Za-z0-9_\\.])+\\.([A-Za-z]{2,4})$";*/
    	   // Modified regular expression to allow hypen 
    	   String  expression= "^([A-Za-z0-9_\\.])+([A-Za-z0-9_\\-\\.])*@([A-Za-z0-9_\\.])+([A-Za-z0-9_\\-\\.])*\\.([A-Za-z]{2,4})$";
    	   CharSequence inputStr = emailAddress; 
    	   Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
    	   Matcher matcher = pattern.matcher(inputStr);
    	   return matcher.matches();
    	}
    	
    	/**
    	 * This method will return scheduled Timestamp when timer task should run.
    	 * @param  calendar : java.util.Calendar, String, String, String
    	 * @return calendar 
    	 */
    	public static Calendar GetTimerTaskScheduleTimestamp(Calendar calendar, String scheduledHours, String scheduledMinutes, String scheduledSeconds){
    		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(scheduledHours));
    		calendar.set(Calendar.MINUTE, Integer.parseInt(scheduledMinutes));
    		calendar.set(Calendar.SECOND, Integer.parseInt(scheduledSeconds));
    		//We are not considering the granularity of time upto MilliSeconds so set it to '0'(Zero)
    		calendar.set(Calendar.MILLISECOND, 0);		
    		return calendar;
    	}	
    	
    	public static int getMonths(Calendar currentDate, Calendar pastDate) {
    		int months = 0;
    		if(EPAT2Util.isNotNullAndEmpty(currentDate) && EPAT2Util.isNotNullAndEmpty(pastDate)){
    			 int years = currentDate.get(Calendar.YEAR) - pastDate.get(Calendar.YEAR);
    			 int extraDays = currentDate.get(Calendar.DAY_OF_MONTH) + 1 + pastDate.getActualMaximum(Calendar.DAY_OF_MONTH) - pastDate.get(Calendar.DAY_OF_MONTH);
    			 months = (years - 1) * 12 + ( currentDate.get(Calendar.MONTH)) + (11 - pastDate.get(Calendar.MONTH)) + (extraDays/30);
    			 
    		}
    		return months;
    	}
    	
    	/**
    	 * This Method is used to truncate the msgGUID
    	 * @param fileName
    	 * @return
    	 */
    	public static String truncateGUID(String fileName) {
    		 int index = fileName.indexOf("-");
    		 if(index!=-1){
    			 fileName = fileName.substring(index+1, fileName.length());
    		 }
    		 return fileName;
    	}

    	public static String getStackTrace(Throwable e){
    		StringWriter stackTrace = new StringWriter();
    		e.printStackTrace(new PrintWriter(stackTrace));
    		String formattedString = stackTrace.toString();
    		formattedString = formattedString.replace("\\", "&#92;").replace("$", "\\$").replace("\r", "<br>").replace("\n", "<br>");
    		return formattedString;
    	}
    	  public static String stringToHTMLString(String string) {
    	        StringBuffer sb = new StringBuffer(string.length());
    	        // true if last char was blank
    	        boolean lastWasBlankChar = false;
    	        int len = string.length();
    	        char c;
    	        for (int i = 0; i < len; i++) {
    	            c = string.charAt(i);
    	            if (c == ' ') {
    	                // blank gets extra work,
    	                // this solves the problem you get if you replace all
    	                // blanks with &nbsp;, if you do that you loss
    	                // word breaking
    	                if (lastWasBlankChar) {
    	                    lastWasBlankChar = false;
    	                    sb.append("&nbsp;");
    	                } else {
    	                    lastWasBlankChar = true;
    	                    sb.append(' ');
    	                }
    	            } else {
    	                lastWasBlankChar = false;
    	                //
    	                // HTML Special Chars
    	                if (c == '"')
    	                    sb.append("&quot;");
    	                else if (c == '&')
    	                    sb.append("&amp;");
    	                else if (c == '<')
    	                    sb.append("&lt;");
    	                else if (c == '>')
    	                    sb.append("&gt;");
    	                else {
    	                    int ci = 0xffff & c;
    	                    if (ci < 160)
    	                        // nothing special only 7 Bit
    	                        sb.append(c);
    	                    else {
    	                        // Not 7 Bit use the unicode system
    	                        sb.append("&#");
    	                        sb.append(new Integer(ci).toString());
    	                        sb.append(';');
    	                    }
    	                }
    	            }
    	        }
    	        return sb.toString();
    	    }
    	  
    	   public static String formatXML(String xml) {
    	        StringWriter stringWriter = new StringWriter();
    	        String newXml = xml.replaceAll("\n", "\r");
    	        try {
    	            Transformer t = TransformerFactory.newInstance().newTransformer();
    	            t.setOutputProperty(OutputKeys.INDENT, "yes");
    	            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    	            StreamResult result = new StreamResult(stringWriter);
    	            t.transform(new StreamSource(new StringReader(newXml)), result);
    	            return result.getWriter().toString();
    	        } catch (Exception ex) {
    	            return xml;
    	        }
    	    }
    	   /**
    	    * This method is used to convert retrived UTC timestamp from DB to CST format  
    	    * @param UTCtimestamp
    	    * @param timezone
    	    * @return
    	    */
    	   public static String convert_TIMEZONE(String UTCtimestamp,String timezone) {
    		   int year = new Integer(UTCtimestamp.substring(0, 4)).intValue();
    		   int month = new Integer(UTCtimestamp.substring(5, 7)).intValue();
    		   int day = new Integer(UTCtimestamp.substring(8, 10)).intValue();
    		   int hour = new Integer(UTCtimestamp.substring(11, 13)).intValue();
    		   int min = new Integer(UTCtimestamp.substring(14, 16)).intValue();
    		   int sec = new Integer(UTCtimestamp.substring(17, 19)).intValue();

    		   //create with the above a calendar in UTC
    		   TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    		   Calendar calUTC = Calendar.getInstance();
    		   calUTC.clear();
    		   calUTC.set(year, month-1, day, hour, min, sec );

    		   //prepare the formatter for the specified timezone
    		   DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
    		   TimeZone tz = TimeZone.getTimeZone(timezone);
    		   formatter.setTimeZone(tz);
    		   String CSTTimestamp=formatter.format(calUTC.getTime());
    		   TimeZone.setDefault(null);
    		   // return the new value
    		   return CSTTimestamp;
    	   }

    	   /**
    	     * Method implimentation by DP23230
    	     * This method will search for a specific string in a String Array
    	     * @param srcArray
    	     * @param str
    	     * @return
    	     */
    	    public static boolean isStringPresentInArray(String[] srcArray,String str) {
    	    	Arrays.sort(srcArray) ;
    	    	 int indexValue = Arrays.binarySearch(srcArray, str);
    	    	 if(indexValue >= 0) {
    	    		 return true;
    	    	 } else {
    	    		 return false ;
    	    	 }
    	    }
    	    
    	    /**
             * This method takes in a String and trim it
             */
            public static String trimString(String strObj) {
                    String str=null;
                    if(isNotNullAndEmpty(strObj)){
                            str=strObj.trim();
                    }
                    return str;
            }
           
            
        	
        	
        	public static List<String> parseTextFile(InputStream inputStream){
        		List<String> elementList = new ArrayList<String>(); 
        		Scanner scanner = new Scanner(inputStream);
        		while(scanner.hasNextLine()){			
        			elementList.add(scanner.nextLine());			
        		}
        		scanner.close();
        		return elementList;
        	}

        	

        	public static Double convertStringToDouble(String numberString) {
				if(numberString!=null)
					return Double.parseDouble(numberString);
				return null;
			}
        	
        	public static double roundValue(double value, int uptoDecimalPlaces){
            	double p = (double)Math.pow(10,uptoDecimalPlaces);
            	value = value * p;
        		  double tmp = Math.round(value);
        		  return (double)tmp/p;
            }
        	
        	public static String getDefaultStringValue(Object obj){
                if (obj == null)
                    return EPAT2Constants.EMPTY;
                
                return obj.toString().trim() ;
            }
        	
        	
}
