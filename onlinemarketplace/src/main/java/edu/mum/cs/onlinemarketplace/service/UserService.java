package edu.mum.cs.onlinemarketplace.service;



import edu.mum.cs.onlinemarketplace.domain.Address;

import edu.mum.cs.onlinemarketplace.domain.User;

import java.util.List;

public interface UserService {


    public User getUserById(Long id);

    User findUserById(Long id);


}
