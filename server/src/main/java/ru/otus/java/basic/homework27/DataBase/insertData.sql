INSERT INTO public.users ("password", email, username) VALUES('12345', 'user1@mail.ru', 'user1');
INSERT INTO public.users ("password", email, username) VALUES('23456', 'user2@mail.ru', 'user2');
INSERT INTO public.users ("password", email, username) VALUES('34567', 'user2@mail.ru', 'user3');
INSERT INTO public.users ("password", email, username) VALUES('45678', 'user2@mail.ru', 'user4');
INSERT INTO public.users ("password", email, username) VALUES('56789', 'user2@mail.ru', 'user5');
INSERT INTO public.users ("password", email, username) VALUES('admin', 'admin@mail.ru', 'admin');

INSERT INTO public.roles ("name") VALUES('admin');
INSERT INTO public.roles ("name") VALUES('manager');
INSERT INTO public.roles ("name") VALUES('user');

INSERT INTO public.users_to_role (users_id, roles_id) VALUES(1, 3);
INSERT INTO public.users_to_role (users_id, roles_id) VALUES(2, 3);
INSERT INTO public.users_to_role (users_id, roles_id) VALUES(3, 3);
INSERT INTO public.users_to_role (users_id, roles_id) VALUES(4, 3);
INSERT INTO public.users_to_role (users_id, roles_id) VALUES(5, 3);
INSERT INTO public.users_to_role (users_id, roles_id) VALUES(6, 1);
INSERT INTO public.users_to_role (users_id, roles_id) VALUES(6, 2);
INSERT INTO public.users_to_role (users_id, roles_id) VALUES(6, 3);
INSERT INTO public.users_to_role (users_id, roles_id) VALUES(1, 2);
INSERT INTO public.users_to_role (users_id, roles_id) VALUES(2, 2);