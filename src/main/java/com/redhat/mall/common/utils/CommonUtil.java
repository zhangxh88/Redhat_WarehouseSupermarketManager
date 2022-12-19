package com.redhat.mall.common.utils;

import com.redhat.mall.domain.Base;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommonUtil {
    public static Map<String, Object> convertObjToMap(Object object) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = object.getClass();
        int pageIndex = 0;
        int pageSize = 0;
        boolean pageFlag = false;

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(object);
            map.put(field.getName(), value);

            if ("pageIndex".equals(field.getName())) {
                pageIndex = (int) value;
                pageFlag = true;
            }
            if ("pageSize".equals(field.getName())) {
                pageSize = (int) value;
            }
        }

        if (pageFlag) {
            map.put("offset", (pageIndex - 1) * pageSize);
        }
        return map;
    }

    public static void copyProperties(Object sourceObj, Object destObj) {
        BeanUtils.copyProperties(sourceObj, destObj);
    }

    public static void wrapSaveObj(Base baseObj) {
        baseObj.setId(UUID.randomUUID().toString().replace("-", ""));
        baseObj.setCreateTime(new Date());
        baseObj.setCreateUser("1");
        baseObj.setUpdateTime(new Date());
        baseObj.setUpdateUser("1");
    }

    public static void wrapUpdateObj(Base baseObj) {
        baseObj.setUpdateTime(new Date());
        baseObj.setUpdateUser("1");
    }
}
