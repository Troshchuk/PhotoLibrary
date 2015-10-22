package com.troshchuk.photoLibrary.web.filter;

import com.troshchuk.photoLibrary.security.CaptchaContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter for capturing Captcha fields.
 * It's purpose is to store these values internally
 */
public class CaptchaCaptureFilter extends OncePerRequestFilter {
    @Autowired
    private CaptchaContainer captchaContainer;

    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
                                 FilterChain chain) throws IOException, ServletException {

        if (req.getRequestURI().equals("/login")) {
            captchaContainer.add(req.getRequestedSessionId(), String.valueOf((int) Math.floor(Math.random() * 100)));
            chain.doFilter(req, res);
        } else if (!"/verify_captcha".equals(req.getRequestURI()) && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                && captchaContainer.getTimeInterval(req.getRequestedSessionId()) > 1000 * 20) {
            req.getRequestDispatcher("/captcha").forward(req, res);
        } else {

            chain.doFilter(req, res);
        }
    }
}
 
