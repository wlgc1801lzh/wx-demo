package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * 基于Jackson的json工具类
 *
 * @author hui
 * @date 2020-07-20 16:46:00
 */
public class JsonUtil {

    /**
     * 将对象转化为json字符串
     *
     * @param object 对象
     * @return json字符串
     */
    public static String parse2String(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 字符串转json对象
     *
     * @param str json字符串
     * @return JsonNode对象
     */
    public static JsonNode parse2json(String str) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

    /**
     * json字符串转java bean
     *
     * @param str     json字符串
     * @param classes 类
     * @param <T>     泛型
     * @return 泛型对象
     */
    public static <T> T parse2bean(String str, Class<T> classes) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T object = null;
        try {
            object = mapper.readValue(str, classes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * Restful 返回值
     *
     * @param code 状态码
     * @param msg  消息
     * @return json字符串
     */
    public static String response(int code, String msg) {
        ObjectMapper mapper = new ObjectMapper();
        String response = null;
        HashMap<String, Object> map = new LinkedHashMap<>(16);
        map.put("code", code);
        map.put("msg", msg);
        try {
            response = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * Restful 返回值
     *
     * @param code 状态码
     * @param msg  消息
     * @param data 数据
     * @return json字符串
     */
    public static String response(int code, String msg, Object data) {
        ObjectMapper mapper = new ObjectMapper();
        String response = null;
        HashMap<String, Object> map = new LinkedHashMap<>(16);
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        try {
            response = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * Restful 返回值
     *
     * @param code  状态码
     * @param count 计数
     * @param msg   消息
     * @param data  数据
     * @return json字符串
     */
    public static String response(int code, int count, String msg, Object data) {
        ObjectMapper mapper = new ObjectMapper();
        String response = null;
        HashMap<String, Object> map = new LinkedHashMap<>(16);
        map.put("code", code);
        map.put("count", count);
        map.put("msg", msg);
        map.put("data", data);
        try {
            response = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }

}
