package com.hatkar.spotifybackend.usercontext.mapper;

import com.hatkar.spotifybackend.usercontext.ReadUserDTO;
import com.hatkar.spotifybackend.usercontext.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ReadUserDTO userToReadUserDTO(User user);
}
