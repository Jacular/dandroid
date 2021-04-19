package com.dandroid.module.home.request

import com.dandroid.module.home.model.ApiPagerResponse
import com.dandroid.module.home.model.ApiResponse
import com.dandroid.module.home.model.DiscountDetailResponse

import retrofit2.http.*

/**
 * 网络API
 */
interface ApiService {


    /**
     * 解析实体内容
     */
    @FormUrlEncoded
    @POST("demo/bean")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") pwd: String
    ): ApiResponse<DiscountDetailResponse>

    /**
     * 只返回结果，不解析
     */
    @FormUrlEncoded
    @POST("demo/any")
    suspend fun register(
        @Field("username") username: String, @Field("password") pwd: String, @Field(
            "repassword"
        ) rpwd: String
    ): ApiResponse<Any>

    /**
     * 获取数组方式
     */
    @GET("demo/listJson")
    suspend fun getList(): ApiResponse<ArrayList<DiscountDetailResponse>>



    /**
     * 分页方式
     */
    @GET("demo/list/{page}/json")
    suspend fun getPageList(@Path("page") pageNo: Int): ApiResponse<ApiPagerResponse<ArrayList<DiscountDetailResponse>>>



}