package hillel.jiraclone.demo.persistence.repos;

import hillel.jiraclone.demo.persistence.entity.Project;
import hillel.jiraclone.demo.service.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends CommonRepository<Project> {
}

//    Для вашего проекта добавить таблицы и ентити для записи исторических действий. Примерный вид таблиц :
//
//        history (id, create_date, client_id (reference), history_level, history_type)
//
//        history_detail (id, history_id, name, value).
//
//        Чтобы в дальнейшем вы могли писать данные, пригодные для отображения на стороне клиента, к примеру, "пользователь ФИО создал задачу с названием НАЗВАНИЕ ЗАДАЧИ 1".
//        В базе эта информация ложится так
//
//        insert into history (id, create_date, client_id, history_level, history_type) values  (1, '2020-11-11 20:00:00.000',  1, 'DEBUG', 'CREATE_TASK');
//        insert into history_detail(id, history_id, name, value) values (1, 1, 'AUTHOR_NAME', 'ФИО');
//        insert into history_detail(id, history_id, name, value) values (2, 1, 'TASK_NAME', 'НАЗВАНИЕ ЗАДАЧИ 1');
//        Исходя из этих данных, можно очень гибко планировать отображение истории.
//
//        Необходимо будет сделать также DAO слой для работы с историей и сервисный слой. В дао слое сделать метод который будет вызывать хранимую процедуру на стороне БД. Данная процедура будет в зависимости от входного
//        параметра (входной параметра процедуры - дата, до которой надо удалить всю историю) удалять всю историю. Историю можно либо удалять с базы данных физически, либо проставлять дату удаления и в запросах на получение
//        истории учитывать фильтр where delete_date is null.
//
//        Реализация вызова хранимой процедуры сделать как при помощи entityManager так и при помощи spring jdbc. Примерный вид сигнатуры хранимой процедуры - create or replace procedure delete_all_by_date(p_date IN date)