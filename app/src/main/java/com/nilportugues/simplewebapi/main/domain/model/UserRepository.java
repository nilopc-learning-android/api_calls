package com.nilportugues.simplewebapi.main.domain.model;

import com.nilportugues.simplewebapi.main.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.main.repository.user.model.User;

import java.util.List;

public interface UserRepository
{
    User findByEmail(Email email);

    List<User> findAll();
}
