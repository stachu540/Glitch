package io.glitchlib.api.service.request

import io.glitchlib.auth.AppCredential
import io.glitchlib.internal.http.AbstractRequest
import io.glitchlib.internal.http.HttpRequest

class ExtensionTransactionRequest internal constructor(
    private val credential: AppCredential
) : AbstractRequest {
    private var limit: Int? = null
    private var after: String? = null
    private var before: String? = null

    fun limit(limit: Int) = apply {
        this.limit = limit
    }

    fun after(after: String) = apply {
        this.after = after
    }

    fun before(before: String) = apply {
        this.before = before
    }

    override fun invoke(): HttpRequest.() -> Unit = {
        if (limit != null && limit!! in 1..100) addQueryParameters("first", limit!!.toString())
        if (after != null) addQueryParameters("after", after!!)
        if (before != null) addQueryParameters("before", before!!)

        addHeaders("Authorization", "Bearer ${credential.accessToken}")
        addQueryParameters("extension_id", credential.clientId)
    }
}