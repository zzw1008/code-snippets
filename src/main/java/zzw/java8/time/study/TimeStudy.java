package zzw.java8.time.study;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

//java。time包中的是类是不可变且线程安全的。新的时间及日期API位于java.time中，下面是一些关键类
//●Instant——它代表的是时间戳
//●LocalDate——不包含具体时间的日期，比如2014-01-14。它可以用来存储生日，周年纪念日，入职日期等。
//●LocalTime——它代表的是不含日期的时间
//●LocalDateTime——它包含了日期及时间，不过还是没有偏移信息或者说时区。
//●ZonedDateTime——这是一个包含时区的完整的日期时间，偏移量是以UTC/格林威治时间为基准的。
//java.time.Duration用于计算两个“时间”间隔
//java.time.Period用于计算两个“日期”间隔
public class TimeStudy {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// 获取今天的日期、年、月、日
		LocalDate today = LocalDate.now();
		System.out.println("今天的日期是:" + today);
		System.out.println("年：" + today.getYear());
		System.out.println("月：" + today.getMonthValue());
		System.out.println("日：" + today.getDayOfMonth());

		// 一周后的日期
		LocalDate week = today.plusWeeks(1);
		System.out.println("一周后的日期是:" + week);

		// 判断日期前后
		if (week.isAfter(today)) {
			System.out.println("一周后");
		}

		// 计算相差几天
		Period p = Period.between(today, week);
		System.out.println("相差" + p.getDays() + "天");

		// 一年前的日期
		LocalDate year = today.minus(1, ChronoUnit.YEARS);
		System.out.println("一年前的日期是:" + year);

		// 判断日期前后
		if (year.isBefore(today)) {
			System.out.println("一年前");
		}

		// 定义日期
		LocalDate birth = LocalDate.of(2017, 6, 11);
		System.out.println("自定义生日是：" + birth);

		// 格式化字符串 日期和字符串转换
		String temp = "20170722";
		LocalDate format = LocalDate.parse(temp, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("格式化字符串" + format);
		temp = "2017/07/22";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		System.out.println(LocalDate.parse(temp, dtf));
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(LocalDate.parse(temp, dtf).format(dtf1));

		// MonthDay 只保存 月和日
		MonthDay md = MonthDay.of(birth.getMonth(), birth.getDayOfMonth());
		System.out.println(md);

		// YearMonth 只保存 年和月
		YearMonth ym = YearMonth.now();
		System.out.println(ym.getYear() + "/" + ym.getMonthValue());

		// 获取当前的时间、时、分、秒、毫秒
		LocalTime now = LocalTime.now();
		System.out.println("当前的时间是：" + now);
		System.out.println("小时：" + now.getHour());
		System.out.println("分钟：" + now.getMinute());
		System.out.println("秒：" + now.getSecond());
		System.out.println("毫秒：" + now.getNano());

		// 一小时后的时间，分、秒、毫秒类似
		LocalTime one = now.plusHours(1);
		System.out.println("一小时后的时间是：" + one);

		// Clock
		Clock clock = Clock.systemUTC();
		System.out.println("Clock：" + clock);

		Clock.systemDefaultZone();
		System.out.println("Clock：" + clock);
		System.out.println(clock.systemUTC());

		// 日期和时间
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("日期和时间：" + ldt);

		// 某时区日期和时间
		LocalDateTime todayKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST=" + todayKolkata);

		// 当前时间戳
		Instant timestamp = Instant.now();
		System.out.println("当前时间戳：" + timestamp);

		// 时区
		ZoneId zone = ZoneId.of(ZoneId.SHORT_IDS.get("VST"));
		ZonedDateTime zdt = ZonedDateTime.of(ldt, zone);
		System.out.println("时区日期和时间：" + zdt);
		System.out.println(zdt.getZone());

		//自1970年时间差
		long milli = Instant.now().toEpochMilli();
		System.out.println(milli);
		System.out.println(System.currentTimeMillis());
		
		LocalDateTime ldt1 = LocalDateTime.of(1970, 01, 01, 00, 00, 00);

		LocalDateTime ldt2 = LocalDateTime.now();
		Duration d = Duration.between(ldt1, ldt2);
		System.out.println(d.toMillis());
		System.out.println(ldt2);
		//偏离8小时是系统时间
		System.out.println(Instant.now().atOffset(ZoneOffset.ofHours(8)));
		System.out.println(Instant.now());
		
		// 某时区日期和时间
		LocalDateTime todayShangHai = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println("Current Date in IST=" + todayShangHai);

	}

}
