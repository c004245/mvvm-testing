package com.example.lobbymvvm

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulersFacade {

    /**
     * IO Thread poll scheduler
     */
    fun io(): Scheduler {
        return Schedulers.io()
    }

    /**
     * Computation thread pool scheduler
     */
    fun computation(): Scheduler {
        return Schedulers.computation()
    }

    /**
     * Main Thread Scheduler
     */
    fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}