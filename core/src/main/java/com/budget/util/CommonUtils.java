package com.budget.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author Harlan.Liu
 * @version 1.0
 * @date 2021/9/25 15:22
 *
 */
public class CommonUtils {

    /**
     * 检查字符串是否为空.
     */
    public static boolean isBlank(final String str) {
        return (str == null) || (str.trim().length() <= 0);
    }

    /**
     * 检查字符串是否不为空.
     */
    public static boolean isNotBlank(final String str) {
        return !(isBlank(str));
    }

    /**
     * 检查数组是否为空.
     */
    public static boolean isBlank(final Object[] objs) {
        return (objs == null) || (objs.length <= 0);
    }

    /**
     * 检查数组是否不为空.
     */
    public static boolean isNotBlank(final Object[] objs) {
        return !(isBlank(objs));
    }

    /**
     * 检查对象是否为空.
     */
    public static boolean isBlank(final Object objs) {
        return (objs == null) || "".equals(objs);
    }

    /**
     * 检查对象是否不为空.
     */
    public static boolean isNotBlank(final Object objs) {
        return !(isBlank(objs));
    }

    /**
     * 检查Collection是否为空.
     */
    public static boolean isBlank(final Collection obj) {
        return (obj == null) || (obj.size() <= 0);
    }

    /**
     * 检查Collection是否不为空.
     */
    public static boolean isNotBlank(final Collection obj) {
        return !(isBlank(obj));
    }

    /**
     * 检查Set是否为空.
     */
    public static boolean isBlank(final Set obj) {
        return (obj == null) || (obj.size() <= 0);
    }

    /**
     * 检查Set是否不为空.
     */
    public static boolean isNotBlank(final Set obj) {
        return !(isBlank(obj));
    }

    /**
     * 检查Serializable是否为空.
     */
    public static boolean isBlank(final Serializable obj) {
        return obj == null;
    }

    /**
     * 检查Serializable是否不为空.
     */
    public static boolean isNotBlank(final Serializable obj) {
        return !(isBlank(obj));
    }

    /**
     * 检查Map是否为空.
     */
    public static boolean isBlank(final Map obj) {
        return (obj == null) || (obj.size() <= 0);
    }

    /**
     * 检查Map是否不为空.
     */
    public static boolean isNotBlank(final Map obj) {
        return !(isBlank(obj));
    }

}
