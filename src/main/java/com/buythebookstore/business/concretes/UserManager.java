package com.buythebookstore.business.concretes;

import com.buythebookstore.business.abstracts.UserService;
import com.buythebookstore.core.DataResult;
import com.buythebookstore.core.Result;
import com.buythebookstore.entities.User;
import com.buythebookstore.entities.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    @Override
    public Result create(User staff) {
        return null;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return null;
    }

    @Override
    public Result update(UserDto userUpdateDto) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
