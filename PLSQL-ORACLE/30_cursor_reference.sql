CREATE OR REPLACE FUNCTION get_user_detail(
    user_id IN NUMBER
)
    RETURN SYS_REFCURSOR
IS
    res_return SYS_REFCURSOR;
BEGIN
    OPEN res_return FOR
    SELECT id,name FROM mytable WHERE id = user_id;
    RETURN res_return;
    
END get_user_detail;


CREATE OR REPLACE PROCEDURE display_details
AS
    C_REC SYS_REFCURSOR;
    uid mytable.id%type;
    uname mytable.name%type;
BEGIN
    C_REC := get_user_detail(2);
    
    LOOP
        FETCH C_REC INTO uid,uname;
        EXIT WHEN c_rec%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(uname);
    END LOOP;
END display_details;


execute display_details;