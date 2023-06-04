package Mao.SocialSite;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Mao.SocialSite.CommentModel;
import Mao.SocialSite.CommentService;

@RestController
public class CommentController {
	  
	@Autowired
	  CommentModel commentModel;
	  
	  @Autowired
	  CommentService commentService;
	  
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  
	  @RequestMapping(value = "/Comments/{id}", method = RequestMethod.GET)
	  public List<Map<String, Object>> GetCommentForPost(@PathVariable String id){
	      return commentService.GetCommentForPost(id);
	  }
	  
	  @RequestMapping(value = "/Comment", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	  public String AddComment(@RequestBody String request){
		  ObjectMapper objectMapper = new ObjectMapper();
		  try {
			  // Convert JSON string to Map
			  Map<String, String> map = objectMapper.readValue(request, new TypeReference<Map<String, String>>() {});
	          UUID uuid = UUID.randomUUID();
	          // Access map values
	          String userid = map.get("userid");
	          String postid = map.get("postid");
	          String content = map.get("content");
		  commentModel = new CommentModel();
		  
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  commentModel.SetCommentID(uuid.toString());
		  commentModel.SetUserID(userid);
		  commentModel.SetPostID(postid);
		  commentModel.SetContent("content");
		  commentModel.SetCreatedTime(timestamp);
		  commentService.addComment(commentModel);
	      return "Added a new comment";
		  } catch (IOException e) {
	            e.printStackTrace();
	            return "Error!";
	      }
	  }
	  
	  @RequestMapping(value = "/Comment/{id}", method = RequestMethod.DELETE)
	  public String DeleteComment(@PathVariable String id){
		  commentService.deleteComment(id);
		  return "Deleted the comment";
	  }

}
