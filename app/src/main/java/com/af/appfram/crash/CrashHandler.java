package com.af.appfram.crash;

/**
 * @author: winton
 * @time: 2017/11/3 9:39
 * @package: com.af.appfram.crash
 * @project: APPFram
 * @mail:
 * @describe: 全局的异常捕获
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = CrashHandler.class.getSimpleName();

    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private CrashHandler(){

    }
    private static class InstanceHolder{
        static CrashHandler instance = new CrashHandler();
    }

    /**
     * 对外单例
     * @return
     */
    public static CrashHandler getInstance(){
        return InstanceHolder.instance;
    }

    public void init(){
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if(!handleException(e) && mDefaultHandler != null){
            mDefaultHandler.uncaughtException(t,e);
            return;
        }
        try{
            Thread.sleep(500);
        }catch (InterruptedException ex){
            LogUtils.e(TAG,"crashHandler has Exception"+ex.getMessage());
        }
        //处理完异常，退出程序
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    private boolean handleException(Throwable e){
        if(e == null){
            LogUtils.e(TAG,"发生了异常，throwable is null");
            return false;
        }
        saveCrashLog(e);
        return true;
    }

    /**
     * 保存异常的倒日志文件
     * @param throwable
     */
    private void saveCrashLog(Throwable throwable){
        LogUtils.e(TAG,"========================异常开始=====================");
        LogUtils.e(TAG,"应用奔溃",throwable);
        LogUtils.e(TAG,"========================异常结束=====================");
    }
}
