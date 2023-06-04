package Mao.SocialSite;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Mao.SocialSite.PostModel;
import Mao.SocialSite.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository PostRepository;
	
	public List<Map<String, Object>> getAllPost(){
		  return PostRepository.getAllPost();
	  }
	
	public void addPost(PostModel PostModel){
		PostRepository.addPost(PostModel);
	}
	
	public void updatePost(String request){
		PostRepository.updatePost(request);
	}
	
	@Transactional
	public void deletePost(String id) {
		PostRepository.deletePost(id);
	}
	/*
	public void updatePost(Long id, PostModel PostModel) {
		PostRepository.updatePost(id, PostModel);
	}*/

}
