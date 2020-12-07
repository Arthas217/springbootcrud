package com.hlj.jixi.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 定制json中的属性信息
 * 实现ErrorAttributes接口，否则返回错误信息内容来自DefaultErrorAttributes
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        // 向json中新添加公司信息
        map.put("company", "zuocheng");
        // 将新的属性context带到json的属性中
        Map<String, Object> contentMap = (Map<String, Object>) webRequest.getAttribute("content", 0);
        if (contentMap != null) {
            map.put("ext", contentMap);
        }
        return map;
    }
}
