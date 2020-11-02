-- creation of enumeration
create type participant_roles as enum ('scrum_master', 'regular_participant');

create type affiliation as enum ('assigned_to_me', 'created_by_me', 'reviewer_by_me');

create type task_status as enum ('todo', 'on_going', 'finished');

create type task_status_approval as enum ('approved', 'to_be_approved');

--идея такова, что любой участник проекта предлагает свою идею, если это фича,  то ее должен
-- подтвердить скрам мастер, если баг, то она сразу подтвержена, и к ней могут добавится или быть добавлены
-- участники. Все неподтвержденные таски хранятся в бэклоге, и потом с м назначает им спринт и тд
create type task_status_type as enum ('feature', 'bug');
----------------------------------------------

-- creation of tables and sequence
create table if not exists project(id serial primary key,
                                   title varchar(100) not null,
                                   owner_id int not null );

create sequence if not exists seq_proj start 1;

-- мне кажется, лучше убрать отдел, лучше сделать один раздел(разработка) и чтобы все были привязаны только
-- к проекту
-- create table if not exists department(id serial primary key,
-- type varchar(100) not null);
-- create sequence if not exists seq_dep start 1;

create table if not exists back_log(id serial primary key,
                                    project_id int not null );
create sequence if not exists backlog_dep start 1;


create table if not exists sprint(id serial primary key,
                                  dateOfBeginning date not null,
                                  duration int,
                                  project_id int not null );
create sequence if not exists seq_sprint start 1;

create table if not exists task(id serial primary key,
                                title varchar(100) not null,
                                start_date date not null,
                                description varchar(500),
                                duration int,
                                status task_status not null,
                                status_apr task_status_approval not null,
                                status_type task_status_type not null,
                                backlog_id int not null ,
                                sprint_id int ,
                                extra_info_id int ,
                                creator_id int not null ,
                                priority int check ( priority > 0));

create sequence if not exists seq_task start 1;

create table if not exists usr(id serial primary key,
                               name varchar(50) not null ,
                               email varchar(50) not null ,
                               password varchar(50) not null);
create sequence if not exists seq_participant start 1;
---------------------------------------------
create table if not exists extra_task_info(id serial primary key,
                                           file bytea not null );
create sequence if not exists seq_task_extra start 1;

-- Creation of many-to-many between users and tasks
create table user_has_tasks(
                               task_id int references task (id) on delete cascade on update cascade ,
                               participant_id int references usr (id) on delete cascade ,
                               affiliation affiliation not null );

-- Creation of many-to-many between users and projects
create table project_has_participants(
                                         project_id int references project(id) on delete cascade ,
                                         participant_id int references usr(id) on delete cascade ,
                                         role participant_roles not null );

