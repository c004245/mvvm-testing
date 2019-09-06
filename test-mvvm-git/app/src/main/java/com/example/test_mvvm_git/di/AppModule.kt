package com.example.test_mvvm_git.di

import androidx.lifecycle.ViewModelProvider
import com.example.test_mvvm_git.service.repository.GithubService
import com.example.test_mvvm_git.viewmodel.ProjectViewModelFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(subcomponents = [ViewModelSubComponent::class])
class AppModule {
    @Singleton
    @Provides
    fun provideGithubService(): GithubService {
        return Retrofit.Builder()
            .baseUrl(GithubService.HTTPS_API_GITHUB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }

    @Singleton
    @Provides
    fun provideViewModelFactory(viewModelSubComponent: ViewModelSubComponent.Builder): ViewModelProvider.Factory {
        return ProjectViewModelFactory(viewModelSubComponent.build())
    }
}

