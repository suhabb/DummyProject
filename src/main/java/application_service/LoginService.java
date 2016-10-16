package application_service;

import annotation.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {

    @Autowired
    protected MongoDbFactory mongo;

    @Loggable
    public void loggin() throws Exception {
        System.out.println("Log in Exception");
        System.out.println(mongo.getDb().getName());
        throw new Exception("hello iam exception");

    }
}
