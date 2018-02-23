package xin.iffun.util;


import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2017/6/21
 * Time: 15:28
 */
public class DateUtils {

    /**
     * 年-月-日 时:分:秒 显示格式
     */
    // 备注:如果使用大写HH标识使用24小时显示格式,如果使用小写hh就表示使用12小时制格式。
    public static String DATE_TO_STRING_DETAIAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年-月-日 显示格式
     */
    public static String DATE_TO_STRING_SHORT_PATTERN = "yyyy-MM-dd";


    public static String DATEFORMATSTR_DAY = "yyyy-MM-dd";
    public static String DATEFORMATSTR_MINUTE = "yyyy-MM-dd HH:mm:ss";


    /**
     * unix时间戳转为指定格式的String类型
     * <p>
     * <p>
     * System.currentTimeMillis()获得的是是从1970年1月1日开始所经过的毫秒数
     * unix时间戳:是从1970年1月1日（UTC/GMT的午夜）开始所经过的秒数,不考虑闰秒
     *
     * @param source
     * @param pattern
     * @return
     */
    public static String timeStampToString(long source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date(source * 1000);
        return simpleDateFormat.format(date);
    }


    /**
     * 字符串转换为对应日期(可能会报错异常)
     *
     * @param source
     * @param pattern
     * @return
     */
    public static Date stringToDate(String source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获得当前时间对应的指定格式
     *
     * @param pattern
     * @return
     */
    public static String currentFormatDate(String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());

    }



    /**
     * 获取当前时间
     * @return
     */
    public static Date getCurrentDate(){
        return new Date();
    }
    /**
     * 获取当前时间
     * @return
     */
    public static Date getTotayDate4Zero(){
        String yestdayStr = DateToString(new Date(System.currentTimeMillis()), DATE_TO_STRING_SHORT_PATTERN);
        return stringToDate(yestdayStr, DATE_TO_STRING_SHORT_PATTERN);
    }


    /**
     * 获取昨天 0 点的时间
     */
    public static Date getYestdayDateStart(){
        String yestdayStr = DateToString( new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000), DATE_TO_STRING_SHORT_PATTERN);
        return stringToDate(yestdayStr, DATE_TO_STRING_SHORT_PATTERN);
    }
    /**
     * 获取昨天 23:59:59 的时间
     */
    public static Date getYestdayDateEnd(){
        String yestdayStr = DateToString(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000), DATE_TO_STRING_SHORT_PATTERN);
        yestdayStr += " 23:59:59 ";
        return stringToDate(yestdayStr, DATE_TO_STRING_DETAIAL_PATTERN);
    }


    public static String formatTime4Mill(String createTime) {

// 将微信传入的CreateTime转换成long类型,再乘以1000

        long msgCreateTime = Long.parseLong(createTime) * 1000L;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return format.format(new Date(msgCreateTime));

    }
    public static Date formatTime4Mill2(String createTime) {
// 将微信传入的CreateTime转换成long类型,再乘以1000
        return  new Date(Long.parseLong(createTime) * 1000L);
    }


    public static Date addAndSubMouth(Date date,Integer num){
        Calendar  g = Calendar.getInstance();
        g.setTime(date);
        g.add(Calendar.MONTH,num);
        return g.getTime();
    }
    public static Date addAndSubMouth(String date,Integer num){
        Calendar  g = Calendar.getInstance();
        g.setTime(stringToDate(date,"yyyy-MM-dd"));
        g.add(Calendar.MONTH,num);
        return g.getTime();
    }

    public static Date addAndSubDay(Date date,Integer num){
        Calendar  g = Calendar.getInstance();
        g.setTime(date);
        g.add(Calendar.DAY_OF_YEAR,num);
        return g.getTime();
    }
    public static Date addAndSubDay(String date,Integer num){
        Calendar  g = Calendar.getInstance();
        g.setTime(stringToDate(date,"yyyy-MM-dd"));
        g.add(Calendar.DAY_OF_YEAR,num);
        return g.getTime();
    }

    /**
     * Date类型转为指定格式的String类型
     *
     * @param source
     * @param pattern
     * @return
     */
    public static String DateToString(Date source, String pattern) {
        if (source==null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(source);
    }

    /**
     * 返回两个时间的相隔时间
     *          以小时为单位
     * @param startDate
     * @param endDate
     * @return
     */
    public static Integer getIntervalTime(Date startDate,Date endDate){
        Long intervalTime = endDate.getTime()-startDate.getTime();
        return ((Long) (intervalTime/60*60*1000)).intValue();
    }
    /**
     * 返回两个时间的相隔时间
     *          以小时为单位
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getIntervalTimeByM(Date startDate,Date endDate){
        Long intervalTime = endDate.getTime()-startDate.getTime();
        return intervalTime/(60*1000);
    }

    /**
     * 以小时为单位+ - 时间
     *          例  addAndSubHour(new Date(),-2)   返回2小时之前的Date
     *            addAndSubHour(new Date(),2)   返回2小时之后的Date
     *
     * @param date
     * @param num
     * @return
     */
    public static Date addAndSubHour(Date date,Integer num){
        Calendar  g = Calendar.getInstance();
        g.setTime(date);
        g.add(Calendar.HOUR_OF_DAY,num);
        return g.getTime();
    }


    public static String judgeTime(Date date){
//        Integer time = getIntervalTime(date, new Date());
        Long tiem4m = getIntervalTimeByM(date,new Date());
        String msg = "";
        if (tiem4m < 1*60){
            msg = tiem4m +"分钟前";
        }else if (tiem4m < 12*60 ){
            msg = (tiem4m/60)+"小时前";
        }else if (tiem4m>=12*60 && tiem4m <24*60){
            msg = "昨天";
        }else {
            msg =  DateToString(date,"yyyy-MM-dd");
        }
        return msg;
    }

    /**
     *          转换时间格式
     *
     * @param countTime
     * @param sourceFormatStr
     * @param targetFormatStr
     * @return
     */
    public static String  transitionFormatStr(String  countTime,String sourceFormatStr, String targetFormatStr) {
       return   DateToString(stringToDate(countTime, sourceFormatStr),targetFormatStr);
    }




    /** 时间格式(yyyy-MM-dd) */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /** 时间格式(yyyy-MM-dd HH:mm:ss) */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    public static boolean isToday(Date endDate) {
        if (endDate== null) {
            return false;
        }
        return format(new Date(),DATE_PATTERN).equals(format(endDate,DATE_PATTERN));
    }
    public static boolean isToday(String date) {
        if (StringUtils.isBlank(date)) {
            return false;
        }
        return format(new Date(),DATE_PATTERN).equals(date);
    }

    public static boolean isYestDay(Date endDate) {
        if (endDate== null) {
            return false;
        }
        return format(DateUtils.addAndSubDay(new Date(),-1),DATE_PATTERN).equals(format(endDate,DATE_PATTERN));
    }


    /*
     *  时间比较
      *     1 大于 2 ？
     */
    public static long compare(String p1,String p2,String fmStr){
        return compare(stringToDate(p1,fmStr),stringToDate(p2,fmStr));
    }

    public static long compare(String p1,String p2){
        return compare(p1,p2,DATE_PATTERN);
    }


    public static long compare(String p1){
        return compare(stringToDate(p1,DATE_PATTERN),getCurrentDate());
    }

    public static long compare(Date p1,Date p2){
        return p1.getTime() - p2.getTime();
    }


    public static boolean isSameDay(Date start_date, Date end_date) {
        return format(start_date).equals(format(end_date));
    }

    public static Date string2ZeroDate(String dateStr) {
        return stringToDate(dateStr,DATE_PATTERN);
    }

    public static Date getTomorrowDate(String end_date) {
        return addAndSubDay(end_date,1);
    }
}
