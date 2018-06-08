package com.keepdigging.ds.string;

import java.util.Set;

/**
 * 统一字符串匹配接口
 */
public interface StringMatchApi {

    int searchOnce(char[] text, char pattern);

    Set<Integer> searchAll(char[] text, char pattern);
}
