package com.cnkonica.demo.example.service.impl;

import com.cnkonica.demo.example.domain.OrmUser;
import com.cnkonica.demo.example.repository.OrmUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private OrmUserRepository mockOrmUserRepository;

    @InjectMocks
    private UserServiceImpl userServiceImplUnderTest;

    @Test
    void testGetAllUser() {
        // Setup
        final OrmUser ormUser = new OrmUser();
        ormUser.setId(0L);
        ormUser.setName("name");
        ormUser.setPassword("password");
        ormUser.setSalt("salt");
        ormUser.setEmail("email");
        final List<OrmUser> expectedResult = List.of(ormUser);

        // Configure OrmUserRepository.findAll(...).
        final OrmUser ormUser1 = new OrmUser();
        ormUser1.setId(0L);
        ormUser1.setName("name");
        ormUser1.setPassword("password");
        ormUser1.setSalt("salt");
        ormUser1.setEmail("email");
        final List<OrmUser> ormUsers = List.of(ormUser1);
        when(mockOrmUserRepository.findAll()).thenReturn(ormUsers);

        // Run the test
        final List<OrmUser> result = userServiceImplUnderTest.getAllUser();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllUser_OrmUserMapperReturnsNoItems() {
        // Setup
        when(mockOrmUserRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<OrmUser> result = userServiceImplUnderTest.getAllUser();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testSelectByPrimaryKey() {
        // Setup
        final OrmUser expectedResult = new OrmUser();
        expectedResult.setId(0L);
        expectedResult.setName("name");
        expectedResult.setPassword("password");
        expectedResult.setSalt("salt");
        expectedResult.setEmail("email");

        // Configure OrmUserRepository.findById(...).
        final OrmUser ormUser = new OrmUser();
        ormUser.setId(0L);
        ormUser.setName("name");
        ormUser.setPassword("password");
        ormUser.setSalt("salt");
        ormUser.setEmail("email");
        when(mockOrmUserRepository.findById(0L)).thenReturn(Optional.of(ormUser));

        // Run the test
        final OrmUser result = userServiceImplUnderTest.selectByPrimaryKey(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testDeleteByPrimaryKey() {
        when(mockOrmUserRepository.existsById(0L)).thenReturn(true);
        // Run the test
        int i = userServiceImplUnderTest.deleteByPrimaryKey(0L);

        // Verify the results
        assertThat(i).isEqualTo(0);
    }
}
