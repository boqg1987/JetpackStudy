package com.xtxk.tnt.library.startup.java;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.startup.Initializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wendell on 2020/11/27
 * QQ 282993091
 * desc
 */
public class FragmentInitializer implements Initializer<Fragment> {
    /**
     * Initializes and a component given the application {@link Context}
     *
     * @param context The application context.
     */
    @NonNull
    @Override
    public Fragment create(@NonNull Context context) {
        Log.e("FragmentInitializer","create");
        return new Fragment();
    }

    /**
     * @return A list of dependencies that this {@link Initializer} depends on. This is
     * used to determine initialization order of {@link Initializer}s.
     * <br/>
     * For e.g. if a {@link Initializer} `B` defines another
     * {@link Initializer} `A` as its dependency, then `A` gets initialized before `B`.
     */
    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        Log.e("FragmentInitializer","dependencies");
        List<Class<? extends Initializer<?>>> dependencies = new ArrayList<>();
        //如没有依赖，返回空集合，不能直接返回null，否则会报异常
        return dependencies;
    }
}
