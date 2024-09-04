# MySQL里的函数和存储过程

在数据库里已经定义好的存储过程(procedure)或者函数(function)：

`int output = f(int input);`

希望实现这样的功能：
```mysql
select * from table_b where id in (select f(id) from table_a)
```

- 如果这里的f是`函数`: 可以直接在select语句里使用，如上面sql的例子。

- 如果f是`存储过程`：由于存储过程只能通过call调用，且不一定有返回值，所以不能像函数一样直接使用。

## 问题

一般情况下，
- 函数被用于做数据转换并且一定有返回值；
- 存储过程更多的用于执行某些操作。

所以上面讲的场景应该用函数更合适。


## 参考

- [MySQL中的函数和存储过程的异同和使用场景](https://www.linkedin.com/pulse/differences-between-functions-stored-procedures-mysql-owais-qayyum-rg4qf)
- mybatis里使用存储过程:
   [1 ](https://stackoverflow.com/questions/61043089/correctly-configuring-mybatis-out-parameter-to-stored-procedure-call)
   [2 ](https://stackoverflow.com/questions/7817185/cannot-receive-out-parameter-from-oracle-procedure-executed-by-mybatis/7845399#7845399)
   [3 ](https://stackoverflow.com/questions/58205549/how-can-i-call-a-function-that-return-a-boolean-using-mybatis/58221626#58221626)