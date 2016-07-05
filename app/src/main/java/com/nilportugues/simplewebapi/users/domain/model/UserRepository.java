package com.nilportugues.simplewebapi.users.domain.model;

import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.repository.model.User;

import java.util.List;

public interface UserRepository
{
    User findByEmail(Email email);

    List<User> findAll();
}
