package com.dandroid.lib.global.exception

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tencent.mmkv.MMKV
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

/**
 * 应用模块: storage
 *
 *
 * 类描述: 腾讯MMKV序列化存储工具类
 *
 *
 */
class MMkvHelper private constructor() {
    val mmkv: MMKV

    /**
     * 存入map集合
     *
     * @param key 标识
     * @param map 数据集合
     */
    fun saveInfo(
        key: String?,
        map: Map<String?, Any?>?
    ) {
        val gson = Gson()
        val mJsonArray = JSONArray()
        var `object`: JSONObject? = null
        try {
            `object` = JSONObject(gson.toJson(map))
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        mJsonArray.put(`object`)
        mmkv.encode(key, mJsonArray.toString())
    }

    /**
     * 获取map集合
     *
     * @param key 标识
     */
    fun getInfo(key: String?): Map<String, String> {
        val itemMap: MutableMap<String, String> =
            HashMap()
        val result = mmkv.decodeString(key, "")
        try {
            val array = JSONArray(result)
            for (i in 0 until array.length()) {
                val itemObject = array.getJSONObject(i)
                val names = itemObject.names()
                if (names != null) {
                    for (j in 0 until names.length()) {
                        val name = names.getString(j)
                        val value = itemObject.getString(name)
                        itemMap[name] = value
                    }
                }
            }
        } catch (e: JSONException) {
        }
        return itemMap
    }

    /**
     * 扩展MMKV类使其支持对象存储
     *
     */
    fun <T> getObject(key: String?, t: Class<T>?): T? {
        val str = mmkv.decodeString(key, null)
        return if (!TextUtils.isEmpty(str)) {
            GsonBuilder().create().fromJson(str, t)
        } else {
            null
        }
    }

    fun putObject(key: String?, `object`: Any?) {
        val jsonString = GsonBuilder().create().toJson(`object`)
        mmkv.encode(key, jsonString)
    }

    companion object {
        private val mmkv: MMKV? = null
        private var INSTANCE: MMkvHelper? = null
        val instance: MMkvHelper?
            get() {
                if (INSTANCE == null) {
                    INSTANCE = MMkvHelper()
                }
                return INSTANCE
            }
    }

    init {
        mmkv = MMKV.defaultMMKV()
    }
}