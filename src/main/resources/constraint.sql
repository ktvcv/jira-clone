alter table project add constraint owner_ref foreign key (owner_id) references usr (id) on delete restrict ;

alter table sprint  add constraint project_ref foreign key (project_id) references project (id) on delete cascade on update cascade;

alter table back_log add constraint project_ref foreign key (project_id) references project (id) on delete cascade on update cascade;

alter table task add constraint backlog_ref foreign key (backlog_id) references backlog(id) on delete cascade on update cascade ,
                 add constraint sprint_ref foreign key (sprint_id) references sprint (id) on delete set null on update cascade ,
                 add constraint extra_info_ref foreign key (extra_info_id)  references extra_task_info (id) on delete set null on update cascade);

alter table comments add constraint user_ref foreign key (user_id) references usr(id) on delete set null ,
                     add constraint task_ref foreign key (task_id) references task(id) on delete cascade on update cascade