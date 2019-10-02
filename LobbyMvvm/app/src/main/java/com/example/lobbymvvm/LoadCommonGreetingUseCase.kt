package com.example.lobbymvvm

import io.reactivex.Single
import javax.inject.Inject

class LoadCommonGreetingUseCase @Inject constructor(private val greetingRepository: CommonGreetingRepository) {

    fun execute(): Single<String> {
        return greetingRepository.getGreeting()
    }
}