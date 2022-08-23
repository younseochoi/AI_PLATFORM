create table board(
	seq int auto_increment primary key,
    title varchar(100) not null,
    contents varchar(4000),
    writer varchar(30),
    pw int,
    viewcount int,
    writingtime datetime
);

select * from board;

-- 외래키 참조
alter table board add constraint board_writer_fk foreign key(wirter)
references member(id) on delete cascade;