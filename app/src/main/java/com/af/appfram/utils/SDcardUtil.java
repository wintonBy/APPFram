package com.af.appfram.utils;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;

import java.io.File;

/**
 * SD卡工具类
 * @author:续写经典
 * @createtime:2015/11/4
 */
public final class SDcardUtil {
  private SDcardUtil() {
  }

  /** 默认根目录名称 */
  private static String ROOT_DIR = "download";
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
    if(!TextUtils.isEmpty(rootDir)){
       rootDir= rd;
    }else {
      rootDir = ROOT_DIR;
    }

    //默认根目录
    String downloadRootPath = File.separator + rootDir + File.separator ;
    //默认日志目录
    String logDownloadPath = downloadRootPath + LOG_DIR + File.separator;

    try {
      if (isCanUseSD()) {
        File root = Environment.getExternalStorageDirectory();
        rootDir = checkDir(root.getAbsolutePath() + downloadRootPath);
        logDir = checkDir(root.getAbsolutePath() + logDownloadPath);
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
      file.mkdirs();
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
    if (rootDir == null) {
      initDir(rootDir);
    }
    return rootDir;
  }

  /**
   * 获取日志文件的目录
   */
  public static String getLogDir() {
    if (logDir == null) {
      initDir(rootDir);
    }
    return logDir;
  }
}
