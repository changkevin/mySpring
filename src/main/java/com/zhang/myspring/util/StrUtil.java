package com.zhang.myspring.util;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

public class StrUtil {
	public static final String DAY_KEY_PATTERN = "yyyyMMdd";

	/**
	 * 判断字符串是否为空
	 * @param strObj
	 * @return
	 */
	public static boolean isEmpty(Object strObj){
		if(strObj == null) return true;
		String str = strObj.toString();
		return "null".equals(str) || str.isEmpty() || StringUtils.isBlank(str);
	}

	/**
	 * 判断字符串是否非空
	 * @param strObj
	 * @return
	 */
	public static boolean isNotEmpty(Object strObj){
		return !isEmpty(strObj);
	}

	/**
	 * 连接字符串
	 * @param list
	 * @param separator
	 * @return
	 */
	public static String join(Collection list, char separator) {
		if (list == null) {
			return "";
		}
		int size = list.size();
		if (size == 0) {
			return "";
		}
		final StringBuilder sb = new StringBuilder();
		boolean notfirst = false;
		for (Object item : list) {
			if (notfirst) {
				sb.append(separator);
			} else {
				notfirst = true;
			}
			sb.append(item);
		}
		return sb.toString();
	}

	/**
	 * 字段值类型处理
	 * @param list
	 * @param type
	 * @return
	 */
	public static List<String> convertValue(List<String> list, String type){
		List<String> result = new ArrayList<>();
		if(type != null) {
			if (type.equals("String")) {
				for (String s : list) {
					result.add("'" + s + "'");
				}
				return result;
			}
			//else if(type.equals("int")){}
		}
		result.addAll(list);
		return result;
	}

	/**
	 * 连接字符串
	 * 分隔符
	 * @param list
	 * @param separator
	 * @return
	 */
	public static String join(Collection list, String separator) {
		if (list == null) {
			return "";
		}
		int size = list.size();
		if (size == 0) {
			return "";
		}
		final StringBuilder sb = new StringBuilder();
		boolean notfirst = false;
		for (Object item : list) {
			if (notfirst) {
				sb.append(separator);
			} else {
				notfirst = true;
			}
			sb.append(item);
		}
		return sb.toString();
	}

	public static String getMd5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32浣嶉敓鏂ゆ嫹閿熸枻鎷�
			return buf.toString();
			// 16浣嶉敓渚ョ》鎷烽敓鏂ゆ嫹
			// return buf.toString().substring(8, 24);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 閿熸枻鎷峰彇UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static boolean isNumber(String number) {
		number = number.replace("-", "");
		if (StringUtils.isEmpty(number)) {
			return false;
		}
		int index = number.indexOf(".");
		if (index < 0) {
			return StringUtils.isNumeric(number);
		} else {
			String num1 = number.substring(0, index);
			String num2 = number.substring(index + 1);

			return StringUtils.isNumeric(num1) && StringUtils.isNumeric(num2);
		}
	}

	public static String getTimeStr(int delta) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, delta);
		return DateFormatUtils.format(calendar.getTime(), "yyyy-MM-dd");
	}

	public static int getTime(int delta) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, delta);
		return Integer.parseInt(DateFormatUtils.format(calendar.getTime(), DAY_KEY_PATTERN));
	}

	public static int getTime(int daykey, int delta) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(new SimpleDateFormat(DAY_KEY_PATTERN).parse(daykey + ""));
		} catch (Exception e) {
			// e.printStackTrace();
		}
		calendar.add(Calendar.DAY_OF_MONTH, delta);
		return Integer.parseInt(DateFormatUtils.format(calendar.getTime(), DAY_KEY_PATTERN));
	}

	public static Integer getToday() {
		return Integer.parseInt(DateFormatUtils.format(new Date(), DAY_KEY_PATTERN));
	}

	public static String getTodayStr() {
		return DateFormatUtils.format(new Date(), "yyyy年MM月dd日");
	}

	public static Integer getYesterDay() {
		return getDefaultDayKey(null);
	}

	public static Integer getTomorrow() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return Integer.parseInt(DateFormatUtils.format(calendar.getTime(), DAY_KEY_PATTERN));
	}

	public static Integer getDefaultDayKey(String indexDayStr) {
		if (StringUtils.isEmpty(indexDayStr)) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			return Integer.parseInt(DateFormatUtils.format(calendar.getTime(), DAY_KEY_PATTERN));
		}
		return Integer.parseInt(indexDayStr);
	}

	public static Integer getDayDeltaN(int daykey, int delta) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_KEY_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(daykey + ""));
		calendar.add(Calendar.DAY_OF_MONTH, delta);
		return Integer.parseInt(DateFormatUtils.format(calendar.getTime(), DAY_KEY_PATTERN));

	}

	public static Integer getMonthBeforeN(int monthkey, int delta) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(monthkey + ""));
		calendar.add(Calendar.MONTH, delta);
		return Integer.parseInt(DateFormatUtils.format(calendar.getTime(), "yyyyMM"));

	}

	/**
	 * daykey杞敓琛楀嚖鎷烽敓鏂ゆ嫹鏃堕敓鏂ゆ嫹
	 */

	public static String fmtDaykey2Str(int daykey) {
		try {
			return DateFormatUtils.format(new SimpleDateFormat(DAY_KEY_PATTERN).parse(daykey + ""), "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return daykey + "";
	}

	public static String insertCrum2Daykey(String daykey) {
		return daykey.substring(0, 4) + "-" + daykey.substring(4, 6) + "-" + daykey.substring(6);
	}

	public static int parseInt(String text) {
		if (StringUtils.isEmpty(text)) {
			return -1;
		}
		text = text.trim();
		try {
			return Integer.parseInt(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 閿熸枻鎷峰彇閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
	 */
	public static String getWeekRange(int daykey) {
		try {
			return getMondayOfThisWeek(daykey) + "-" + getSundayOfThisWeek(daykey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return daykey + "";
	}

	/**
	 * 閿熸枻鎷峰彇閿熼摪鍑ゆ嫹
	 */
	public static String getMonthDay(int daykey) {
		return (daykey + "").substring(0, 6);
	}

	public static String getMonthDay(String daykey) {
		return (daykey + "").substring(0, 6);
	}

	/**
	 * 閿熸枻鎷峰彇閿熼摪鍑ゆ嫹key
	 */
	public static int getMonthDaykey(int daykey) {
		if ((daykey + "").length() <= 6) {
			return daykey;
		}
		return Integer.parseInt((daykey + "").substring(0, 6));
	}

	public static int getMonthDaykey(String daykey) {
		return getMonthDaykey(Integer.parseInt(daykey));
	}

	/**
	 * 閿熸枻鎷峰彇閿熼摪鍑ゆ嫹
	 * 
	 * @throws Exception
	 */
	public static String parseMonthKeyToRange(int monthKey) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DAY_KEY_PATTERN);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(monthKey + "01"));
			int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			return monthKey + "01-" + monthKey + lastDay;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return monthKey + "";
	}

	/**
	 * 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷峰潃閿熸枻鎷烽敓闃额�亷鎷烽敓鏂ゆ嫹閿燂拷
	 */
	public static int[] splitRange2Arr(String range) {
		try {
			int start = Integer.parseInt(range.split("-")[0]);
			int end = Integer.parseInt(range.split("-")[1]);
			return new int[] { start, end };
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 閿熺煫纰夋嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷蜂竴
	 * 
	 * @return yyyy-MM-dd
	 * @throws Exception
	 */
	public static String getMondayOfThisWeek(int daykey) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_KEY_PATTERN);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(daykey + ""));
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week + 1);
		return sdf.format(c.getTime());
	}

	/**
	 * 閿熺煫纰夋嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getSundayOfThisWeek(int daykey) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_KEY_PATTERN);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(daykey + ""));
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week + 7);
		return sdf.format(c.getTime());
	}

	public static String parseO2String(Object obj) {
		if (null != obj) {
			return obj.toString();
		}
		return "";
	}

	public static String deleteLastComma(String sql) {
		if (-1 != sql.indexOf(",")) {
			sql = sql.substring(0, sql.length() - 1);
		}
		return sql;
	}

	public static double parseO2Double(Object obj) {
		double value = 0;
		if (null != obj) {
			String valueStr = obj.toString();
			if (-1 != valueStr.indexOf("E") || -1 != valueStr.indexOf("e")) {
				try {
					valueStr = new BigDecimal(valueStr).toPlainString();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (StringUtils.isNotEmpty(valueStr) && isNumber(valueStr)) {
				value = Double.parseDouble(valueStr);
			}
		}
		return value;
	}

	public static int getMaxLegalDaykeyByMonth(int monthKey) {
		String monthRange = parseMonthKeyToRange(monthKey);
		String lastDay = monthRange.split("-")[1];

		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DAY_OF_MONTH, -1);

		Calendar thatDay = Calendar.getInstance();
		try {
			thatDay.setTime(new SimpleDateFormat(DAY_KEY_PATTERN).parse(lastDay));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 閿熻闈╂嫹閿熼摪纰夋嫹閿熸枻鎷烽敓鎻紮鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熻顔炲府鎷烽敓鏂ゆ嫹閿熺煫杈炬嫹閿熸枻鎷锋瓑閿熸枻鎷风閿熸枻鎷烽敓鏂ゆ嫹涓�閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
		Date selected = new Date();
		if (thatDay.compareTo(yesterday) < 0) {
			selected = thatDay.getTime();
		} else {
			selected = yesterday.getTime();
		}
		return Integer.parseInt(DateFormatUtils.format(selected, DAY_KEY_PATTERN));

	}

	public static int parseO2Int(Object obj) {
		return (int) parseO2Double(obj);
	}

	public static long parseO2Long(Object obj) {
		return (long) parseO2Double(obj);
	}

	public static int parseO2DayKey(Object obj) {
		if (null == obj || StringUtils.isEmpty(obj.toString())) {
			return -1;
		}
		return (int) parseO2Double(obj.toString().replace("-", ""));

	}

	public static String parseO2DayKeyStr(Object obj) {
		if (null == obj || StringUtils.isEmpty(obj.toString())) {
			return "-1";
		}
		try {
			return parseO2Double(obj.toString().replace("-", "")) + "";
		} catch (Exception e) {

		}
		return parseO2String(obj);

	}

	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	public static String getShortUUID() {
		return getUUID().replace("-", "").substring(0, 6);
	}

	public static String getUniqueTag() {
		return getTimeStamp() + "_" + getUUID().replace("-", "").substring(0, 6);
	}

	public static String getFileSuffix(String fileName) {
		try {
			if (-1 != fileName.indexOf(".")) {
				return fileName.substring(fileName.indexOf(".") + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static long getMillisTime() {
		return System.currentTimeMillis();
	}

	public static int getWeekTime(int delta, int whichDay, int baseDaykey) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_KEY_PATTERN);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(baseDaykey + ""));
		cal.add(Calendar.DATE, delta * 7);
		cal.set(Calendar.DAY_OF_WEEK, whichDay);
		String time = sdf.format(cal.getTime());
		return Integer.parseInt(time);
	}

	public static String getSummaryResult(String result) {
		if (result.length() > 200) {
			result = result.substring(0, 200) + "...";
		}
		return result;
	}

	public static String getNoSpaceText(Object result) {
		return result.toString().replaceAll("\\s+|\r|\n|\t", " ");
	}

	public static double makeLegalDouble(double num) {
		if (Double.isInfinite(num) || Double.isNaN(num)) {
			return 0;
		}
		return num;
	}

	public static int getPassedMaxDaykey(int daykey) {
		int now = Integer.parseInt(DateFormatUtils.format(new Date(), DAY_KEY_PATTERN));
		if (daykey > now) {
			daykey = now;
		}
		return daykey;
	}

	public Object getObjVal(ResultSet rs, String fieldName) {
		try {
			return rs.getObject(fieldName);
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		return null;
	}

	public static double getDiv(double fenzi, double fenmu) {
		if (0 == fenmu) {
			return 0;
		}
		return fenzi / fenmu;
	}

	public static String getLogLikeText(String text) {
		return text.replaceAll("\\s+|\n|\r|\t", " ");
	}

	public static String getCostTimeMonitorKey(long costTime) {
		String key = "";
		if (costTime < 1000) {
			key = "<1s";
		} else if (costTime >= 1000 && costTime < 2000) {
			key = "1s-2s";
		} else if (costTime >= 2000 && costTime < 3000) {
			key = "2s-3s";
		} else if (costTime >= 3000 && costTime < 4000) {
			key = "3s-4s";
		} else if (costTime >= 4000) {
			key = ">4s";
		}
		return key;
	}

	public static double round2(double value) {
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(value));
	}

	public static int daysBetween(int smdate, int bdate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate + ""));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate + ""));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	public static Object getObjVal(Object value) {
		return null != value && StringUtils.isNotEmpty(value.toString()) ? value : "-";
	}

	public static void main(String[] args) throws Exception {
		System.out.println(daysBetween(20161210, 20170103));
	}

	public static int[] getWeekRangeByDayKey(int daykey) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 设置时间格式
		Date time = sdf.parse(daykey + "");
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);

		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}

		cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

		int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		String mondayStr = sdf.format(cal.getTime());

		cal.add(Calendar.DATE, 6);
		String sundayStr = sdf.format(cal.getTime());

		int monday = Integer.parseInt(mondayStr);
		int sunday = Integer.parseInt(sundayStr);
		return new int[] { monday, sunday };
	}

	public static int[] getMonthRangeByDayKey(int daykey) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 设置时间格式
		Date time = sdf.parse(daykey + "");
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);

		int lastDayIndex = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		String firstDayStr = (daykey + "").substring(0, 6) + "01";
		String lastDayStr = (daykey + "").substring(0, 6) + lastDayIndex;

		int firstDay = Integer.parseInt(firstDayStr);
		int lastDay = Integer.parseInt(lastDayStr);
		return new int[] { firstDay, lastDay };
	}

	public static List<Integer> parseDaykeys2List(String daykeys) throws Exception {
		if (StringUtils.isEmpty(daykeys)) {
			daykeys = getYesterDay() + "";
		}
		if (-1 == daykeys.indexOf("-")) {
			daykeys = daykeys + "-" + daykeys;
		}
		String pattern = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar start = Calendar.getInstance();
		start.setTime(sdf.parse(daykeys.split("-")[0]));
		Calendar end = Calendar.getInstance();
		end.setTime(sdf.parse(daykeys.split("-")[1]));
		Set<Integer> timeSet = new HashSet<Integer>();
		while (start.compareTo(end) <= 0) {
			int daykey = Integer.parseInt(DateFormatUtils.format(start.getTime(), pattern));
			timeSet.add(daykey);
			start.add(Calendar.DAY_OF_MONTH, 1);
		}
		List<Integer> result = new ArrayList<Integer>(timeSet);
		Collections.sort(result);
		return result;
	}
}
