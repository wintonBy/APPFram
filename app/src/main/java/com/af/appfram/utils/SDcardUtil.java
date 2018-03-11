package com.af.appfram.utils;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;

import com.af.appfram.MyApplication;

import java.io.File;
import java.io.IOException;

/**
 * SD卡工具类
 * @author:续写经典
 * @createtime:2015/11/4
 */
public final class SDcardUtil {
  private SDcardUtil() {
  }

  /** 默认根目录名称 */
  private static final String ROOT_DIR = MyApplication.INSTANCE.getPackageName();
  /** 默认日志目录名称 */
  public static final String LOG_DIR = "logs";

  /** 默认根目录 */
  private static String rootDir = null;
  /** 默认日志的目录 */
  private static String logDir = null;

  /**
   * SD卡是否可用
   * @return true:可用,false:不可用
   */
  public static boolean isCanUseSD() {
    try {
      return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * 初始化目录
   */
  public static void initDir(String rd) {
    if(!TextUtils.isEmpty(rd)){
       rootDir= rd;
    }else {
      rootDir = ROOT_DIR;
    }

    //默认根目录
    String rootPath = File.separator + rootDir + File.separator ;
    //默认日志目录
    String logPath = rootPath + LOG_DIR + File.separator;

    try {
      if (isCanUseSD()) {
        String root = MyApplication.INSTANCE.getExternalFilesDir(null).getPath();
        rootDir = checkDir(root + rootPath);
        logDir = checkDir(root + logPath);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  private static String checkDir(String path){
    File file = new File(path);
    if (!file.exists()) {
      file.mkdirs();
    }
    return file.getPath();
  }

  private static File checkFile(String path) {
    File file = new File(path);
    if (!file.exists()) {
      try {
        file.createNewFile();
      }catch (IOException e){
        e.printStackTrace();
      }
    }
    return file;
  }

  /**
   * 计算sdcard上的剩余空间.
   *
   * @return the int
   */
  public static int freeSpaceOnSD() {
    StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
    double sdFreeMB =
        ((double) stat.getAvailableBlocks() * (double) stat.getBlockSize()) / 1024 * 1024;
    return (int) sdFreeMB;
  }

  /**
   * 获取下载根目录
   */
  public static String getRootDir() {
    if (TextUtils.isEmpty(rootDir)) {
      initDir(rootDir);
    }
    return rootDir;
  }

  /**
   * 获取日志文件的目录
   */
  public static String getLogDir() {
    if (TextUtils.isEmpty(rootDir)) {
      initDir(rootDir);
    }
    return logDir;
  }
}
