package utils;

import data.models.User;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map (RegisterRequest registerRequest){
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

    //public static void map (RegisterRequest registerRequest, User user) {
      //  user.setFirstName(registerRequest.getFirstName());
      //  user.setLastName(registerRequest.getLastName());
       // user.setUserName(registerRequest.getUserName());
       // user.setPassword(registerRequest.getPassword());
   // }

    public static void map (User foundUser, FindUserResponse response) {
        response.setFullName(foundUser.getFirstName()+ " " + foundUser.getLastName());
        response.setUserId(foundUser.getId());
        response.setUserName(foundUser.getUserName());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("E, dd/mm/yyyy, hh:mm a");
        response.setDateRegistered(df.format(foundUser.getDateRegistered()));
    }

}
