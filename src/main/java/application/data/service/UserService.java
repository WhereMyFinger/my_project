package application.data.service;

import application.data.model.User;
import application.data.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;
    public void addNewUser(User user){
        userRepository.save(user);
    }
    @Transactional
    public void addNewListUser(List<User> user){
        userRepository.save(user);
    }
    public User findOne(int id){
     return  userRepository.findOne(id);
    }
    public boolean updateUser(User user){
        try{
            userRepository.save(user);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return false;
    }
    public boolean daleteUser(int id){
        try{
            userRepository.delete(id);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return false;
    }
}
