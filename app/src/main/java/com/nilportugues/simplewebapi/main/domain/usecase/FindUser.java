package com.nilportugues.simplewebapi.main.domain.usecase;

import com.nilportugues.simplewebapi.main.domain.model.attributes.Email;
import com.nilportugues.simplewebapi.main.repository.ContactRepository;
import com.nilportugues.simplewebapi.main.repository.datasource.userapi.transformers.User;

public class FindUser {

    private ContactRepository contactRepository;

    public FindUser(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public User byEmail(Email email) {
        return contactRepository.findByEmail(email);
    }
}
