package com.hatkar.spotifybackend.usercontext.Controller;

import com.hatkar.spotifybackend.usercontext.Application.UserService;
import com.hatkar.spotifybackend.usercontext.ReadUserDTO;
import com.hatkar.spotifybackend.usercontext.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthRessource {
    private final UserService userService;
    private final ClientRegistration registration;


    public AuthRessource(UserService userService, ClientRegistrationRepository registration) {
        this.userService = userService;
        this.registration = registration.findByRegistrationId("okta");
    }

    @GetMapping("/get-authenticated-user")
    public ResponseEntity<ReadUserDTO> getAuthenticatedUser(@AuthenticationPrincipal OAuth2User user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
    userService.syncWithIdp(user);
    ReadUserDTO userFromAuthentication = userService.getAuthenticatedUser();
    return ResponseEntity.ok().body(userFromAuthentication);

        }
    }


    public ResponseEntity<?> logout(HttpServletRequest request) {
        String issuerUrl = registration.getProviderDetails().getIssuerUri();
        String originUrl = request.getHeader(HttpHeaders.ORIGIN);
        Object[] params = {issuerUrl,registration.getClientId(), originUrl};
        String logoutUrl = MessageFormat.format("{0}v2/logout?clientId={1}&returnTo={2}",params );
        request.getSession().invalidate();
        return ResponseEntity.ok().body(Map.of("logoutUrl",logoutUrl));
    }
}
