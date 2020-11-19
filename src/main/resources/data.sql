INSERT INTO ADDRESS(ADDRESS_ID,STREET_NAME,NUMBER,CITY,COUNTRY,ZIP_CODE)
VALUES (NEXTVAL('SEQ_ADDRESS'),'Street 1',10,'Valencia','Spain','46022');

INSERT INTO CUSTOMER(CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL)
VALUES (NEXTVAL('SEQ_CUSTOMER'), 'First Name customer 1', 'Last Name Customer 1', 'email1@mail.com');

INSERT INTO PRODUCT(PRODUCT_ID,NAME,PRICE,TYPE) VALUES (NEXTVAL('SEQ_PRODUCT'),'Product 1',15.0,'BOOK');
INSERT INTO PRODUCT(PRODUCT_ID,NAME,PRICE,TYPE) VALUES (NEXTVAL('SEQ_PRODUCT'),'Product 2',15.0,'BOOK');

INSERT INTO ORDR(ORDR_ID,CLOSED_AT,ADDRESS_ID,CUSTOMER_ID) VALUES (NEXTVAL('SEQ_ORDR'),null,1,1);
INSERT INTO ORDERITEM(ID,QUANTITY,ORDR_ID,PRODUCT_ID) VALUES (NEXTVAL('SEQ_ORDERITEM'),1,1,1);
INSERT INTO ORDERITEM(ID,QUANTITY,ORDR_ID,PRODUCT_ID) VALUES (NEXTVAL('SEQ_ORDERITEM'),2,1,2);
