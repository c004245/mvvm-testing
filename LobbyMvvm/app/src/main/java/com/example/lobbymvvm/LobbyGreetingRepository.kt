package com.example.lobbymvvm

import io.reactivex.Single

class LobbyGreetingRepository {
    fun getGreeting(): Single<String> {
        return Single.just("Hello from LobbyGreetingRepository")
    }
}