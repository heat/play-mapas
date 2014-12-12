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

create table fornecedor (
  dtype                     varchar(10) not null,
  id                        bigint,
  tipo                      bigint,
  nome                      varchar(255),
  setor_id                  bigint,
  setor_empresa             bigint,
  constraint pk_fornecedor primary key (id, tipo))
;

create table fornecedor_complemento (
  id                        bigint not null,
  tipo                      bigint,
  inscricao_estadual        varchar(255),
  inscricao_municipal       varchar(255),
  constraint pk_fornecedor_complemento primary key (id))
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
  constraint pk_pessoa primary key (id))
;

create table setor (
  id                        bigint,
  empresa                   bigint,
  constraint pk_setor primary key (id, empresa))
;

create sequence contato_seq;

create sequence fornecedor_seq;

create sequence fornecedor_complemento_seq;

create sequence perfil_seq;

create sequence pessoa_seq;

create sequence setor_seq;

alter table contato add constraint fk_contato_pessoa_1 foreign key (pessoa_id) references pessoa (id) on delete restrict on update restrict;
create index ix_contato_pessoa_1 on contato (pessoa_id);
alter table fornecedor add constraint fk_fornecedor_setor_2 foreign key (setor_id,setor_empresa) references setor (id,empresa) on delete restrict on update restrict;
create index ix_fornecedor_setor_2 on fornecedor (setor_id,setor_empresa);
alter table fornecedor_complemento add constraint fk_fornecedor_complemento_forn_3 foreign key (id,tipo) references fornecedor (id,tipo) on delete restrict on update restrict;
create index ix_fornecedor_complemento_forn_3 on fornecedor_complemento (id,tipo);
alter table perfil add constraint fk_perfil_pessoa_4 foreign key (pessoa_id) references pessoa (id) on delete restrict on update restrict;
create index ix_perfil_pessoa_4 on perfil (pessoa_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists contato;

drop table if exists fornecedor;

drop table if exists fornecedor_complemento;

drop table if exists perfil;

drop table if exists pessoa;

drop table if exists setor;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists contato_seq;

drop sequence if exists fornecedor_seq;

drop sequence if exists fornecedor_complemento_seq;

drop sequence if exists perfil_seq;

drop sequence if exists pessoa_seq;

drop sequence if exists setor_seq;

