-- 회원 데이터
INSERT INTO member (username, password, member_role, business_name, business_number, postal_code, address,
                    business_registration, manager, manager_email, manager_phone_number)
VALUES ('user', '$2a$10$LzE0lOWV3xyyXdFcl12VJOb0oLr7cduFZHL51X5z5a5bezwJ5b5lm', 'ROLE_USER', 'John Doe Inc.',
        '123-45-67890', '12345', '123 Main Street, Anytown USA', '12345678-9', 'John Doe', 'john.doe@example.com',
        '+1-123-456-7890'),
       ('admin123', '$2a$10$Ald8g8dDd24x1JhYdTmC.OAA4bEhA65GP5GLOcSdrRkftqeFdztk6', 'ROLE_ADMIN', 'Jane Doe Inc.',
        '098-76-54321', '54321', '543 Maple Avenue, Anytown USA', '98765432-1', 'Jane Doe', 'jane.doe@example.com',
        '+1-987-654-3210'),
       ('user123', '$2a$10$NDcbTahormwJsIgwfoctXO47jK3n5pmKbx7xnkMxTnf5rr6yIjQ22', 'ROLE_USER', 'user', '123-4512-1234',
        '4542', 'somewhere', '12314', 'user', 'user@email', '010-123-4567');

-- 공지사항
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'NOTICE', false, 'Jahan', 'Bickford', '2022-11-12 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
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

-- 자묻질
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-12 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-13 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-14 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-15 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-16 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-17 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-18 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-19 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-20 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-21 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-22 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-23 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-24 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-25 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-26 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-27 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-28 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-29 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-11-30 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-12-01 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-12-02 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-12-03 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-12-04 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-12-05 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-12-06 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-12-07 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-12-08 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-12-09 12:33:51', '2022-11-02 10:18:32');
insert into article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
values (1, 'Integer a nibh.',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. falsea justo.',
        'FAQ', false, 'Jahan', 'Bickford', '2022-12-10 12:33:51', '2022-11-02 10:18:32');


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


insert into manufacturer (id, name)
values (1, '슬찬이네'),
       (2, '연희네'),
       (3, '인후네'),
       (4, '브루앤드디스틸시스템'),
       (5, '포포네');

insert into product (id, created_at, discount_rate, max_quantity, min_quantity, monthly_clicks,
                     name, regular_price, updated_at, weekly_clicks, category_id, manufacturer_id)
values (1, '2022-01-23 00:07:58', 10, 100, 1, 1000, 'Product 1', 1000, '2022-01-23 00:07:58', 1000, 1, 1),
       (2, '2022-02-23 00:07:58', 15, 200, 2, 1500, 'Product 2', 2000, '2022-02-23 00:07:58', 1500, 2, 2),
       (3, '2022-03-23 00:07:58', 20, 300, 3, 2000, 'Product 3', 3000, '2022-03-23 00:07:58', 2000, 3, 3),
       (4, '2022-04-23 00:07:58', 25, 400, 4, 2500, 'Product 4', 4000, '2022-04-23 00:07:58', 2500, 4, 4),
       (5, '2022-05-23 00:07:58', 30, 500, 5, 3000, 'Product 5', 5000, '2022-05-23 00:07:58', 3000, 5, 5),
       (6, '2022-06-23 00:07:58', 35, 600, 6, 3500, 'Product 6', 6000, '2022-06-23 00:07:58', 3500, 6, 4),
       (7, '2022-07-23 00:07:58', 40, 700, 7, 4000, 'Product 7', 7000, '2022-07-23 00:07:58', 4000, 7, 3),
       (8, '2022-08-23 00:07:58', 45, 800, 8, 4500, 'Product 8', 8000, '2022-08-23 00:07:58', 4500, 8, 2),
       (9, '2022-09-23 00:07:58', 2, 900, 9, 5000, 'Product 9', 9000, '2022-09-23 00:07:58', 5000, 9, 1),
       (10, '2022-10-23 00:07:58', 3, 1000, 10, 5500, 'Product 10', 10000, '2022-10-23 00:07:58', 5500, 10, 1),
       (11, '2022-11-23 00:07:58', 5, 1100, 11, 6000, 'Product 11', 11000, '2022-11-23 00:07:58', 6000, 1, 5),
       (12, '2022-12-23 00:07:58', 1, 1200, 12, 6500, 'Product 12', 12000, '2022-12-23 00:07:58', 6500, 2, 4),
       (13, '2023-01-23 00:07:58', 11, 1300, 13, 7000, 'Product 13', 13000, '2023-01-23 00:07:58', 7000, 3, 3),
       (14, '2023-02-23 00:07:58', 11, 1400, 14, 7500, 'Product 14', 14000, '2023-02-23 00:07:58', 7500, 4, 2),
       (15, '2023-03-23 00:07:58', 11, 1500, 15, 8000, 'Product 15', 15000, '2023-03-23 00:07:58', 8000, 5, 1),
       (16, '2023-04-23 00:07:58', 14, 1600, 16, 8500, 'Product 16', 16000, '2023-04-23 00:07:58', 8500, 6, 5),
       (17, '2023-05-23 00:07:58', 12, 1700, 17, 9000, 'Product 17', 17000, '2023-05-23 00:07:58', 9000, 7, 4),
       (18, '2023-06-23 00:07:58', 23, 1800, 18, 9500, 'Product 18', 18000, '2023-06-23 00:07:58', 9500, 8, 3),
       (19, '2023-07-23 00:07:58', 22, 1900, 19, 10000, 'Product 19', 19000, '2023-07-23 00:07:58', 10000, 9, 2),
       (20, '2023-08-23 00:07:58', 23, 2000, 20, 10500, 'Product 20', 20000, '2023-08-23 00:07:58', 10500, 10, 1);

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
INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address,
                          request_content, postal_code, payment_method, cost, shipping_fee, delivery_state, order_type,
                          order_time,
                          buyer_id, product_id, order_detail_id)
VALUES (1, 2, 'John Doe', '1234567890', '123 Main St', 'Sample request', '12345', 'Credit', 100, 10, 'PAID',
        'IMMEDIATE', '2023-05-14 00:07:58', 1, 1, 1);

INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address,
                          request_content, postal_code, payment_method, cost, shipping_fee, delivery_state, order_type,
                          order_time,
                          buyer_id, product_id, order_detail_id)
VALUES (2, 3, 'Jane Smith', '9876543210', '456 Elm St', 'Sample request', '54321', 'PayPal', 200, 20, 'DELIVERING',
        'REQUEST_DOCUMENT', '2023-02-01 00:07:58', 1, 1, 1);

INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address,
                          request_content, postal_code, payment_method, cost, shipping_fee, delivery_state, order_type,
                          order_time,
                          buyer_id, product_id, order_detail_id)
VALUES (3, 1, 'Michael Johnson', '5551112222', '789 Oak St', 'Sample request', '67890', 'Cash', 150, 15, 'DELIVER_DONE',
        'IMMEDIATE', '2023-03-23 00:07:58', 1, 1, 1);

INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address,
                          request_content, postal_code, payment_method, cost, shipping_fee, delivery_state, order_type,
                          order_time,
                          buyer_id, product_id, order_detail_id)
VALUES (3, 10, 'Kelly Johnson', '500002222', '789 Green St', 'Sample request', '67890', 'Cash', 150, 15, 'DELIVER_DONE',
        'REQUEST_DOCUMENT', '2022-09-23 00:12:58', 1, 2, 2);

insert into cart (id, product_id, member_id, quantity)
values (1, 1, 1, 10),(3,3,2,10),(2,2,1,10);