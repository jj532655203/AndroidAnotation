package com.maxnerva.demo111;

/**
 * Created by user on 2018/1/11.
 */

public class DownLoadManager {
    private static DownLoadManager instance;

    private DownLoadManager() {

    }

    public static DownLoadManager getInstance() {
        if (instance == null) {
            synchronized (DownLoadManager.class) {
                if (instance == null) {
                    return new DownLoadManager();
                }
            }
        }
        return instance;
    }

}
