insert into USER_DETAILS (ID, BIRTH, NAME) values(10001, current_date, 'Ranga')
insert into USER_DETAILS (ID, BIRTH, NAME) values(10002, current_date, 'Ravi')
insert into USER_DETAILS (ID, BIRTH, NAME) values(10003, current_date, 'Sathish')

insert into post(id, description, user_id) values(20001, 'This is a post', 10001)
insert into post(id, description, user_id) values(20002, 'This is another post', 10001)
insert into post(id, description, user_id) values(20003, 'This is a different post', 10002)
insert into post(id, description, user_id) values(20004, 'This is a boringpost', 10002)