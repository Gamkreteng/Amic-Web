package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Data
@Table(name = "user_account")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class UserAccount {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String username;

    @Column
    @NonNull
    private String password;

    @Column
    @NonNull
    private String email;

    @Column
    @NonNull
    private String firstName;

    @Column
    @NonNull
    private String lastName;

    @Column
    @NonNull
    private boolean isProjectManager;

    @Column
    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date registrationTime;

}
