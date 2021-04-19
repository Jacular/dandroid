package com.dandroid.module.home.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 后台实体
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class DiscountDetailResponse(
    var pay_type: String? = "",//哪一种支付方式的优惠类型{@link 对应DiscountPayType的枚举值}
    var card_no: String? = "",//加油卡号(pay_type为加油卡类型时返回，每张卡有不同的优惠)
    var origin_amount: Int = 0,//原价（分）
    var pay_money: Int = 0,//需要支付金额（分）
    var coupon_discount_money: Int = 0,//优惠券优惠金额（分）
    var platform_coupon_discount_money: Int = 0,//平台优惠券优惠金额（分）
    var total_discount_money: Int = 0,//总优惠金额（分）
    var discount_detail: List<DiscountBean>? = emptyList()//活动优惠的详情信息
) : Parcelable

@Parcelize
data class DiscountBean(
    var background_color: String? = "",//标签背景色（十六进制 eg:#FE6563）
    var discount_money: Int = 0,//优惠金额（分）
    var field_label: String? = "",//优惠标签名称
    var field_name: String? = "",//优惠唯一标识（eg:price_discount_detail）
    var field_value: String? = ""//优惠信息（eg:满8元直降0.2元/L）
): Parcelable


