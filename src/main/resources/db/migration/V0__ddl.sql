create table if not exists author
(
    id               uuid         not null
        primary key,
    name             varchar(255) not null,
    created_at       timestamp(6) not null,
    last_modified_at timestamp(6) not null
);

create table if not exists kind
(
    id               uuid         not null
        primary key,
    name             varchar(255) not null,
    created_at       timestamp(6) not null,
    last_modified_at timestamp(6) not null
);

create table if not exists publisher
(
    id               uuid         not null
        primary key,
    closed           boolean      not null,
    name             varchar(255) not null,
    created_at       timestamp(6) not null,
    last_modified_at timestamp(6) not null
);

create table if not exists series
(
    id               uuid         not null
        primary key,
    name             varchar(255) not null,
    type             varchar(255) not null
        constraint series_type_check
            check ((type)::text = ANY
                   ((ARRAY ['SHONEN'::character varying, 'SEINEN'::character varying, 'SHOJO'::character varying])::text[])),
    year             bigint       not null,
    created_at       timestamp(6) not null,
    last_modified_at timestamp(6) not null
);

create table if not exists edition
(
    id               uuid         not null
        primary key,
    name             varchar(255) not null,
    status           varchar(255) not null
        constraint edition_status_check
            check ((status)::text = ANY
                   ((ARRAY ['PENDING'::character varying, 'FINISHED'::character varying, 'STOPPED'::character varying])::text[])),
    created_at       timestamp(6) not null,
    last_modified_at timestamp(6) not null,
    publisher_id     uuid
        constraint fkg2qgt9wer0mqe587e28hq0x5t
            references publisher,
    series_id        uuid
        constraint fkmx0len6r62m4u9o305ra401uy
            references series
);

create table if not exists series_authors
(
    series_id  uuid not null
        constraint fkm1h8mchw5py0g21feb4664l9n
            references series,
    authors_id uuid not null
        constraint fkdosk13yyqqcvr24n7rgr33g07
            references author,
    primary key (series_id, authors_id)
);

create table if not exists series_kinds
(
    series_id uuid not null
        constraint fkn45n31st62vn8beiq0fmfaa7v
            references series,
    kinds_id  uuid not null
        constraint fk9yf6fqgxbjlhpprfa42wx9rpc
            references kind,
    primary key (series_id, kinds_id)
);

create table if not exists volume
(
    id               uuid         not null
        primary key,
    asin             varchar(255),
    image_url        varchar(255),
    isbn             varchar(255),
    name             varchar(255) not null,
    number           bigint       not null,
    publication_date timestamp(6) not null,
    created_at       timestamp(6) not null,
    last_modified_at timestamp(6) not null,
    edition_id       uuid
        constraint fkcgug82vgmlgy5wwi92d25wu7x
            references edition
);
