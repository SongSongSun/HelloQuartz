package com.song.demo.HelloQuartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{
	
	//相当于Timer的run()方法
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//打印当前的执行时间
		// 编写具体的业务逻辑
		Date date  = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Exec Time is : "+simpleDateFormat.format(date));
		System.out.println("hello world!");
	}

}
