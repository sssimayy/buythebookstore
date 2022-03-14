package com.buythebookstore.business.abstracts;

import com.buythebookstore.core.DataResult;
import com.buythebookstore.core.Result;
import com.buythebookstore.entities.User;
import com.buythebookstore.entities.dtos.UserDto;

import java.util.List;

public interface UserService {

    public Result create(User staff);

    public DataResult<List<User>> getAll();

    public Result update(UserDto userUpdateDto);

    boolean delete(Long id);
}
