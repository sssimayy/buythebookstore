package com.buythebookstore.core.check;


import com.buythebookstore.core.results.ErrorResult;
import com.buythebookstore.core.results.Result;
import com.buythebookstore.core.results.SuccessResult;
import com.buythebookstore.entities.dtos.UserDto;
import org.springframework.stereotype.Component;

@Component
public class ConfirmPasswordCheck implements Check {

    @Override
    public Result check(UserDto userDto) {
        if (userDto.getPassword().equals(userDto.getPasswordCheck())) {
            return new SuccessResult();
        }
        return new ErrorResult("Password and Confirm Password fields are not equals.");
    }
}
