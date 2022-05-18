DECLARE
    ordernumber number := 1000;
    orderid number default 1200;
    customername varchar2(20) := 'techworldthink';
    id constant number := 12;
BEGIN
    ordernumber := 11111;
    dbms_output.put_line(ordernumber);
    dbms_output.put_line(orderid);
    dbms_output.put_line(customername);
    dbms_output.put_line(id);
END;