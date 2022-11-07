create table customers
(
    id   bigserial
        primary key,
    name varchar(255)
);

alter table customers
    owner to depaul;

-- ########################################

create table vehicles
(
    id        bigserial
        primary key,
    available boolean,
    make      varchar(30) default 'UNSPECIFIED'::character varying,
    mileage   integer,
    model     varchar(255),
    type      varchar(30) default 'UNSPECIFIED'::character varying
);

alter table vehicles
    owner to depaul;

-- ########################################

create table reservations
(
    id              bigserial
        primary key,
    dropoff_time    timestamp,
    dropoff_mileage integer,
    pickup_time     timestamp,
    pickup_mileage  integer,
    status          varchar(25) default 'AVAILABLE'::character varying,
    customer_id     bigint
        constraint fk8eccffekcj27jkdiyw2e9r8ks
            references customers,
    vehicle_id      bigint
        constraint fk7s1rlt0ccv2hjeaubf52di8er
            references vehicles
);

alter table reservations
    owner to depaul;


-- ########################################



