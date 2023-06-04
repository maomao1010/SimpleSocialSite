package Mao.SocialSite;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import Mao.SocialSite.UserModel;
import Mao.SocialSite.UserService;

@RestController
public class UserController {
	  
	  @Autowired
	  UserModel userModel;
	  
	  @Autowired
	  UserService userService;
	  
	  @RequestMapping(value = "/Users", method = RequestMethod.GET)
	  public List<Map<String, Object>> GetAllUser(){
		  return userService.getAllUser();
	  }
	  
	  @RequestMapping(value = "/User", method = RequestMethod.POST)
	  public String AddUser(@RequestBody String request){
		  ObjectMapper objectMapper = new ObjectMapper();
		  try {
			  // Convert JSON string to Map
	          Map<String, String> map = objectMapper.readValue(request, new TypeReference<Map<String, String>>() {});

	          // Access map values
	          UUID uuid = UUID.randomUUID();
	          String name = map.get("name");
	          String phone = map.get("phone");
	          String email = map.get("email");
	          String password = map.get("password");
	          password = password + "salt";
	          String coverimage = map.get("coverimage");
	          String biography = map.get("biography");
	          
			  userModel = new UserModel();
			  userModel.SetID(uuid.toString());
			  userModel.SetName(name);
			  userModel.SetPhone(phone);
			  userModel.SetEmail(email);
			  userModel.SetPassword(Integer.toString(password.hashCode()));
			  userModel.SetCoverImage(coverimage);
			  userModel.SetBiography(biography);
			  userService.addUser(userModel);
			  
			  return "Added a new user";
		  } catch (IOException e) {
	            e.printStackTrace();
	            return "Error!";
	      }
	  }
	  
	  @RequestMapping(value = "/User/{id}", method = RequestMethod.DELETE)
	  public String DeleteUser(@PathVariable String id){
		  userService.deleteUser(id);
		  return "Deleted the user";
	  }
	  
}
