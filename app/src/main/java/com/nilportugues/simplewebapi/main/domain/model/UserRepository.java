package com.nilportugues.simplewebapi.main.domain.model;

import com.nilportugues.simplewebapi.main.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.main.repository.user.model.User;

public interface UserRepository {
    User findByEmail(Email email);
}
