package com.fcsummer.cloudCheck.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Title: ScheduleCheck
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.schedule
 * @Date 2023/8/27 10:21
 * @description: 云盘定时签到任务
 */
@Component
public class ScheduleCheck {


    @Scheduled(cron = "0 0 3 * * ?") // 每天凌晨三点执行任务
    public void checkOnDay(){

    }
}
