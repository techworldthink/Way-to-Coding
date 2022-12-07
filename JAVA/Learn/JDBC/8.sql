CREATE DEFINER=`root`@`localhost` PROCEDURE `get_names`()
BEGIN
	SELECT * FROM mytable;
END