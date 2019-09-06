package com.example.test_mvvm_git.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.test_mvvm_git.di.AppInjector.Companion.init
import com.example.test_mvvm_git.service.model.Project
import com.example.test_mvvm_git.service.repository.ProjectRepository

import javax.inject.Inject

class ProjectViewModel @Inject
constructor(projectRepository: ProjectRepository, application: Application) : AndroidViewModel(application) {

    var projectObservable: LiveData<Project>

    var projectID: MutableLiveData<String> = MutableLiveData()
    set(value) = projectID.value = value


    var project = ObservableField<Project>()

    init {
        ABSENT.setValue(null)
    }

    init {
        projectObservable = Transformations.switchMap(projectID) { input ->
            if (input.isEmpty()) {
                return@switchMap ABSENT
            }

            projectRepository.getProjectDetails("Google", projectID.value!!)
        }
    }

    fun setProject(project: Project) {
        this.project.set(project)
    }

    companion object {
        private val TAG = ProjectViewModel::class.java.simpleName
        private val ABSENT = MutableLiveData<Project>()
    }
}
