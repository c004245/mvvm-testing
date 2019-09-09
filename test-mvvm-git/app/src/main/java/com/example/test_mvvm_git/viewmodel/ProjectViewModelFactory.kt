package com.example.test_mvvm_git.viewmodel

import android.telecom.Call
import android.util.ArrayMap
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Singleton
import androidx.lifecycle.ViewModel
import com.example.test_mvvm_git.di.ViewModelSubComponent
import java.util.concurrent.Callable
import javax.inject.Inject
import java.lang.RuntimeException

@Singleton
class ProjectViewModelFactory @Inject constructor(private val viewModelSubComponent: ViewModelSubComponent): ViewModelProvider.Factory {

    private var creators: ArrayMap<Class<*>, Callable<out ViewModel>>? = null
    init {
        creators = ArrayMap()
        creators!![ProjectViewModel::class.java] = Callable { viewModelSubComponent.projectViewModel() }
        creators!![ProjectListViewModel::class.java] = Callable { viewModelSubComponent.projectListViewModel() }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        val creator = creators[modelClass] as Callable<out ViewModel>
        var creator = creators?.get(modelClass) as Callable<out ViewModel>
        if (creator == null) {
            for (entry: Map.Entry<Class<*>, Callable<out ViewModel>> in creators!!.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    creator = entry.value
                    break
                }
            }
        }

        if (creator == null) {
            throw IllegalArgumentException("Unknown model class $modelClass")
        }
        try {
            return creator.call() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}
