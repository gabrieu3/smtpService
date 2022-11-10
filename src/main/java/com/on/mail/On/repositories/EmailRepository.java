package com.on.mail.On.repositories;

import com.on.mail.On.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
