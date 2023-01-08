show databases;
use tododb;
show tables;

INSERT INTO user (username)
VALUES ('bbbb');

SELECT *
FROM user;


INSERT INTO task ( taskName, dateTimeEnd, isCompleted)
VALUES ('taskName5', '1948-12-08 00:00:00' ,0);




INSERT INTO todolist (task_taskID, user_userId)
VALUES (3,1);



CREATE DEFINER=`root`@`localhost` PROCEDURE `AddTask`(taskName VARCHAR(45), dateTimeEnd datetime , username varchar(16))
BEGIN
	INSERT INTO task ( taskName, dateTimeEnd, isCompleted)
    VALUES (taskName, dateTimeEnd , 0 );
    
    INSERT INTO todolist ( user_userId)
    SELECT userId
    FROM users u
    WHERE username = u.username;
   
END