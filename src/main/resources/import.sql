-- /**
--  * Author:  Mohammed.Rakayby
--  * Created: Dec 8, 2019
--  */
   
insert into employees (ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRING_DATE,SALARY,MANAGER_ID,DEPARTMENT_ID) values (1,'Mohammed','Rakayby','mohammedrakayby@gmail.com','123456789',PARSEDATETIME('17-09-2012', 'dd-MM-yyyy'),123,null,1);
insert into employees (ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRING_DATE,SALARY,MANAGER_ID,DEPARTMENT_ID) values (2,'Foo','bar','fooBar@gmail.com','123456789',PARSEDATETIME('13-09-2018', 'dd-MM-yyyy'),183,1,1);
insert into employees (ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRING_DATE,SALARY,MANAGER_ID,DEPARTMENT_ID) values (3,'another','name','anotherName@gmail.com','123456789',PARSEDATETIME('1-05-2019', 'dd-MM-yyyy'),13,1,1);

insert into departments values (1,'Services',1);


