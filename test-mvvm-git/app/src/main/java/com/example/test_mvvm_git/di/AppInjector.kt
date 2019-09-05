package com.example.test_mvvm_git.di

class AppInjector constructor(){
    companion object {
        fun init(mvvmApplication: MVVMApplication) {
            DaggerAppComponent.build().appl
        }
    }

}