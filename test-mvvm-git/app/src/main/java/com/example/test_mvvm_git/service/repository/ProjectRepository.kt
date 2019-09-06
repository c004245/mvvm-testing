package com.example.test_mvvm_git.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test_mvvm_git.service.model.Project
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectRepository @Inject constructor(private val githubService: GithubService) {

    fun getProjectList(userId: String): LiveData<List<Project>> {
        val data = MutableLiveData<List<Project>>()

        githubService.getProjectList(userId).enqueue(object: Callback<List<Project>> {
            override fun onResponse(call: Call<List<Project>>?, response: Response<List<Project>>?) {
                data.value = response!!.body()
            }

            override fun onFailure(call: Call<List<Project>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        return data
    }

    fun getProjectDetails(userId: String, projectName: String): LiveData<Project> {
        val data = MutableLiveData<Project>()

        githubService.getProjectDetails(userId, projectName).enqueue(object: Callback<Project> {
            override fun onResponse(call: Call<Project>?, response: Response<Project>?) {
                simulateDelay()
                data.value = response!!.body()
            }

            override fun onFailure(call: Call<Project>?, t: Throwable?) {
                data.value = null
            }
        })
        return data
    }

    fun simulateDelay() {
        try {
            Thread.sleep(10)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}