package com.vtc.gateway.scoinv2api.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Author : Le Quang Dat
 * Email  : quangdat@gmail.com
 * Date   : 24/08/2018
 */
public class DateUtils {
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
  
    public static final String DATE_TIME_JAVA_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";
    
    public static final String DATE_TIME_MYSQL_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    public static final String DATE_MYSQL_FORMAT = "yyyy-MM-dd";
    
    public static final String DATE_DEFAULT_FORMAT = "dd/MM/yyyy";
    
    public static final String DATE_DEFAULT_SCOIN = "yyyyMMdd";
    
    public static final String DATE_ONLY_DAY = "dd";
    
    public static final String DATE_TIME_CODE_SCOIN = "yyyyMMddHHmmss";
    
    public static String toStringFormDate(Date date, String format) {
        if (date == null || StringUtils.isEmpty(format))
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    
    //convert from STRING to DATE and change FORMAT
    public static Date toDateChangeFormatFromStr(String oldDate, String oldFormat, String newformat) {
        Date newDate = toDateFromStr(oldDate, oldFormat);
        String newDateToString =  toStringFormDate(newDate, newformat);
        newDate = toDateFromStr(newDateToString, newformat);
        return newDate;
    }
    
  //convert from DATE to DATE and change FORMAT
    public static Date toDateChangeFormatFromDate(Date oldDate, String newformat) {
        String oldStrDate = toStringFormDate(oldDate, newformat);
        Date newDate = toDateFromStr(oldStrDate, newformat);
        return newDate;
    }
    
    public static Date toDateFromStr(String dateString, String format) {
        DateFormat dateTimeFormat = new SimpleDateFormat(format);
        try {
            Date date = dateTimeFormat.parse(dateString);
            return date;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
    
    public static String toStringCurrentDateTime() {
        Calendar currDate = Calendar.getInstance();
        String dateName = (currDate.get(Calendar.YEAR)) + "-" 
                + (currDate.get(Calendar.MONTH) +1) + "-" 
                + currDate.get(Calendar.DATE) + "/";
        return dateName;
    }
    
    public static Set<String> toStringDaysBetweenTwoDay(Date start, Date end, String fomatDate) {
        
        try {
            Set<String> daysOfBetweenDate = new HashSet<String>();
            LocalDate startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1;
            List<LocalDate> totalDates = LongStream.iterate(0, i -> i + 1).limit(daysBetween)
                    .mapToObj(i -> startDate.plusDays(i)).collect(Collectors.toList());
            totalDates.forEach(totalDate -> {
                DateTimeFormatter formatters = DateTimeFormatter.ofPattern(fomatDate);
                String text = totalDate.format(formatters);
                daysOfBetweenDate.add(text);
            });
            
            return daysOfBetweenDate;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }

    }
    
    public static int compareDayOfMonth(Date dateOne, Date dateTwo) {
        Calendar calOne = Calendar.getInstance();
        Calendar calTwo = Calendar.getInstance();
        calOne.setTime(dateOne);
        calTwo.setTime(dateTwo);
        
        int dayOne = calOne.get(Calendar.DAY_OF_MONTH);
        int dayTwo = calTwo.get(Calendar.DAY_OF_MONTH);
        
        if(dayOne > dayTwo) return 1;
        if(dayOne < dayTwo) return -1;
        return 0;
    }
    
    public static Date startDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 00);

        return cal.getTime();
    }

    public static Date endDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        return cal.getTime();
    }
    
    public static Date getDateUTC() {
        return new Date(new Date().getTime()
                - Calendar.getInstance().getTimeZone().getOffset(new Date().getTime()));
    }
    
    public static Date addDate(Date date, int index) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, index);
        
        return cal.getTime();
    }

}
