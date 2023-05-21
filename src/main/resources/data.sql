-- 회원
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
       ('user1@user.com', '$2a$10$Ef5oakcZUNfETYLE1f1qfOpVwyoEuPQnXtyxVnU7o0fLFlJAghVlC', 'ROLE_USER', '이민수', '민수호텔',
        '123456-7890123', '12345', '대전시 유성구 유성동 유성로 12 미왕빌딩 201호',
        'http://sunwoosc.co.kr/wp-content/uploads/2017/08/%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D-blackwhite.jpg',
        '이영희', 'younghee@minsu.com', '010-1234-5678', NOW(), NOW(), true),
       ('user2@user.com', '$2a$10$Ef5oakcZUNfETYLE1f1qfOpVwyoEuPQnXtyxVnU7o0fLFlJAghVlC', 'ROLE_USER', '박창용', '창용택배',
        '573456-7890123', '57345', '인천시 부평구 부메동 부메로 49 신설타워 601호',
        'http://sunwoosc.co.kr/wp-content/uploads/2017/08/%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D-blackwhite.jpg',
        '박미현', 'mihyun@changyong.com', '010-1934-5678',
        NOW(), NOW(), true),
       ('user3@user.com', '$2a$10$Ef5oakcZUNfETYLE1f1qfOpVwyoEuPQnXtyxVnU7o0fLFlJAghVlC', 'ROLE_USER', '최다예', '다예피피아이',
        '123456-7890120', '12340', '울산시 남구 야음동 야음로 20 야음빌딩 701호',
        'http://sunwoosc.co.kr/wp-content/uploads/2017/08/%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D-blackwhite.jpg',
        '최지우', 'jiwoo@daye.com', '010-2034-5678',
        NOW(), NOW(), true),
       ('user4@user.com', '$2a$10$Ef5oakcZUNfETYLE1f1qfOpVwyoEuPQnXtyxVnU7o0fLFlJAghVlC', 'ROLE_USER', '황예성', '예성전자',
        '224565-7890121', '22456', '부산시 해운대구 센텀동 재송로 21 재송타워 301호',
        'http://sunwoosc.co.kr/wp-content/uploads/2017/08/%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D-blackwhite.jpg', '황유진', 'yujin@yesung.com', '010-2100-5678',
        NOW(), NOW(), true),
       ('user5@user.com', '$2a$10$Ef5oakcZUNfETYLE1f1qfOpVwyoEuPQnXtyxVnU7o0fLFlJAghVlC', 'ROLE_USER', '남영후',
        '영후전자상거래', '298760-7890122', '29876', '부산시 해운대구 센텀동 재송로 22 재송타워 302호',
        'http://sunwoosc.co.kr/wp-content/uploads/2017/08/%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D-blackwhite.jpg', '남가린', 'garin@younghoo.com', '010-2200-5678',
        NOW(), NOW(), true),
       ('user6@user.com', '$2a$10$Ef5oakcZUNfETYLE1f1qfOpVwyoEuPQnXtyxVnU7o0fLFlJAghVlC', 'ROLE_USER', '민소영', '소영식품',
        '375840-7890123', '37584', '대구시 수성구 가제동 가제로 23 가제타워 303호',
        'http://sunwoosc.co.kr/wp-content/uploads/2017/08/%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D-blackwhite.jpg', '민기환', 'kihwan@soyoung.com', '010-2300-5678',
        NOW(), NOW(), true),
       ('user7@user.com', '$2a$10$Ef5oakcZUNfETYLE1f1qfOpVwyoEuPQnXtyxVnU7o0fLFlJAghVlC', 'ROLE_USER', '이민지', '민지월드',
        '987456-7890140', '98745', '화성시 주공동 주공로 38 주공빌딩 401호',
        'http://sunwoosc.co.kr/wp-content/uploads/2017/08/%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D-blackwhite.jpg', '이하늬', 'haneul@minji.com', '010-3800-5678',
        NOW(), NOW(), true),
       ('user8@user.com', '$2a$10$Ef5oakcZUNfETYLE1f1qfOpVwyoEuPQnXtyxVnU7o0fLFlJAghVlC', 'ROLE_USER', '조유림', '유림출판물',
        '789741-2356980', '12345', '대구시 수성구 가제동 가제로 39 가제타워 403호',
        'http://sunwoosc.co.kr/wp-content/uploads/2017/08/%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D-blackwhite.jpg', '조수아', 'sua@yurim.com', '010-3900-5678', NOW(),
        NOW(), true),
       ('user9@user.com', '$2a$10$Ef5oakcZUNfETYLE1f1qfOpVwyoEuPQnXtyxVnU7o0fLFlJAghVlC', 'ROLE_USER', '전서경', '서경프린트',
        '625874-7890141', '62559', '부산시 기장군 기장읍 기장로 40 기장빌딩 404호',
        'http://sunwoosc.co.kr/wp-content/uploads/2017/08/%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D-blackwhite.jpg', '전나라', 'nara@seokyung.com', '010-4000-5678',
        NOW(), NOW(), true);

-- 공지사항
INSERT INTO article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
VALUES
    (1, '중요 공지사항', '안녕하세요. 중요한 공지사항입니다.', 'NOTICE', true, 'admin', 'admin', NOW(), NOW()),
    (1, '서비스 업데이트 안내', '안녕하세요. 이커머스 사이트의 새로운 업데이트 내용을 안내드립니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '배송 지연 안내', '안녕하세요. 최근에 발생한 배송 지연 사항에 대해 안내드립니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '할인 이벤트 안내', '안녕하세요. 이번 주에 할인 이벤트가 진행될 예정입니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '최신 상품 소식', '안녕하세요. 최신 상품 소식을 공유합니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '주문 취소 안내', '안녕하세요. 주문 취소 관련 안내입니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '서비스 장애 안내', '안녕하세요. 현재 일시적인 서비스 장애로 불편을 드려 죄송합니다.', 'NOTICE', true, 'admin', 'admin', NOW(), NOW()),
    (1, '회원 이벤트 안내', '안녕하세요. 회원 전용 이벤트가 개최될 예정입니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '반품 접수 안내', '안녕하세요. 반품 접수 관련 안내입니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '고객센터 운영 시간 변경', '안녕하세요. 고객센터 운영 시간이 변경되었습니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '이벤트 당첨자 발표', '안녕하세요. 이벤트에 당첨된 분들을 발표합니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '포인트 적립 안내', '안녕하세요. 포인트 적립에 대한 안내입니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '상품 리뷰 이벤트', '안녕하세요. 상품 리뷰 작성 이벤트가 진행됩니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '신규 상품 입고 안내', '안녕하세요. 신규 상품이 입고되었습니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '회원 탈퇴 안내', '안녕하세요. 회원 탈퇴 절차 안내입니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '이용약관 변경', '안녕하세요. 이용약관이 변경되었습니다. 확인해주세요.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '공지사항 게시판 개편 안내', '안녕하세요. 공지사항 게시판이 개편되었습니다. 변경된 사항을 확인해주세요.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '최근 이슈 사항 안내', '안녕하세요. 최근에 발생한 이슈 사항에 대해 안내드립니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '정기 점검 안내', '안녕하세요. 정기 점검 일정이 변경되었습니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '이메일 수신 동의 안내', '안녕하세요. 이메일 수신 동의에 대한 안내입니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW()),
    (1, '회원 등급 조정 안내', '안녕하세요. 회원 등급 조정에 대한 안내입니다.', 'NOTICE', false, 'admin', 'admin', NOW(), NOW());

-- 자묻질
INSERT INTO article (member_id, title, content, board_type, is_fixed, created_by, modified_by, created_at, modified_at)
VALUES
    (1, '[배송/물류] 물건이 도착하지 않았습니다.', '물건이 도착하지 않은 경우 배송업체와 먼저 연락해보시고 연락주세요. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[의뢰서] 견적 의뢰한 내용을 수정하고 싶습니다.', '[마이페이지]의 [내 의뢰내역]에서 수정이 가능합니다. 다만 의뢰구분 상태값이 대기인 경우에만 가능하며, 승인 및 반려인 상태에서는 수정이 불가능합니다. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[바로구매] 비즈큐레이터 바로구매는 무엇인가요?', '기존 비즈큐레이터의 시스템인 구매 및 견적의뢰를 거치지 않으며, 고객들이 합리적인 가격에 대량으로 바로 제품구매가 가능하게끔 만든 구매형태입니다. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[회원정보] 회원탈퇴는 어떻게 하나요?', '[마이페이지]의 [회원정보 수정]의 맨 아래 회원탈퇴 텍스트를 누르신 후 탈퇴하실 수 있습니다. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[주문/결제] 결제 방법은 어떤 것들이 있나요?', '저희 이커머스 사이트에서는 다양한 결제 방법을 제공하고 있습니다. 주요 결제 수단으로는 신용카드, 계좌이체, 휴대폰 소액결제 등이 있습니다. 자세한 결제 방법은 [마이페이지]의 [결제정보]에서 확인하실 수 있습니다. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[배송/반품] 상품을 언제 받을 수 있나요?', '배송일정은 상품 및 배송지역에 따라 다를 수 있습니다. 주문하신 상품의 배송일정은 [마이페이지]의 [주문내역]에서 확인하실 수 있습니다. 반품 및 교환에 관한 내용은 [마이페이지]의 [반품/교환 안내]를 참고해주세요. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[상품문의] 상품 문의는 어떻게 할 수 있나요?', '상품에 대한 문의는 해당 상품 페이지에서 [상품 문의하기] 버튼을 통해 작성하실 수 있습니다. 상품 문의에 대한 답변은 빠르게 처리해드리겠습니다. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[배송비] 배송비는 어떻게 결정되나요?', '배송비는 상품의 종류, 무게, 크기, 배송지역 등에 따라 다르게 책정됩니다. 상품 페이지에서 배송비 정보를 확인하실 수 있습니다. 일부 상품은 무료 배송 서비스를 제공하기도 합니다. 자세한 내용은 상품 페이지를 참고해주세요. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[회원정보] 비밀번호를 잊어버렸어요. 어떻게 해야하나요?', '비밀번호를 잊어버리신 경우 [로그인] 페이지에서 [비밀번호 찾기]를 클릭하시면 비밀번호를 재설정할 수 있는 안내를 받으실 수 있습니다. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[상품평] 상품평 작성은 어떻게 할 수 있나요?', '구매하신 상품에 대한 상품평은 해당 상품 페이지에서 작성하실 수 있습니다. 다른 고객들의 구매 결정에 도움이 되는 솔직한 리뷰를 남겨주세요. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[할인/쿠폰] 할인쿠폰은 어떻게 사용하나요?', '할인쿠폰은 상품 결제 시 사용할 수 있는 혜택입니다. 쿠폰 코드를 [장바구니]나 [결제 페이지]에서 입력하시면 할인이 적용됩니다. 유효기간 및 사용 조건은 쿠폰에 따라 다를 수 있으니 유의해주세요. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[환불/취소] 상품 환불은 어떻게 진행되나요?', '상품 환불은 [마이페이지]의 [주문내역]에서 가능합니다. 반품 신청 후에는 해당 상품을 반송하셔야 합니다. 환불 처리에 대한 상세한 정보는 [환불/취소 정책]을 참고해주세요. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[이용약관] 이용약관은 어디서 확인할 수 있나요?', '이용약관은 [하단]의 [이용약관] 링크를 통해 확인하실 수 있습니다. 이용약관에 동의하지 않으신 경우 서비스 이용이 제한될 수 있습니다. 자세한 내용은 이용약관을 참고해주세요. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[회원혜택] 회원 등급은 어떻게 변경되나요?', '회원 등급은 주문액이나 구매 빈도에 따라 자동으로 조정됩니다. 회원 등급 혜택에 대한 자세한 내용은 [마이페이지]의 [회원 등급 혜택]을 참고해주세요. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[이벤트] 현재 진행 중인 이벤트는 어떤 것들이 있나요?', '현재 진행 중인 이벤트는 [이벤트] 페이지에서 확인하실 수 있습니다. 다양한 이벤트 및 혜택을 놓치지 않으시려면 주기적으로 확인해주세요. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[교환] 상품을 다른 상품으로 교환하고 싶습니다.', '상품 교환은 [마이페이지]의 [주문내역]에서 가능합니다. 교환 가능 여부와 절차에 대한 상세한 내용은 [반품/교환 정책]을 참고해주세요. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[결제오류] 결제가 정상적으로 이루어지지 않습니다.', '결제 오류가 발생한 경우 [고객센터]로 문의해주시거나 결제 시도한 환경(브라우저, 결제 수단 등)과 함께 상세한 내용을 알려주시면 빠르게 도움을 드리도록 하겠습니다. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[상품정보] 상품의 추가 정보를 알고 싶습니다.', '더 자세한 상품 정보를 원하시는 경우 [상품 페이지]에서 상품 설명을 참고하시거나 [고객센터]로 문의해주시면 친절하게 안내해드리겠습니다. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW()),
    (1, '[회원가입] 회원가입은 어떻게 진행되나요?', '회원가입은 [메인 페이지]의 [회원가입] 버튼을 클릭하시면 진행하실 수 있습니다. 필요한 정보를 입력하시고 약관에 동의하신 후 가입이 완료됩니다. 감사합니다.', 'FAQ', false, 'admin', 'admin', NOW(), NOW());


insert into purpose_category (id, name)
values (1, '창업(제품판매)'),
       (2, '작품 제작'),
       (3, '개인적인 목적');


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
                     name, regular_price, modified_at, weekly_clicks, category_id, manufacturer_id)
values (1, '2022-01-23 00:07:58', 10, 100, 20, 1000, '빗', 1000, '2022-01-23 00:07:58', 1000, 1, 1),
       (2, '2022-02-23 00:07:58', 15, 200, 10, 1500, '샤워타월', 2000, '2022-02-23 00:07:58', 1500, 2, 2),
       (3, '2022-03-23 00:07:58', 20, 300, 10, 2000, '점보롤', 3000, '2022-03-23 00:07:58', 2000, 3, 3),
       (4, '2022-04-23 00:07:58', 25, 400, 10, 2500, '베개', 14000, '2022-04-23 00:07:58', 2500, 4, 4),
       (5, '2022-05-23 00:07:58', 30, 500, 10, 3000, '커피 포트', 150000, '2022-05-23 00:07:58', 3000, 5, 5),
       (6, '2022-06-23 00:07:58', 35, 600, 10, 3500, '제습제', 2000, '2022-06-23 00:07:58', 3500, 6, 4),
       (7, '2022-07-23 00:07:58', 40, 700, 10, 4000, '비상조명', 25000, '2022-07-23 00:07:58', 4000, 7, 3),
       (8, '2022-08-23 00:07:58', 45, 800, 30, 4500, '볼펜', 200, '2022-08-23 00:07:58', 4500, 8, 2),
       (9, '2022-09-23 00:07:58', 2, 900, 10, 5000, '식혜', 900, '2022-09-23 00:07:58', 5000, 9, 1),
       (10, '2022-10-23 00:07:58', 3, 1000, 10, 5500, '강아지 밥그릇', 10000, '2022-10-23 00:07:58', 5500, 10, 1),
       (11, '2022-11-23 00:07:58', 5, 1100, 10, 6000, '옷걸이', 11000, '2022-11-23 00:07:58', 6000, 1, 5),
       (12, '2022-12-23 00:07:58', 1, 1200, 10, 6500, '바디워시', 12000, '2022-12-23 00:07:58', 6500, 2, 4),
       (13, '2023-01-23 00:07:58', 11, 1300, 10, 7000, '미용티슈', 13000, '2023-01-23 00:07:58', 7000, 3, 3),
       (14, '2023-02-23 00:07:58', 11, 1400, 10, 7500, '베개커버', 14000, '2023-02-23 00:07:58', 7500, 4, 2),
       (15, '2023-03-23 00:07:58', 11, 1500, 10, 8000, '청소기', 15000, '2023-03-23 00:07:58', 8000, 5, 1),
       (16, '2023-04-23 00:07:58', 14, 1600, 10, 8500, '주방세제', 16000, '2023-04-23 00:07:58', 8500, 6, 5),
       (17, '2023-05-23 00:07:58', 12, 1700, 10, 9000, '분말소화기', 17000, '2023-05-23 00:07:58', 9000, 7, 4),
       (18, '2023-06-23 00:07:58', 23, 1800, 10, 9500, '메모지', 18000, '2023-06-23 00:07:58', 9500, 8, 3),
       (19, '2023-07-23 00:07:58', 22, 1900, 10, 10000, '생수', 450, '2023-07-23 00:07:58', 10000, 9, 2),
       (20, '2023-08-23 00:07:58', 23, 2000, 20, 10500, '마스크', 500, '2023-08-23 00:07:58', 10500, 10, 1),
       (21, '2023-09-23 00:07:58', 20, 2100, 10, 11000, '샴푸', 7000, '2023-09-23 00:07:58', 11000, 2, 1),
       (22, '2023-10-23 00:07:58', 25, 2200, 20, 11500, '폼클렌징', 8000, '2023-10-23 00:07:58', 11500, 2, 2),
       (23, '2023-11-23 00:07:58', 30, 2300, 30, 12000, '변기세정제', 9000, '2023-11-23 00:07:58', 12000, 2, 3),
       (24, '2023-12-23 00:07:58', 20, 2400, 40, 12500, '이불', 10000, '2023-12-23 00:07:58', 12500, 4, 4),
       (25, '2024-01-23 00:07:58', 10, 2500, 50, 13000, '에어컨', 200000, '2024-01-23 00:07:58', 13000, 5, 5),
       (26, '2024-02-23 00:07:58', 10, 2600, 50, 14000, '무선 이어폰', 120000, '2024-02-23 00:07:58', 14000, 5, 1),
       (27, '2024-03-23 00:07:58', 15, 2700, 30, 14500, '스킨로션', 25000, '2024-03-23 00:07:58', 14500, 2, 2),
       (28, '2024-04-23 00:07:58', 20, 2800, 20, 15000, '키친세트', 40000, '2024-04-23 00:07:58', 15000, 1, 3),
       (29, '2024-05-23 00:07:58', 25, 2900, 10, 15500, '테이블', 80000, '2024-05-23 00:07:58', 15500, 1, 4),
       (30, '2024-06-23 00:07:58', 30, 3000, 10, 16000, 'TV', 600000, '2024-06-23 00:07:58', 16000, 5, 5),
       (31, '2024-07-23 00:07:58', 15, 3100, 60, 16500, '스마트 워치', 250000, '2024-07-23 00:07:58', 16500, 5, 1),
       (32, '2024-08-23 00:07:58', 20, 3200, 40, 17000, '성인용 기저귀', 35000, '2024-08-23 00:07:58', 17000, 3, 2),
       (33, '2024-09-23 00:07:58', 25, 3300, 30, 17500, '안마기', 150000, '2024-09-23 00:07:58', 17500, 5, 3),
       (34, '2024-10-23 00:07:58', 30, 3400, 20, 18000, '커피머신', 200000, '2024-10-23 00:07:58', 18000, 5, 4),
       (35, '2024-11-23 00:07:58', 35, 3500, 10, 18500, '화장대', 300000, '2024-11-23 00:07:58', 18500, 1, 5),
       (36, '2024-12-23 00:07:58', 40, 3600, 60, 19000, '자전거', 600000, '2024-12-23 00:07:58', 19000, 10, 1),
       (37, '2025-01-23 00:07:58', 45, 3700, 50, 19500, '주방 도구 세트', 50000, '2025-01-23 00:07:58', 19500, 1, 2),
       (38, '2025-02-23 00:07:58', 50, 3800, 40, 20000, '마사지 의자', 2000000, '2025-02-23 00:07:58', 20000, 1, 3),
       (39, '2025-03-23 00:07:58', 55, 3900, 30, 20500, '식탁 세트', 700000, '2025-03-23 00:07:58', 20500, 1, 2),
       (40, '2025-04-23 00:07:58', 60, 4000, 20, 21000, '노트북', 1500000, '2025-04-23 00:07:58', 21000, 5, 2),
       (41, '2024-07-23 00:07:58', 10, 3100, 10, 16500, '에어프라이어', 150000, '2024-07-23 00:07:58', 16500, 5, 1),
       (42, '2024-08-23 00:07:58', 15, 3200, 20, 17000, '선크림', 35000, '2024-08-23 00:07:58', 17000, 1, 1),
       (43, '2024-09-23 00:07:58', 20, 3300, 30, 17500, '체어', 70000, '2024-09-23 00:07:58', 17500, 1, 2),
       (44, '2024-10-23 00:07:58', 25, 3400, 40, 18000, '베개', 40000, '2024-10-23 00:07:58', 18000, 4, 2),
       (45, '2024-11-23 00:07:58', 30, 3500, 50, 18500, '모니터', 80000, '2024-11-23 00:07:58', 18500, 5, 3),
       (46, '2024-12-23 00:07:58', 35, 3600, 60, 19000, 'HDMI 케이블', 90000, '2024-12-23 00:07:58', 19000, 5, 3),
       (47, '2025-01-23 00:07:58', 40, 3700, 70, 19500, '레몬즙', 15000, '2025-01-23 00:07:58', 19500, 9, 4),
       (48, '2025-02-23 00:07:58', 45, 3800, 80, 20000, '사과즙', 15000, '2025-02-23 00:07:58', 20000, 9, 4),
       (49, '2025-03-23 00:07:58', 50, 3900, 90, 20500, '바나나즙', 15000, '2025-03-23 00:07:58', 20500, 9, 5),
       (50, '2025-04-23 00:07:58', 55, 4000, 100, 21000, '망고즙', 15000, '2025-04-23 00:07:58', 21000, 9, 5);


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
       (16, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 15),
       (17, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 14),
       (18, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 13),
       (19, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 12),
       (20, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 11),
       (21, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 10),
       (22, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 9),
       (23, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 8),
       (24, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 7),
       (25, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 6),
       (26, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 5),
       (27, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 4),
       (28, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 3),
       (29, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 2),
       (30, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 1),
       (31, 'https://picsum.photos/200/300?random=30', 'Y', 16),
       (32, 'https://picsum.photos/200/300?random=31', 'Y', 17),
       (33, 'https://picsum.photos/200/300?random=32', 'Y', 18),
       (34, 'https://picsum.photos/200/300?random=33', 'Y', 19),
       (35, 'https://gdimg.gmarket.co.kr/1965125533/still/600?ver=1666511437', 'Y', 20),
       (36, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 16),
       (37, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 17),
       (38, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 18),
       (39, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 19),
       (40, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 20),
       (41, 'https://picsum.photos/200/300?random=40', 'Y', 21),
       (42, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 21),
       (43, 'https://picsum.photos/200/300?random=42', 'Y', 22),
       (44, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 22),
       (45, 'https://picsum.photos/200/300?random=44', 'Y', 23),
       (46, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 23),
       (47, 'https://picsum.photos/200/300?random=46', 'Y', 24),
       (48, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 24),
       (49, 'https://picsum.photos/200/300?random=48', 'Y', 25),
       (50, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 25),
       (51, 'https://picsum.photos/200/300?random=50', 'Y', 26),
       (52, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 26),
       (53, 'https://picsum.photos/200/300?random=52', 'Y', 27),
       (54, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 27),
       (55, 'https://picsum.photos/200/300?random=54', 'Y', 28),
       (56, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 28),
       (57, 'https://picsum.photos/200/300?random=56', 'Y', 29),
       (58, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 29),
       (59, 'https://picsum.photos/200/300?random=58', 'Y', 30),
       (60, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 30),
       (61, 'https://m.ylshop.co.kr/web/product/big/202008/02db84c7132d6548bf8a72c813be6ee0.jpg', 'Y', 31),
       (62, 'https://picsum.photos/200/300?random=59', 'Y', 32),
       (63, 'https://sitem.ssgcdn.com/86/43/68/item/1000066684386_i1_1100.jpg', 'Y', 33),
       (64, 'https://picsum.photos/200/300?random=59', 'Y', 34),
       (65, 'https://picsum.photos/200/300?random=59', 'Y', 35),
       (66, 'https://picsum.photos/200/300?random=59', 'Y', 36),
       (67, 'https://picsum.photos/200/300?random=59', 'Y', 37),
       (68, 'https://www.lge.co.kr/kr/images/massage-chairs/md09217826/gallery/large-m01.jpg', 'Y', 38),
       (69, 'https://picsum.photos/200/300?random=59', 'Y', 39),
       (70, 'https://www.apple.com/newsroom/images/product/mac/standard/Apple_MacBook-Pro_14-16-inch_10182021_big.jpg.large.jpg', 'Y', 40),
       (71, 'https://picsum.photos/200', 'Y', 41),
       (72, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 41),
       (73, 'https://picsum.photos/200', 'Y', 42),
       (74, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 42),
       (75, 'https://picsum.photos/200', 'Y', 43),
       (76, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 43),
       (77, 'https://picsum.photos/200', 'Y', 44),
       (78, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 44),
       (79, 'https://picsum.photos/200', 'Y', 45),
       (80, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 45),
       (81, 'https://picsum.photos/200', 'Y', 46),
       (82, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 46),
       (83, 'https://picsum.photos/200', 'Y', 47),
       (84, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 47),
       (85, 'https://picsum.photos/200', 'Y', 48),
       (86, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 48),
       (87, 'https://picsum.photos/200', 'Y', 49),
       (88, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 49),
       (89, 'https://picsum.photos/200', 'Y', 50),
       (90, 'https://s3-ebnatural.s3.ap-northeast-2.amazonaws.com/product_images/detail.png?response-content-dis[…]6d2222f04aa2be4456b3bccf418d74e45ce024d9ceec04', 'N', 50);

--  주문 내역
INSERT INTO order_detail (payment_id, quantity, buyer_id, product_id, order_time, receiver_name, buyer_phone_number, address, request_content, postal_code, payment_method, cost, delivery_state, order_type, shipping_fee, invoice_number)
VALUES
    (1, 5, 1, 1, '2021-05-22 10:00:00', '홍길동', '010-1234-5678', '서울시 강남구 역삼동', '특별 요청 사항 없음', '12345', '신용카드', 247860, 'PAID', 'IMMEDIATE', 10, 'INV001'),
    (1, 3, 1, 2, '2021-05-22 10:00:00', '홍길동', '010-1234-5678', '서울시 강남구 역삼동', '특별 요청 사항 없음', '12345', '신용카드', 247860, 'DELIVERING', 'IMMEDIATE', 10, 'INV001'),
    (1, 2, 1, 3, '2021-05-22 10:00:00', '홍길동', '010-1234-5678', '서울시 강남구 역삼동', '특별 요청 사항 없음', '12345', '신용카드', 311200, 'FINISH', 'IMMEDIATE', 10, 'INV001'),
    (2, 1, 2, 4, '2021-05-25 11:30:00', '박지영', '010-1111-2222', '인천시 남구 만수동', '조심히 배달해주세요', '98765', '신용카드', 67250, 'PAID', 'IMMEDIATE', 7, 'INV004'),
    (2, 4, 2, 5, '2021-05-25 11:30:00', '박지영', '010-1111-2222', '인천시 남구 만수동', '조심히 배달해주세요', '98765', '신용카드', 191340, 'DELIVER_DONE', 'IMMEDIATE', 7, 'INV004'),
    (3, 2, 1, 6, '2022-05-27 13:20:00', '김지원', '010-7777-8888', '광주시 서구 쌍촌동', '비닐 포장해주세요', '24680', '신용카드', 958680, 'PAID', 'IMMEDIATE', 9, 'INV006'),
    (3, 3, 1, 7, '2022-05-27 13:20:00', '김지원', '010-7777-8888', '광주시 서구 쌍촌동', '비닐 포장해주세요', '24680', '신용카드', 63830, 'DELIVER_DONE', 'IMMEDIATE', 9, 'INV006'),
    (3, 2, 1, 8, '2022-05-27 13:20:00', '김지원', '010-7777-8888', '광주시 서구 쌍촌동', '비닐 포장해주세요', '24680', '신용카드', 372450, 'PAID', 'IMMEDIATE', 9, 'INV006'),
    (3, 1, 1, 9, '2022-05-27 13:20:00', '김지원', '010-7777-8888', '광주시 서구 쌍촌동', '비닐 포장해주세요', '24680', '신용카드', 306800, 'DELIVERING', 'IMMEDIATE', 9, 'INV006'),
    (4, 4, 3, 10, '2023-01-31 16:55:00', '정민우', '010-6666-7777', '대구시 수성구 만촌동', '조심히 다뤄주세요', '35791', '신용카드', 124880, 'FINISH', 'IMMEDIATE', 11, 'INV010'),
    (4, 3, 3, 11, '2023-01-31 16:55:00', '정민우', '010-6666-7777', '대구시 수성구 만촌동', '조심히 다뤄주세요', '35791', '신용카드', 109570, 'DELIVER_DONE', 'IMMEDIATE', 11, 'INV010'),
    (5, 2, 1, 12, '2023-02-02 09:40:00', '김민서', '010-9876-5432', '광주시 북구 산정동', '상품에 표시된 번호로 연락주세요', '26748', '신용카드', 60, 'DELIVER_DONE', 'IMMEDIATE', 6, 'INV012'),
    (5, 1, 1, 12, '2023-02-02 09:40:00', '김민서', '010-9876-5432', '광주시 북구 산정동', '상품에 표시된 번호로 연락주세요', '26748', '신용카드', 74850, 'DELIVERING', 'IMMEDIATE', 6, 'INV012'),
    (6, 4, 1, 14, '2023-02-03 13:05:00', '박민서',  '010-5555-5555', '울산시 중구 성안동', '부드럽게 다뤄주세요', '59374', '무통장 입금', 47580, 'PAID', 'IMMEDIATE', 5, 'INV013'),
    (6, 4, 1, 14, '2023-02-03 13:05:00', '박민서', '010-5555-5555', '울산시 중구 성안동', '부드럽게 다뤄주세요', '59374', '무통장 입금', 36760, 'DELIVER_DONE', 'IMMEDIATE', 5, 'INV013'),
    (7, 2, 2, 15, '2023-02-05 12:50:00', '김민준', '010-3333-4444', '대전시 중구 대흥동', '옷을 접혀서 배달해주세요', '73984', '신용카드', 91450, 'DELIVER_DONE', 'IMMEDIATE', 9, 'INV015'),
    (7, 3, 2, 16, '2023-02-05 12:50:00', '김민준', '010-3333-4444', '대전시 중구 대흥동', '옷을 접혀서 배달해주세요', '73984', '신용카드', 93500, 'DELIVER_DONE', 'IMMEDIATE', 9, 'INV015'),
    (7, 3, 2, 16, '2023-02-05 12:50:00', '김민준', '010-3333-4444', '대전시 중구 대흥동', '옷을 접혀서 배달해주세요', '73984', '신용카드', 217455, 'FINISH', 'IMMEDIATE', 9, 'INV015'),
    (8, 1, 3, 17, '2023-02-10 16:30:00', '임수경', '010-9999-8888', '부산시 북구 덕천동', '부품은 한 묶음으로', '62835', '신용카드', 159850, 'PAID', 'IMMEDIATE', 13, 'INV017'),
    (8, 3, 3, 18, '2023-02-10 16:30:00', '임수경', '010-9999-8888', '부산시 북구 덕천동', '부품은 한 묶음으로', '62835', '신용카드', 57800, 'DELIVERING', 'IMMEDIATE', 13, 'INV017'),
    (9, 2, 1, 19, '2023-02-15 10:30:00', '김우진', '010-4444-3333', '제주시 한림읍 월령리', '건물 앞에서 연락주세요', '69016', '무통장 입금', 137910, 'DELIVER_DONE', 'IMMEDIATE', 15, 'INV019'),
    (10, 5, 2, 20, '2023-02-20 14:54:00', '이하늘', '010-7777-6666', '대구시 달서구 진천동', '오후 2시 이후 전화 부탁', '57139', '신용카드', 249073, 'FINISH', 'IMMEDIATE', 8, 'INV020');

-- 구매 의뢰서
INSERT INTO purchase_document (id, member_id, category_id, product_name, product_detail, quantity, desired_estimate_date,
                               desired_delivery_date, manager_name, manager_call, request_message, image_directory,
                               state_type, created_at, modified_at)
Values (1, 1, 1, "편백나무침대", "흰색을 사고싶다.", 40, "23-05-20", "23-05-30", "이연희", "1087-1087",
        "최대한 빨리 답변주세요.", "imageDirectory", "WAIT", '2022-04-14 12:00:00', now()),
       (2, 1, 2, "친환경칫솔", "대나무로 만든것", 30, "23-05-20", "23-05-30", "황슬찬", "1541-1541",
        "생분해되는 제품으로 알아봐주세요.", "imageDirectory", "WAIT", '2023-05-20 12:00:00', now()),
       (3, 1, 3, "우산", "접이식", 20, "23-05-20", "23-05-30", "김인후", "8282-8282",
        "색상 어떤것들이 있는지 미리 말씀해주세요.", "imageDirectory", "WAIT", '2023-03-20 12:00:00', now()),
       (4, 1, 4, "머리빗", "휴대용", 10, "23-05-20", "23-05-30", "이연희", "managerCall",
        "휴대용으로 작은것 구해주세요.", "imageDirectory", "WAIT", '2023-01-20 12:00:00', now());

-- 제작 의뢰서
INSERT INTO make_document (id, member_id, purpose_category_id, product_name, product_detail, quantity, desired_estimate_date,
                           desired_delivery_date, manager_name, manager_call, request_message, image_directory,
                           state_type, created_at, modified_at)
Values (1, 1, 3, "운동복", "등에 '한사랑 산악회'라고 새겨주세요.", 10, "23-05-20", "23-05-30", "조갑수", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", '2022-12-20 12:00:00', now()),
       (2, 1, 3, "수건", "[이길동 축 돌] 이라고 새겨주세요.", 20, "23-05-20", "23-05-30", "managerName", "managerCall",
        "돌잔치 선물용", "imageDirectory", "WAIT", '2022-11-20 12:00:00', now()),
       (3, 1, 2, "마우스패드", "productDetail", 30, "23-05-20", "23-05-30", "managerName", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", '2023-04-20 12:00:00', now()),
       (4, 1, 1, "마우스", "사무용으로 쓸 것", 40, "23-05-20", "23-05-30", "managerName", "managerCall",
        "requestMessage", "imageDirectory", "WAIT", '2022-03-10 12:00:00', now());

-- 판매 의뢰서
INSERT INTO sell_document (id, member_id, category_id, business_name, ceo_name, manager_phone_number, business_number,
                           product_detail, establish_year, introduction, image_directory, state_type, created_at, modified_at)
VALUES (1, 1, 1, "다이써", "선우연희", "1234-1234", "5421534", "문구류", 2000,
        "introduction", "imageDirectory", "WAIT", '2020-03-10 12:00:00', now()),
       (2, 1, 2, "네이클로버", "황우슬찬", "4321-4321", "5444534", "운동복", 2000,
        "introduction", "imageDirectory", "WAIT", '2022-12-01 12:00:00', now()),
       (3, 1, 3, "규글", "제갈인후", "3333-22222", "34357788", "뷰티제품", 2000,
        "비건 화장품을 판매하고 있습니다.", "imageDirectory", "WAIT", '2023-02-21 12:00:00', now()),
       (4, 1, 4, "삼섬", "연찬후", "1111-1111", "67686796", "침구류", 2000,
        "introduction", "imageDirectory", "WAIT", '2021-02-21 12:00:00', now());