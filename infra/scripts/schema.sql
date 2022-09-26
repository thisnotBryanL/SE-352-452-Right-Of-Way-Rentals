create table customers
(
    id   bigint not null
        primary key,
    name varchar(255)
);

alter table customers
    owner to depaul;


create table employees
(
    id   bigint not null
        primary key,
    name varchar(255),
    role integer
);

alter table employees
    owner to depaul;


create table locations
(
    id      bigint not null
        primary key,
    city    varchar(255),
    state   varchar(2),
    zipcode varchar(255)
);

alter table locations
    owner to depaul;


-- auto-generated definition
create table reservations
(
    id              bigint not null
        primary key,
    customer_id     bigint,
    dropoff_time    timestamp,
    dropoff_mileage integer,
    employee_id     bigint,
    pickup_time     timestamp,
    pickup_mileage  integer,
    status          varchar(25) default 'AVAILABLE'::character varying,
    vehicle_id      bigint
);

alter table reservations
    owner to depaul;



-- auto-generated definition
create table vehicles
(
    id        bigint not null
        primary key,
    available boolean,
    make      varchar(30) default 'UNSPECIFIED'::character varying,
    mileage   integer,
    model     varchar(255),
    type      integer
);

alter table vehicles
    owner to depaul;

