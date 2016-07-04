package com.nilportugues.simplewebapi.main.domain.usecase;

import com.nilportugues.simplewebapi.main.repository.ContactRepository;
import com.nilportugues.simplewebapi.main.repository.datasource.userapi.transformers.User;

import java.util.List;

public class ListUsers {
    private ContactRepository contactRepository;

    public ListUsers(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<User> list() {
        return contactRepository.findAll();
    }
}
