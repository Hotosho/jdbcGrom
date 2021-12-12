create table product
(
    id          integer     not null,
    constraint product_pk primary key (id),
    name        varchar(20) not null,
    description text,
    price       integer     not null
)