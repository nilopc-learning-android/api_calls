package com.nilportugues.simplewebapi.users.domain.model;

import com.nilportugues.simplewebapi.users.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.users.infrastructure.repository.model.User;

public interface UserRepository {
    User findByEmail(Email email);

}
