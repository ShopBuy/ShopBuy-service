INSERT INTO USERS (ID,EMAIL, PASSWORD, GENDER,FULL_NAME,DATE_OF_BIRTH, PHONE_NUMBER, IS_DELETED,ROLE_ID)
VALUES (	'1',	'accTest1234@example.com',	'$2a$10$Ew0DRwxPtfkOdo1t5l24ZuFRUJqseqpDIzmOT0sQ/2lIOVpx15oke',	'Male',	'John Doe',	'1990-05-15',	'1234567890',	0,	2);
INSERT INTO ADDRESS (`ID`,STREET, WARD, DISTRICT, CITY, PHONE_NUMBER, RECEIVER, USER_ID, IS_DELETED, IS_DEFAULT)
VALUES ('1','123 Main Street', 'West Ward', 'Central District', 'Big City', '9876543210', 'John Doe', 1, 0, 'Yes'),
       ('2','456 Oak Avenue', 'East Ward', 'Downtown District', 'Metropolis', '5556667777', 'Jane Smith', 1, 0, 'No');

INSERT INTO PRODUCT (`ID`,NAME, PRICE, STOCK, DESCRIPTION, STAR, IS_DELETED, CATEGORY_ID, SUB_CATEGORY_ID)
VALUES ('1','Áo thun nam', 200, 50, 'Áo thun cotton nam cao cấp', 4, 0, 1, 1),
       ('2','Áo sơ mi nữ', 250, 40, 'Áo sơ mi nữ dài tay', 5, 0, 1, 2),
       ('3', 'Quần jeans nam', 350, 30, 'Quần jeans nam phong cách', 4, 0, 2, 1),
       ('4', 'Váy đầm dự tiệc', 300, 25, 'Váy đầm dự tiệc sang trọng', 5, 0, 2, 2),
       ('5', 'Áo khoác dù unisex', 400, 20, 'Áo khoác dù unisex thời trang', 4, 0, 1, 3),
       ('6', 'Balo laptop chống nước', 150, 35, 'Balo laptop chống nước dung lượng lớn', 4, 0, 3, 1),
       ('7', 'Dép xỏ ngón nữ', 50, 60, 'Dép xỏ ngón nữ thoải mái', 3, 0, 4, 2),
       ('8', 'Túi xách da cao cấp', 500, 15, 'Túi xách da cao cấp thời trang', 5, 0, 3, 2),
       ('9', 'Áo len nam', 280, 45, 'Áo len nam mịn màng', 4, 0, 1, 4),
       ('10', 'Áo hoodie unisex', 320, 40, 'Áo hoodie unisex thời trang', 5, 0, 1, 5),
       ('11', 'Quần short nữ', 180, 55, 'Quần short nữ thoải mái', 4, 0, 2, 3),
       ('12', 'Áo vest nam công sở', 420, 22, 'Áo vest nam công sở lịch lãm', 5, 0, 1, 6),
       ('13', 'Áo thun nữ', 180, 60, 'Áo thun cotton nữ thoải mái', 4, 0, 1, 7),
       ('14', 'Quần tây nam', 380, 28, 'Quần tây nam kiểu dáng trẻ trung', 4, 0, 2, 5),
       ('15', 'Váy maxi nữ', 280, 33, 'Váy maxi nữ thanh lịch', 5, 0, 2, 6),
       ('16', 'Áo khoác jean unisex', 420, 18, 'Áo khoác jean unisex phong cách', 4, 0, 1, 8),
       ('17', 'Balo du lịch', 200, 45, 'Balo du lịch tiện ích', 3, 0, 3, 3),
       ('18', 'Giày sneaker nam', 300, 25, 'Giày sneaker nam thoải mái', 4, 0, 4, 1),
       ('19', 'Túi xách nữ', 450, 20, 'Túi xách nữ phối hợp đồ điệu', 5, 0, 3, 4),
       ('20', 'Áo khoác phao nam', 500, 15, 'Áo khoác phao nam ấm áp', 4, 0, 1, 9),
       ('21', 'Áo len nữ', 260, 50, 'Áo len nữ dễ phối đồ', 5, 0, 1, 10),
       ('22', 'Áo hoodie nam', 320, 40, 'Áo hoodie nam thời trang', 4, 0, 1, 11),
       ('23', 'Quần legging nữ', 150, 55, 'Quần legging nữ co giãn tốt', 5, 0, 2, 7),
       ('24', 'Áo vest nữ công sở', 380, 22, 'Áo vest nữ công sở thanh lịch', 5, 0, 1, 12),

       ('63', 'Áo polo nam', 240, 48, 'Áo polo nam trẻ trung', 4, 0, 1, 14),
       ('64', 'Đồng hồ nữ dây da', 600, 10, 'Đồng hồ nữ dây da cao cấp', 5, 0, 5, 1)
;

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
