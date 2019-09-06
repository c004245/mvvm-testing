package com.example.test_mvvm_git.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.test_mvvm_git.di.AppInjector.Companion.init
import com.example.test_mvvm_git.service.model.Project
import com.example.test_mvvm_git.service.repository.ProjectRepository
import javax.inject.Inject

class ProjectListViewModel @Inject constructor(projectRepository: ProjectRepository, application: Application): AndroidViewModel(application) {

    private val projectListObservable: LiveData<List<Project>> = projectRepository.getProjectList("Google")

    fun getProjectListObservable(): LiveData<List<Project>> {
        return projectListObservable
    }
}