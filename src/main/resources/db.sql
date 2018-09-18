
select * from TBL_BOARD where WRITER = 'gonnys';

insert into TBL_BOARD (BNO, TITLE, CONTENT, WRITER)
VALUES (SEQ_BOARD.nextval, '머쓱타드.....', '머쓱머쓱', 'gonnys');

select count(*) from TBL_BOARD;

--1pgae
  select
  /*+ index_desc(tbl_board pk_board ) */
  bno, title, CONTENT, WRITER, REGDATE, UPDATEDATE
  from TBL_BOARD
  where bno > 0
  and rownum <- (1 *10)
;

--2page
select *
from (
  select
  /*+ index_desc(tbl_board pk_board ) */
  Rownum rn, bno, title, CONTENT, WRITER, REGDATE, UPDATEDATE
  from TBL_BOARD
  where bno > 0
  and rownum <= (1 * 20)
)
where rn > (1 - 1) * 10
;

--
insert into tbl_board(bno,title,content,writer)
(select_board.)

