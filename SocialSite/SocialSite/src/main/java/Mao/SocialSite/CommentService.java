package Mao.SocialSite;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import Mao.SocialSite.CommentModel;
import Mao.SocialSite.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository CommentRepository;
	
	public List<Map<String, Object>> GetCommentForPost(String id){
	      return CommentRepository.getCommentForPost(id);
	  }
	public void addComment(CommentModel CommentModel){
		CommentRepository.addComment(CommentModel);
	}
	public void deleteComment(String id) {
		CommentRepository.deleteComment(id);
	}
}
