INSERT INTO public.t_group (id,group_name) VALUES
	 (1,'Группа тестов №1'),
	 (2,'Группа тестов №2'),
	 (3,'Группа тестов №3');

 INSERT INTO public.test (id,test_name) VALUES
     (1,'Тест №1'),
     (2,'Тест №2'),
     (3,'Тест №3'),
     (4,'Тест №4'),
     (5,'Тест №5');

INSERT INTO public.questions (id,question) VALUES
	 (1,'Вопрос №1'),
	 (2,'Вопрос №2'),
	 (3,'Вопрос №3'),
	 (4,'Вопрос №4'),
	 (5,'Вопрос №5'),
	 (6,'Вопрос №6'),
	 (7,'Вопрос №7'),
	 (8,'Вопрос №8'),
	 (9,'Вопрос №9');

INSERT INTO public.answers (id,answer) VALUES
	 (1,'Ответ №1'),
	 (2,'Ответ №2'),
	 (3,'Ответ №3'),
	 (4,'Ответ №4'),
	 (5,'Ответ №5'),
	 (6,'Ответ №6'),
	 (7,'Ответ №7'),
	 (8,'Ответ №8'),
	 (9,'Ответ №9'),
	 (10,'Ответ №10');
INSERT INTO public.answers (id,answer) VALUES
	 (11,'Ответ №11'),
	 (12,'Ответ №12'),
	 (13,'Ответ №13'),
	 (14,'Ответ №14'),
	 (15,'Ответ №15'),
	 (16,'Ответ №16'),
	 (17,'Ответ №17'),
	 (18,'Ответ №18'),
	 (19,'Ответ №19'),
	 (20,'Ответ №20');
INSERT INTO public.answers (id,answer) VALUES
	 (21,'Ответ №21'),
	 (22,'Ответ №22'),
	 (23,'Ответ №23'),
	 (24,'Ответ №24'),
	 (25,'Ответ №25');

INSERT INTO public.question_answer (id,question_id,answer_id,is_valid) VALUES
	 (1,1,1,false),
	 (2,1,2,false),
	 (3,1,3,false),
	 (4,1,4,true),
	 (5,1,5,false),
	 (6,2,6,true),
	 (7,2,7,false),
	 (8,2,8,false),
	 (9,2,9,false),
	 (10,2,10,false);
INSERT INTO public.question_answer (id,question_id,answer_id,is_valid) VALUES
	 (11,2,11,false),
	 (12,3,12,false),
	 (13,3,13,false),
	 (15,3,15,false),
	 (14,3,14,true),
	 (16,4,16,false),
	 (17,4,17,false),
	 (19,4,19,false),
	 (20,4,20,false),
	 (21,5,21,false);
INSERT INTO public.question_answer (id,question_id,answer_id,is_valid) VALUES
	 (22,5,22,false),
	 (23,5,23,false),
	 (25,5,25,false),
	 (18,4,18,true),
	 (24,5,24,true);

INSERT INTO public.qa_test (id,qa_id,test_id) VALUES
	 (1,1,1),
	 (2,2,1),
	 (3,3,1),
	 (4,4,1),
	 (5,5,1),
	 (6,6,2),
	 (7,7,2),
	 (8,8,2),
	 (9,9,2),
	 (10,10,2);

INSERT INTO public.test_group (id,group_id,test_id) VALUES
	 (1,1,1),
	 (2,1,2),
	 (3,1,3),
	 (4,2,4),
	 (5,2,5);