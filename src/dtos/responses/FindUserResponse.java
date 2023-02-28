package dtos.responses;

import data.models.User;

import java.time.temporal.TemporalAccessor;

public class FindUserResponse extends User {
    private int userId;
    private String userName;
    private String fullName;
    private String dateRegistered;

    @Override
    public String toString() {
        return "findUserResponse{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateRegistered='" + dateRegistered + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public TemporalAccessor getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
