package com.aynulin.dalividali.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import javax.sql.DataSource;

/**
 * Created by Aynulin on 28.02.2017.
 */

@Configuration
@EnableSocial
public class SocialContext implements SocialConfigurer{
    @Autowired
    private DataSource dataSource;

    @Bean
    public ProviderSignInUtils providerSignInUtils(
            ConnectionFactoryLocator connectionFactoryLocator,
            UsersConnectionRepository connectionRepository) {
        return new ProviderSignInUtils(connectionFactoryLocator,
                connectionRepository
        );
    }

    /**
     * Configures the connection factories for Facebook and Twitter.
     * @param cfConfig
     * @param env
     */
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
        cfConfig.addConnectionFactory(new FacebookConnectionFactory(
                env.getProperty("facebook.app.id"),
                env.getProperty("facebook.app.secret")
        ));
    }

    /**
     * The UserIdSource determines the account ID of the user. The example application
     * uses the username as the account ID.
     */
    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return new JdbcUsersConnectionRepository(
                dataSource,
                connectionFactoryLocator,
                /**
                 * The TextEncryptor object encrypts the authorization details of the connection. In
                 * our example, the authorization details are stored as plain text.
                 * DO NOT USE THIS IN PRODUCTION.
                 */
                Encryptors.noOpText()
        );
    }

    /**
     * This bean manages the connection flow between the account provider and
     * the application.
     */
    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        ConnectController connectController = new ConnectController(connectionFactoryLocator, connectionRepository);
        return connectController;
    }
}
