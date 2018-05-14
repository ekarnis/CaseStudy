-- Procedures
CREATE OR REPLACE PROCEDURE AddOrder(OrderID VARCHAR2, UserID VARCHAR2, 
PlacedTimestamp NUMBER, DeliveryTimestamp NUMBER, CardID VARCHAR2, 
Instructions VARCHAR2, DeliveryMethodID VARCHAR2, StoreID VARCHAR2, 
DeliveryStatusID VARCHAR2)
AS
BEGIN
  INSERT INTO ORDERS (ORDER_ID, USER_ID, PLACED_TIMESTAMP, DELIVERY_TIMESTAMP, 
  CARD_ID, INSTRUCTIONS, DELIVERY_METHOD_ID, STORE_ID, DELIVERY_STATUS_ID)
    VALUES (OrderID, UserID, PlacedTimestamp, DeliveryTimestamp, CardID, 
    Instructions, DeliveryMethodID, StoreID, DeliveryStatusID);
END;

CREATE OR REPLACE PROCEDURE DeleteOrder(OrderID VARCHAR2)
AS
BEGIN
  DELETE FROM ORDERS 
  WHERE ORDER_ID = OrderID;
END;

--procedures for adding items to order_items
CREATE OR REPLACE PROCEDURE AddOrderItem(OrderID VARCHAR2, ItemID VARCHAR2)
AS
BEGIN 
  INSERT INTO ORDER_ITEMS (ORDER_ID, ITEM_ID)
  VALUES (OrderID, ItemID);
END;

CREATE OR REPLACE PROCEDURE DeleteOrderItems(OrderID VARCHAR2)
AS
BEGIN
  DELETE FROM ORDER_ITEMS 
  WHERE ORDER_ID = OrderID;
END;

--View compilation errors
SHOW ERRORS;