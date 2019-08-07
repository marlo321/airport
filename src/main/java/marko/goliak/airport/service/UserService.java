package marko.goliak.airport.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import marko.goliak.airport.dto.request.UserRequest;
import marko.goliak.airport.dto.response.UserResponse;
import marko.goliak.airport.entity.User;
import marko.goliak.airport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findOne(Long id){
        return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User with "+id+" not exists"));
    }

    public void save(UserRequest userRequest){
        userRepository.save(userRequestToUser(null, userRequest));
    }

    public void update(Long id, UserRequest userRequest){
        userRepository.save(userRequestToUser(findOne(id), userRequest));
    }

    public void delete(Long id){
        User user = findOne(id);
        userRepository.delete(user);
    }

    public List<UserResponse> findAll(){
        return userRepository.findAll().stream().map(UserResponse::new).collect(Collectors.toList());
    }

    private User userRequestToUser(User user, UserRequest userRequest){
        if(user == null){
            user = new User();
        }
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPurchaseDataTime(LocalDateTime.now(ZoneId.of("Europe/Kiev")));
        return user;
    }
    public User findOneByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
}
