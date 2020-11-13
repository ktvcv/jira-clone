create table if not exists project(id serial primary key,
                                   title varchar(100) not null,
                                   owner_id int not null,
                                   creation_date timestamp not null default current_date);

create sequence if not exists seq_proj start 1;

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

alter table sprint  add constraint project_ref foreign key (project_id) references project (id) on delete cascade on update cascade;

alter table backlog add constraint project_ref foreign key (project_id) references project (id) on delete cascade on update cascade;
