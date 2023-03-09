package services.user;

import dto.request.UserRequestDto;
import dto.response.UserResponseDto;
import models.user.User;
import services.BaseService;

import java.util.UUID;

public interface UserService extends BaseService<UserRequestDto, UUID, UserResponseDto, User> {
    UserResponseDto getUser(String phoneNumber);

}
