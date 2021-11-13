package com.zwl.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map map, T bean){

        try {
            BeanUtils.populate(bean,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue){

        if (strInt != null && !"".equals(strInt)){
            try {
                return Integer.parseInt(strInt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return defaultValue;

    }
}
