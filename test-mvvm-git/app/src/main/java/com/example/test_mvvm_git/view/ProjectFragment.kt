package com.example.test_mvvm_git.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.test_mvvm_git.di.Injectable
import com.example.test_mvvm_git.viewmodel.ProjectViewModel
import javax.inject.Inject

class ProjectFragment: Fragment(), Injectable {


    @Inject
    val viewModelFactory: ViewModelProvider.Factory

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProjectViewModel::class.java)
    }

    companion object {

        val KEY_PROJECT_ID = "project_id"

        fun forProject(projectId: String): ProjectFragment {
            val fragment = ProjectFragment()
            val args = Bundle()

            args.putString(KEY_PROJECT_ID, projectId)
            fragment.arguments = args

            return fragment
        }
    }
}