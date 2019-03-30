package com.example.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exception.InvalidCityException;
import com.example.exception.InvalidEmailException;
import com.example.exception.InvalidNameException;
import com.example.exception.InvalidPasswordException;
import com.example.exception.InvalidPhoneException;
import com.example.exception.InvalidUserIdException;
import com.example.model.User;
import com.example.repository.UserRepository;
@Service
public class RegistrationService {
    
    @Autowired
    private UserRepository userRepository;
    
    public String registerUser (User user) throws Exception{
        String registrationMessage = null;
        validateUser(user);    
        registrationMessage = userRepository.registerUser(user);
        return registrationMessage;
   }
    
public void validateUser(User user)throws Exception
    {
        if(!isValidUserId(user.getUserId()))
            throw new InvalidUserIdException("RegistrationService.INVALID_USER_ID");
        if(!isValidPassword(user.getPassword()))
            throw new InvalidPasswordException("RegistrationService.INVALID_PASSWORD");
        if(!isValidName(user.getName()))
            throw new InvalidNameException("RegistrationService.INVALID_NAME");
        if(!isValidCity(user.getCity()))
            throw new InvalidCityException("RegistrationService.INVALID_CITY");
        if(!isValidEmail(user.getEmail()))
            throw new InvalidEmailException("RegistrationService.INVALID_EMAIL");
        if(!isValidPhoneNumber(user.getPhone()))
            throw new InvalidPhoneException("RegistrationService.INVALID_PHONE_NUMBER");
    }
    
public Boolean isValidUserId(String userid)
    {
        String regex1 = "^[a-zA-Z0-9]{4,15}+$";
         
        Pattern patternUserId = Pattern.compile(regex1);
         Matcher matcherUserId = patternUserId.matcher(userid);
          return matcherUserId.matches();
    }
    
public Boolean isValidPassword(String password)
    {
        String regex2 = "^[a-zA-Z0-9]{8,15}+$";
             
            Pattern patternPassword = Pattern.compile(regex2);
             Matcher matcherPassword = patternPassword.matcher(password);
              return matcherPassword.matches();
    }
    
public Boolean isValidName(String name)
    {
        String regex3 = "^[a-zA-Z0-9]{4,15}+$";
         
        Pattern patternName = Pattern.compile(regex3);
         Matcher matcherName = patternName.matcher(name);
          return matcherName.matches();
    }
    
public Boolean isValidCity(String city)
    {
        String regex4 = "^[a-zA-Z0-9]{4,15}+$";
         
        Pattern patternCity = Pattern.compile(regex4);
         Matcher matcherCity = patternCity.matcher(city);
          return matcherCity.matches();
          
    }
    
public Boolean isValidEmail(String email)
    {
        String regex5 = "^[A-Za-z0-9+_.-]+@(.+)$";
         
            Pattern patternEmail = Pattern.compile(regex5);
             Matcher matcherEmail = patternEmail.matcher(email);
              return matcherEmail.matches();
    }
    
public Boolean isValidPhoneNumber(String number)
    {
          String regex6 = "[0-9]{10}";
             
            Pattern patternPhone = Pattern.compile(regex6);
             Matcher matcherPhone = patternPhone.matcher(number);
              return matcherPhone.matches();
    }
}
