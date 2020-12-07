package com.xtxk.tnt.library.startup.kotlin

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.startup.Initializer

/**
 * Created by Wendell on 2020/11/27
 * QQ 282993091
 * desc
 */

//此文件只是一个用来学习的例子。并没有太强的逻辑性。比如Activity并非必须有fragment。
//同时fragment和activity并不是通过此方式来进行初始化
//按照官方demo来学习，WorkManager和ExampleLogger 来举例。此处只是为了独立学习方便
//执行顺序是ActivtyInitializer中dependencies -》FragmentInitalizer中dependencies
//-->FragmentInitalizer create --> ActivityInitializer create
class FragmentInitalizer: Initializer<Fragment>{

    /**
     * 需要初始化的所有操作与及返回对象
     */
    override fun create(context: Context): Fragment {
        Log.e("FragmentInitalizer","create")
        return Fragment()
    }

    /**
     * 返回初始化器所依赖的其它初始化器所需要的列表,可通过止方法来控制初始化的顺序
     */
    override fun dependencies(): List<Class<out Initializer<*>>> {
        Log.e("FragmentInitalizer","dependencies")
        return emptyList()
    }

}

class ActivityInitializer : Initializer<Activity>{
    /**
     * Initializes and a component given the application [Context]
     *
     * @param context The application context.
     */
    override fun create(context: Context): Activity {
        Log.e("ActivityInitializer","create")
        return Activity()
    }

    /**
     * @return A list of dependencies that this [Initializer] depends on. This is
     * used to determine initialization order of [Initializer]s.
     * <br></br>
     * For e.g. if a [Initializer] `B` defines another
     * [Initializer] `A` as its dependency, then `A` gets initialized before `B`.
     * 返回的是listOf(FragmentInitalizer::class.java)，所以初始化之前会先初始化FragmentInitalizer
     */
    override fun dependencies(): List<Class<out Initializer<*>>> {
        Log.e("ActivityInitializer","dependencies")
       return listOf(FragmentInitalizer::class.java)
    }

}