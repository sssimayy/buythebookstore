package com.buythebookstore.business.abstracts;

import com.buythebookstore.core.results.DataResult;
import com.buythebookstore.core.results.Result;
import com.buythebookstore.entities.User;
import com.buythebookstore.entities.dtos.UserDto;

import java.util.List;

public interface UserService {

    public Result add(UserDto userDto);

    public DataResult<List<User>> getAll();

    public Result update(UserDto userUpdateDto);

    boolean delete(Long id);
}
