package com.example.lobbymvvm

import io.reactivex.Single

class CommonGreetingRepository {
    fun getGreeting(): Single<String> {
        return Single.just("Hello from CommonGreetingRepository")
    }
}