package com.chaytech.datastructure;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date 2021/06/06 13:37
 */
public class TimeTool {

    private static final SimpleDateFormat FMT = new SimpleDateFormat("HH:mm:ss.SSS");

    private TimeTool() {
    }

    /**
     * 测试程序执行时长
     *
     * @param title
     * @param task
     */
    public static void run(String title, Task task) {
        if (task == null) {
            return;
        }

        title = title == null ? "" : "【" + title + "】";
        System.out.println(title);
        System.out.println("begin time：" + FMT.format(new Date()));
        long beginTime = System.currentTimeMillis();
        task.execute();
        long endTime = System.currentTimeMillis();
        System.out.println("end time：" + FMT.format(new Date()));
        System.out.println("spend time：" + (endTime - beginTime) / 1000 + "s");
        System.out.println("------------------------------");
    }
}

interface Task {
    void execute();
}
