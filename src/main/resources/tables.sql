-- creation of enumeration
-- create type participant_roles as enum ('scrum_master', 'regular_participant');
--
-- create type affiliation as enum ('assigned_to_me', 'created_by_me', 'reviewer_by_me');
--
-- create type task_status as enum ('todo', 'in_work', 'finished');
--
-- create type task_status_approval as enum ('approved', 'to_be_approved');

--идея такова, что любой участник проекта предлагает свою идею, если это фича,  то ее должен
-- подтвердить скрам мастер, если баг, то она сразу подтвержена, и к ней могут добавится или быть добавлены
-- участники. Все неподтвержденные таски хранятся в бэклоге, и потом с м назначает им спринт и тд
create type task_status_type as enum ('feature', 'bug');
----------------------------------------------

-- creation of tables and sequence
create table if not exists project(id serial primary key,
                                   title varchar(100) not null,
                                   owner_id int not null,
                                   creation_date timestamp not null default current_date);

create sequence if not exists seq_proj start 1;

-- мне кажется, лучше убрать отдел, лучше сделать один раздел(разработка) и чтобы все были привязаны только
-- к проекту
-- create table if not exists department(id serial primary key,
-- type varchar(100) not null);
-- create sequence if not exists seq_dep start 1;

create table if not exists backlog(id serial primary key,
                                    project_id int not null,
                                    creation_date timestamp not null default current_date);
create sequence if not exists seq_backlog start 1;


create table if not exists sprint(id serial primary key,
                                  creation_date timestamp not null default current_date,
                                  date_of_beginning timestamp,
                                  duration int,
                                  project_id int not null );
create sequence if not exists seq_sprint start 1;

create table if not exists task(id serial primary key,
                                title varchar(100) not null,
                                creation_date timestamp not null default current_date,
                                description varchar(500),
                                duration int,
                                status_work varchar(20) not null
                                    check ( status_work = 'TODO' or
                                            status_work = 'OPENED' or
                                            status_work = 'CLOSED'),
                                status_approval varchar(20) not null
                                    check ( status_approval = 'APPROVED' or
                                            status_approval = 'TO_BE_APPROVED'),
                                type varchar(20) not null
                                    check ( type = 'BUG' or
                                            type = 'FEATURE'),
                                backlog_id int not null ,
                                sprint_id int ,
                                extra_info_id int ,
                                priority int check ( priority > 0));

create sequence if not exists seq_task start 1;

create table if not exists usr(id serial primary key,
                               name varchar(50) not null ,
                               email varchar(50) not null unique ,
                               password varchar(50) not null,
                               fullname varchar(100),
                               creation_date timestamp not null default current_date);
create sequence if not exists seq_user start 1;
---------------------------------------------
create table if not exists extra_task_info(id serial primary key,
                                           file bytea not null,
                                           creation_date timestamp not null default current_date);
create sequence if not exists seq_task_extra start 1;

-- Creation of many-to-many between users and tasks
create table user_has_tasks(
                               task_id int references task (id) on delete cascade on update cascade ,
                               user_id int references usr (id) on delete cascade ,
                               affiliation varchar(20) not null
                                   check ( affiliation = 'ASSIGNED_TO_ME' or
                                            affiliation = 'CREATED_BY_ME' or
                                            affiliation = 'REVIEWED_BY_ME'));

-- Creation of many-to-many between users and projects
create table project_has_participants(
                                         project_id int references project(id) on delete cascade ,
                                         participant_id int references usr(id) on delete cascade ,
                                         role varchar(20) not null
                                             check ( role = 'SCRUM_MASTER' or
                                                     role = 'REGULAR_PARTICIPANT'));


create table if not exists comment(
    id serial primary key,
    user_id int,
    task_id int not null,
    creation_date timestamp not null default current_date
);

create sequence if not exists seq_com start 1;
alter table comment add constraint user_ref foreign key (user_id) references usr(id) on delete set null ,
                     add constraint task_ref foreign key (task_id) references task(id) on delete cascade on update cascade



