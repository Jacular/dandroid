package com.dandroid.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * 自定义头部参数拦截器，传入heads
 */
class HeadInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("token", "mkkv").build()
        builder.addHeader("device", "mkkv").build()
        builder.addHeader("isLogin", "mkkv").build()
        return chain.proceed(builder.build())
    }

}