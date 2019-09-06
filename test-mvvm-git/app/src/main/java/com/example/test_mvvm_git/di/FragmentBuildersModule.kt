package com.example.test_mvvm_git.di

import com.example.test_mvvm_git.view.ProjectFragment
import com.example.test_mvvm_git.view.ProjectListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProjectFragment(): ProjectFragment

    @ContributesAndroidInjector
    abstract fun contributeProjectListFragment(): ProjectListFragment
}