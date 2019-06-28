package com.ultrapower.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.util.Date;


public class PrintTimeJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    //作业任务
       /* LocalDateTime now = LocalDateTime.now();
        System.out.println("获取当前时间："+now);*/
        System.out.println(new Date());
    }
}
