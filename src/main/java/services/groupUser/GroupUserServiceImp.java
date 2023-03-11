package services.groupUser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.request.GroupUserRequestDto;
import dto.response.GroupResponseDto;
import dto.response.GroupUserResponseDto;
import models.groupUser.GroupUser;
import org.modelmapper.ModelMapper;
import services.group.GroupService;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupUserServiceImp implements GroupUserService {


    static ModelMapper modelMapper  = new ModelMapper();
    static File file;
    static Gson gson;


    @Override
    public boolean create(GroupUserRequestDto groupUserRequestDto) {
        if (groupUserRequestDto != null) {
            List<GroupUser> data = getData();
            if (data == null) {
                data = new ArrayList<>();
            }
            data.add(modelMapper.map(groupUserRequestDto, GroupUser.class));
            writeData(data);
            return true;
        }
        return false;
    }

    @Override
    public GroupUserResponseDto get(UUID id) {
        List<GroupUser> data = getData();
        if (data != null) {
            for (GroupUser groupUser : data) {
                if (groupUser.getId().equals(id)) {
                    return modelMapper.map(groupUser, GroupUserResponseDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<GroupUserResponseDto> getList() {
        List<GroupUser> data = getData();
        if (data != null) {
            List<GroupUserResponseDto> groupUsers = new ArrayList<>();
            for (GroupUser groupUser : data) {
                groupUsers.add(modelMapper.map(groupUser, GroupUserResponseDto.class));
            }
            return groupUsers;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<GroupUser> data = getData();
        if (data != null) {
            for (GroupUser groupUser : data) {
                if (groupUser.getId().equals(id)) {
                    data.remove(groupUser);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UUID id, GroupUserRequestDto groupUserRequestDto) {
        List<GroupUser> data = getData();
        if (data != null) {
            for (GroupUser groupUser : data) {
                if (groupUser.getId().equals(id)) {
                    data.add(modelMapper.map(groupUserRequestDto, GroupUser.class));
                    data.remove(groupUser);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<GroupUser> getData() {
        file = new File("data/groupUser.json");
        gson = new Gson();
        List<GroupUser> groupUsers;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<GroupUser> > (){}.getType();
            groupUsers = gson.fromJson(bufferedReader, type);
        }catch(IOException ioException) {
            return null;
        }
        return groupUsers;
    }

    @Override
    public boolean writeData(List<GroupUser> data) {
        file = new File("data/groupUser.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(gson.toJson(data));
        }catch(IOException ioException) {
            return false;
        }
        return true;
    }

    @Override
    public GroupUser getEntity(UUID id) {
        List<GroupUser> data = getData();
        if (data != null) {
            for (GroupUser groupUser : data) {
                if (groupUser.getId().equals(id)) {
                    return groupUser;
                }
            }
        }
        return null;
    }

}
