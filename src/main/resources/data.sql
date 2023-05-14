-- 회원 데이터
INSERT INTO member (username, password, member_role, business_name, business_number, postal_code, address,
                    business_registration, manager, manager_email, manager_phone_number)
VALUES ('user', '$2a$10$LzE0lOWV3xyyXdFcl12VJOb0oLr7cduFZHL51X5z5a5bezwJ5b5lm', 'ROLE_USER', 'John Doe Inc.',
        '123-45-67890', '12345', '123 Main Street, Anytown USA', '12345678-9', 'John Doe', 'john.doe@example.com',
        '+1-123-456-7890'),
       ('admin', '$2a$10$YFV7nOXf.1ehs4sC4olpiuW58ss0yws1RQ2dGZbOT0oFq3Z.DX9RS', 'ROLE_ADMIN', 'Jane Doe Inc.',
        '098-76-54321', '54321', '543 Maple Avenue, Anytown USA', '98765432-1', 'Jane Doe', 'jane.doe@example.com',
        '+1-987-654-3210');

-- 공지사항
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', 'NOTICE', 'Bruggeman', 'Coppin', '2022-08-10 22:36:01', '2022-07-16 10:48:52');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'In congue.', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 'NOTICE', 'Piechnik', 'Beardow', '2022-03-22 21:15:25', '2022-08-04 20:12:20');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nullam porttitor lacus at turpis.', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 'NOTICE', 'Garioch', 'Bandt', '2022-02-23 14:43:13', '2022-07-24 07:13:57');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nam nulla.', 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', 'NOTICE', 'Haney', 'Wadforth', '2022-01-28 09:23:03', '2022-05-13 11:19:19');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Praesent lectus.', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', 'NOTICE', 'Tisor', 'McClenan', '2022-11-23 19:09:13', '2022-02-12 01:57:46');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Donec ut dolor.', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', 'NOTICE', 'Boule', 'McAree', '2022-09-25 03:14:23', '2022-10-15 09:44:37');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Integer ac neque.', 'Sed ante. Vivamus tortor. Duis mattis egestas metus.', 'NOTICE', 'Broader', 'Leif', '2022-01-18 00:29:22', '2022-03-19 03:04:12');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Duis bibendum.', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', 'NOTICE', 'Ding', 'Lightbown', '2022-08-19 21:38:27', '2022-07-19 04:08:19');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Aenean lectus.', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 'NOTICE', 'Safhill', 'Karp', '2022-07-17 19:23:51', '2022-08-12 11:40:12');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', 'NOTICE', 'Rosini', 'Paladini', '2022-02-17 12:59:22', '2022-03-28 19:22:37');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Mauris lacinia sapien quis libero.', 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', 'NOTICE', 'Howsden', 'Iannitti', '2022-10-14 12:30:02', '2022-02-17 16:36:11');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Donec posuere metus vitae ipsum.', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', 'NOTICE', 'Garbutt', 'Hodges', '2022-09-10 18:03:18', '2022-07-08 16:37:02');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nulla tempus.', 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 'NOTICE', 'D''Alessio', 'Josse', '2022-06-24 19:54:12', '2022-01-09 04:03:07');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Aliquam sit amet diam in magna bibendum imperdiet.', 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', 'NOTICE', 'Bester', 'Patterfield', '2022-08-18 00:33:38', '2022-01-17 00:52:14');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nam dui.', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 'NOTICE', 'Leyburn', 'Wanjek', '2022-07-05 22:46:25', '2022-03-08 11:37:37');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Integer ac leo.', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', 'NOTICE', 'Coles', 'Garham', '2022-09-25 04:50:23', '2022-12-13 22:27:05');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Pellentesque eget nunc.', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', 'NOTICE', 'Hitzke', 'L''Archer', '2022-05-30 20:42:27', '2022-11-19 00:12:15');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Proin eu mi.', 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', 'NOTICE', 'Boone', 'Lorentz', '2022-06-04 04:45:47', '2022-09-03 06:49:52');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Suspendisse accumsan tortor quis turpis.', 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', 'NOTICE', 'McEntegart', 'Jewiss', '2022-07-12 07:58:23', '2022-04-15 08:20:12');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nam dui.', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 'NOTICE', 'Niemetz', 'Bigg', '2022-05-11 18:28:44', '2022-11-21 09:47:20');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Donec ut mauris eget massa tempor convallis.', 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', 'NOTICE', 'Baines', 'Edscer', '2022-06-16 04:35:31', '2022-09-02 19:34:58');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla.', 'Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', 'NOTICE', 'Garrard', 'Story', '2022-08-22 14:48:34', '2022-05-26 09:18:29');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Pellentesque viverra pede ac diam.', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 'NOTICE', 'Brideau', 'Andrivel', '2022-12-07 20:27:18', '2022-12-06 13:51:38');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Mauris sit amet eros.', 'Fusce consequat. Nulla nisl. Nunc nisl.', 'NOTICE', 'Pude', 'Trevino', '2022-05-03 03:30:06', '2022-08-24 12:22:57');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'In eleifend quam a odio.', 'Phasellus in felis. Donec semper sapien a libero. Nam dui.', 'NOTICE', 'Hanscome', 'McWard', '2022-09-18 11:35:48', '2022-06-02 13:17:48');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 'NOTICE', 'Jaggard', 'Rampton', '2022-06-11 19:36:43', '2022-01-06 01:19:01');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', 'NOTICE', 'Fluger', 'Still', '2022-11-10 01:04:47', '2022-05-03 15:36:22');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', 'NOTICE', 'McLae', 'Kindle', '2022-04-11 00:50:23', '2022-12-30 16:06:58');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Aenean auctor gravida sem.', 'In congue. Etiam justo. Etiam pretium iaculis justo.', 'NOTICE', 'Lehon', 'Diss', '2022-03-01 04:38:53', '2022-10-13 07:01:22');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Proin at turpis a pede posuere nonummy.', 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 'NOTICE', 'Gobel', 'Cyphus', '2022-01-24 23:22:33', '2022-07-15 06:35:24');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Ut at dolor quis odio consequat varius.', 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', 'NOTICE', 'Lapthorne', 'Nealand', '2022-04-02 22:51:26', '2022-04-17 03:34:31');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', 'NOTICE', 'Rignold', 'Algar', '2022-11-24 00:33:00', '2022-12-09 16:30:12');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Maecenas rhoncus aliquam lacus.', 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 'NOTICE', 'Height', 'Joney', '2022-11-13 23:26:30', '2022-06-09 03:53:44');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Suspendisse potenti.', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 'NOTICE', 'Wild', 'Brigham', '2022-06-16 22:10:55', '2022-04-07 20:04:06');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nullam molestie nibh in lectus.', 'Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', 'NOTICE', 'Mewett', 'Highman', '2022-04-26 01:01:09', '2022-02-19 20:49:17');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'NOTICE', 'Patient', 'Aickin', '2022-04-30 05:44:12', '2022-09-11 06:27:06');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', 'NOTICE', 'Andreutti', 'Kenington', '2022-07-21 07:16:57', '2022-10-17 18:32:04');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Aenean auctor gravida sem.', 'Phasellus in felis. Donec semper sapien a libero. Nam dui.', 'NOTICE', 'Pes', 'Crofts', '2022-12-21 12:03:50', '2022-04-09 23:13:32');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Donec ut mauris eget massa tempor convallis.', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 'NOTICE', 'Cranmere', 'Logg', '2022-05-27 13:13:32', '2022-12-15 00:28:42');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Cras non velit nec nisi vulputate nonummy.', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 'NOTICE', 'Dray', 'Chicken', '2022-05-11 14:50:15', '2022-10-14 04:27:03');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Integer ac leo.', 'Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', 'NOTICE', 'Blessed', 'Gutteridge', '2022-03-05 11:03:47', '2022-07-20 06:37:09');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nulla justo.', 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 'NOTICE', 'Syce', 'Constance', '2022-10-17 21:10:10', '2022-11-10 19:46:27');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Maecenas ut massa quis augue luctus tincidunt.', 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', 'NOTICE', 'Broxis', 'I''anson', '2022-01-07 16:46:44', '2022-03-29 16:32:10');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nulla tempus.', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 'NOTICE', 'Trounce', 'Buswell', '2022-12-09 22:55:46', '2022-07-04 07:27:26');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Aliquam erat volutpat.', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 'NOTICE', 'Lowdes', 'Buglass', '2022-06-18 17:23:16', '2022-09-19 12:16:47');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Morbi non quam nec dui luctus rutrum.', 'Fusce consequat. Nulla nisl. Nunc nisl.', 'NOTICE', 'Hawkey', 'Disbrey', '2022-09-19 16:09:44', '2022-09-29 20:14:26');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Pellentesque eget nunc.', 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', 'NOTICE', 'Legerwood', 'Razoux', '2022-01-04 05:03:13', '2022-02-13 10:40:18');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Sed sagittis.', 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', 'NOTICE', 'Waters', 'Waleran', '2022-10-31 06:57:19', '2022-01-07 02:10:16');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Mauris lacinia sapien quis libero.', 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', 'NOTICE', 'Drew-Clifton', 'Haugeh', '2022-04-06 20:24:47', '2022-08-10 07:36:15');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue.', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 'NOTICE', 'Castellone', 'Danilevich', '2022-03-13 16:47:34', '2022-09-09 07:25:54');

-- 자주하는질문
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Proin risus.', 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.', 'FAQ', 'Orgill', 'Gairdner', '2022-08-29 10:38:11', '2022-05-23 11:52:27');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Maecenas ut massa quis augue luctus tincidunt.', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 'FAQ', 'Tasch', 'Yakebovich', '2022-07-26 22:27:13', '2022-06-16 22:11:28');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Sed ante.', 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', 'FAQ', 'Hamlett', 'Gasperi', '2022-05-08 00:05:24', '2022-09-24 13:22:25');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Mauris lacinia sapien quis libero.', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', 'FAQ', 'Guthrie', 'Baitson', '2022-10-19 10:46:43', '2022-03-01 14:32:51');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Donec vitae nisi.', 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', 'FAQ', 'Saywood', 'Eastby', '2022-01-10 17:45:48', '2022-12-27 19:09:32');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nulla tellus.', 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 'FAQ', 'Extill', 'McLagan', '2022-03-15 19:04:23', '2022-03-26 06:40:47');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Quisque ut erat.', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 'FAQ', 'Claus', 'Hailey', '2022-05-24 21:32:08', '2022-07-13 23:14:34');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Duis at velit eu est congue elementum.', 'In congue. Etiam justo. Etiam pretium iaculis justo.', 'FAQ', 'Godard', 'Luter', '2022-08-01 13:13:30', '2022-08-28 07:51:58');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Etiam faucibus cursus urna.', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 'FAQ', 'Markey', 'Wickwar', '2022-02-10 01:47:29', '2022-10-08 00:14:20');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nulla tempus.', 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', 'FAQ', 'Baldacchino', 'Tollady', '2022-07-25 23:01:22', '2022-04-21 18:50:20');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Proin eu mi.', 'Phasellus in felis. Donec semper sapien a libero. Nam dui.', 'FAQ', 'Reiach', 'Pavlovsky', '2022-06-27 13:29:47', '2022-09-26 12:33:51');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nulla mollis molestie lorem.', 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', 'FAQ', 'Flores', 'Salerg', '2022-04-04 18:03:09', '2022-07-07 15:28:25');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Donec quis orci eget orci vehicula condimentum.', 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.', 'FAQ', 'Abbott', 'Reddan', '2022-09-22 10:45:57', '2022-10-09 07:42:04');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 'FAQ', 'Tyrrell', 'Pilbury', '2022-07-19 10:02:51', '2022-06-24 02:25:46');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'In blandit ultrices enim.', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', 'FAQ', 'Fabb', 'Pashba', '2022-08-08 22:06:32', '2022-05-12 05:11:09');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nunc purus.', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 'FAQ', 'Riordan', 'Haliburn', '2022-06-01 15:14:08', '2022-02-20 00:19:29');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Phasellus id sapien in sapien iaculis congue.', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', 'FAQ', 'Meredyth', 'Sinclaire', '2022-01-09 05:52:31', '2022-06-04 20:57:07');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', 'FAQ', 'Lilley', 'McRitchie', '2022-01-29 18:37:15', '2022-09-20 13:12:39');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Suspendisse accumsan tortor quis turpis.', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 'FAQ', 'Boddy', 'Jefford', '2022-09-27 01:09:09', '2022-07-05 11:01:26');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Proin interdum mauris non ligula pellentesque ultrices.', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 'FAQ', 'Possa', 'Wixey', '2022-08-21 12:35:25', '2022-06-08 14:34:06');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nulla facilisi.', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 'FAQ', 'Pearse', 'Manners', '2022-10-12 15:20:13', '2022-10-22 03:12:58');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 'FAQ', 'Shorter', 'Jacox', '2022-03-25 12:18:53', '2022-04-23 13:02:54');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nulla ut erat id mauris vulputate elementum.', 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 'FAQ', 'Demanche', 'Asquez', '2022-07-16 12:33:46', '2022-07-01 01:14:27');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue.', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 'FAQ', 'Hackwell', 'Wyld', '2022-07-29 22:24:07', '2022-03-27 21:55:29');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', 'FAQ', 'Mulvenna', 'Dunniom', '2022-07-24 12:10:02', '2022-02-28 08:13:32');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', 'FAQ', 'Sisnett', 'Faust', '2022-07-29 13:04:22', '2022-01-19 05:54:13');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nulla suscipit ligula in lacus.', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 'FAQ', 'Pelfer', 'Cadlock', '2022-02-06 12:08:50', '2022-09-22 16:45:15');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Integer ac leo.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.', 'FAQ', 'Lavender', 'Dobbinson', '2022-06-09 09:03:15', '2022-06-01 18:38:38');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Sed sagittis.', 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 'FAQ', 'Gerrans', 'Jizhaki', '2022-10-04 12:48:35', '2022-11-05 10:17:42');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Vivamus tortor.', 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', 'FAQ', 'Ottam', 'Titchener', '2022-06-30 16:38:02', '2022-11-07 00:38:26');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', 'FAQ', 'Wanne', 'Dermott', '2022-01-28 22:45:19', '2022-07-01 08:54:10');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', 'FAQ', 'Bark', 'Bockin', '2022-10-22 17:51:42', '2022-11-26 05:35:13');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Morbi a ipsum.', 'Fusce consequat. Nulla nisl. Nunc nisl.', 'FAQ', 'Label', 'Ledbetter', '2022-10-04 02:45:39', '2022-10-13 08:36:06');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Donec ut dolor.', 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', 'FAQ', 'Blowing', 'Brawson', '2022-09-09 03:16:52', '2022-07-25 15:36:28');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Suspendisse potenti.', 'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.', 'FAQ', 'Whiles', 'Nott', '2022-06-23 04:43:29', '2022-12-24 10:13:35');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Duis ac nibh.', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', 'FAQ', 'Keep', 'Ferronel', '2022-12-13 21:58:06', '2022-05-10 12:09:10');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nunc nisl.', 'Sed ante. Vivamus tortor. Duis mattis egestas metus.', 'FAQ', 'Hellin', 'Lampett', '2022-03-03 09:24:41', '2022-09-19 06:13:19');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Cras non velit nec nisi vulputate nonummy.', 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', 'FAQ', 'Bulfoot', 'Willars', '2022-04-21 12:41:16', '2022-01-09 17:03:16');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Pellentesque ultrices mattis odio.', 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.', 'FAQ', 'Dutnall', 'Deport', '2022-11-23 05:53:37', '2022-12-07 00:08:21');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Aliquam non mauris.', 'Fusce consequat. Nulla nisl. Nunc nisl.', 'FAQ', 'Harry', 'Zimmermeister', '2022-10-23 11:03:47', '2022-12-08 10:08:32');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Cras pellentesque volutpat dui.', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 'FAQ', 'Vogl', 'Montilla', '2022-12-07 05:29:17', '2022-05-20 23:27:45');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.', 'FAQ', 'Stannus', 'Phateplace', '2022-08-27 19:46:09', '2022-06-26 02:47:41');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Aliquam quis turpis eget elit sodales scelerisque.', 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', 'FAQ', 'O''Doohaine', 'Hendrickx', '2022-09-09 05:31:23', '2022-06-12 15:13:27');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', 'FAQ', 'Bonney', 'Dewbury', '2022-11-22 20:10:50', '2022-04-30 01:34:42');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nullam molestie nibh in lectus.', 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 'FAQ', 'Klosser', 'Wearing', '2022-07-09 18:49:48', '2022-08-28 21:11:38');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Morbi quis tortor id nulla ultrices aliquet.', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 'FAQ', 'Aldrin', 'Fawthrop', '2022-07-05 03:37:17', '2022-09-05 15:53:30');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'FAQ', 'Kull', 'Morey', '2022-02-21 19:41:38', '2022-08-10 09:59:49');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Nulla mollis molestie lorem.', 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', 'FAQ', 'Hawkswood', 'Culcheth', '2022-04-27 09:14:19', '2022-05-17 19:06:00');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Ut at dolor quis odio consequat varius.', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', 'FAQ', 'McMurthy', 'Searl', '2022-10-20 22:34:56', '2022-01-24 18:29:55');
insert into article (member_id, title, content, board_type, created_by, modified_by, created_at, modified_at) values (1, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 'FAQ', 'Brazil', 'McGaughay', '2022-10-27 05:29:58', '2022-01-23 00:07:58');


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
                         request_content, postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                         buyer_id, product_id, order_detail_id)
VALUES
    (1, 2, 'John Doe', '1234567890', '123 Main St', 'Sample request', '12345', 'Credit', 100, 10, 'PAID',  'IMMEDIATE', '2023-05-14 00:07:58', 1, 1 , 1);

INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address,
                          request_content, postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, order_detail_id)
VALUES
(2, 3, 'Jane Smith', '9876543210', '456 Elm St', 'Sample request', '54321', 'PayPal', 200, 20, 'DELIVERING', 'REQUEST_DOCUMENT', '2023-02-01 00:07:58', 1, 1 , 1);

INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address,
                              request_content, postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                              buyer_id, product_id, order_detail_id)
VALUES
(3, 1, 'Michael Johnson', '5551112222', '789 Oak St', 'Sample request', '67890', 'Cash', 150, 15, 'DELIVER_DONE', 'IMMEDIATE','2023-03-23 00:07:58', 1, 1 , 1);

INSERT INTO order_detail (payment_id, quantity, receiver_name, buyer_phone_number, address,
                          request_content, postal_code, payment_method, cost, shipping_fee, delivery_state, order_type, order_time,
                          buyer_id, product_id, order_detail_id)
VALUES
    (3, 10, 'Kelly Johnson', '500002222', '789 Green St', 'Sample request', '67890', 'Cash', 150, 15, 'DELIVER_DONE', 'REQUEST_DOCUMENT','2022-09-23 00:12:58', 1, 2 , 2);
