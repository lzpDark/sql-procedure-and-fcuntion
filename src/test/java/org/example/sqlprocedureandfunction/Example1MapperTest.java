package org.example.sqlprocedureandfunction;

import org.example.sqlprocedureandfunction.entity.Client;
import org.example.sqlprocedureandfunction.mapper.Example1Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author lzp
 */
@SpringBootTest
public class Example1MapperTest {

    @Autowired
    Example1Mapper example1Mapper;

    @Test
    public void testProcedure() {
        List<Client> clients =
                example1Mapper.getAllClients();
        Assertions.assertNotNull(clients);
        Assertions.assertEquals(2, clients.size());
    }
}
