package services.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.request.UserRequestDto;
import dto.response.UserResponseDto;
import enums.Role;
import models.user.User;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserServiceImp implements UserService {
    static final ModelMapper modelmapper = new ModelMapper();
    @Override
    public boolean create(UserRequestDto userRequestDto) {
        if (userRequestDto == null) return false;
        var userResponseDto = getUser(userRequestDto.getPhoneNumber());
        if (userResponseDto == null){
            User user = new User();
            modelmapper.map(userRequestDto, user);
            user.setRole(Role.USER);
            var users = getData();
            if (users == null)
                users = new ArrayList<>();
            users.add(user);
            return writeData(users);
        }
        return false;
    }

    @Override
    public UserResponseDto get(UUID id) {
        var list = getList();
        if (list != null) {
            for (UserResponseDto responseDto : list) {
                if (responseDto.getId().equals(id))
                    return responseDto;
            }
        }
        return null;
    }

    @Override
    public List<UserResponseDto> getList() {
        var data = getData();
        List<UserResponseDto> users = null;
        if (data != null) {
            users = new ArrayList<>();
            for (User user : data) {
                var responseDto = modelmapper.map(user, UserResponseDto.class);
                users.add(responseDto);
            }
        }
        return users;
    }

    @Override
    public boolean delete(UUID id) {
        var user = getEntity(id);
        if (user != null) {
            var users = getData();
            users.remove(user);
            return writeData(users);
        }
        return false;
    }

    @Override
    public boolean update(UUID id, UserRequestDto userRequestDto) {
        var user = getEntity(id);
        if (user != null && userRequestDto != null) {
            var users = getData();
            users.remove(user);
            modelmapper.map(userRequestDto, user);
            users.add(user);
            return writeData(users);
        }
        return false;
    }

    @Override
    public List<User> getData() {
        File file = new File("data/users.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<User> users;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<User>>(){}.getType();
            users = gson.fromJson(bufferedReader, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public boolean writeData(List<User> data) {
        File file = new File("data/users.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            var json = gson.toJson(data);
            bufferedWriter.write(json);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public User getEntity(UUID id) {
        var users = getData();
        if (users != null) {
            for (User user : users) {
                if (user.getId().equals(id))
                    return user;
            }
        }
        return null;
    }


    @Override
    public UserResponseDto getUser(String phoneNumber) {
        var list = getList();
        if (list != null) {
            for (UserResponseDto userResponseDto : list) {
                if (userResponseDto.getPhoneNumber().equals(phoneNumber))
                    return userResponseDto;
            }
        }
        return null;
    }
}