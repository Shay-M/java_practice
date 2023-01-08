CREATE VIEW v_ueser
AS
SELECT *
FROM tododb.users;

CREATE VIEW v_ueser_list
AS
SELECT taskName, dateTimeEnd, isCompleted
	FROM (
	SELECT taskName, dateTimeEnd, isCompleted, username
	FROM todolist l, task t ,users u
	WHERE l.user_userId = u.userId AND l.task_taskID = t.taskID) AS new_list
WHERE  username = 'shay';



