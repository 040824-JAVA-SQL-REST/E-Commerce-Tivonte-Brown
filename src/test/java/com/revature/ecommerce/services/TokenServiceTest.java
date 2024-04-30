package com.revature.ecommerce.services;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.io.InputStream;
import java.util.Properties;

import com.revature.eCommerce.dao.CartDao;
import com.revature.eCommerce.dto.responses.Principal;
import com.revature.eCommerce.models.Role;
import com.revature.eCommerce.services.CartService;
import com.revature.eCommerce.services.ProductsService;
import com.revature.eCommerce.services.TokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.IOException;

import java.util.Date;

@SuppressWarnings("deprecation")
public class TokenServiceTest {


    @Mock
    private InputStream inputStream;

    @Mock
    private Properties properties;

    @InjectMocks
    private TokenService tokenService;

    @Before
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);

        // Stubbing behavior of the mocked properties
        when(properties.getProperty("secret")).thenReturn("ml0ldkfslk564m7k56m+=754l6mdngklfndgkl45=7654765+65nm7k45647mm56lm7");
    }

    @Test
    public void testGenerateToken() {
        // Mock data
        Role role = new Role("1", "ROLE_ADMIN");
        Principal principal = new Principal("userId123", "john.doe@example.com", role);

        // Stubbing behavior of the mocked Jwts
        when(Jwts.builder().setId(principal.getUserID())
                .setIssuer("ecommerce")
                .setSubject(principal.getName())
                .claim("roleID", principal.getRole().getID())
                .claim("roleName", principal.getRole().getRoleName())
                .setExpiration(any(Date.class))
                .signWith(eq(SignatureAlgorithm.HS256), "secret" )
                .compact()).thenReturn("dummyToken");

        // Call the method to be tested
        String token = tokenService.generateToken(principal);

        // Verify that the correct token is generated
        assertEquals("dummyToken", token);
    }
}
