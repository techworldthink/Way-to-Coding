create Trigger updateAvailableQuantity
 before insert  on saleitem
 for each row 
 update product set qtyinstock = qtyinstock - NEW.qty where pdtid = NEW.pdtid;