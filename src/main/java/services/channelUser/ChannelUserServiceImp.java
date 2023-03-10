package services.channelUser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.request.ChannelUserRequestDto;
import dto.response.ChannelUserResponseDto;
import models.channelUser.ChannelUser;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

public class ChannelUserServiceImp implements ChannelUserService {

    static ModelMapper modelMapper = new ModelMapper();
    static File file;
    static Gson gson;

    @Override
    public boolean create(ChannelUserRequestDto channelUserRequestDto) {
        return false;
    }

    @Override
    public ChannelUserResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<ChannelUserResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<ChannelUser> data = getData();
        if (data != null) {
            for (ChannelUser channelUser : data) {
                if (channelUser.getId().equals(id)) {
                    boolean remove = data.remove(channelUser);
                    if (remove) {
                        boolean writeData = writeData(data);
                        if (writeData) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UUID id, ChannelUserRequestDto channelUserRequestDto) {
        return false;
    }

    @Override
    public List<ChannelUser> getData() {
        file = new File("data/channelUsers.json");
        gson = new Gson();
        List<ChannelUser> channelUsers;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<ChannelUser>>(){}.getType();
            channelUsers = gson.fromJson(bufferedReader, type);
        }catch(IOException ioException) {
            return null;
        }
        return channelUsers;
    }

    @Override
    public boolean writeData(List<ChannelUser> data) {
        file = new File("data/channelUsers.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(gson.toJson(data));
        }catch(IOException ioException) {
            return false;
        }
        return true;
    }

    @Override
    public ChannelUser getEntity(UUID id) {
        List<ChannelUser> data = getData();
        if (data != null) {
            for (ChannelUser channelUser : data) {
                if (channelUser.getId().equals(id)) {
                    return channelUser;
                }
            }
        }
        return null;
    }
}