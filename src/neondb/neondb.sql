-- //////////////////////////////////////////
-- Create tables
-- //////////////////////////////////////////


create table menu (
   id         serial primary key,
   name       varchar(255) unique not null,
   created_at timestamp not null default current_timestamp
);

create table dinner_table (
   id         serial primary key,
   capacity   int not null,
   notes      varchar(255),
   created_at timestamp not null default current_timestamp
);

create table dinner_order (
   id         serial primary key,
   menu_id    int not null,
   table_id   int not null,
   menu_count int not null,
   created_at timestamp not null default current_timestamp,
   foreign key ( menu_id )
      references menu ( id ),
   foreign key ( table_id )
      references dinner_table ( id )
);

-- //////////////////////////////////////////
-- Insert data
-- //////////////////////////////////////////

insert into menu (
   name,
   created_at
) values ( 'Papas fritas con pollo al jugo',
           current_timestamp );
insert into menu (
   name,
   created_at
) values ( 'Papas fritas con bistec',
           current_timestamp );
insert into menu (
   name,
   created_at
) values ( 'Ensalada de papas mayo con bistec',
           current_timestamp );


insert into dinner_table (
   capacity,
   notes
) values ( 5,
           'esquina izquierda' );


insert into dinner_order (
   menu_id,
   table_id,
   menu_count
) values ( 2,
           1,
           5 );


-- //////////////////////////////////////////
-- Read data
-- //////////////////////////////////////////


select *
  from user_tables;

select *
  from menu;

select *
  from dinner_table;

select *
  from dinner_order;


select *
  from menu
 where name like '%Papas%'
    or name like '%papas%';

desc menu;
