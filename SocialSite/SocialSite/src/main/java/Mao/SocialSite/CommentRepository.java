package Mao.SocialSite;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import Mao.SocialSite.CommentModel;

@Repository
public class CommentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getCommentForPost(String id){
		  String sql = "select * from commentdata where postid = ?";
		  List<Map<String, Object>> comments = jdbcTemplate.queryForList(sql,id);
	      return comments;
	  }
	
	public void addComment(CommentModel CommentModel){
		jdbcTemplate.update("INSERT INTO commentdata(CommentID, UserID, PostID, Content, CreatedAt) "
	  		+ "VALUES (?,?,?,?,?)",CommentModel.GetCommentID(), CommentModel.GetUserID(), 
	  		CommentModel.GetPostID(), CommentModel.GetContent(), CommentModel.GetCreatedTime());
	}
	
	public void deleteComment(String id) {
		String sql = "DELETE FROM commentdata WHERE commentid = ?";
		jdbcTemplate.update(sql,id);
	}

}
