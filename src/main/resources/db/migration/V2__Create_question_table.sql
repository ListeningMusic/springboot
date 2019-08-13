create table question
(
	id int auto_increment,
	title varchar(50) null,
	description text null,
	create_time bigint null,
	modified_time bigint null,
	creator_id int null,
	comment_number int null,
	like_number int null,
	tag varchar(255) null,
	constraint question_pk
		primary key (id)
);
