package com.example.test_mvvm_git.view.callback

import com.example.test_mvvm_git.service.model.Project

interface ProjectClickCallback {
    fun onClick(project: Project)
}