-- SELECT * FROM bookstore.books;
-- desc books;
-- insert into books (title, summary, writer, publisher , image, price, category_id) 
-- values ('이것이 자바다', 
-- '15년 이상 자바 언어를 교육해온 자바 전문강사의 노하우를 아낌 없이 담아낸 자바 입문서. 
-- 저자 직강의 인터넷 강의와 Q/A를 위한 커뮤니티[네이커 카페]까지 무료로 제공하여 자바 개발자로 가는 길을 안내한다.'
-- ,'신용권', '한빛미디어', '이미지' ,27000 , 1);

-- select * from books;

insert into categories (category_name, domestic) value ('it','true');

ALTER TABLE categories AUTO_INCREMENT = 1;
ALTER TABLE books AUTO_INCREMENT = 1;
DELETE FROM categories;
delete from books;
set sql_safe_updates=0;

insert into categories (category_id, category_name, domestic) value (1, 'it','true');
insert into categories (category_id, category_name, domestic) value (2, '과학','true');
insert into categories (category_id, category_name, domestic) value (3, '소설','true');
insert into categories (category_id, category_name, domestic) value (4, '시','true');
insert into categories (category_id, category_name, domestic) value (5, '인문학','true');

insert into categories (category_id, category_name, domestic) value (6, 'it','false');
insert into categories (category_id, category_name, domestic) value (7, '과학','false');
insert into categories (category_id, category_name, domestic) value (8, '소설','false');
insert into categories (category_id, category_name, domestic) value (9, '시','false');
insert into categories (category_id, category_name, domestic) value (10, '인문학','false');

select * from categories;


-- 8 해외 소설 3 국내 소설
insert into books (title, summary, writer, publisher , image, price, category_id) 
values ('불편한 편의점', 
'서울역에서 노숙인 생활을 하던 독고라는 남자가 어느 날 70대 여성의 지갑을 찾아준 인연으로 그녀가 운영하는 편의점에서 야간 아르바이트를 하며 이야기가 시작된다. 
덩치가 곰 같은 이 사내는 알코올성 치매로 과거를 기억하지 못하는 데다 말도 어눌하고 행동도 굼떠 과연 손님을 제대로 상대할 수 있을까 의구심을 갖게 하는데 웬걸,
 의외로 그는 일을 꽤 잘해낼 뿐 아니라 주변 사람들을 묘하게 사로잡으면서 편의점의 밤을 지키는 든든한 일꾼이 되어간다.'
,'김호연', '나무옆의자', '불편한편의점.jpeg' ,12600 , 3);

insert into books (title, summary, writer, publisher , image, price, category_id) 
values ('불편한 편의점2', 
'70만 독자의 지친 하루를 위로한 얼웨이즈 편의점은 오늘도 문을 연다. 서울역 노숙인이던 독고가 편의점의 야간 아르바이트 직원으로 일하면서 시작되는 
1편의 이야기 이후 1년 반이 흘렀다. ALWAYS 편의점의 여름, 독고의 후임으로 밤 시간을 책임지던 곽 씨가 그만두고 새 야간 알바를 구하면서 편의점은 다시 한 번 변화를 맞이한다. 
커다란 덩치와 느린 행동이 독고를 연상시키는 이 남자, 
어수룩한 수다쟁이가 황근배라는 이름 대신 홍금보라는 별명이 적힌 명찰을 가슴에 달고 마냥 느긋하게 손님들을 맞는다.'
,'김호연', '나무옆의자', '불편한편의점2.jpeg' ,12600 , 3);


insert into books (title, summary, writer, publisher , image, price, category_id) 
values ('트로피컬 나이트', 
'부드럽고 말랑말랑하고 따뜻한, 총천연색 마음으로 쓰인 소설집 <트로피컬 나이트>는 소름이 돋을 만큼 무서운데도 사랑과 다정함이 충만하다. 
한여름의 트로피카나 스파클링 음료수처럼 짜릿하고 다채로운 이 이야기들은 올여름 더위에 지친 우리를 시원하게 위로해줄 것이다.'
,'조예은', '한겨레출판', '트로피컬나이트.jpeg' ,13500 , 3);

insert into books (title, summary, writer, publisher , image, price, category_id) 
values ('튜브', 
'부드럽고 말랑말랑하고 따뜻한, 총천연색 마음으로 쓰인 소설집 <트로피컬 나이트>는 소름이 돋을 만큼 무서운데도 사랑과 다정함이 충만하다. 
한여름의 트로피카나 스파클링 음료수처럼 짜릿하고 다채로운 이 이야기들은 올여름 더위에 지친 우리를 시원하게 위로해줄 것이다.'
,'조예은', '한겨레출판', '트로피컬나이트.jpeg' ,13500 , 3);

