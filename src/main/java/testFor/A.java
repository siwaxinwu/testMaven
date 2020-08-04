package testFor;

import utils.GeneralUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class A {
    static int a = 0 ;
    static {
        a = 1;
        b = 1;
    }
    static int b = 0;

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);

        int bTime = GeneralUtils.isNullOrEmpty("-2880") ? 0 : Integer.parseInt("-2880");
        int eTime = GeneralUtils.isNullOrEmpty("0") ? 0 : Integer.parseInt("0");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
/*
        LocalDateTime beginTime = job.getWaitExeTime().plusMinutes(bTime);
        LocalDateTime endTime = job.getWaitExeTime().plusMinutes(eTime);

        sqlStr = String.format(sqlStr, beginTime.format(dtf), endTime.format(dtf));
*/





    }
}