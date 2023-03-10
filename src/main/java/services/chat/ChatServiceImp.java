package services.chat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.request.ChatRequestDto;
import dto.response.ChatResponseDto;
import models.chat.Chat;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

public class ChatServiceImp implements ChatService {

    static ModelMapper modelMapper = new ModelMapper();
    static File file;
    static Gson gson;

    @Override
    public boolean create(ChatRequestDto chatRequestDto) {
        return false;
    }

    @Override
    public ChatResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<ChatResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<Chat> data = getData();
        if (data != null) {
            for (Chat chat : data) {
                if (chat.getId().equals(id)) {
                    boolean remove = data.remove(chat);
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
    public boolean update(UUID id, ChatRequestDto chatRequestDto) {
        return false;
    }

    @Override
    public List<Chat> getData() {
        file = new File("data/chats.json");
        gson = new Gson();
        List<Chat> chats;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<Chat>> (){}.getType();
            chats = gson.fromJson(bufferedReader, type);
        }catch(IOException ioException) {
            return null;
        }
        return chats;
    }

    @Override
    public boolean writeData(List<Chat> data) {
        file = new File("data/chats.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(gson.toJson(data));
        }catch(IOException ioException) {
            return false;
        }
        return true;
    }

    @Override
    public Chat getEntity(UUID id) {
        List<Chat> data = getData();
        if (data != null) {
            for (Chat chat : data) {
                if (chat.getId().equals(id)) {
                    return chat;
                }
            }
        }
        return null;
    }
}