package com.example.lobbymvvm

import io.reactivex.Single

interface LoadGreetingUseCase {
    fun execute(): Single<String>
}