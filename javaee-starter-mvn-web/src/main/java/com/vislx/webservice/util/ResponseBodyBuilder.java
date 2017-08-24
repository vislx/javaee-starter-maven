/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vislx.webservice.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author victor
 */

public class ResponseBodyBuilder {
    
    public static Map<String ,Object> buildObject(Object data){
        Map<String, Object> result = new HashMap<>();
        result.put("data", data);
        result.put("status", 200);
        result.put("count", data == null ? 0 : 1);
        return result;
    }
    
    public static Map<String ,Object> buildList(List data){
        Map<String, Object> result = new HashMap<>();
        result.put("data", data);
        result.put("count", data.size());
        result.put("status", 200);
        return result;
    }
    
    public static Map<String ,Object> buildMessage(int statusCode, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("status", statusCode);
        return result;
    }    
}
