package com.example.lobbymvvm


/**
 * Response holder provided to the UI
 */
class Response constructor(private val status: Status, private val data: String?, private val error: Throwable?) {

    companion object {
        fun loading(): Response {
            return Response(Status.LOADING, null, null)
        }

        fun success(data: String): Response {
            return Response(Status.SUCCESS, data, null)
        }

        fun error(error: Throwable): Response {
            return Response(Status.ERROR, null, error)
        }
    }
}