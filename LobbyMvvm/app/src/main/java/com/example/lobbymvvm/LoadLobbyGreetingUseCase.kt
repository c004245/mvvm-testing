package com.example.lobbymvvm

import io.reactivex.Single
import javax.inject.Inject

class LoadLobbyGreetingUseCase @Inject constructor(private val greetingRepository: LobbyGreetingRepository) {

    fun execute(): Single<String> {
        return greetingRepository.getGreeting()
    }
}