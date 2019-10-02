package com.example.lobbymvvm

import io.reactivex.Single
import javax.inject.Inject

class LoadCommonGreetingUseCase @Inject constructor(private val greetingRepository: CommonGreetingRepository): LoadGreetingUseCase {

    override fun execute(): Single<String> {
        return greetingRepository.getGreeting()
    }
}