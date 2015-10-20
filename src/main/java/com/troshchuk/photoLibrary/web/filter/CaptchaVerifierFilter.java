package com.troshchuk.photoLibrary.web.filter;

import com.troshchuk.photoLibrary.security.CaptchaContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter for verifying if the submitted Captcha fields
 * are valid.
 */
public class CaptchaVerifierFilter extends OncePerRequestFilter {
    private String failureUrl;
    private CaptchaCaptureFilter captchaCaptureFilter;

    @Autowired
    private CaptchaContainer captchaContainer;

    private SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

    private static final Logger LOGGER = LogManager.getLogger(CaptchaVerifierFilter.class.getName());

    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
                                 FilterChain chain) throws IOException, ServletException {
        if (req.getRequestURI().equals("/j_spring_security_check")) {
            if (captchaContainer.validate(req.getRequestedSessionId(), req.getParameter("captcha"))) {
                chain.doFilter(req, res);
            } else {
                failureHandler.setDefaultFailureUrl(failureUrl);
                failureHandler.onAuthenticationFailure(req, res, new BadCredentialsException("Captcha invalid!"));
                LOGGER.info("Captcha is invalid");
            }
        } else {
            chain.doFilter(req, res);
        }
    }


    public void setFailureUrl(String failureUrl) {
        this.failureUrl = failureUrl;
    }

    public void setCaptchaCaptureFilter(CaptchaCaptureFilter captchaCaptureFilter) {
        this.captchaCaptureFilter = captchaCaptureFilter;
    }
}
 
