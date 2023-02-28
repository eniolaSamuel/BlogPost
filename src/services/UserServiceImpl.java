package services;

import data.models.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;
import utils.Mapper;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUserName())) throw new IllegalArgumentException(registerRequest.getUserName() + "already exists");
        return userRepository.save(Mapper.map(registerRequest));

        //User user = new User();
        //Mapper.map(registerRequest, user);
        //return userRepository.save(user);
        //follow up method for commented out method in Mapper
    }

    @Override
    public FindUserResponse findUser(int id) {
        User foundUser = userRepository.findById(id);
        FindUserResponse response = new FindUserResponse();
        Mapper.map(foundUser, response);
        return response;
    }

    private boolean userExist(String userName) {
        User foundUser = userRepository.findByUserName(userName);
        if (foundUser != null)return true;
        return false;
    }
}
