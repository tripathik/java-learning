package com.javalearning.webapp.service.impl;

import com.javalearning.webapp.model.User;
import com.javalearning.webapp.repository.UserRepository;
import com.javalearning.webapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    public String saveUser(User user){
        if(user!=null){
            userRepository.save(user);
        }
        return "User has been saved successfully!";
    }
    public List<User> getAllUsers(){
        List<User> userList = (List<User>) userRepository.findAll();
        if(!userList.isEmpty()){
            return userList;
        }
        return null;
    }
    public User getUserById(Long id){

        User user = userRepository.findById(id).orElse(null);
        return user;
    }
    public User updateUserDetails(User newUser){
        User existingUser = userRepository.findById(newUser.getId()).orElse(null);
        if(existingUser!=null){
            existingUser.setName(newUser.getName());
            existingUser.setDistrict(newUser.getDistrict());
            existingUser.setCountry(newUser.getCountry());
            existingUser.setState(newUser.getState());
            existingUser.setZipCode(newUser.getZipCode());
            existingUser.setEmail(newUser.getEmail());
        }
        return userRepository.save(existingUser);
    }
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User has been deleted Successfully";
    }

    public static void main(String[] args) {
        int result = processRepeatingCharacters("HELLOOO");
    }
    public static int processRepeatingCharacters(String str){
        char[] chars = str.toCharArray();
        int repeatedCharacter =0;
        Map<Character,Integer> carMap = new HashMap<>();
        for(char c : chars){
            if(carMap.containsKey(c)){
                repeatedCharacter=repeatedCharacter+1;
                carMap.put(c,carMap.get(c)+1);
            }
            carMap.put(c,1);
        }
        return repeatedCharacter;
    }
//    public int getSecondLargestNumber(int[] numbers){
//        for(int i=0;i<numbers.length;i++){
//
//        }
//    }

}
