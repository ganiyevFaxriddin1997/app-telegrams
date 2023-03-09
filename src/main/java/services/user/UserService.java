package services.user;

import dto.response.UserResponseDto;
import services.BaseService;

public interface UserService extends BaseService {
    UserResponseDto getUser(String phoneNumber);

}
