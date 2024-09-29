package com.hatkar.spotifybackend.usercontext.Application;

import com.hatkar.spotifybackend.usercontext.ReadUserDTO;
import com.hatkar.spotifybackend.usercontext.domain.User;
import com.hatkar.spotifybackend.usercontext.mapper.UserMapper;
import com.hatkar.spotifybackend.usercontext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;

@Service

public class UserService {
    //@Autowired
   private final UserRepository userRepository;
   // @Autowired
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

   /* public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }*/

    //extraction de jwt
    public ReadUserDTO getAuthenticatedUser() {
        OAuth2User principal = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = mapOauthToUser(principal.getAttributes());
        return userMapper.userToReadUserDTO(user);
    }

    public void syncWithIdp(OAuth2User oAuth2User) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        User user = mapOauthToUser(attributes);
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            if (attributes.get("updated_at") != null) {
                Instant dbLastModifiedDate = existingUser.orElseThrow().getLastModified();
                Instant idpModifiedDate;
                if(attributes.get("updated_at") instanceof Instant) {
                    idpModifiedDate = (Instant) attributes.get("updated_at");
                } else {
                    idpModifiedDate = Instant.ofEpochSecond((Integer) attributes.get("updated_at"));
                }
                if(idpModifiedDate.isAfter(dbLastModifiedDate)) {
                    updateUser(user);
                }
            }
        } else {
            userRepository.saveAndFlush(user);
        }
    }

    //mettre a jours un utilisateur si besoin
    private void updateUser(User user) {
        Optional<User> userToUpdateop = userRepository.findByEmail(user.getEmail());
        if (userToUpdateop.isPresent()) {
            User userToUpdate = userToUpdateop.get();
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setImageUrl(user.getImageUrl());
            userRepository.saveAndFlush(userToUpdate);
        }

    }


    //from jwt provenant de oauth to User
    private User mapOauthToUser(Map<String, Object> attributes) {
        User user = new User();
        String sub = String.valueOf(attributes.get("sub"));

        String username = null;
        if (attributes.get("preferred-username") != null) {
            username = ((String) attributes.get("preferred-username")).toLowerCase();
        }
        if (attributes.get("given-name") != null) {
            user.setFirstName((String) attributes.get("given-name"));
        } else if (attributes.get("name") != null) {
            user.setFirstName((String) attributes.get("name"));
        }
        if (attributes.get("family-name") != null) {
            user.setLastName((String) attributes.get("family-name"));
        }
        if (attributes.get("email") != null) {
            user.setEmail((String) attributes.get("email"));

        } else if (username != null && username.contains("@")) {
            user.setEmail(username);
        } else {
            user.setEmail(sub);
        }
        if (attributes.get("picture") != null) {
            user.setImageUrl((String) attributes.get("picture"));
        }
        return user;
    }
}
