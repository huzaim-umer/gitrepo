package com.morelllcrm.services;

import com.morelllcrm.entities.PasswordHistory;
import com.morelllcrm.entities.Users;
import com.morelllcrm.exception.UserAlreadyExists;
import com.morelllcrm.exception.UserNotFoundException;
import com.morelllcrm.payload.ForgotPasswordVerificationDetails;
import com.morelllcrm.payload.ResetPasswordVerificationDetails;
import com.morelllcrm.payload.SignUpVerificationDetails;
import com.morelllcrm.repositories.PasswordRespository;
import com.morelllcrm.repositories.UserRepository;
import com.morelllcrm.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.*;

import static org.apache.commons.lang3.Validate.notNull;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRespository passwordRespository;

    @Autowired
    private ErrorService errorService;


    @Autowired
    UserValidator userValidator;

    public Users saveUser(Users user, BindingResult result){

//        user name must be unique
//        password and confirm passwords must match , shouldn't persist or show confirm password


        try{
            notNull(user, "User Object cannot be null");
            user.setEmailId(user.getEmailId());
            user.setCreatedAt(LocalDateTime.now());
            user.setModifiedAt(LocalDateTime.now());
            user.setUserSaltValue("");
            user.setRequirePasswordChange(false);

            PasswordHistory passwordHistory =new PasswordHistory();
            List<PasswordHistory> passwordHistoryList=new ArrayList<>();
            passwordHistory.setPassword(passwordEncoder.encode(user.getPasswordHistories().get(0).getPassword()));
            passwordHistory.setUpdatedBy(user.getEmailId());
            passwordHistory.setUpdatedAt(LocalDateTime.now());
            passwordHistory.setCreatedAt(LocalDateTime.now());
            passwordHistory.setAccessKey("");
            passwordHistory.setAccessSecret("");
            passwordHistory.setCreatedBy(user.getEmailId());
            passwordHistory.setActivationToken(UUID.randomUUID().toString());
            passwordHistory.setActivationTokenExpired(false);
            passwordHistory.setActivationTokenValidDays(7);
            passwordHistory.setActivationTokenVerified(false);
            passwordHistory.setDeleted(false);
            passwordHistory.setActive(true);
            passwordHistory.setValidated(true);
          //  passwordHistory.setDeletedAt(LocalDateTime.now());
          //  passwordHistory.setDeletedBy(user.getEmailId());
            passwordHistory.setPasswordId(UUID.randomUUID());
            passwordHistoryList.add(passwordHistory);

            user.setPasswordHistories(passwordHistoryList);
            user.setPassword(passwordHistory.getPassword());


            Users users=userRepository.save(user);
            RestTemplate restTemplate =new RestTemplate();
            final String postApi= "https://760i25yb4g.execute-api.us-east-2.amazonaws.com/MorellCRM/api-send-signup-email";

            Map<String,String> map = new HashMap<String,String>();
            map.put("to",users.getEmailId());
            map.put("subject","New Password Activation Communication");
            map.put("activation_id", users.getPasswordHistories().get(0).getActivationToken());
            map.put("uid",users.getId().toString());
            map.put("username",users.getFirstName()+" "+users.getLastName());
            map.put("link", "http://localhost:3000/email/uid="+users.getId());
            map.put("days",users.getPasswordHistories().get(0).getActivationTokenValidDays()+" days");



            ResponseEntity<SignUpVerificationDetails> S =restTemplate.postForEntity(postApi,map,SignUpVerificationDetails.class);
            System.out.println(S);
          return users ;

        }catch (Exception e){
            throw new UserAlreadyExists("User with email '"+user.getEmailId()+"' already exists");
        }

    }

    public ResponseEntity<?> forgotPassword(String email){
        Users user = userRepository.findByEmailId(email);

        if (user==null)
            throw new UserNotFoundException("User with email ' "+email+"' doesn't exist");
//        else if(!user.getEmailVerified()){
//            throw new UserNotVerifiedException("User is not Verified!!");
//        }
        else {
            RestTemplate restTemplate =new RestTemplate();
            final String postApi= "https://760i25yb4g.execute-api.us-east-2.amazonaws.com/MorellCRM/api-send-forgot-password-email";

            Map<String,String> map = new HashMap<String,String>();
            map.put("to",email);
            map.put("activation_id", UUID.randomUUID().toString());
            map.put("uid",user.getId().toString());
            map.put("username",user.getFirstName()+" "+user.getLastName());
            map.put("link", "http://localhost:3000/email");
            ResponseEntity<ForgotPasswordVerificationDetails> forgotPasswordVerificationDetailsResponseEntity =restTemplate.postForEntity(postApi,map,ForgotPasswordVerificationDetails.class);
            return ResponseEntity.ok("Reset Password link has been sent to your provided email address. Please check your Inbox");
        }
    }

    public ResponseEntity<?> resetPassword(String email,String password){
        Users user = userRepository.findByEmailId(email);
        if (user==null)
            throw new UserNotFoundException("User with email ' "+email+"' doesn't exist");
        else {
            RestTemplate restTemplate=new RestTemplate();
            final String postApi= "https://760i25yb4g.execute-api.us-east-2.amazonaws.com/MorellCRM/api-send-reset-password-email-communication";
            Map<String,String> map = new HashMap<>();
            map.put("to",email);
            map.put("username",user.getFirstName()+" "+user.getLastName());
            map.put("date", LocalDateTime.now().toString());
//            Passwords passwords = passwordRespository.findPasswordObjectById(user.getId());
//            passwords.setPasswordChangeReason(PasswordChangeReason.ForgotPassword);
//            passwords.setUpdatedAt(LocalDateTime.now());
//            passwords.setUpdatedBy(user.getId());
//            user.setPassword(passwordEncoder.encode(password));
            this.userRepository.save(user);
            ResponseEntity<ResetPasswordVerificationDetails> responseEntity=restTemplate.postForEntity(postApi,map, ResetPasswordVerificationDetails.class);

            return ResponseEntity.ok("Password Reset Successful!");
        }
    }

    public ResponseEntity<?> checkEmailVerify(String email){
        Users user=this.userRepository.findByEmailId(email);
        if (user==null)
            throw new UserNotFoundException("User with email ' "+email+"' doesn't exist");
       // user.setEmailVerified(true);
        return ResponseEntity.ok( this.userRepository.save(user));
    }


    public Users findUserByEmail(String email){
        Users user =userRepository.findByEmailId(email);
        if (user==null)
            throw new UserNotFoundException("User with email ' "+email+"' doesn't exist");
        return user;
    }



}
