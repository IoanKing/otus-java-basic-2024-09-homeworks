-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;
-- public.answers определение

-- Drop table

-- DROP TABLE public.answers;

CREATE TABLE public.answers (
	id int4 NOT NULL,
	answer varchar(255) NOT NULL,
	CONSTRAINT answers_pkey PRIMARY KEY (id)
);


-- public.questions определение

-- Drop table

-- DROP TABLE public.questions;

CREATE TABLE public.questions (
	id int4 NOT NULL,
	question varchar(255) NOT NULL,
	CONSTRAINT questions_pkey PRIMARY KEY (id)
);


-- public.t_group определение

-- Drop table

-- DROP TABLE public.t_group;

CREATE TABLE public.t_group (
	id int4 NOT NULL,
	group_name varchar(255) NOT NULL,
	CONSTRAINT t_group_pkey PRIMARY KEY (id)
);


-- public.test определение

-- Drop table

-- DROP TABLE public.test;

CREATE TABLE public.test (
	id int4 NOT NULL,
	test_name varchar(255) NOT NULL,
	CONSTRAINT test_pkey PRIMARY KEY (id)
);


-- public.question_answer определение

-- Drop table

-- DROP TABLE public.question_answer;

CREATE TABLE public.question_answer (
	id int4 NOT NULL,
	question_id int4 NOT NULL,
	answer_id int4 NOT NULL,
	is_valid bool DEFAULT false NOT NULL,
	CONSTRAINT question_answer_pkey PRIMARY KEY (id),
	CONSTRAINT question_answer_answer_id_fkey FOREIGN KEY (answer_id) REFERENCES public.answers(id),
	CONSTRAINT question_answer_question_id_fkey FOREIGN KEY (question_id) REFERENCES public.questions(id)
);


-- public.test_group определение

-- Drop table

-- DROP TABLE public.test_group;

CREATE TABLE public.test_group (
	id int4 NOT NULL,
	group_id int4 NOT NULL,
	test_id int4 NOT NULL,
	CONSTRAINT test_group_pkey PRIMARY KEY (id),
	CONSTRAINT test_group_group_id_fkey FOREIGN KEY (group_id) REFERENCES public.t_group(id),
	CONSTRAINT test_group_test_id_fkey FOREIGN KEY (test_id) REFERENCES public.test(id)
);


-- public.qa_test определение

-- Drop table

-- DROP TABLE public.qa_test;

CREATE TABLE public.qa_test (
	id int4 NOT NULL,
	qa_id int4 NOT NULL,
	test_id int4 NOT NULL,
	CONSTRAINT qa_test_pkey PRIMARY KEY (id),
	CONSTRAINT qa_test_qa_id_fkey FOREIGN KEY (qa_id) REFERENCES public.question_answer(id),
	CONSTRAINT qa_test_test_id_fkey FOREIGN KEY (test_id) REFERENCES public.test(id)
);