package com.xzy.activitybestpractice.controller;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：created by xzy.
 * @date ：2020/5/29
 */
public class ActivityController {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            activity.finish();
        }
    }

}
