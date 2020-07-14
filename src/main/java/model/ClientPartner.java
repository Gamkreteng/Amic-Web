package model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Table (name = "client_partner")
public class ClientPartner {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NonNull
    private String cpName;

    @Column
    @NonNull
    private String spAddress;

    @Column
    @NonNull
    private String cpDetails;

}
