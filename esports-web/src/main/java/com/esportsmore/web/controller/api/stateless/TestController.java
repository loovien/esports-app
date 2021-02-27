package com.esportsmore.web.controller.api.stateless;

import com.esportsmore.core.api.Result;
import com.esportsmore.web.dto.TestDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @PostMapping(value = "/test", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Result<TestDto> post(TestDto testDto) {
        return Result.wrapOKResult(testDto);
    }

    @RequestMapping(value = "/session")
    public Result<Object> getSessions(HttpSession httpSession) {
        Enumeration<String> attributeNames = httpSession.getAttributeNames();
        Map<String, Object> sessions = new HashMap<>();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            sessions.put(attributeName, httpSession.getAttribute(attributeName));
        }
        return Result.wrapOKResult(sessions);
    }

    @RequestMapping("/session/record")
    public Result<Boolean> setSession(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "value") String value,
            HttpSession httpSession) {
        httpSession.setAttribute(name, value);
        return Result.wrapOKResult(true);
    }
}
