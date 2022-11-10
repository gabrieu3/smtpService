package com.on.mail.On.models;

import com.on.mail.On.enums.StatusEmail;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="ON_EMAIL")
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

}
