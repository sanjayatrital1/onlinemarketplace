package edu.mum.cs.onlinemarketplace.service.impl;

import edu.mum.cs.onlinemarket.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

}
