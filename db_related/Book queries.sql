
/*Find number of books for each author (name,count)*/

select A.name, count(B.name) as count
from Books B, Authors A, written_by W
where W.name=A.name
and B.bid=W.bid
group by A.name;


/*Find names of books with a movie adaptation (Movie, Book)*/

select M.name as movie, B.name as book
from Movies M, Books B, based_on O
where M.mid=O.mid
and B.bid=O.bid;


/*Find books shared by libraries that are novels(Library, Novel)*/

select L.name as library, B.name as novel
from Books B, Libraries L, share S
where B.bid=S.bid
and L.lid=S.lid
and B.type='novel';

/*Find number of readers each book has(name,count)*/

select B.name, Count(R.username) as count
from Books B, Readers R, Have H
where B.bid=H.bid
and R.rid=H.rid
group by B.name;

/*Find number of Books each Bookstore has(name,count)*/

select K.name, Count(B.name) as count
from Books B, Book_stores K, sold_in S
where B.bid=S.bid
and K.sid=S.sid
group by K.name;
