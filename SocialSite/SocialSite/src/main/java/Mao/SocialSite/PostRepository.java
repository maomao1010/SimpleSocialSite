package Mao.SocialSite;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Mao.SocialSite.PostModel;

@Repository
public class PostRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getAllPost(){
		  List<Map<String, Object>> posts = jdbcTemplate.queryForList("select * from postdata");
	      return posts;
	  }
	
	public void addPost(PostModel PostModel){
		jdbcTemplate.update("INSERT INTO postdata(PostID, UserID, Content, Image, CreateAt) "
	  		+ "VALUES (?,?,?,?,?)",PostModel.GetPostID(), PostModel.GetUserID(), 
	  		PostModel.GetContent(), PostModel.GetImage(), PostModel.GetCreatedTime());
	}
	
	public void updatePost(String request) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
            // Convert JSON string to Map
            Map<String, String> map = objectMapper.readValue(request, new TypeReference<Map<String, String>>() {});

            // Access map values
            String postid = map.get("postid");
            String content = map.get("content");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String sql = "UPDATE postdata SET Content = ?, CreateAt = ? WHERE PostID = ?";
            jdbcTemplate.update(sql,content,timestamp,postid);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void deletePost(String id) {
		String sql = "DELETE FROM commentdata WHERE postid = ?";
		jdbcTemplate.update(sql,id);
		sql = "DELETE FROM postdata WHERE postid = ?";
		jdbcTemplate.update(sql,id);
	}
	/*
	public void updatePost(Long id, PostModel PostModel){
		jdbcTemplate.update("UPDATE postdata SET (PostID, UserID, Content, Image, CreateAt)"
		  		+ "VALUES (?,?,?,?,?)",PostModel.GetPostID(), PostModel.GetUserID(), 
		  		PostModel.GetContent(), PostModel.GetImage(), PostModel.GetCreatedTime() + "WHERE PostID = ", id);
	}*/
}
