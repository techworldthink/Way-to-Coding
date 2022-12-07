CREATE DEFINER=`root`@`localhost` PROCEDURE `change_dept_to_advanced`(
	INOUT deptname VARCHAR(10)
)
BEGIN
	SET deptname = concat('ADV.',deptname);
END