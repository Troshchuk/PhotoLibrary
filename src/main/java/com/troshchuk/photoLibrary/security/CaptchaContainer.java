package com.troshchuk.photoLibrary.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CaptchaContainer {
    protected Map<String, String> captches = new HashMap<String, String>();

    public boolean validate(String session, String answer) {
        String key = captches.get(session);
        return key != null && key.equals(answer);
    }

    public void add(String session, String answer) {
        captches.put(session, answer);
    }

    public String getCaptcha(String session) {
        return captches.get(session);
    }
}
