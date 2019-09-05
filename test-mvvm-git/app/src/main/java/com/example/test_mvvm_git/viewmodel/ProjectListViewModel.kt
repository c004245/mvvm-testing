package com.example.test_mvvm_git.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.test_mvvm_git.model.Project
import com.example.test_mvvm_git.service.repository.ProjectRepository

class ProjectListViewModel(private val app: Application): AndroidViewModel(app) {

    private val projectListObservable: LiveData<List<Project>>

    init {
        projectListObservable = ProjectRepository.getInstance().getProjectList("Google")
    }

    fun getProjectListObservable(): LiveData<List<Project>> {
        return projectListObservable
    }

}