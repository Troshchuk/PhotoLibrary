package com.troshchuk.photoLibrary.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CaptchaContainer {
    protected Map<String, String> captches = new HashMap<String, String>();
    protected Map<String, Long> sessionsTerms = new HashMap<String, Long>();

    public boolean validate(String session, String answer) {
        String key = captches.get(session);
        boolean result = key != null && key.equals(answer);
        if (result) {
            sessionsTerms.put(session, System.currentTimeMillis());
            return true;
        } else {
            add(session, String.valueOf((int) Math.floor(Math.random() * 100)));
            return false;
        }
    }

    public void add(String session, String answer) {
        captches.put(session, answer);
    }

    public String getCaptcha(String session) {
        return captches.get(session);
    }

    public long getTimeInterval(String session) {
        Long term = sessionsTerms.get(session);
        if (term == null) {
            sessionsTerms.put(session, System.currentTimeMillis());
            return 0;
        }
        return System.currentTimeMillis() - sessionsTerms.get(session);
    }
}
