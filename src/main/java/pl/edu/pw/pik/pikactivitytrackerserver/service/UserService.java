package pl.edu.pw.pik.pikactivitytrackerserver.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.UserDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.Repository.UserRepository;
import pl.edu.pw.pik.pikactivitytrackerserver.model.User;

//it means that this class contains buisness logic
@Service
public class UserService {

    @Autowired
    private static UserRepository userRepository;

    public User register(UserDTO userDTO) {

        String username = userDTO.getUsername();
        User user = new User(username,userDTO.getPassword());

        if (userRepository.findByUsername(username) != null){
            return null;
        }
        userRepository.save(user);

        return user;
    }

}
