package com.dandroid.network.interceptor

import android.os.Build
import android.util.Base64
import com.dandroid.lib.global.AppUtils
import com.dandroid.lib.global.appContext
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.*

/**
 * 自定义头部参数拦截器，传入heads
 */
const val CLIENT_ID = "2f6cebf8-ed1e-11e5-b7ad-acbc32acde63"
const val CLIENT_SECRET = "1ee28ee1-3036-4828-a98a-c12a053b5bde"


val systemVersion = Build.VERSION.SDK_INT.toString()
val vender = Build.MANUFACTURER + Build.MODEL
val appVersion = AppUtils.getVerName(appContext)
val authorization = "Basic " + Base64.encodeToString(
    ("$CLIENT_ID:$CLIENT_SECRET").toByteArray(),
    Base64.NO_WRAP
)

class HeadInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request().newBuilder().run {
            addHeader("platform", "android")
            addHeader("clientType", "android")
            addHeader("channelPackage", "default")
            addHeader("comefrom", "36")

            addHeader("systemVersion", systemVersion)
            addHeader("vender", vender)
            addHeader("appVersion", appVersion)
            addHeader("Authorization", authorization)
            addHeader("time", Calendar.getInstance().timeInMillis.toString())
            addHeader("token","kdfgjdsngjkfnsdjkgnsdjkngjkdsfngkljsbdjkgfbklnsfgjksbdfkjgn")
            build()
        })
    }

}