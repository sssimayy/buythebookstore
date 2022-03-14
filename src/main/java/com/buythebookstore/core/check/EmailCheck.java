package com.buythebookstore.core.check;

import com.buythebookstore.core.results.ErrorResult;
import com.buythebookstore.core.results.Result;
import com.buythebookstore.core.results.SuccessResult;
import com.buythebookstore.dataAccess.UserDao;
import com.buythebookstore.entities.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailCheck implements Check{
    private UserDao userDao;

    @Autowired
    public EmailCheck(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result check(UserDto userDto) {
        if (userDao.existsByEmail(userDto.getEmail())) {
            return new ErrorResult("This email is already exist.");
        }
        return new SuccessResult();
    }
}
