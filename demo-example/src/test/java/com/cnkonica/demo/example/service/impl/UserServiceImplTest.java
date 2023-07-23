package com.cnkonica.demo.example.service.impl;

import com.cnkonica.demo.example.domain.OrmUser;
import com.cnkonica.demo.example.mapper.OrmUserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private OrmUserMapper mockOrmUserMapper;

    @InjectMocks
    private UserServiceImpl userServiceImplUnderTest;

    @Test
    void testGetAllUser() {
        // Setup
        final OrmUser ormUser = new OrmUser();
        ormUser.setId(0);
        ormUser.setName("name");
        ormUser.setPassword("password");
        ormUser.setSalt("salt");
        ormUser.setEmail("email");
        final List<OrmUser> expectedResult = List.of(ormUser);

        // Configure OrmUserMapper.selectAllUser(...).
        final OrmUser ormUser1 = new OrmUser();
        ormUser1.setId(0);
        ormUser1.setName("name");
        ormUser1.setPassword("password");
        ormUser1.setSalt("salt");
        ormUser1.setEmail("email");
        final List<OrmUser> ormUsers = List.of(ormUser1);
        when(mockOrmUserMapper.selectAllUser()).thenReturn(ormUsers);

        // Run the test
        final List<OrmUser> result = userServiceImplUnderTest.getAllUser();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllUser_OrmUserMapperReturnsNoItems() {
        // Setup
        when(mockOrmUserMapper.selectAllUser()).thenReturn(Collections.emptyList());

        // Run the test
        final List<OrmUser> result = userServiceImplUnderTest.getAllUser();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testSelectByPrimaryKey() {
        // Setup
        final OrmUser expectedResult = new OrmUser();
        expectedResult.setId(0);
        expectedResult.setName("name");
        expectedResult.setPassword("password");
        expectedResult.setSalt("salt");
        expectedResult.setEmail("email");

        // Configure OrmUserMapper.selectByPrimaryKey(...).
        final OrmUser ormUser = new OrmUser();
        ormUser.setId(0);
        ormUser.setName("name");
        ormUser.setPassword("password");
        ormUser.setSalt("salt");
        ormUser.setEmail("email");
        when(mockOrmUserMapper.selectByPrimaryKey(0L)).thenReturn(ormUser);

        // Run the test
        final OrmUser result = userServiceImplUnderTest.selectByPrimaryKey(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
