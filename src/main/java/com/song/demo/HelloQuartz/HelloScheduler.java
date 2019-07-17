package com.song.demo.HelloQuartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {
	public static void main(String[] args) throws SchedulerException {
		// 创建一个JobDetail实例 将该实例与 HelloJob 绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1").build();
		// 创建一个 Trigger实例，定义该job立即执行 并且每隔两秒重复一次
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
		//创建Scheduler实例  工厂模式  其他两个都是Build
		SchedulerFactory sFactory = new StdSchedulerFactory();
		Scheduler scheduler = sFactory.getScheduler();
		scheduler.start();
		Date date  = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Exec Time is : "+simpleDateFormat.format(date));
		scheduler.scheduleJob(jobDetail,trigger);
	}
}
