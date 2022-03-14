package com.buythebookstore.core.check;

import com.buythebookstore.core.results.Result;
import com.buythebookstore.entities.dtos.UserDto;

public interface Check {

    public Result check(UserDto userDto);

}