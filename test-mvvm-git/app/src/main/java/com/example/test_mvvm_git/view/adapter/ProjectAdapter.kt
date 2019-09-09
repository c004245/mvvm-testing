package com.example.test_mvvm_git.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test_mvvm_git.R
import com.example.test_mvvm_git.databinding.ProjectListItemBinding
import com.example.test_mvvm_git.service.model.Project
import com.example.test_mvvm_git.view.callback.ProjectClickCallback
import java.util.*

class ProjectAdapter (private val projectClickCallback: ProjectClickCallback):
    RecyclerView.Adapter<ProjectAdapter.Companion.ProjectViewHolder>() {

    var listProject: List<Project>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.project_list_item, parent, false) as ProjectListItemBinding

        binding.callback = projectClickCallback

        return ProjectViewHolder(binding)
    }

    fun setProjectList(projectList: List<Project>?) {
        if (this.listProject == null) {
            this.listProject = projectList
            notifyItemRangeInserted(0, projectList!!.size)
        } else {
            val result = DiffUtil.calculateDiff(object: DiffUtil.Callback() {

                override fun getOldListSize(): Int {
                    return listProject!!.size
                }

                override fun getNewListSize(): Int {
                    return projectList!!.size
                }

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return listProject!![oldItemPosition].id == projectList!![newItemPosition].id
                }

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val project = projectList!![newItemPosition]
                    val old = projectList[oldItemPosition]

                    return project.id == old.id && Objects.equals(project.git_url, old.git_url)
                }
            })
            this.listProject = projectList
            result.dispatchUpdatesTo(this)
        }
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.binding.project = listProject!![position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return if (listProject == null) 0 else listProject!!.size
    }

    companion object {
        class ProjectViewHolder(val binding: ProjectListItemBinding): RecyclerView.ViewHolder(binding.root)
    }
}