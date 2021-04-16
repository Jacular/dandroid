package com.dandroid.home.model

import com.dandroid.base.response.BaseResponse


/**
 * code data msg 对应你服务器返回字段
 */
data class ApiResponse<T>(val errorCode: Int, val errorMsg: String, val data: T) : BaseResponse<T>() {

    override fun isSuccess()= errorCode == 0

    override fun getResponseCode() = errorCode

    override fun getResponseData() = data

    override fun getResponseMsg() = errorMsg

}