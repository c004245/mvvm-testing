package com.example.test_mvvm_git.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.test_mvvm_git.R
import com.example.test_mvvm_git.databinding.FragmentProjectListBinding
import com.example.test_mvvm_git.di.Injectable
import com.example.test_mvvm_git.service.model.Project
import com.example.test_mvvm_git.view.adapter.ProjectAdapter
import com.example.test_mvvm_git.view.callback.ProjectClickCallback
import com.example.test_mvvm_git.viewmodel.ProjectListViewModel
import javax.inject.Inject

class ProjectListFragment: Fragment(), Injectable {

    lateinit var projectAdapter: ProjectAdapter
    lateinit var binding: FragmentProjectListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false)

        projectAdapter = ProjectAdapter(projectClickCallback)
        binding.projectList.adapter = projectAdapter
        binding.isLoading = true

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProjectListViewModel::class.java)

        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectListViewModel) {
        viewModel.getProjectListObservable().observe(this,
            Observer<List<Project>> { projects ->
                if (projects != null) {
                    projectAdapter.setProjectList(projects)
                }
            })
    }

    private val projectClickCallback = object : ProjectClickCallback {
        override fun onClick(project: Project) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                (activity as MainActivity).show(project)
            }
        }
    }
    companion object {
        val TAG = ProjectListFragment::class.simpleName
    }
}