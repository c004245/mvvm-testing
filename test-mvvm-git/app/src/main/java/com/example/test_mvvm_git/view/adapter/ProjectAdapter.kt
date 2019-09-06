package com.example.test_mvvm_git.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test_mvvm_git.R
import com.example.test_mvvm_git.databinding.ProjectListItemBinding
import com.example.test_mvvm_git.service.model.Project
import com.example.test_mvvm_git.view.callback.ProjectClickCallback
import javax.annotation.Nullable

class ProjectAdapter (private val projectClickCallback: ProjectClickCallback):
    RecyclerView.Adapter<ProjectAdapter.Companion.ProjectViewHolder>() {

    internal var projectList: List<Project>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.project_list_item, parent, false) as ProjectListItemBinding

        binding.setCallback(projectClickCallback)

        return ProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.binding.setProject(projectList!![position])
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return if (projectList == null) 0 else projectList!!.size
    }

    companion object {
        class ProjectViewHolder(val binding: ProjectListItemBinding): RecyclerView.ViewHolder(binding.root)
    }
}