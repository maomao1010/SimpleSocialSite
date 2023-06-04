package Mao.SocialSite;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Mao.SocialSite.UserModel;
import Mao.SocialSite.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository UserRepository;
	
	public List<Map<String, Object>> getAllUser(){
		return UserRepository.getAllUser();
	}
	
	public void addUser(UserModel UserModel){
		UserRepository.addUser(UserModel);
	}
	@Transactional
	public void deleteUser(String id) {
		UserRepository.deleteUser(id);
	}

}
