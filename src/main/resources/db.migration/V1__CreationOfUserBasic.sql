create table if not exists usr(id serial primary key,
                               name varchar(50) not null ,
                               email varchar(50) not null unique ,
                               password varchar(50) not null,
                               creation_date date not null default current_date);
create sequence if not exists seq_user start 1;