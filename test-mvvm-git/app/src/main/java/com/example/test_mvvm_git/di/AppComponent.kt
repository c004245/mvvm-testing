package com.example.test_mvvm_git.di

import android.app.Application
import com.example.test_mvvm_git.MVVMApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appliation(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mvvmApplication: MVVMApplication)
}

