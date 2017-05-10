package com.vnet.sms.common.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DateUtil {

	private static DateUtil dateUtil = null;
    public static DateUtil getInstance() {

        if (dateUtil == null) {
        	dateUtil = new DateUtil();
        }
        return dateUtil;
    }
    public static final int JANUARY = 0, FEBRUARY = 1, MARCH = 2, APRIL = 3,
            MAY = 4, JUNE = 5, JULY = 6, AUGUST = 7, SEPTEMBER = 8,
            OCTOBER = 9, NOVEMBER = 10, DECEMBER = 11;

    public DateUtil() {
    }

    public int getCallTimeTotal(String callDuration) {
        String[] time = callDuration.split(":");
        int total = 0;
        if (time != null && time.length == 3) {
            int hour = Integer.parseInt(time[0].trim());
            int minute = Integer.parseInt(time[1].trim());
            int second = Integer.parseInt(time[2].trim());
            total = hour * 60 * 60 + minute * 60 + second;
        }
        return total;
    }

    public String getDate(Calendar cal) {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dayFormat.format(cal.getTime());
    }

    public Date getFirstDayForSMSSent(Date d) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date dddd = calendar.getTime();
        // SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dddd;
    }

    public String getFirstDay(Date d) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date dddd = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf1.format(dddd);
    }

    public HashMap<String, String> getDateList(String endTime) {
        Calendar cal = getCalendar(endTime);
        HashMap<String, String> dateHM = new HashMap<String, String>();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 01);

        String startW1 = getDate(cal);
        cal.add(Calendar.DATE, 7);
        String startW2 = getDate(cal);
        cal.add(Calendar.DATE, 7);
        String startW3 = getDate(cal);
        cal.add(Calendar.DATE, 7);
        String startW4 = getDate(cal);
        cal.add(Calendar.DATE, 6);
        String endW4 = getDate(cal);
        dateHM.put("startW1", startW1);
        dateHM.put("startW2", startW2);
        dateHM.put("startW3", startW3);
        dateHM.put("startW4", startW4);
        dateHM.put("endW4", endW4);

        return dateHM;
    }

    public String getTotalTimeCall(int total) {
        String hour = "" + total / 60 * 60;
        if (hour.length() < 2) {
            hour = 0 + "" + hour;

        }
        String minute = "" + (total % (60 * 60)) / 60;
        if (minute.length() < 2) {
            minute = 0 + "" + minute;

        }
        String second = "" + (total % (60 * 60)) % 60;
        if (second.length() < 2) {
            second = 0 + "" + second;

        }

        String totalTime = hour + ":" + minute + ":" + second;
        return totalTime;
    }

    public Calendar getCalendar(String time) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");

        // SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
        Date startTimeDate;
        try {
            startTimeDate = simpleDate.parse(time);
            cal.setTime(startTimeDate);
        } catch (ParseException e) {
            simpleDate = new SimpleDateFormat("dd/MM/yyyy");
            try {
                startTimeDate = simpleDate.parse(time);
                cal.setTime(startTimeDate);
            } catch (ParseException e1) {
            }
        }
        return cal;
    }

    public String getTime(String time) {
        String timeFormat = "";
        for (String s : time.split(":")) {
            timeFormat += s;
        }
        return timeFormat;
    }

    public Date getFirstDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, 2);
        return calendar.getTime();
    }

    public String getDate(String date) {
        String dateFormat = "";
        for (String s : date.split("-")) {
            dateFormat += s;
        }
        return dateFormat;
    }

    public long getSecondDuration(int weekly) {
        return weekly * 24 * 60 * 60;
    }

    public long getMinuteDuration(int weekly) {
        return weekly * 24 * 60;
    }

    public String getFormatDate1(String dateTime) {
        String date = "";
        String[] s = dateTime.split(" ");
        if (s.length > 1) {
            date = getDate(s[0]) + getTime(s[1]);
        }
        return date;

    }

    public String getCurrentDate1() {
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calen = Calendar.getInstance();
        String str = simpleDate.format(calen.getTime());

        return str;
    }
    
    public String getCurrentDate() {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calen = Calendar.getInstance();
        String str = simpleDate.format(calen.getTime());
        return str;
    }
 
    public Date getFormatDate(String date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date startTimeDate = null;
        try {
            startTimeDate = simpleDate.parse(getCurrentDate());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return startTimeDate;
    }
    
    public Date getFormatDateYYYYMMDD(String stringDate) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        Date startTimeDate = null;
        
//        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String str = dayFormat.format(date);
        try {
            startTimeDate = simpleDate.parse(stringDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return startTimeDate;
    }

    public Date getFormatDateForView(String date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        Date startTimeDate = null;
        try {
            if (date != null && date.split(".").length > 0) {
                date = date.split(".")[0];
            }
            // System.out.println("date:::" + date);
            startTimeDate = simpleDate.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return startTimeDate;
    }

    public String getDateFormatForCount(String date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
        Date newDate = null;
        try {
            newDate = simpleDate.parse(date);
        } catch (ParseException e) {
            simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                newDate = simpleDate.parse(date);
            } catch (ParseException e1) {
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = dayFormat.format(calendar.getTime());
        return str;
    }

    public String getDateFormatForView(String date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
        Date newDate = null;
        try {
            newDate = simpleDate.parse(date);
        } catch (ParseException e) {
            simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                newDate = simpleDate.parse(date);
            } catch (ParseException e1) {
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String str = dayFormat.format(calendar.getTime());
        return str;
    }

    public String getddMMYY(String date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
        Date newDate = null;
        try {
            newDate = simpleDate.parse(date);
        } catch (ParseException e) {
            simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                newDate = simpleDate.parse(date);
            } catch (ParseException e1) {
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd-MM-yyyy");
        String str = dayFormat.format(calendar.getTime());
        return str;
    }

    public String getddMMYY1(String date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("MM/dd/yyyy");
        Date newDate = null;
        if (date == null || "".equals(date.trim())) {
            return "";
        }
        try {
            newDate = simpleDate.parse(date);
        } catch (ParseException e) {
            simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                newDate = simpleDate.parse(date);
            } catch (ParseException e1) {
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str = dayFormat.format(calendar.getTime());
        return str;
    }

    public String getyyyyMMdd(String date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("MM/dd/yyyy");
        Date newDate = null;
        if (date == null || "".equals(date.trim())) {
            return "";
        }
        try {
            newDate = simpleDate.parse(date);
        } catch (ParseException e) {
            simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                newDate = simpleDate.parse(date);
            } catch (ParseException e1) {
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = dayFormat.format(calendar.getTime());
        return str;
    }

    public String getDateFormat(String date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss");
        Date newDate = null;
        try {
            newDate = simpleDate.parse(date);
        } catch (ParseException e) {
            simpleDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            try {
                newDate = simpleDate.parse(date);
            } catch (ParseException e1) {
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String str = dayFormat.format(calendar.getTime());
        return str;
    }

    public String getStringDate(Date strDate) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strDate);
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String str = dayFormat.format(calendar.getTime());
        return str;
    }
    
    public String getStringDate1(Date strDate) {
        if(strDate!=null){
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(strDate);
	        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String str = dayFormat.format(calendar.getTime());
	        return str;
        }else{
        	return "";
        }
        
    }
    
    public String getCurrentDate2() {
        SimpleDateFormat simpleDate = new SimpleDateFormat(
                "dd/MM/yyyy");
        Calendar calen = Calendar.getInstance();
        // SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str = simpleDate.format(calen.getTime());
        // Date currentdate = null;
        // try {
        // currentdate = simpleDate.parse(str);
        // } catch (ParseException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        return str;
    }

    public String[] getSortArray(String[] array) {
        String temp = "0";
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Integer.parseInt(array[i]) >= Integer.parseInt(array[j])) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

        }
        return array;
    }

    public String getddMMMyy() {
        Format formatter = new SimpleDateFormat("dd-MMM-yy");
        String s = formatter.format(new Date());
        return s;
    }

    public static String getddMMMyy(String date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("MM/dd/yy");
        Date newDate = null;
        try {
            newDate = simpleDate.parse(date);
        } catch (ParseException e) {
            simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                newDate = simpleDate.parse(date);
            } catch (ParseException e1) {
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd-MMM-yy");
        String str = dayFormat.format(calendar.getTime());
        return str;
    }

    public long getSecondDifference(Date d1, Date d2) {
        long diff = 0;
        long diffMinutes = 0;
        try {
            diff = d2.getTime() - d1.getTime();
            diffMinutes = diff / (60 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return diffMinutes;
    }

    public boolean isLeapYear(int year) {
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0)
                || (year % 400 == 0);
        return isLeapYear;
    }

    public int getDaysInMonth(int monthNumber, int year) {
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0)
                || (year % 400 == 0);
        if (monthNumber < JANUARY || monthNumber > DECEMBER) {
            return 0;
        }
        switch (monthNumber) {
            case FEBRUARY:
                return isLeapYear ? 29 : 28;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:// intentional fall-through
                return 30;
            default:
                return 31;
        }// end switch
    }// end method days in month

    public static void main(String[] args) {
//        DateUtil test = new DateUtil();
//        Date date1 = new Date();
//        int k = (int) (date1.getTime() / 1000);
//        System.out.println("date to in = :" + k);
//        String dateAsText = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//                .format(new Date(k * 1000L));
//        System.out.println("INT TO DATE:==" + dateAsText);
//
//        String dateTest = "2013-11-18 17:23:30";
//        Date date = test.getFormatDate(dateTest);
//        System.out.println("date==" + date);
//        System.out.println("date to int==" + (int) (date.getTime() / 1000));
        Format formatter = new SimpleDateFormat("dd-MMM-yy");
        String s = formatter.format(new Date());
        String a = "abc";
        String b = "ab";
//        System.out.println("get day " + getddMMMyy("12/03/2013"));
       // System.out.println(a.compareTo(b));
       // System.out.println("new date s1::"+ DateUtil.getInstance().getFormatDate("11/6/14"));
        
        String test ="RTE.CSC.NULL" +
        		"ATTEMPT SEIZURE   ALERT  ANSWER CALL_FW TRAFFIC HOLDTIM ALT (%) ANS (%) CUR" +
        		"WRONGNO CALLREJ ABS_SUB RSCFAIL TERBUSY  NO_ANS ORG_REL MNP_REL CIR_UAV SWCCONG" +
        		"NETFAIL MNP_MIS NOR_UNS  OVERLD TMP_FAI PRO_ERR BEA_ERR SVC_ERR ETC_ERR" +
        		"DRP_MGW DRP_MSV DRP_ETC" +
        		"<<CALL SERVICE CONVERSION>>" +
        		"TYPE MNP_ATT MNP_SUC MNP_CON MNP_FAI TIMEOUT" +
        		"CALL_TYPE = MM";
        if(test.startsWith("ITEM.CSC.NULL")){
        	System.out.println("test11=="+test);
        }
    }
}