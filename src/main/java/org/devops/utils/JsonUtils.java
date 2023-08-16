package org.devops.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang.StringUtils;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        //序列化时 跳过null属性
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //序列化时 遇到空bean不会失败
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        //反序列化时 遇到未知属性不会失败
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //反序列化时 将空数组当作null来处理
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

        //不通过fields来探测，仅通过getter探测
        mapper.configure(MapperFeature.AUTO_DETECT_FIELDS, false);
    }


    /**
     * 序列化
     */
    public static String writeToString(Object target) {
        try {
            return mapper.writeValueAsString(target);
        } catch (JsonProcessingException e) {
            LogUtils.logWarn(JsonUtils.class, String.format("write to string error. target = %s,msg = %s", target.getClass(), e.getMessage()));
            return StringUtils.EMPTY;
        }
    }

    /**
     * 反序列化
     */
    public static <T> T parse(String json, Class<T> type) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }

        try {
            return mapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            LogUtils.logWarn(JsonUtils.class, String.format("parse error. json = %s, type = %s ,msg = %s", json, type, e.getMessage()));
            return null;
        }
    }
}
