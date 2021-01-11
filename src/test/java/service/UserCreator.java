package service;

import model.User;

public class UserCreator {
    public static final String USER_EMAIL="test.data.user.useremail";
    public static final String USER_PASSWORD="test.data.user.userpassword";
    public static final String USER_NAME="test.data.user.username";
    public static final String USER_FAILD_EMAIL="test.data.user.faild.useremail";
    public static final String USER_FAILD_PASSWORD="test.data.user.faild.userpassword";
    public static User withAllProperty(){
        return new User(TestDataReader.getTestData(USER_NAME),
                TestDataReader.getTestData(USER_PASSWORD),
                TestDataReader.getTestData(USER_EMAIL));
    }

    public static User withFaildEmailProperty(){
        return new User(TestDataReader.getTestData(USER_PASSWORD),
                TestDataReader.getTestData(USER_FAILD_EMAIL));
    }

    public static User withFaildPasswordProperty(){
        return new User(TestDataReader.getTestData(USER_FAILD_PASSWORD),
                TestDataReader.getTestData(USER_EMAIL));
    }

}
