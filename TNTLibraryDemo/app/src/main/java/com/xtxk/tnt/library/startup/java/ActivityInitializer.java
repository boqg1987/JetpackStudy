package com.xtxk.tnt.library.startup.java;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wendell on 2020/11/27
 * QQ 282993091
 * desc
 */
public class ActivityInitializer implements Initializer<Activity> {
    /**
     * Initializes and a component given the application {@link Context}
     *
     * @param context The application context.
     */
    @NonNull
    @Override
    public Activity create(@NonNull Context context) {
        Log.e("ActivityInitializer","create");
        return new Activity();
    }

    /**
     * @return A list of dependencies that this {@link Initializer} depends on. This is
     * used to determine initialization order of {@link Initializer}s.
     * <br/>
     * For e.g. if a {@link Initializer} `B` defines another
     * {@link Initializer} `A` as its dependency, then `A` gets initialized before `B`.
     */
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        Log.e("ActivityInitializer","dependencies");
        List<Class<? extends Initializer<?>>> dependencies = new ArrayList<>();
        dependencies.add(FragmentInitializer.class);
        //直接返回Arrays.asList(FragmentInitializer.class)会报错，类型不匹配
        return dependencies;
    }

}
