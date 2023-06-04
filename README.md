# SimpleSocialSite
## Environment
MariaDB 10.3(The mysql-connector-j in this project is 8.33 so we can not use the last version)

## API
### User
1. GetAllUserData  
URL: /Users Method:GET  

2. AddUser  
URL: /User Method:POST  
json:
```
{ 
  "name": "name", 
  "phone": "0912345678", 
  "email":"email", 
  "password":"password", 
  "biography":"biography"
}
```
3. DeleteUser  
URL:/User/{userid} Method:DELETE  

### Post
1. GetPostData  
URL: /Posts Method:GET  

2. AddPost  
URL: /Post Method:POST  
json:
```
{ 
  "userid": "userid", 
  "content": "content"
}
```

3. UpdatePost  
URL:/Post Method:PUT  
json:
```
{
  "postid":"postid",
  "content": "content"
}
```

4. DeletePost  
URL:/Post/{postid} Method:DELETE  

### Comment
1. GetCommentsForPost  
URL: /Comments/{postid} Method:GET  

2. AddComment  
URL: /Comment Method:POST  
json:
```
{ 
  "userid": "userid",
  "postid":"postid",
  "content": "content" 
}
```

3. DeleteComment  
URL: /Comment/{commentid} Method:DELETE  
