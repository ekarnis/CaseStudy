-- Procedures
CREATE OR REPLACE PROCEDURE AddDeliveryStatus(ID VARCHAR2, Name VARCHAR2)
AS
BEGIN
  INSERT INTO DELIVERY_STATUSES (DELIVERY_STATUS_ID, DELIVERY_STATUS)
    VALUES (ID, Name);
END;

CREATE OR REPLACE PROCEDURE DeleteDeliveryStatus(ID VARCHAR2)
AS
BEGIN
  DELETE FROM DELIVERY_STATUSES 
  WHERE DELIVERY_STATUS_ID = ID;
END;

--View compilation errors
SHOW ERRORS;