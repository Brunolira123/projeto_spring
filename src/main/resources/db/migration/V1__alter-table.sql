CREATE TABLE empresa(
id serial PRIMARY KEY,
razao varchar(100) NOT null,
cnpj varchar (50) NOT NULL UNIQUE ,
bairro varchar (50) NOT NULL ,
cidade varchar (50)NOT null,
complemento varchar(50) NULL ,
uf char (2) NOT NULL ,
cep varchar (15)NOT NULL 
)