CREATE TABLE produto(
  id serial PRIMARY KEY,
  descricao varchar (100) NOT NULL,
  ean varchar (14) NOT NULL,
  id_empresa int,
  FOREIGN KEY (id_empresa) REFERENCES empresa(id)
)
