package com.example.test_mvvm_git.di

import com.example.test_mvvm_git.viewmodel.ProjectListViewModel
import dagger.Subcomponent

@Subcomponent
interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    fun projectListViewModel(): ProjectListViewModel
    fun projectViewModel(): ProjectViewModel
}