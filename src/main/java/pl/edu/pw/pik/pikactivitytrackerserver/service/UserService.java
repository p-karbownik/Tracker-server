package pl.edu.pw.pik.pikactivitytrackerserver.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.UserDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.Repository.UserRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.User;

import java.util.List;
import java.util.UUID;

//it means that this class contains buisness logic
@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User register(UserDTO userDTO) {

        String username = userDTO.getUsername();

        User user = new User();
        user.setUsername(username);
        user.setPassword(userDTO.getPassword());
        user.setSalt(userDTO.getSalt());

        if (userRepository.findByUsername(username).size() != 0){
            return null;
        }
        userRepository.save(user);

        return user;
    }

    public String loginUsername(String username) {
        List<User> users = userRepository.findByUsername(username);
        if (users.size() != 0){
            return users.get(0).getSalt();
        }
        return null;
    }

    public Integer loginUsernameAndHashedPassword(String username, String password) {
        List<User> users = userRepository.findByUsername(username);

        if ( users.size() != 0){

            if(users.get(0).getPassword().equals(password))

                return users.get(0).getUser_id();
        }
        return null;
    }
}
