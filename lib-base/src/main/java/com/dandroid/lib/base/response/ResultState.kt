package com.dandroid.lib.base.response
import android.net.ParseException
import androidx.lifecycle.MutableLiveData
import com.dandroid.lib.base.response.BaseResponse
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException

/**
 * 自定义结果集封装类
 */
sealed class ResultState<out T> {
    companion object {
        fun <T> onAppSuccess(data: T): ResultState<T> = Success(data)
        fun <T> onAppLoading(loadingMessage:String): ResultState<T> = Loading(loadingMessage)
        fun <T> onAppError(error: AppException): ResultState<T> = Error(error)
    }
    data class Loading(val loadingMessage:String) : ResultState<Nothing>()
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val error: AppException) : ResultState<Nothing>()
}

/**
 * 处理返回值
 * @param result 请求结果
 */
fun <T> MutableLiveData<ResultState<T>>.paresResult(result: BaseResponse<T>) {
    value = when {
        result.isSuccess() -> {
            ResultState.onAppSuccess(result.getResponseData())
        }
        else -> {

            ResultState.onAppError(AppException(result.getResponseCode(), result.getResponseMsg()))
        }
    }
}

/**
 * 不处理返回值 直接返回请求结果
 * @param result 请求结果
 */
fun <T> MutableLiveData<ResultState<T>>.paresResult(result: T) {
    value = ResultState.onAppSuccess(result)
}

/**
 * 异常转换异常处理
 */
fun <T> MutableLiveData<ResultState<T>>.paresException(e: Throwable) {
    this.value = ResultState.onAppError(handleException(e))
}
fun handleException(e: Throwable?): AppException {
    val ex: AppException
    e?.let {
        when (it) {
            is HttpException -> {
                ex = AppException(
                    Error.NETWORK_ERROR,
                    e
                )
                return ex
            }
            is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> {
                ex = AppException(
                    Error.PARSE_ERROR,
                    e
                )
                return ex
            }
            is ConnectException -> {
                ex = AppException(
                    Error.NETWORK_ERROR,
                    e
                )
                return ex
            }
            is javax.net.ssl.SSLException -> {
                ex = AppException(
                    Error.SSL_ERROR,
                    e
                )
                return ex
            }
            is ConnectTimeoutException -> {
                ex = AppException(
                    Error.TIMEOUT_ERROR,
                    e
                )
                return ex
            }
            is java.net.SocketTimeoutException -> {
                ex = AppException(
                    Error.TIMEOUT_ERROR,
                    e
                )
                return ex
            }
            is java.net.UnknownHostException -> {
                ex = AppException(
                    Error.TIMEOUT_ERROR,
                    e
                )
                return ex
            }
            is AppException -> return it

            else -> {
                ex =
                    AppException(Error.UNKNOWN, e)
                return ex
            }
        }
    }
    ex = AppException(Error.UNKNOWN, e)
    return ex
}

