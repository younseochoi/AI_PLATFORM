insert into members (id,pw,name,address,email,phone) values('test1',1111,'user1','test address','test@gmail.com','01012341234');
insert into members (id,pw,name,address,email,phone) values('test2',1111,'user2','test2 address','test2@gmail.com','01012341234');

insert into orders (member_id,orderdate) values (1,now());
insert into orders (member_id,orderdate) values (2,now());

insert into order_details (order_id, book_id, count) values (1,1,3);
insert into order_details (order_id, book_id, count) values (1,2,1);
insert into order_details (order_id, book_id, count) values (1,3,5);

insert into order_details (order_id, book_id, count) values (2,1,10);
insert into order_details (order_id, book_id, count) values (1,2,1);
insert into order_details (order_id, book_id, count) values (1,3,4);
insert into order_details (order_id, book_id, count) values (1,4,100);
insert into order_details (order_id, book_id, count) values (1,5,40);
insert into order_details (order_id, book_id, count) values (1,6,30);
insert into order_details (order_id, book_id, count) values (1,7,80);
insert into order_details (order_id, book_id, count) values (1,8,200);
insert into order_details (order_id, book_id, count) values (1,9,80);
insert into order_details (order_id, book_id, count) values (1,3,10);
insert into order_details (order_id, book_id, count) values (1,10,50);

--
select*from order_details;
insert into order_details (order_id, book_id, count) values (3,14,10);
insert into order_details (order_id, book_id, count) values (3,23,1);
insert into order_details (order_id, book_id, count) values (3,24,4);

select *from categories;
select * from books;
insert into books (title, summary, writer, publisher , image, price, category_id) 
values ('The Old Man and the Sea', 
"The Old Man and the Sea is one of Hemingway's most enduring works. Told in language of great simplicity and power, 
it is the story of an old Cuban fisherman, down on his luck, and his supreme ordeal--a relentless, 
agonizing battle with a giant marlin far out in the Gulf Stream. Here Hemingway recasts, in strikingly contemporary style, 
the classic theme of courage in the face of defeat, of personal triumph won from loss. Written in 1952, this hugely successful novella confirmed his power and presence 
in the literary world and played a large part in his winning the 1954 Nobel Prize for Literature."
,'Ernest Miller Hemingway', 'Scribner', 'TheOldManandtheSea.jpeg' ,10000 , 4);

insert into books (title, summary, writer, publisher , image, price, category_id) 
values ('Fahrenheit 451', 
"Fahrenheit 451는 레이 브래드베리에 의해 쓰여진 반 유토피아적 SF 소설이다. 1953년 처음 출간된 이 작품은 냉전 초기의 늘어나는 미국의 사회적 역기능에 대한 저자의 비판을 담고 있다."
,'Ray Bradbury', 'Simon & Schuster', 'Fahrenheit451.jpeg' ,7540 , 4);

insert into books (title, summary, writer, publisher , image, price, category_id) 
values ('Lord of the Flies', 
"'파리대왕'은 성서에 등장하는 말로 악마를 뜻한다. 비행기 사고로 남해의 외딴섬에 표류하게 된 몇 명의 소년들은 문명적인 규칙을 자신들에게 부과하여 공동체를 만들지만 결국 원시적인 야만상태로 퇴행해 간다. 이 작품으로 골딩은 1983년 노벨문학상을 받았다.
"
,'William Golding', 'Penguin Classics', 'LordoftheFlies.jpeg' ,8910 , 4);


select b.book_id, sum(count) total, title, writer, image from books b join order_details od on b.book_id = od.book_id group by book_id order by total  desc limit 0,4;
select date_format(now(), '%Y-%m-%d') from dual;
select * from orders;
-- 이번달에 주문량 조회 후 가격별로 묶어서 순서대로 데이터 조회 해와라.
 select b.book_id, sum(price) total from orders o join order_details od on o.order_id = od.order_id join books b on od.book_id=b.book_id where orderdate
 between date_format(now(), '%Y-%m-01 00:00:00') and date_format(now(), '%Y-%m-%d %H:%i:%s') group by book_id order by total;
 
 -- select b.book_id, sum(count) total from orders o left join order_details od on o.order_id = od.order_id left join books b on od.book_id=b.book_id 
--  left join categories c on b.category_id=c.category_id where c.category_name like '%시%';
 select b.book_id from orders o left join order_details od on o.order_id = od.order_id left outer join books b on od.book_id=b.book_id 
join categories c on b.category_id=c.category_id where c.category_name = '시';
-- group by book_id order by total desc ;
select*from orders o join order_details od on o.order_id = od.order_id join books b on od.book_id=b.book_id join categories c on b.category_id=c.category_id; 
  
  
  select b.book_id, sum(price) total from orders o join order_details od on o.order_id = od.order_id join books b on od.book_id=b.book_id 
	    join categories c on b.category_id=c.category_id where category_name = '소설'
	    group by book_id order by total desc limit 0,4;
  
  
  --  group by book_id ;
select b.book_id, sum(count) total, title, writer, image from books b join order_details od on b.book_id = od.book_id group by book_id order by total  desc limit 0,4;