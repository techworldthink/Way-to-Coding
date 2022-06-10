CREATE DEFINER=`root`@`localhost` PROCEDURE `get_name_by_id`(
	IN idget INT,
    OUT nameget VARCHAR(20)
)
BEGIN
	SELECT name INTO nameget FROM mytable WHERE id=idget;
END