package cz.vsb.SLI0095_project.services;

import cz.vsb.SLI0095_project.repositories.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserJPARepository userJPARepository;


}
