package com.tmu.amic.controller;

import com.tmu.amic.controller.request.ProjectRequest;
import com.tmu.amic.controller.request.UserAccountRequest;
import com.tmu.amic.controller.response.UserAccountResponse;
import com.tmu.amic.model.UserAccount;
import com.tmu.amic.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/api")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/useraccount")
    public ArrayList<UserAccountResponse> getAllProject() {

        return userAccountService.findAll();
    }

    @GetMapping("/useraccount/{id}")
    public UserAccountResponse getById(@PathVariable long id) {
        return userAccountService.getUserAccountById(id);
    }

    @PostMapping("/useraccount")
    public void creatUser(@RequestBody UserAccountRequest userAccount) {
        userAccountService.creatUser(userAccount);
    }

    @PutMapping("/useraccount/{id}")
    public void replaceUser(@RequestBody UserAccount updateUser, @PathVariable Long id) {
        userAccountService.replaceUser(updateUser, id);
    }

    @DeleteMapping("/useraccount/{id}")
    public void delete(@PathVariable String id) {

        Long userAccountId = Long.parseLong(id);
        userAccountService.deleteById(userAccountId);
    }

}
