-- MULTISET UNION
-- MULTISET UNION DISTINCT
-- MULTISET EXCEPT
-- MULTISET INTERSECT

DECLARE 
    TYPE t_tab IS TABLE OF NUMBER;
    l_tab1 t_tab := t_tab(1,2,3,4,5,6);
    l_tab2 t_tab := t_tab(5,6,7,8,9,10);
BEGIN
    l_tab1 := l_tab1 MULTISET EXCEPT l_tab2;
    
    FOR i IN l_tab1.first .. l_tab1.last LOOP
        DBMS_OUTPUT.put_line(l_tab1(i));
    END LOOp;
END;
/