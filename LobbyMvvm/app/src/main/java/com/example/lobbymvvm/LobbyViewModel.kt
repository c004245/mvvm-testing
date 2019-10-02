package com.example.lobbymvvm

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class LobbyViewModel constructor(private val loadCommonGreetingUseCase: LoadCommonGreetingUseCase,
                                 private val loadLobbyGreetingUseCase: LoadLobbyGreetingUseCase,
                                 private val schedulersFacade: SchedulersFacade): ViewModel() {

    val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
    }

    fun loadCommonGreeting() {
        loadGreeting(lo)
    }

    private fun loadGreeting(loadGreetingUseCase: LoadGreetingUseCase) {
        disposables.add(loadGreetingUseCase.execute().sub)
    }
}