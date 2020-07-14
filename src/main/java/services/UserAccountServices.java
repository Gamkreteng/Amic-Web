package services;

import model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.UserAccountRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAccountServices {

    @Autowired
    UserAccountRepository userAccountRepository;

    @GetMapping("/useraccount")
    public List<UserAccount> getAllUser_account() {

        return userAccountRepository.findAll();
    }

    @PostMapping("/project")
    public UserAccount createUserAccount(@Valid @RequestBody UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }
}
