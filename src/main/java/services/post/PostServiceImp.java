package services.post;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.request.PostRequestDto;
import dto.response.PostResponseDto;
import models.post.Post;
import org.modelmapper.ModelMapper;
import services.user.UserService;
import services.user.UserServiceImp;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PostServiceImp implements PostService {

    static final UserService userService = new UserServiceImp();
    final static ModelMapper modelmapper = new ModelMapper();
    @Override
    public boolean create(PostRequestDto postRequestDto) {
        if (postRequestDto != null) {
            Post post = new Post();
            modelmapper.map(postRequestDto, post);
            post.setDate(new Date());
            post.setUser(userService.getEntity(postRequestDto.getUserId()));
            var posts = getData();
            if (posts == null)
                posts = new ArrayList<>();
            posts.add(post);
            return writeData(posts);
        }
        return false;
    }

    @Override
    public PostResponseDto get(UUID id) {
        var responseDtoList = getList();
        if (responseDtoList != null) {
            for (PostResponseDto postResponseDto : responseDtoList) {
                if (postResponseDto.getId().equals(id))
                    return postResponseDto;
            }
        }
        return null;
    }

    @Override
    public List<PostResponseDto> getList() {
        var posts = getData();
        List<PostResponseDto> postResponseDtoList = null;
        if (posts != null) {
            postResponseDtoList = new ArrayList<>();
            for (Post post : posts) {
                var postResponseDto = modelmapper.map(post, PostResponseDto.class);
                postResponseDtoList.add(postResponseDto);
            }
        }
        return postResponseDtoList;
    }

    @Override
    public boolean delete(UUID id) {
        var post = getEntity(id);
        if (post != null) {
            var posts = getData();
            posts.remove(post);
            return writeData(posts);
        }
        return false;
    }

    @Override
    public boolean update(UUID id, PostRequestDto postRequestDto) {
        var post = getEntity(id);
        if (post != null && postRequestDto != null) {
            var posts = getData();
            posts.remove(post);
            modelmapper.map(postRequestDto, post);
            post.setUser(userService.getEntity(postRequestDto.getUserId()));
            if (postRequestDto.getViews() != null){
                post.setViews(new ArrayList<>());
                for (UUID user : postRequestDto.getViews()) {
                    post.getViews().add(userService.getEntity(user));
                }
            }
            if (postRequestDto.getComments() != null){
                post.setComments(new ArrayList<>());
                for (UUID comment : postRequestDto.getComments()) {
                    post.getComments().add(getEntity(comment));
                }
            }
            posts.add(post);
            return writeData(posts);
        }

        return false;
    }

    @Override
    public List<Post> getData() {
        List<Post> posts;
        File file = new File("data/posts.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            Type type = new TypeToken<List<Post>>(){}.getType();
            posts = gson.fromJson(bufferedReader, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }

    @Override
    public boolean writeData(List<Post> data) {
        File file = new File("data/posts.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            var s = gson.toJson(data);
            bufferedWriter.write(s);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public Post getEntity(UUID id) {
        var posts = getData();
        if (posts != null) {
            for (Post post : posts) {
                if (post.getId().equals(id))
                    return post;
            }
        }
        return null;
    }

    @Override
    public PostResponseDto getPost(UUID channelId, UUID userId) {
        return null;
    }
}