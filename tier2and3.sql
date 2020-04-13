Tier 2

select * from app_user where role_id = 3;
insert into app_user (user_id, username, "password", first_name, last_name, role_id) values (7, 'jmorgan', 'shade','Jordan', 'Morgan', 4);
 
inner join study_set 
on user_id = owner_id
where 
user_id =4;

Tier 3
create user quizuser with password 'password';
create database quizzard;
grant all privileges on database quizzard to quizuser;
grant all privileges on database postgress to quizuser;
CREATE OR REPLACE FUNCTION get_study_sets(user_id int) RETURNS refcursor AS $$
    DECLARE
      ref refcursor;                                                     
    BEGIN
      OPEN ref FOR SELECT * FROM study_set where owner_id = user_id);   
      RETURN ref;                                                       
    END;
    $$ LANGUAGE plpgsql;



create table user_role (
	role_id serial primary key,
	name text unique not null
);


create table app_user(
	user_id serial primary key,
	username text unique not null,
	"password" text null null,
	first_name text not null,
	last_name text not null,
	role_id int references user_role(role_id)
);

create table study_set(
	study_set_id serial primary key,
	name text unique not null,
	owner_id int references app_user(user_id)
);

create table category(
		category_id serial primary key,
		name text unique not null
);

create table flashcard(
	flashcard_id serial primary key,
	question text unique not null,
	answer text unique not null,
	category_id int references category(category_id)
);


create table study_set_card(
	study_set_id int references study_set(study_set_id),
	flashcad_id int references flashcard(flashcard_id)
);

ALTER TABLE study_set_card ADD PRIMARY KEY (study_set_id);


