package com.rubincomputers.springboot01.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {
    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {
        if (event instanceof InteractiveAuthenticationSuccessEvent){
            return;
        }
        Authentication authentication = event.getAuthentication();
        String auditMessage = "Login attempt with username " +
                authentication.getName() + " " +
                authentication.getAuthorities() + " " +
                authentication.getCredentials() + " " +
                authentication.getPrincipal() + " " +
                "\t\t Success: " + authentication.isAuthenticated();
        System.out.println(auditMessage);
    }
}
