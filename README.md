## An API which can connect to database using spring boot jpa and can send response back to Postman.  

### Explaination-:  
1) There is a Entity named Book with @Entity notation.
2) There is a BookRepository interface inside dao pakage which extends the CrudRepository which perform all database operations for Book class.This layer directly interacts with database.
3) There is a BookService class which uses BookRepository to perform all database related operatios, one should not directly interact with BookRepository.If you want any database operation to occur, use BookRepository
  which itself uses BookService.
4) There is a package called controller which has 2 controllers but we will use only BookController2, BookController does not sends HttpResponse.  
  i) See BookController. we first need to give it @RestController annotation instead of Controller.  
  ii) It uses BookService object to connect with database  
  iii) @PathVariable binds the method parameter to the uri  
  iv) @RequesBody converts the json object to Book object  
  v) it perform all CRUD operations.  
  vi) However it does not send any response back like 404, 200 etc.  
  vii) So BookController2 is extension of BookController and we will use BookController2 only thats why BookController's code has been commented out.  
  viii) BookController2 uses ResponseEntity to send HttpStatus.  

### How to run this project on EC2 Instance-:
1) Pull this repository form GitHub.
2) Run the dockerSetup.sh script to install docker and docker compose
3) Run command "docker-compose up"
4) Now application is ready, now copy IP address of your EC2 instance and open postman and hit urls "https://ip:8080". If there is no book created initially then it will give error . so first create book then fetch it.




  local repo project=api
  local database=springBootApi
