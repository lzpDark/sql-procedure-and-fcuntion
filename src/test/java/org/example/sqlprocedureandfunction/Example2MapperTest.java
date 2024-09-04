package org.example.sqlprocedureandfunction;

import org.example.sqlprocedureandfunction.entity.CustomerOrderDetail;
import org.example.sqlprocedureandfunction.mapper.Example2Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author lzp
 */
@SpringBootTest
public class Example2MapperTest {

    @Autowired
    private Example2Mapper example2Mapper;

    @Test
    public void testTotalRevenue() {
        BigDecimal totalRevenue = example2Mapper.getTotalRevenue();
        Assertions.assertNotNull(totalRevenue);
        Assertions.assertEquals(81.8, totalRevenue.doubleValue());
    }

    @Test
    public void testCustomerDetail() {
        CustomerOrderDetail detail = new CustomerOrderDetail();
        detail.setCustomerId(1);
        example2Mapper.getCustomerOrderDetail(detail);

        Assertions.assertEquals("1f1s", detail.getName());
        Assertions.assertEquals(2, detail.getOrderCount());
        Assertions.assertEquals(20.5, detail.getTotalSpent().doubleValue());
    }
}
