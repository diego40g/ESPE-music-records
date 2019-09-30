/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     28/9/2019 15:38:28                           */
/*==============================================================*/

drop table if exists ADMINISTRADOR_RECORD_MUSIC;

drop table if exists ALBUM;

drop table if exists BANDA;

drop table if exists CANCION;

drop table if exists CREA;

drop table if exists MANAGER;

drop table if exists MIEMBROS_BANDA;

/*==============================================================*/
/* Table: ADMINISTRADOR_RECORD_MUSIC                            */
/*==============================================================*/
create table ADMINISTRADOR_RECORD_MUSIC
(
   CODIGO_ADMIN         varchar(10) not null,
   APELLIDO_ADMIN       varchar(50) not null,
   NOMBRE_ADMIN         varchar(50) not null,
   EMAIL_ADMIN          varchar(50) not null,
   TELEFONO_ADMIN       varchar(10) not null,
   primary key (CODIGO_ADMIN)
);

/*==============================================================*/
/* Table: ALBUM                                                 */
/*==============================================================*/
create table ALBUM
(
   CODIGO_ALBUM         varchar(10) not null,
   NOMBRE_ALBUM         varchar(50) not null,
   GENERO_ALBUM         varchar(50) not null,
   NUMERO_CANCIONES     varchar(50) not null,
   primary key (CODIGO_ALBUM)
);

/*==============================================================*/
/* Table: BANDA                                                 */
/*==============================================================*/
create table BANDA
(
   CODIGO_MUSICO        varchar(10) not null,
   CODIGO_BANDA         varchar(10) not null,
   NOMBRE_BANDA         varchar(50) not null,
   NUMERO_INTEGRANTES   int,
   GENERO_BANDA         varchar(50) not null,
   primary key (CODIGO_MUSICO, CODIGO_BANDA)
);

/*==============================================================*/
/* Table: CANCION                                               */
/*==============================================================*/
create table CANCION
(
   CODIGO_MUSICO        varchar(10) not null,
   CODIGO_BANDA         varchar(10) not null,
   CODIGO_CANCION       varchar(10) not null,
   NOMBRE_CANCION       varchar(50) not null,
   DURACION             time not null,
   GENERO_CANCION       varchar(50) not null,
   primary key (CODIGO_MUSICO, CODIGO_BANDA, CODIGO_CANCION)
);

/*==============================================================*/
/* Table: CREA                                                  */
/*==============================================================*/
create table CREA
(
   CODIGO_ALBUM         varchar(10) not null,
   CODIGO_MUSICO        varchar(10) not null,
   CODIGO_BANDA         varchar(10) not null,
   CODIGO_CANCION       varchar(10) not null,
   primary key (CODIGO_ALBUM, CODIGO_MUSICO, CODIGO_BANDA, CODIGO_CANCION)
);

/*==============================================================*/
/* Table: MANAGER                                               */
/*==============================================================*/
create table MANAGER
(
   CODIGO_MANAGER       varchar(10) not null,
   CODIGO_MUSICO        varchar(10),
   CODIGO_BANDA         varchar(10),
   CODIGO_ADMIN         varchar(10),
   APELLIDO_MANAGER     varchar(50) not null,
   NOMBRE_MANAGER       varchar(50) not null,
   EMAIL_MANAGER        varchar(50) not null,
   TELEFONO_MANAGER     varchar(10) not null,
   primary key (CODIGO_MANAGER)
);

/*==============================================================*/
/* Table: MIEMBROS_BANDA                                        */
/*==============================================================*/
create table MIEMBROS_BANDA
(
   CODIGO_MUSICO        varchar(10) not null,
   APELLIDO             varchar(50) not null,
   NOMBRE               varchar(50) not null,
   CARGO                varchar(50) not null,
   EMAIL                varchar(50) not null,
   TELEFONO             varchar(10) not null,
   primary key (CODIGO_MUSICO)
);

alter table MIEMBROS_BANDA comment 'Tabla que muestra información de los mimbros de la banda
                                   -&';

alter table BANDA add constraint FK_TIENE foreign key (CODIGO_MUSICO)
      references MIEMBROS_BANDA (CODIGO_MUSICO) on delete restrict on update restrict;

alter table CANCION add constraint FK_POSEE foreign key (CODIGO_MUSICO, CODIGO_BANDA)
      references BANDA (CODIGO_MUSICO, CODIGO_BANDA) on delete restrict on update restrict;

alter table CREA add constraint FK_CREA foreign key (CODIGO_ALBUM)
      references ALBUM (CODIGO_ALBUM) on delete restrict on update restrict;

alter table CREA add constraint FK_CREA2 foreign key (CODIGO_MUSICO, CODIGO_BANDA, CODIGO_CANCION)
      references CANCION (CODIGO_MUSICO, CODIGO_BANDA, CODIGO_CANCION) on delete restrict on update restrict;

alter table MANAGER add constraint FK_TIENE_UN foreign key (CODIGO_MUSICO, CODIGO_BANDA)
      references BANDA (CODIGO_MUSICO, CODIGO_BANDA) on delete restrict on update restrict;

alter table MANAGER add constraint FK_TRABAJA_CON foreign key (CODIGO_ADMIN)
      references ADMINISTRADOR_RECORD_MUSIC (CODIGO_ADMIN) on delete restrict on update restrict;

