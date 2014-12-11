# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contato (
  id                        bigint not null,
  nome                      varchar(255),
  telefone                  varchar(255),
  pessoa_id                 bigint,
  constraint pk_contato primary key (id))
;

create table perfil (
  id                        bigint not null,
  pessoa_id                 bigint,
  endereco                  varchar(255),
  constraint pk_perfil primary key (id))
;

create table pessoa (
  DTYPE                     varchar(31) not null,
  id                        bigint not null,
  nome                      varchar(255),
  nascimento                timestamp,
  FORNECEDOR_NASCIMENTO     timestamp,
  constraint pk_pessoa primary key (id))
;

create sequence contato_seq;

create sequence perfil_seq;

create sequence pessoa_seq;

alter table contato add constraint fk_contato_pessoa_1 foreign key (pessoa_id) references pessoa (id) on delete restrict on update restrict;
create index ix_contato_pessoa_1 on contato (pessoa_id);
alter table perfil add constraint fk_perfil_pessoa_2 foreign key (pessoa_id) references pessoa (id) on delete restrict on update restrict;
create index ix_perfil_pessoa_2 on perfil (pessoa_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists contato;

drop table if exists perfil;

drop table if exists pessoa;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists contato_seq;

drop sequence if exists perfil_seq;

drop sequence if exists pessoa_seq;

