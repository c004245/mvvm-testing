package com.example.test_mvvm_git.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.test_mvvm_git.service.model.Project
import com.example.test_mvvm_git.service.repository.ProjectRepository

import javax.inject.Inject

class ProjectViewModel @Inject
constructor(projectRepository: ProjectRepository, application: Application) : AndroidViewModel(application) {

    private val projectObservable: LiveData<Project>
    private val projectID: MutableLiveData<String> = MutableLiveData()

    var project = ObservableField<Project>()

    init {
        ABSENT.setValue(null)
    }

    init {

        projectObservable = Transformations.switchMap(projectID) { input ->
            if (input.isEmpty()) {
                return@switchMap ABSENT
            }

            projectRepository.getProjectDetails("Google", projectID.value)
        }
    }

    companion object {

        private val TAG = ProjectViewModel::class.java.simpleName
        private val ABSENT = MutableLiveData<Project>()
    }
}
