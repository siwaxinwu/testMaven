package utils;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description：
 * author：dingyawu
 * date：created in 10:03 2020/7/28
 * history:
 */

public final class GeneralUtils {

    /**
     * 判断集合对象是否为null或者0大小 , 为空或0大小返回true ,否则返回false
     *
     * @param c collection 集合接口
     * @return boolean 布尔值
     */
    public static boolean isNullOrEmpty(Collection<? extends Object> c) {
        return (null == c || c.isEmpty());
    }

    public static boolean isNotNullOrEmpty(Collection<? extends Object> c) {
        return !isNullOrEmpty(c);
    }

    public static boolean isNotNullOrEmpty(Map map) {
        return map != null && map.size() > 0;
    }

    /**
     * 判断str字符串是否为null或“null”串或空串，是的话返回true, 否则返回false
     *
     * @param str String 字符串
     * @return boolean
     */
    public static boolean isNullOrEmpty(String str) {
        return (null == str || "null".equals(str.toLowerCase()) || "".equals(str.trim()));
    }

    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */

    public static double div(double v1, double v2) {
        return div(v1, v2, 10);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */

    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 数字不足位数左补0
     *
     * @param str
     * @param strLength
     * @return
     */
    public static String addZeroForNum(String str, int strLength) {
        return addZeroForNum(str, strLength, true);
    }

    /**
     * 数字不足位数补0
     *
     * @param str
     * @param strLength
     * @param isLeft    为true时，左补；否则，右补
     * @return
     */
    public static String addZeroForNum(String str, int strLength, Boolean isLeft) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                str = isLeft ? sb.append("0").append(str).toString() : sb
                        .append(str).append("0").toString();
                strLen = str.length();
            }
        }
        return str;
    }

    /**
     * 获取当前IP地址
     *
     * @return String
     */
    public static String getIP() {
        InetAddress ia = null;
        try {
            ia = ia.getLocalHost();
            String localname = ia.getHostName();
            String localip = ia.getHostAddress();
            System.out.println("本机名称是：" + localname);
            System.out.println("本机的ip是 ：" + localip);
            return ia.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // 一般用于分页，list取整
    public static int getCeil(int a, int b) {
        int result;
        if (a % b != 0) {
            result = a / b + 1;
        } else {
            result = a / b;
        }
        return result;
    }

    /**
     * 作者：李博
     * 描述：分钟转化为*时*分
     * 时间：2018-04-26
     *
     * @return
     */
    public static String getHmFromMin(Long min) {
        Long h = min / 60;
        Long m = min % 60;
        return h + "时" + m + "分";
    }

    /**
     * 作者: 李博
     * 描述: 获取n分钟后的时间
     * 日期: 2018-10-23
     */
    public static Date getMinuteLater(Date date, Integer n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, n);
        return calendar.getTime();
    }



    /**
     * 获得一个UUID
     *
     * @return String UUID
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "").toUpperCase();
    }


    public static String padLeft(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    /**
     * @功能 String右对齐
     */
    public static String padRight(String src, int len, char ch) {

        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, 0, src.length());
        for (int i = src.length(); i < len; i++) {
            charr[i] = ch;
        }
        return new String(charr);

    }







    /**
     * 检查表zto_truck_startplan_point中时间是否有效
     *
     * @param d
     * @return
     */
    public static boolean vaildDate(Date d) {
        Date tmpDate = new Date(2000 - 1900, 0, 1);//2000-01-01
        //规定发车时间
        if (d == null || d.before(tmpDate)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 作者：WangLei
     * 描述：根据传入的时间，计算相差毫秒数(绝对值)
     * 参数：endDate nowDate
     * 返回：java.lang.String
     * 时间：2018-05-30 12:42
     */
    public static Long getDifferMin(Date beginTime, Date endTime) {
        if (beginTime == null || endTime == null) {
            return null;
        }

        // 获得两个时间的毫秒时间差异
        long diff = endTime.getTime() - beginTime.getTime();
        //取绝对值
        long abs = Math.abs(diff);
        return abs;
    }

}


