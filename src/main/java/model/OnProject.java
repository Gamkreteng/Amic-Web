package model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Data
@Table (name = "on_project")
public class OnProject {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NonNull
    private int projectId;

    @Column
    @NonNull
    private int clientPartnerId;

    @Column
    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateStart;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateEnd;

    @Column
    @NonNull
    private boolean isClient;

    @Column
    @NonNull
    private boolean isPartner;

    @Column
    @NonNull
    private String description;

}
