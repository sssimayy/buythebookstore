package com.buythebookstore.business.concretes;

import com.buythebookstore.business.abstracts.UserService;
import com.buythebookstore.core.check.CheckResult;
import com.buythebookstore.core.check.ConfirmPasswordCheck;
import com.buythebookstore.core.check.EmailCheck;
import com.buythebookstore.core.results.*;
import com.buythebookstore.dataAccess.UserDao;
import com.buythebookstore.entities.User;
import com.buythebookstore.entities.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserManager implements UserService {

    private UserDao userDao;
    private EmailCheck emailCheck;
    private ConfirmPasswordCheck confirmPasswordCheck;

    @Autowired
    public UserManager(UserDao userDao, EmailCheck emailCheck, ConfirmPasswordCheck confirmPasswordCheck) {
        this.userDao = userDao;
        this.emailCheck = emailCheck;
        this.confirmPasswordCheck = confirmPasswordCheck;
    }


    @Override
    public Result add(UserDto userDto) {
        Result result = CheckResult.checkResult(Arrays.asList(emailCheck.check(userDto),
                confirmPasswordCheck.check(userDto)));

        if (!isValid(userDto.getEmail())) {
            return new ErrorResult("Email is not valid format");
        }
        if (result.isSuccess()) {

            return new SuccessResult("Success");
        }

        User userRegister = new User();
        userRegister.setUserName(userDto.getUserName());
        userRegister.setSurname(userDto.getSurname());
        userRegister.setEmail(userRegister.getEmail());
        userDao.save(userRegister);

        return new SuccessResult("Registration is successfull");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(userDao.findAll(), "Data is listed successfully");
    }

    //TODO: İhtiyaca göre kullanılabilir
    /*@Override
    public Result update(UserDto userDto) {
        if (!this.userDao.existsById(userDto.getUserId())) {
            return new ErrorResult("No such a user");
        } else if (userDto.getUserName().length() < 2) {
            return new ErrorResult("Name cannot be shorter than 2 characters");
        } else if (userDto.getSurname().length() < 2) {
            return new ErrorResult("Surname cannot be shorter than 2 characters");
        } else if (!isValid(userDto.getEmail())) {
            return new ErrorResult("Not a valid email");
        }

        User user = this.userDao.getById(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        this.userDao.save(user);
        return new SuccessResult("Information saved");
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
*/
    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}