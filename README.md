# Chat
# Token :- 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
Api details
1)User-Registration
  Type :- Post
  Url :- http://localhost:8587/user/registration
  Input JSON :- 
    {
      "emailId":"p1@gmail.com",
      "name":"P1",
      "contactNo":"9876543210",
      "password":"password"
    }
    
    
2)User-Login
  Type :- Post
  Url :- http://localhost:8587/user/login
  Input JSON :- 
    {
    	"emailId":"p@gmail.com",
    	"password":"password"
    }
  
3)Create-Room
  Type :- Post
  Url :- http://localhost:8587/createroom
  Input JSON :- 
    {
    	"emailId":"p@gmail.com",
    	"password":"password",
    	"roomName":"Room1"
    }
    
4)Join-Room
  Type :- Post
  Url :- http://localhost:8587/joinroom
  Input JSON :- 
    {
    	"emailId":"p1@gmail.com",
    	"password":"password",
    	"roomId":1
    }
    
5)Add user to Room
  Type :- Post
  Url :- http://localhost:8587/addUser
  Input JSON :- 
    {
    	"emailId":"p@gmail.com",
    	"password":"password",
    	"roomId":1,
    	"userEmailId":"p1@gmail.com"
    }
