package com.example.test_mvvm_git.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.test_mvvm_git.R
import com.example.test_mvvm_git.di.Injectable
import com.example.test_mvvm_git.service.model.Project
import com.example.test_mvvm_git.viewmodel.ProjectListViewModel

class ProjectListFragment: Fragment(), Injectable {

    lateinit var projectAdapter: ProjectAdapter
    lateinit var binding: FragmentProjectListBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(ProjectListViewModel::class.java)

        observeViewModel(viewModel)
    }

    fun observeViewModel(viewModel: ProjectListViewModel) {
        viewModel.getProjectListObservable().observe(this, object : Observer<List<Project>> {
            override fun onChanged(projects: List<Project>?) {
                if (projects != null) {
                    projectAdapter.setProjectList(projects)
                }
            }
        })
    }

    companion object {
        val TAG = ProjectListFragment::class.simpleName
    }
}