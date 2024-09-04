package org.example.sqlprocedureandfunction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.sqlprocedureandfunction.entity.Client;

import java.util.List;

/**
 * @author lzp
 */
@Mapper
public interface Example1Mapper {

    List<Client> getAllClients();

}
