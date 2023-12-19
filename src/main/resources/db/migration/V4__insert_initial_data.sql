INSERT INTO USERS (ID,EMAIL, PASSWORD, GENDER,FULL_NAME,DATE_OF_BIRTH, PHONE_NUMBER, IS_DELETED,ROLE_ID)
VALUES (	'1',	'accTest1234@example.com',	'$2a$10$Ew0DRwxPtfkOdo1t5l24ZuFRUJqseqpDIzmOT0sQ/2lIOVpx15oke',	'Male',	'John Doe',	'1990-05-15',	'1234567890',	0,	2);
INSERT INTO ADDRESS (`ID`,STREET, WARD, DISTRICT, CITY, PHONE_NUMBER, RECEIVER, USER_ID, IS_DELETED, IS_DEFAULT)
VALUES ('1','123 Main Street', 'West Ward', 'Central District', 'Big City', '9876543210', 'John Doe', 1, 0, 'Yes'),
       ('2','456 Oak Avenue', 'East Ward', 'Downtown District', 'Metropolis', '5556667777', 'Jane Smith', 1, 0, 'No');

INSERT INTO PRODUCT (`ID`,NAME, PRICE, STOCK, DESCRIPTION, STAR, IS_DELETED, CATEGORY_ID, SUB_CATEGORY_ID)
VALUES ('1','Áo thun nam', 200, 50, 'Áo thun cotton nam cao cấp', 4, 0, 1, 1),
       ('2','Áo sơ mi nữ', 250, 40, 'Áo sơ mi nữ dài tay', 5, 0, 1, 2);

INSERT INTO COLOR (ID,NAME, CODE, ACRONYM, IS_DELETED)
VALUES ('1','Red', '#FF0000', 'R', 0),
       ('2','Green', '#00FF00', 'G', 0),
       ('3','Blue', '#0000FF', 'B', 0);
INSERT INTO SIZE (`ID`,NAME, IS_DELETED)
VALUES ('1','Small', 0),
       ('2','Medium', 0),
       ('3','Large', 0);
INSERT INTO VARIANT (`ID`,COLOR_ID, SIZE_ID, PRODUCT_ID, IS_DELETED)
VALUES ('1',1, 1, 1, 0),
       ('2',2, 2, 2, 0);
INSERT INTO IMAGE_PRODUCT (`ID`,URL, PRODUCT_ID, IS_DELETED)
VALUES ('1','https://example.com/image1.jpg', 1, 0),
       ('2','https://example.com/image2.jpg', 2, 0);
INSERT INTO REVIEW (`ID`,CONTENT, `TIME`, STAR, USER_ID, PRODUCT_ID, IS_DELETED)
VALUES ('1','Great product!', '2023-12-18 12:00:00', 5, 1, 1, 0),
       ('2','Could be better.', '2023-12-18 13:00:00', 3, 1, 2, 0);
INSERT INTO CART (`ID`,USER_ID)
VALUES ('1',1),
       ('2',1);
INSERT INTO CART_ITEM (`ID`,QUANTITY, PRICE, SUBTOTAL, CART_ID, PRODUCT_ID, VARIANT_ID, IS_DELETED)
VALUES ('1',2, 100, 200, 1, 1, 1, 0),
       ('2',3, 150, 450, 2, 2, 2, 0);
INSERT INTO SALE_VOUCHER (`ID`,CODE, DISCOUNT, IS_DELETED)
VALUES ('1','SALE10', 10.00, 0),
       ('2','SALE20', 20.00, 0);
INSERT INTO ORDERS (`ID`,`DATE`, TOTAL_AMOUNT, `FINAL_PRICE`, PAYMENT, ADDRESS_ID, USER_ID, SALE_VOUCHER_ID)
VALUES ('1','2023-12-18 15:00:00', 200, 180, 'Credit Card', 1, 1, 1),
       ('2','2023-12-18 16:00:00', 450, 400, 'PayPal', 2, 1, 2);
INSERT INTO ORDER_LINE (`ID`,QUANTITY, PRICE, SUBTOTAL, PRODUCT_ID, VARIANT_ID, ORDER_ID)
VALUES ('1',2, 100, 200, 1, 1, 1),
       ('2',3, 150, 450, 2, 2, 2);
