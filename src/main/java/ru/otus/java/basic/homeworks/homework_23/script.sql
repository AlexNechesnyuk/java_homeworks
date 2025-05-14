CREATE TABLE answer(
	id serial PRIMARY KEY,
	body varchar(255) NOT NULL
);

CREATE TABLE question(
	id serial PRIMARY KEY,
	body varchar(255) NOT NULL
);


CREATE TABLE tests(
	id serial PRIMARY KEY,
	answer_id int not null,
	question_id int not null,
	istrue bool not null,
	foreign key(answer_id) references answer(id) on delete cascade,
	foreign key(question_id) references question(id) on delete cascade
);


--Возникла сложность при проектировании структуры БД для системы тестирования:
--Текущая реализация:
--Таблицы question и answer хранят вопросы и ответы тестов.
--Каждый тест может содержать произвольное количество ответов (как правильных, так и неправильных) через связующую таблицу tests.

--Проблема:
--Необходимо обеспечить строгое ограничение:
--Каждый тест должен содержать от 2 до 5 ответов.
--Среди них должен быть 1 правильный ответ.

--Рассмотренные варианты:

--Поля для ответов внутри таблицы тестов:

--correct_answer_id INT NOT NULL,  
--wrong_answer1_id INT NOT NULL,  
--wrong_answer2_id INT,  
--wrong_answer3_id INT,  
--wrong_answer4_id INT,  

--Недостатки:
--Жёсткая привязка к 4 неправильным ответам (даже если нужно меньше).
--Невозможно гарантировать заполнение полей неправильных ответов в порядке 1,2,3,4.
--Нарушение нормализации (дублирование структуры).
--Подскажите, пожалуйста, оптимальный способ реализации
