/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.api.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.teso.story.api.constants.statusCode;

/**
 *
 * @author ASUS
 */
public class responseUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String success(JsonNode body) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put(statusCode.class.getSimpleName(), statusCode.SUCCESS.getValue());
        objectNode.put("message", statusCode.SUCCESS.name());
        objectNode.set("response", body);
        return objectNode.toString();
    }

    public static String invalid() {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put(statusCode.class.getSimpleName(), statusCode.PARAMETER_INVALID.getValue());
        objectNode.put("message", statusCode.PARAMETER_INVALID.name());
        objectNode.put("response", "");
        return objectNode.toString();
    }

    public static String notFound() {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put(statusCode.class.getSimpleName(), statusCode.NOT_FOUND.getValue());
        objectNode.put("message", statusCode.NOT_FOUND.name());
        objectNode.put("response", "");
        return objectNode.toString();
    }

}
