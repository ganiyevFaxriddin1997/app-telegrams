package services.user;

import dto.request.UserRequestDto;
import dto.response.UserResponseDto;
import models.user.User;

import java.util.List;
import java.util.UUID;

public class UserServiceImp implements UserService {

    @Override
    public boolean create(UserRequestDto userRequestDto) {
        return false;
    }

    @Override
    public UserResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<UserResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, UserRequestDto userRequestDto) {
        return false;
    }

    @Override
    public List<User> getData() {
        return null;
    }

    @Override
    public boolean writeData(List<User> data) {
        return false;
    }

    @Override
    public User getEntity(UUID id) {
        return null;
    }

    @Override
    public UserResponseDto getUser(String phoneNumber) {
        return null;
    }
}