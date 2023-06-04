package Mao.SocialSite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.sql.Timestamp;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Mao.SocialSite.PostModel;
import Mao.SocialSite.PostService;

@RestController
public class PostController {
	  @Autowired
	  PostModel postModel;
	  
	  @Autowired
	  PostService postService;
	  
	  @RequestMapping(value = "/Posts", method = RequestMethod.GET)
	  public List<Map<String, Object>> GetAllPost(){
	      return postService.getAllPost();
	  }
	  
	  @RequestMapping(value = "/Post", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	  public String AddPost(@RequestBody String request){
		  ObjectMapper objectMapper = new ObjectMapper();
		  try {
	            // Convert JSON string to Map
	            Map<String, String> map = objectMapper.readValue(request, new TypeReference<Map<String, String>>() {});
	            UUID uuid = UUID.randomUUID();
	            // Access map values
	            String userid = map.get("userid");
	            String content = map.get("content");
	            
	            postModel = new PostModel();
	            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	            postModel.SetPostID(uuid.toString());
	            postModel.SetUserID(userid);
	            postModel.SetContent(content);
	            postModel.SetCreatedTime(timestamp);
	            postService.addPost(postModel);
	            
	            return "Added a new post";

	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Error!";
	        }
	  }
	  
	  @RequestMapping(value = "/Post", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	  public String UpdatePost(@RequestBody String request){
		  postService.updatePost(request);
		  return "Updated the post";
	  }
	  
	  @RequestMapping(value = "/Post/{id}", method = RequestMethod.DELETE)
	  public String DeletePost(@PathVariable String id){
		  postService.deletePost(id);
		  return "Deleted the post";
	  }
	  
}
