package org.example.sqlprocedureandfunction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.sqlprocedureandfunction.entity.CustomerOrderDetail;

import java.math.BigDecimal;

/**
 * @author lzp
 */
@Mapper
public interface Example2Mapper {

    // using function
    BigDecimal getTotalRevenue();

    // call procedure
    // ref: https://stackoverflow.com/questions/61043089/correctly-configuring-mybatis-out-parameter-to-stored-procedure-call
    // ref: https://stackoverflow.com/questions/7817185/cannot-receive-out-parameter-from-oracle-procedure-executed-by-mybatis/7845399#7845399
    // ref: https://stackoverflow.com/questions/58205549/how-can-i-call-a-function-that-return-a-boolean-using-mybatis/58221626#58221626
    void getCustomerOrderDetail(CustomerOrderDetail detail);
}
