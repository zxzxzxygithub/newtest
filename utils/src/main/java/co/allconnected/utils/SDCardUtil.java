package co.allconnected.utils;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * sdcard工具类
 *
 * @author michael
 * @time 16/12/6 下午8:43
 */
public class SDCardUtil {

    private SDCardUtil() {
    }

    ;

    /**
     * 判断SD卡是否可用
     *
     * @return ture：可用；false：不可用
     */
    public static boolean isSDCardEnable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取SD卡路径
     *
     * @return SD卡存在返回正常路径；SD卡不存在返回""
     */
    public static String getSDCradPath() {
        if (isSDCardEnable()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
        } else {
            return "";
        }
    }

    /**
     * 获取SD卡路径
     *
     * @return SD卡存在返回正常路径；SD卡不存在返回null
     */
    public static File getSDCardFile() {
        if (isSDCardEnable()) {
            return Environment.getExternalStorageDirectory();
        } else {
            return null;
        }
    }

    /**
     * 获取SD卡DownloadCache路径
     *
     * @return SD卡存在返回正常路径；SD卡不存在返回""
     */
    public static String getSDCardDownloadCachePath() {
        if (isSDCardEnable()) {
            return Environment.getDownloadCacheDirectory().getAbsolutePath() + File.separator;
        } else {
            return "";
        }
    }

    /**
     * 获取SD卡DownloadCache路径
     *
     * @return SD卡存在返回正常路径；SD卡不存在返回null
     */
    public static File getSDCardDownloadCacheFile() {
        if (isSDCardEnable()) {
            return Environment.getDownloadCacheDirectory();
        } else {
            return null;
        }
    }

    /**
     * 获取系统存储路径
     *
     * @return SD卡存在返回正常路径；SD卡不存在返回""
     */
    public static String getSDCardRootPath() {
        if (isSDCardEnable()) {
            return Environment.getRootDirectory().getAbsolutePath() + File.separator;
        } else {
            return "";
        }
    }

    /**
     * 获取系统存储路径
     *
     * @return SD卡存在返回正常路径；SD卡不存在返回null
     */
    public static File getSDCardRootFile() {
        if (isSDCardEnable()) {
            return Environment.getRootDirectory();
        } else {
            return null;
        }
    }

    /**
     * 获取SD卡大小
     *
     * @return SD卡存在返回大小；SD卡不存在返回-1
     */
    @SuppressLint("NewApi")
    public static long getSDCardSize() {
        if (isSDCardEnable()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator);
            if (android.os.Build.VERSION.SDK_INT < 18) {
                int blockSize = statFs.getBlockSize();
                int blockCount = statFs.getBlockCount();
                return blockCount * blockSize;
            } else {
                long blockSize = statFs.getBlockSizeLong();
                long blockCount = statFs.getBlockCountLong();
                return blockCount * blockSize;
            }
        }
        return -1;
    }

    /**
     * 获取SD卡大小
     *
     * @return SD卡存在返回大小；SD卡不存在返回-1
     */
    @SuppressLint("NewApi")
    public static long getSDCardAvailableSize() {
        if (isSDCardEnable()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator);
            if (android.os.Build.VERSION.SDK_INT < 18) {
                int blockSize = statFs.getBlockSize();
                int blockCount = statFs.getAvailableBlocks();
                return blockCount * blockSize;
            } else {
                long blockSize = statFs.getBlockSizeLong();
                long blockCount = statFs.getAvailableBlocksLong();
                return blockCount * blockSize;
            }
        }
        return -1;
    }

}
