package services;

import data.models.User;
import dtos.requests.RegisterRequest;

public interface UserService {
    User register(RegisterRequest registerRequest);

    User findUser (int id);
}
