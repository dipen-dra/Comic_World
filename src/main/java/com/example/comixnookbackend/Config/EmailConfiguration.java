package com.example.comixnookbackend.Config;

import com.example.comixnookbackend.Entity.EmailCredentials;
import com.example.comixnookbackend.Repo.EmailCredentialRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class EmailConfiguration {

    // Injects the EmailCredentialRepo dependency
    private final EmailCredentialRepo emailCredRepo;

    /**
     * Configures and returns a JavaMailSender bean using email credentials
     * retrieved from the database.
     *
     * @return JavaMailSender configured with the active email credentials.
     * @throws Exception if an error occurs while fetching the credentials.
     */
    @Bean
    public JavaMailSender getJavaMailSender() throws Exception {
        try {
            // Fetch the active email credentials from the database
            EmailCredentials emailCredentials = emailCredRepo.findOneByActive();

            // Check if email credentials are available
            if (emailCredentials != null) {
                JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

                // Set up mail properties
                Properties props = new Properties();
                props.put("mail.transport.protocol", emailCredentials.getProtocol());
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.debug", "true");

                // Configure the mail sender with the fetched credentials
                mailSender.setJavaMailProperties(props);
                mailSender.setHost(emailCredentials.getHost());
                mailSender.setPort(Integer.valueOf(emailCredentials.getPort()));
                mailSender.setUsername(emailCredentials.getEmail());
                mailSender.setPassword(emailCredentials.getPassword());

                return mailSender; // Return the configured JavaMailSender instance
            } else {
                // If no active credentials are found, return an empty JavaMailSenderImpl
                return new JavaMailSenderImpl();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
            return null; // Return null in case of an error
        }
    }
}
