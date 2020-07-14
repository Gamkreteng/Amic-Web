package com.tmu.amic.service;
import com.tmu.amic.controller.request.ProjectRequest;
import com.tmu.amic.controller.request.UserAccountRequest;
import com.tmu.amic.controller.response.ProjectResponse;
import com.tmu.amic.controller.response.UserAccountResponse;
import com.tmu.amic.model.Project;
import com.tmu.amic.model.UserAccount;
import com.tmu.amic.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public ArrayList<UserAccountResponse> findAll() {
        UserAccountResponse userAccountResponse = new UserAccountResponse();
        List<UserAccount> userResults = userAccountRepository.findAll();
        ArrayList<UserAccountResponse> useraccounts = (ArrayList<UserAccountResponse>) userAccountResponse.convertToList(userResults);
        return useraccounts;
    }

    public UserAccountResponse getUserAccountById(long id) {
        UserAccountResponse userAccountResponse = new UserAccountResponse();
        UserAccount userAccount = userAccountRepository.findById(id).get();

        userAccountResponse.setCreatedAt(userAccount.getCreatedAt());
        userAccountResponse.setEmail(userAccount.getEmail());
        userAccountResponse.setFirstName(userAccount.getFirstName());
        userAccountResponse.setLastName(userAccount.getLastName());
        userAccountResponse.setPassword(userAccount.getPassword());
        userAccountResponse.setUpdatedAt(userAccount.getUpdatedAt());
        userAccountResponse.setUsername(userAccount.getUsername());
        userAccountResponse.setProjectManager(userAccount.isProjectManager());

        return userAccountResponse;
    }
    public void deleteById(Long id) {

        userAccountRepository.deleteById(id);
    }

    public void creatUser (UserAccountRequest userAccount) {
        userAccountRepository.save(userAccount.convertToUserAccount(userAccount));
    }

    public UserAccount replaceUser(@RequestBody UserAccount updateUserAccount, @PathVariable Long id) {

        return userAccountRepository.findById(id)
                .map(updateUser -> {
                    updateUser.setEmail(updateUserAccount.getEmail());
                    updateUser.setPassword(updateUserAccount.getPassword());

                    return userAccountRepository.save(updateUser);
                })
                .orElseGet(() -> {
                    updateUserAccount.setId(id);
                    return userAccountRepository.save(updateUserAccount);
                });
    }
}
