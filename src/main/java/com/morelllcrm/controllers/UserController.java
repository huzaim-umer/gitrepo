package com.morelllcrm.controllers;

import com.morelllcrm.entities.Users;
import com.morelllcrm.payload.JwtTokenSuccessResponse;
import com.morelllcrm.payload.LoginRequest;
import com.morelllcrm.security.JwtTokenProvider;
import com.morelllcrm.services.CustomUserDetailsService;
import com.morelllcrm.services.ErrorService;
import com.morelllcrm.services.UserService;
import com.morelllcrm.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.morelllcrm.security.SecurityConstants.TOKEN_TYPE;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    @Autowired
    UserValidator userValidator;

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private ErrorService errorService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> userSignUp(@Valid @RequestBody Users user, BindingResult result) {

        userValidator.validate(user,result);
        ResponseEntity<?> errorMap = errorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        Users users1 = userService.saveUser(user,result);
        return new ResponseEntity<>(users1, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
        ResponseEntity<?> errorMap = errorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Users user= (Users) customUserDetailsService.loadUserByUsername(loginRequest.getUsername());

        ResponseEntity<?> unauthorized = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        System.out.println(passwordEncoder.encode(loginRequest.getPassword()));
//        System.out.println(user.getPassword());
//        if (user != null && passwordEncoder.encode(loginRequest.getPassword()).equals(user.getPasswordHistories().get(0).getPassword())) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername()
                    , loginRequest.getPassword()));
            String jwt_token = TOKEN_TYPE + jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new JwtTokenSuccessResponse(jwt_token, true));
//        }
//        return unauthorized;
    }


    @PutMapping("/forgotpassword")
    public ResponseEntity<?> forgotPassword(@RequestParam String email){
        return this.userService.forgotPassword(email);
    }
    @PutMapping("/resetpassword")
    public ResponseEntity<?> resetPassword(@RequestParam String email,@RequestParam String password){
        return ResponseEntity.ok(this.userService.resetPassword(email,password));
    }
    @GetMapping("/verify")
    public ResponseEntity<?> checkEmailVerify(@RequestParam String email){
        return ResponseEntity.ok(this.userService.checkEmailVerify(email));
    }

    @GetMapping("/test")
    public String hello(){
        return "Hello!";
    }
    @GetMapping("/helloerror")
    public String helloError(){
        return "Hello Error!";
    }
}