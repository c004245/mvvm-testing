package com.example.test_mvvm_git.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.test_mvvm_git.R
import com.example.test_mvvm_git.databinding.FragmentProjectDetailsBinding
import com.example.test_mvvm_git.di.Injectable
import com.example.test_mvvm_git.service.model.Project
import com.example.test_mvvm_git.viewmodel.ProjectViewModel
import javax.inject.Inject

class ProjectFragment: Fragment(), Injectable {

    lateinit var binding: FragmentProjectDetailsBinding

    @Inject
    val viewModelFactory: ViewModelProvider.Factory


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_details, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ProjectViewModel::class.java)

        viewModel.projectID.value = arguments!!.getString(KEY_PROJECT_ID)

        binding.projectViewModel = viewModel
        binding.isLoading = true

        observeViewModel(viewModel)
    }

    fun observeViewModel(viewModel: ProjectViewModel) {
        viewModel.projectObservable.observe(this, Observer<Project> { project ->
            if (project != null) {
                binding.isLoading = false
                viewModel.setProject(project)
            }
        })
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