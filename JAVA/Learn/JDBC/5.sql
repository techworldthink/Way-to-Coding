CREATE DEFINER=`root`@`localhost` PROCEDURE `increase_mark`(
	idget INT,
    addmark INT
)
BEGIN
	UPDATE mytable 
    SET mark1=mark1+addmark 
    WHERE id=idget;
END