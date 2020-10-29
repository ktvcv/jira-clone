-- creation of enumeration
create type participant_roles as enum ('dep_manager', 'scrum_master', 'regular_participant');

create type affiliation as enum ('assigned_to_me', 'created_by_me', 'reviewer_by_me');

create type task_status as enum ('created', 'approved', 'on-going', 'finished');
----------------------------------------------

-- creation of tables and sequence
create table if not exists project(id serial primary key,
                     title varchar(100) not null);
create sequence if not exists seq_proj start 1;

create table if not exists department(id serial primary key,
                        type varchar(100) not null);
create sequence if not exists seq_dep start 1;

create table if not exists back_log(id serial primary key );
create sequence if not exists backlog_dep start 1;

create table if not exists sprint(id serial primary key,
                    dateOfBeginning date not null,
                    duration int);
create sequence if not exists seq_sprint start 1;

create table if not exists task(id serial primary key,
                  title varchar(100) not null,
                  start_date date not null,
                  estimated_finish_date date not null,
                  status task_status not null);
create sequence if not exists seq_task start 1;

create table if not exists usr(id serial primary key,
                        name varchar(50),
                        email varchar(50) not null ,
                        password varchar(50) not null);
create sequence if not exists seq_participant start 1;
---------------------------------------------

alter table project add column owner_id int references usr (id) on delete restrict ;

alter table department add column project_id int references project (id) on delete cascade ,
                       add column head_id int references usr (id) on delete set null ;

alter table back_log add column project_id int references project (id) on delete cascade ;

create table if not exists extra_task_info(id serial primary key,
                             file bytea not null );
create sequence if not exists seq_task_extra start 1;

alter table task add column backlog_id int references back_log (id) on delete cascade ,
                 add column sprint_id int references sprint (id) on delete no action ,
                 add column extra_info_id int references extra_task_info (id) on delete no action ,
                 add column priority int check ( priority > 0);


alter table sprint add column scrum_master_id int references usr (id) on delete set null ;

-- Creation of many-to-many between users and tasks
create table user_has_tasks(
    task_id int references task (id) on delete cascade ,
    participant_id int references usr (id) on delete cascade ,
    affiliation affiliation not null );

-- Creation of many-to-many between users and projects
create table project_has_participants(
    project_id int references project(id) on delete cascade ,
    participant_id int references usr(id) on delete cascade ,
    role participant_roles not null );