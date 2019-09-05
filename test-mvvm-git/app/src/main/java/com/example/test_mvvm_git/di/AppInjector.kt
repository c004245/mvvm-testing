package com.example.test_mvvm_git.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.test_mvvm_git.MVVMApplication
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

class AppInjector constructor() {
    companion object {
        fun init(mvvmApplication: MVVMApplication) {
            DaggerAppComponent.build().application(mvvmApplication)
                .build().inject(mvvmApplication)

            mvvmApplication
                .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                    override fun onActivityResumed(p0: Activity) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onActivityStopped(p0: Activity) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onActivityDestroyed(p0: Activity) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onActivityStarted(p0: Activity) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onActivityPaused(p0: Activity) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle) {
                        handleActivity(activity)
                    }
                })
        }

        fun handleActivity(activity: Activity) {
            if (activity is HasSupportFragmentInjector) {
                AndroidInjection.inject(activity)
            }

            if (activity is FragmentActivity) {
                activity.supportFragmentManager
                    .registerFragmentLifecycleCallbacks(
                        object : FragmentManager.FragmentLifecycleCallbacks() {
                            override fun onFragmentCreated(
                                fm: FragmentManager,
                                fragment: Fragment,
                                savedInstanceState: Bundle?
                            ) {
                                if (fragment is Injectable) {
                                    AndroidSupportInjection.inject(fragment)
                                }
                            }
                        }, true
                    )
            }

        }
    }

}