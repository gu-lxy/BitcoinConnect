package com.btc.connect;


/**
 * 比特币地址类型的枚举，一共有三中：legacy、p2sh-segwit、bech32
 * 标识符规范：标识符只能有字母、数字、下划线、$组成，不能艺术字开头
 */
public enum ADDRES_TYPE {
    LEGACY,
    P2SH_SEGWIT,
    BECH32
}
