package com.capstone.mobilerechargeservice.Controllers;

import com.capstone.mobilerechargeservice.Services.User_Service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class User_Controller {

    @Autowired
    private User_Service userService;
    static long currentUser;

    @GetMapping("/auth")
    public boolean checkUser(@RequestParam ("mobileNumber")long userNumber, HttpServletRequest request) {
        boolean exists = userService.userExists(userNumber);
        if (exists) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userNumber", userNumber);
            currentUser = userNumber;
        }
        return exists;

    }
    @GetMapping("/currentUser")
    public long getCurrentUserI() {
        return currentUser;
    }

}
