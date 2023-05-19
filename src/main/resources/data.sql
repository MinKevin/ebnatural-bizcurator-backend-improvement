-- 회원 데이터
INSERT INTO member (username, password, member_role, representative, business_name, business_number, postal_code,
                    address,
                    business_registration, manager, manager_email, manager_phone_number, created_at, modified_at,
                    is_enable)
VALUES ('admin@admin.com', '$2a$10$y.p87DfRX11cw6mLJ9OZD.SdrRegpOT2YZ9hUqY2h2yvwYfYW9UFy', 'ROLE_ADMIN', 'userRep',
        'user',
        '123-4512-1234',
        '4542', 'somewhere', '12314', 'user', 'user@email', '010-123-4567', '2022-11-12 12:33:51',
        '2022-11-02 10:18:32', true),
       ('admin2@admin.com', '$2a$10$y.p87DfRX11cw6mLJ9OZD.SdrRegpOT2YZ9hUqY2h2yvwYfYW9UFy', 'ROLE_ADMIN', 'userRep',
        'user',
        '123-4512-1234',
        '4542', 'somewhere', '12314', 'user', 'user@email', '010-123-4567', '2022-11-12 12:33:51',
        '2022-11-02 10:18:32', true),
       ('user@user.com', '$2a$10$Ef5oakcZUNfETYLE1f1qfOpVwyoEuPQnXtyxVnU7o0fLFlJAghVlC', 'ROLE_USER', 'userRep', 'user',
        '123-4512-1234',
        '4542', 'somewhere', '12314', 'user', 'user@email', '010-123-4567', '2022-11-12 12:33:51',
        '2022-11-02 10:18:32', true);

-- 공지사항
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, '[안내] 배송관련 소비자 분쟁해결 기준 안내',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-12 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, '[이벤트] 여름이니까 아이스커피! 맥심 할인 판매!',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-13 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-14 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-15 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-16 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, '고정 1',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', true, 'Jahan', 'Bickford', '2022-11-17 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-18 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-19 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-20 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-21 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-22 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-23 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-24 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-25 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-26 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, '고정 2',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', true, 'Jahan', 'Bickford', '2022-11-27 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-28 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-29 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-30 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-12-01 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-12-02 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-12-03 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-12-04 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, '고정 3',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', true, 'Jahan', 'Bickford', '2022-12-05 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-12-06 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-12-07 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-12-08 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-12-09 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-12-10 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, '[안내] 환불관련 소비자 분쟁해결 기준 안내',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-12 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, '[이벤트] 여름이니까 아이스 아메리카노! 카누 할인 판매!',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-13 12:33:51', '2022-11-02 10:18:32');

-- 자묻질
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, '[배송/물류] 물건이 도착하지 않았습니다.',
        '물건이 도착하지 않은 경우 배송업체와 먼저 연락해보시고 연락주세요. 감사합니다.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-12 12:33:51', '2022-11-02 10:18:32'),
       (1, '[의뢰서] 견적 의뢰한 내용을 수정하고 싶습니다.',
        '[마이페이지]의 [내 의뢰내역]에서 수정이 가능합니다. 다만 의뢰구분 상태값이 대기인 경우에만 가능하며, 승인 및 반려인 상태에서는 수정이 불가능합니다. 감사합니다.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-12 12:33:51', '2022-11-02 10:18:32'),
       (1, '[바로구매] 비즈큐레이터 바로구매는 무엇인가요?',
        '기존 비즈큐레이터의 시스템인 구매 및 견적의뢰를 거치지 않으며, 고객들이 합리적인 가격에 대량으로 바로 제품구매가 가능하게끔 만든 구매형태입니다. 감사합니다.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-12 12:33:51', '2022-11-02 10:18:32'),
       (1, '[회원정보] 회원탈퇴는 어떻게 하나요?',
        '[마이페이지]의 [회원정보 수정]의 맨 아래 회원탈퇴 텍스트를 누르신 후 탈퇴하실 수 있습니다. 감사합니다.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-12 12:33:51', '2022-11-02 10:18:32');


-- product

insert into product_category (id, name)
values (1, '객실용품'),
       (2, '욕실용품'),
       (3, '위생용품'),
       (4, '침구류'),
       (5, '가전/전자제품'),
       (6, '청소/시설관리'),
       (7, '소방안전관리'),
       (8, '사무용품'),
       (9, '음료/식품'),
       (10, '기타');

insert into purpose_category (id, name)
values (1, '창업(제품판매)'),
       (2, '작품 제작'),
       (3, '개인적인 목적');


insert into manufacturer (id, name)
values (1, '슬찬이네'),
       (2, '연희네'),
       (3, '인후네'),
       (4, '브루앤드디스틸시스템'),
       (5, '포포네');

insert into product (id, created_at, discount_rate, max_quantity, min_quantity, monthly_clicks,
                     name, regular_price, modified_at, weekly_clicks, category_id, manufacturer_id)
values (1, '2022-01-23 00:07:58', 10, 100, 1, 1000, 'ProductA 1', 1000, '2022-01-23 00:07:58', 1000, 1, 1),
       (2, '2022-02-23 00:07:58', 15, 200, 2, 1500, 'ProductB 2', 2000, '2022-02-23 00:07:58', 1500, 2, 2),
       (3, '2022-03-23 00:07:58', 20, 300, 3, 2000, 'ProductC 3', 3000, '2022-03-23 00:07:58', 2000, 3, 3),
       (4, '2022-04-23 00:07:58', 25, 400, 4, 2500, 'ProductD 4', 4000, '2022-04-23 00:07:58', 2500, 4, 4),
       (5, '2022-05-23 00:07:58', 30, 500, 5, 3000, 'ProductE 5', 5000, '2022-05-23 00:07:58', 3000, 5, 5),
       (6, '2022-06-23 00:07:58', 35, 600, 6, 3500, 'ProductF 6', 6000, '2022-06-23 00:07:58', 3500, 6, 4),
       (7, '2022-07-23 00:07:58', 40, 700, 7, 4000, 'ProductG 7', 7000, '2022-07-23 00:07:58', 4000, 7, 3),
       (8, '2022-08-23 00:07:58', 45, 800, 8, 4500, 'ProductH 8', 8000, '2022-08-23 00:07:58', 4500, 8, 2),
       (9, '2022-09-23 00:07:58', 2, 900, 9, 5000, 'ProductI 9', 9000, '2022-09-23 00:07:58', 5000, 9, 1),
       (10, '2022-10-23 00:07:58', 3, 1000, 10, 5500, 'ProductJ 10', 10000, '2022-10-23 00:07:58', 5500, 10, 1),
       (11, '2022-11-23 00:07:58', 5, 1100, 11, 6000, 'ProductK 11', 11000, '2022-11-23 00:07:58', 6000, 1, 5),
       (12, '2022-12-23 00:07:58', 1, 1200, 12, 6500, 'ProductL 12', 12000, '2022-12-23 00:07:58', 6500, 2, 4),
       (13, '2023-01-23 00:07:58', 11, 1300, 13, 7000, 'ProductM 13', 13000, '2023-01-23 00:07:58', 7000, 3, 3),
       (14, '2023-02-23 00:07:58', 11, 1400, 14, 7500, 'ProductN 14', 14000, '2023-02-23 00:07:58', 7500, 4, 2),
       (15, '2023-03-23 00:07:58', 11, 1500, 15, 8000, 'ProductO 15', 15000, '2023-03-23 00:07:58', 8000, 5, 1),
       (16, '2023-04-23 00:07:58', 14, 1600, 16, 8500, 'ProductP 16', 16000, '2023-04-23 00:07:58', 8500, 6, 5),
       (17, '2023-05-23 00:07:58', 12, 1700, 17, 9000, 'ProductQ 17', 17000, '2023-05-23 00:07:58', 9000, 7, 4),
       (18, '2023-06-23 00:07:58', 23, 1800, 18, 9500, 'ProductR 18', 18000, '2023-06-23 00:07:58', 9500, 8, 3),
       (19, '2023-07-23 00:07:58', 22, 1900, 19, 10000, 'ProductS 19', 19000, '2023-07-23 00:07:58', 10000, 9, 2),
       (20, '2023-08-23 00:07:58', 23, 2000, 20, 10500, 'ProductT 20', 20000, '2023-08-23 00:07:58', 10500, 10, 1);

insert into product_image (id, img_url, repimg_yn, product_id)
values (1, 'https://picsum.photos/200/300?random=0', 'Y', 1),
       (2, 'https://picsum.photos/200/300?random=1', 'Y', 2),
       (3, 'https://picsum.photos/200/300?random=2', 'Y', 3),
       (4, 'https://picsum.photos/200/300?random=3', 'Y', 4),
       (5, 'https://picsum.photos/200/300?random=4', 'Y', 5),
       (6, 'https://picsum.photos/200/300?random=5', 'Y', 6),
       (7, 'https://picsum.photos/200/300?random=6', 'Y', 7),
       (8, 'https://picsum.photos/200/300?random=7', 'Y', 8),
       (9, 'https://picsum.photos/200/300?random=8', 'Y', 9),
       (10, 'https://picsum.photos/200/300?random=9', 'Y', 10),
       (11, 'https://picsum.photos/200/300?random=10', 'Y', 11),
       (12, 'https://picsum.photos/200/300?random=11', 'Y', 12),
       (13, 'https://picsum.photos/200/300?random=12', 'Y', 13),
       (14, 'https://picsum.photos/200/300?random=13', 'Y', 14),
       (15, 'https://picsum.photos/200/300?random=14', 'Y', 15),
       (16, 'https://picsum.photos/200/300?random=15', 'N', 15),
       (17, 'https://picsum.photos/200/300?random=16', 'N', 14),
       (18, 'https://picsum.photos/200/300?random=17', 'N', 13),
       (19, 'https://picsum.photos/200/300?random=18', 'N', 12),
       (20, 'https://picsum.photos/200/300?random=19', 'N', 11),
       (21, 'https://picsum.photos/200/300?random=20', 'N', 10),
       (22, 'https://picsum.photos/200/300?random=21', 'N', 9),
       (23, 'https://picsum.photos/200/300?random=22', 'N', 8),
       (24, 'https://picsum.photos/200/300?random=23', 'N', 7),
       (25, 'https://picsum.photos/200/300?random=24', 'N', 6),
       (26, 'https://picsum.photos/200/300?random=25', 'N', 5),
       (27, 'https://picsum.photos/200/300?random=26', 'N', 4),
       (28, 'https://picsum.photos/200/300?random=27', 'N', 3),
       (29, 'https://picsum.photos/200/300?random=28', 'N', 2),
       (30, 'https://picsum.photos/200/300?random=29', 'N', 1),
       (31, 'https://picsum.photos/200/300?random=30', 'Y', 16),
       (32, 'https://picsum.photos/200/300?random=31', 'Y', 17),
       (33, 'https://picsum.photos/200/300?random=32', 'Y', 18),
       (34, 'https://picsum.photos/200/300?random=33', 'Y', 19),
       (35, 'https://picsum.photos/200/300?random=34', 'Y', 20),
       (36, 'https://picsum.photos/200/300?random=35', 'N', 16),
       (37, 'https://picsum.photos/200/300?random=36', 'N', 17),
       (38, 'https://picsum.photos/200/300?random=37', 'N', 18),
       (39, 'https://picsum.photos/200/300?random=38', 'N', 19),
       (40, 'https://picsum.photos/200/300?random=39', 'N', 20);

--  주문 내역
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (961, 823, 'Michael Johnson', '5166392274', 'Address777', 'Request433', 'PostalCode803', 'PayPal', 776, 977,
        'DELIVER_DONE', 'IMMEDIATE', '2023-01-17 12:00:00', 1, 1, 1);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (670, 619, 'John Smith', '5138545969', 'Address309', 'Request31', 'PostalCode612', 'Card', 699, 773,
        'DELIVER_DONE', 'IMMEDIATE', '2023-02-17 12:00:00', 1, 2, 2);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (529, 584, 'John Smith', '5251333195', 'Address492', 'Request648', 'PostalCode335', 'PayPal', 801, 37, 'FINISH',
        'IMMEDIATE', '2023-03-17 12:00:00', 1, 3, 3);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (501, 628, 'Jane Doe', '5274567819', 'Address867', 'Request373', 'PostalCode882', 'Cash', 496, 420,
        'DELIVER_DONE', 'IMMEDIATE', '2023-04-17 12:00:00', 1, 4, 4);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (827, 167, 'John Smith', '5159384926', 'Address491', 'Request303', 'PostalCode337', 'PayPal', 221, 547,
        'DELIVERING', 'IMMEDIATE', '2023-05-17 12:00:00', 1, 5, 5);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (206, 724, 'Michael Johnson', '5282879563', 'Address869', 'Request813', 'PostalCode742', 'Card', 791, 226,
        'DELIVER_DONE', 'IMMEDIATE', '2022-12-17 12:00:00', 1, 6, 6);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (32, 542, 'John Smith', '5137860168', 'Address563', 'Request319', 'PostalCode722', 'PayPal', 835, 836,
        'DELIVER_DONE', 'IMMEDIATE', '2023-01-17 12:00:00', 1, 7, 7);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (190, 784, 'Michael Johnson', '5130653182', 'Address688', 'Request604', 'PostalCode622', 'Card', 257, 724,
        'DELIVER_DONE', 'IMMEDIATE', '2023-02-17 12:00:00', 1, 8, 8);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (478, 690, 'Jane Doe', '5245672103', 'Address144', 'Request820', 'PostalCode112', 'Cash', 145, 372,
        'DELIVER_DONE', 'IMMEDIATE', '2023-02-17 12:00:00', 1, 9, 9);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (948, 751, 'Jane Doe', '5217390516', 'Address737', 'Request756', 'PostalCode734', 'PayPal', 562, 111,
        'DELIVER_DONE', 'IMMEDIATE', '2023-04-17 12:00:00', 1, 10, 10);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (614, 54, 'Jane Doe', '5228754101', 'Address891', 'Request598', 'PostalCode640', 'PayPal', 419, 992,
        'DELIVER_DONE', 'IMMEDIATE', '2023-03-17 12:00:00', 2, 1, 11);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (195, 331, 'Jane Doe', '5278241713', 'Address124', 'Request34', 'PostalCode527', 'Card', 665, 732, 'FINISH',
        'IMMEDIATE', '2023-03-17 12:00:00', 2, 2, 12);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (547, 51, 'John Smith', '5243207671', 'Address444', 'Request57', 'PostalCode119', 'Card', 278, 769,
        'DELIVER_DONE', 'IMMEDIATE', '2023-05-13 12:00:00', 2, 3, 13);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (47, 798, 'John Smith', '5163359803', 'Address835', 'Request158', 'PostalCode482', 'PayPal', 122, 665,
        'DELIVER_DONE', 'IMMEDIATE', '2023-05-14 12:00:00', 2, 4, 14);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (459, 831, 'Michael Johnson', '5260220314', 'Address634', 'Request199', 'PostalCode974', 'Card', 166, 257,
        'DELIVER_DONE', 'IMMEDIATE', '2023-05-15 12:00:00', 2, 5, 15);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (530, 690, 'Michael Johnson', '5135564978', 'Address899', 'Request108', 'PostalCode822', 'PayPal', 356, 853,
        'DELIVER_DONE', 'IMMEDIATE', '2023-05-16 12:00:00', 2, 6, 16);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (286, 79, 'Jane Doe', '5258309082', 'Address44', 'Request681', 'PostalCode646', 'PayPal', 271, 543,
        'DELIVER_DONE', 'IMMEDIATE', '2023-05-17 12:00:04', 2, 7, 17);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (784, 464, 'Jane Doe', '5257004374', 'Address671', 'Request160', 'PostalCode188', 'Cash', 39, 405,
        'DELIVER_DONE', 'IMMEDIATE', '2023-05-17 12:00:30', 2, 8, 18);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (888, 391, 'Michael Johnson', '5215040637', 'Address463', 'Request590', 'PostalCode430', 'Card', 892, 727,
        'DELIVER_DONE', 'IMMEDIATE', '2023-05-17 12:02:00', 2, 9, 19);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, id)
VALUES (665, 252, 'Michael Johnson', '5161607520', 'Address403', 'Request84', 'PostalCode686', 'Card', 930, 297,
        'DELIVER_DONE', 'IMMEDIATE', '2023-05-17 12:10:00', 2, 10, 20);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id)
VALUES (47, 798, 'John Smith', '5163359803', 'Address835', 'Request158', 'PostalCode482', 'PayPal', 122, 665, 'PAID',
        'IMMEDIATE', '2023-05-14 12:00:00', 2, 4);

INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id)
VALUES (47, 798, 'John Smith', '5163359803', 'Address835', 'Request158', 'PostalCode482', 'PayPal', 122, 665, 'PAID',
        'IMMEDIATE', '2023-05-14 12:00:00', 2, 4);

INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id)
VALUES (47, 798, 'John Smith', '5163359803', 'Address835', 'Request158', 'PostalCode482', 'PayPal', 122, 665, 'PAID',
        'IMMEDIATE', '2023-05-14 12:00:00', 1, 4);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id)
VALUES (47, 798, 'John Smith', '5163359803', 'Address835', 'Request158', 'PostalCode482', 'PayPal', 122, 665, 'PAID',
        'IMMEDIATE', '2023-05-14 12:00:00', 1, 4);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id)
VALUES (47, 798, 'John Smith', '5163359803', 'Address835', 'Request158', 'PostalCode482', 'PayPal', 122, 665, 'PAID',
        'IMMEDIATE', '2023-05-14 12:00:00', 2, 4);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id)
VALUES (47, 798, 'John Smith', '5163359803', 'Address835', 'Request158', 'PostalCode482', 'PayPal', 122, 665, 'PAID',
        'IMMEDIATE', '2023-05-14 12:00:00', 2, 4);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id)
VALUES (47, 798, 'John Smith', '5163359803', 'Address835', 'Request158', 'PostalCode482', 'PayPal', 122, 665, 'PAID',
        'IMMEDIATE', '2023-05-14 12:00:00', 1, 4);
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address, request_content,
                          postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id)
VALUES (47, 798, 'John Smith', '5163359803', 'Address835', 'Request158', 'PostalCode482', 'PayPal', 122, 665, 'PAID',
        'IMMEDIATE', '2023-05-14 12:00:00', 1, 4);

INSERT INTO purchase_document (id, member_id, category_id, product_name, product_detail, quantity, desired_estimate_date,
                               desired_delivery_date, manager_name, manager_call, request_message, image_directory,
                               state_type, created_at, modified_at)
Values (1, 1, 1, "productName", "productDetail", 40, "23-05-20", "23-05-30", "managerName", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", now(), now()),
       (2, 1, 2, "productName", "productDetail", 30, "23-05-20", "23-05-30", "managerName", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", now(), now()),
       (3, 2, 3, "productName", "productDetail", 20, "23-05-20", "23-05-30", "managerName", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", now(), now()),
       (4, 3, 4, "productName", "productDetail", 10, "23-05-20", "23-05-30", "managerName", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", now(), now());

INSERT INTO make_document (id, member_id, purpose_category_id, product_name, product_detail, quantity, desired_estimate_date,
                           desired_delivery_date, manager_name, manager_call, request_message, image_directory,
                           state_type, created_at, modified_at)
Values (1, 3, 3, "productName", "productDetail", 10, "23-05-20", "23-05-30", "managerName", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", now(), now()),
       (2, 2, 3, "productName", "productDetail", 20, "23-05-20", "23-05-30", "managerName", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", now(), now()),
       (3, 2, 2, "productName", "productDetail", 30, "23-05-20", "23-05-30", "managerName", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", now(), now()),
       (4, 1, 1, "productName", "productDetail", 40, "23-05-20", "23-05-30", "managerName", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", now(), now());

INSERT INTO sell_document (id, member_id, category_id, business_name, ceo_name, manager_phone_number, business_number,
                           product_detail, establish_year, introduction, image_directory, state_type, created_at, modified_at)
VALUES (1, 1, 1, "businessName", "ceoName", "managerPhoneNumber", "businessNumber", "productDetail", 2000,
        "introduction", "imageDirectory", "WAIT", now(), now()),
       (2, 2, 2, "businessName", "ceoName", "managerPhoneNumber", "businessNumber", "productDetail", 2000,
        "introduction", "imageDirectory", "WAIT", now(), now()),
       (3, 3, 3, "businessName", "ceoName", "managerPhoneNumber", "businessNumber", "productDetail", 2000,
        "introduction", "imageDirectory", "WAIT", now(), now()),
       (4, 3, 4, "businessName", "ceoName", "managerPhoneNumber", "businessNumber", "productDetail", 2000,
        "introduction", "imageDirectory", "WAIT", now(), now());