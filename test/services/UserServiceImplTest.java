package services;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserService userService;

    @BeforeEach
    public void setUp(){
        userService = new UserServiceImpl();
    }

    @Test
    public void test_saveNewUser_idIsNotZero(){
        User savedUser = userService.register("firstName", "lastName","userName", "securePassword");
        assertTrue(savedUser.getId()!=0);
    }

    @Test
    public void test_duplicateUserNameThrowsException(){
        userService.register("firstName", "lastName","userName", "securePassword");
        assertThrows(IllegalArgumentException.class, ()-> userService.register("firstName", "lastName","userName", "securePassword"));

    }

    @Test
    public void test_findUserById(){
        userService.register("firstName", "lastName","userName", "securePassword");
        assertEquals("firstName", userService.findUser(1).getFirstName());
    }
    //todo add throws exceptionWhenUserIdIsWrong
    @Test
    public void test_throwExceptionWhenIdIsWrongThrowsException(){
        userService.register("firstName", "lastName","userName", "securePassword");
        assertThrows(IllegalArgumentException.class, ()-> userService.register("firstName", "lastName","userName", "securePassword"));

    }

}