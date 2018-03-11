package com.af.appfram.utils;

import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Created by winton on 2017/6/23.
 */

public class LogUtils {

    public static final String TAG_DEFAULT = "LogUtils";

    public static class LEVEL{
        public static final int VERBOSE = 1;
        public static final int DEBUG = 2;
        public static final int INFO = 3;
        public static final int WARM = 4;
        public static final int ERROR = 5;
        public static final int WTF = 6;
    }

    private static int pLogLevel = LEVEL.VERBOSE;
    private static int fLogLevel = LEVEL.ERROR;
    private static String logDir = "";

    private static final String FILE_FORMAT = "yyyyMMdd";
    private static final String MESSAGE_FORMAT = "MM-dd HH:mm:ss.ms";
    private static final String SUFFIX = ".log";
    private static final String SEPARATOR = ".";
    private static final DateFormat messageFormat = new SimpleDateFormat(MESSAGE_FORMAT, Locale.getDefault());
    private static final DateFormat fileNameFormat = new SimpleDateFormat(FILE_FORMAT, Locale.getDefault());
    private static final Executor logExecutor = Executors.newSingleThreadExecutor();

    private static void pLog(String tag,String msg,int level){
        if(level < pLogLevel){
            return;
        }
        switch (level){
            case LEVEL.VERBOSE:
                Log.v(tag,msg);
                break;
            case LEVEL.DEBUG:
                Log.d(tag,msg);
                break;
            case LEVEL.INFO:
                Log.i(tag,msg);
                break;
            case LEVEL.WARM:
                Log.w(tag,msg);
                break;
            case LEVEL.ERROR:
                Log.e(tag,msg);
                break;
            case LEVEL.WTF:
                Log.wtf(tag,msg);
                break;
        }
    }
    private static void pLog(String tag,String msg,Throwable tr,int level){
        if(level < pLogLevel){
            return;
        }
        switch (level){
            case LEVEL.VERBOSE:
                Log.v(tag,msg,tr);
                break;
            case LEVEL.DEBUG:
                Log.d(tag,msg,tr);
                break;
            case LEVEL.INFO:
                Log.i(tag,msg,tr);
                break;
            case LEVEL.WARM:
                Log.w(tag,msg,tr);
                break;
            case LEVEL.ERROR:
                Log.e(tag,msg,tr);
                break;
            case LEVEL.WTF:
                Log.wtf(tag,msg,tr);
                break;
        }
    }

    private static void fLog(final String tag, final String msg, final Throwable tr, int level){
        if(level <fLogLevel){
            return;
        }
        if(TextUtils.isEmpty(logDir)){
            return;
        }
        if(TextUtils.isEmpty(msg)){
            return;
        }
        final long time = System.currentTimeMillis();
        final long threadId = Thread.currentThread().getId();
        logExecutor.execute(new Runnable() {
            @Override
            public void run() {
                String timeStr = messageFormat.format(new Date(time));
                outputToFile(formatMessage(tag,timeStr,msg,tr),getLogFilePath(""));
            }
        });
    }

    private static String formatMessage(String tag, String time, String msg, Throwable tr) {
        StringBuilder sb = new StringBuilder();

        // time
        sb.append(time);
        sb.append(": ");

        // tag
        sb.append(tag);
        sb.append(": ");

        // message
        sb.append(msg);
        sb.append("\n");

        // Throwable
        if (tr != null) {
            sb.append(Log.getStackTraceString(tr));
            sb.append("\n");
        }

        return sb.toString();
    }

    private static boolean outputToFile(String message, String path) {
        if (TextUtils.isEmpty(message)) {
            return false;
        }

        if (TextUtils.isEmpty(path)) {
            return false;
        }
        boolean written = false;
        try {

            BufferedWriter fw = new BufferedWriter(new FileWriter(path, true));
            fw.write(message);
            fw.flush();
            fw.close();

            written = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return written;
    }

    private static String getLogFileName(String cat) {
        StringBuilder sb = new StringBuilder();

        sb.append(fileNameFormat.format(new Date()));

        if (!TextUtils.isEmpty(cat)) {
            sb.append(SEPARATOR);
            sb.append(cat);
        }

        sb.append(SUFFIX);

        return sb.toString();
    }
    private static String getLogFilePath(String cat) {
        File dir = new File(logDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String path = logDir + "/" + getLogFileName(cat);
        File file = new File(path);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return path;
    }


    /********************对外方法**********************/

    public static void v(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.VERBOSE);
        fLog(tag,msg,null,LEVEL.VERBOSE);
    }
    public static void d(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.DEBUG);
        fLog(tag,msg,null,LEVEL.DEBUG);
    }
    public static void i(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.INFO);
        fLog(tag,msg,null,LEVEL.INFO);
    }
    public static void w(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.WARM);
        fLog(tag,msg,null,LEVEL.WARM);
    }
    public static void e(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.ERROR);
        fLog(tag,msg,null,LEVEL.ERROR);
    }
    public static void e(String tag,String msg,Throwable e){
        if(TextUtils.isEmpty(tag)){
            tag = TAG_DEFAULT;
        }
        pLog(tag,msg,e,LEVEL.ERROR);
        fLog(tag,msg,e,LEVEL.ERROR);
    }
    public static void wtf(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.WTF);
        fLog(tag,msg,null,LEVEL.WTF);
    }

    public static void v(String msg){
        v(null,msg);
    }
    public static void d(String msg){
        d(null,msg);
    }
    public static void i(String msg){
        i(null,msg);
    }
    public static void w(String msg){
        w(null,msg);
    }
    public static void e(String msg){
        e(null,msg);
    }
    public static void wtf(String msg){
        wtf(null,msg);
    }

    /**
     * 初始化日志工具类
     * @param pLog
     * @param fLog
     * @param logFileDir
     */
    public static void init(int pLog,int fLog,String logFileDir){
        pLogLevel = pLog;
        fLogLevel = fLog;
        logDir = logFileDir;
    }



}
