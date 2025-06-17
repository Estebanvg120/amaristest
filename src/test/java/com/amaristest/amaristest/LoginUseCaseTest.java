package com.amaristest.amaristest;


import com.amaristest.amaristest.domain.models.LoginLogModel;
import com.amaristest.amaristest.domain.models.LoginModel;
import com.amaristest.amaristest.domain.spi.IDummyClientPort;
import com.amaristest.amaristest.domain.spi.ILoginLogPersistence;
import com.amaristest.amaristest.domain.usecases.LoginUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginUseCaseTest {

    @Mock
    private IDummyClientPort dummyClientPort;

    @Mock
    private ILoginLogPersistence loginLogPersistence;

    @InjectMocks
    private LoginUseCase loginUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void login_ShouldReturnLoginModel_AndSaveLog() {
        // Arrange
        LoginModel loginInput = new LoginModel();
        loginInput.setUsername("emilys");
        loginInput.setPassword("emilyspass");

        LoginModel loginResponse = new LoginModel();
        loginResponse.setUsername("emilys");
        loginResponse.setAccessToken("token123");
        loginResponse.setRefreshToken("refresh456");

        when(dummyClientPort.login(loginInput)).thenReturn(loginResponse);

        // Act
        LoginModel result = loginUseCase.login(loginInput);

        // Assert
        assertNotNull(result);
        assertEquals("emilys", result.getUsername());
        assertEquals("token123", result.getAccessToken());
        assertEquals("refresh456", result.getRefreshToken());

        verify(dummyClientPort, times(1)).login(loginInput);
        verify(loginLogPersistence, times(1)).save(any(LoginLogModel.class));
    }
}