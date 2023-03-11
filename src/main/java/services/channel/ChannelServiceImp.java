package services.channel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.request.ChannelRequestDto;
import dto.response.ChannelResponseDto;
import models.channel.Channel;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChannelServiceImp implements ChannelService {

    static ModelMapper modelMapper = new ModelMapper();
    static Gson gson;
    static File file;
    @Override
    public boolean create(ChannelRequestDto channelRequestDto) {

        if (channelRequestDto.getLink() != null) {
            List<Channel> data = getData();

            if (data == null) {
                data = new ArrayList<>();
            }
            data.add(modelMapper.map(channelRequestDto, Channel.class));
            writeData(data);
            return true;
        }
        return false;
    }

    @Override
    public ChannelResponseDto get(UUID id) {
        List<Channel> data = getData();
        if (data != null) {
            for (Channel channel : data) {
                if (channel.getId().equals(id)) {
                    modelMapper.map(channel, ChannelRequestDto.class);

                }
            }
        }
        return null;
    }

    @Override
    public List<ChannelResponseDto> getList() {
        List<Channel> data = getData();
        if (data != null) {
            List<ChannelResponseDto> channelResponseDto = new ArrayList<>();
            for (Channel channel : data) {
                channelResponseDto.add(modelMapper.map(channel,ChannelResponseDto.class));
            }
            return channelResponseDto;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<Channel> data = getData();
        if (data != null) {
            for (Channel channel : data) {
                if (channel.getId().equals(id)) {
                    boolean remove = data.remove(channel);
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
    public boolean update(UUID id, ChannelRequestDto channelRequestDto) {
        List<Channel> data = getData();
        if (data != null) {
            for (Channel channel : data) {
                if (channel.getId().equals(id)) {
                    data.add(modelMapper.map(channelRequestDto, Channel.class));
                    boolean remove = data.remove(channel);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Channel> getData() {
        file = new File("data/channels.json");
        gson = new Gson();
        List<Channel> channels;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<Channel> > () {}.getType();
            channels = gson.fromJson(bufferedReader, type);
        }catch(IOException ioException) {
            return null;
        }
        return channels;
    }

    @Override
    public boolean writeData(List<Channel> data) {
        file = new File("data/channels.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(gson.toJson(data));
        }catch(IOException ioException) {
            return false;
        }
        return true;
    }

    @Override
    public Channel getEntity(UUID id) {
        List<Channel> data = getData();
        if (data != null) {
            for (Channel channel : data) {
                if (channel.getId().equals(id)) {
                    return channel;
                }
            }
        }
        return null;
    }
}
