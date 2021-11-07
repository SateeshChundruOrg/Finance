CREATE table finance.phone_type(id SERIAL, type varchar UNIQUE ,description varchar);

CREATE table finance.phone_numbers(id bigint primary key, customer_id bigint, phone_number varchar,type varchar,
 CONSTRAINT fk_customer FOREIGN KEY(customer_id) REFERENCES finance.customers(id),
  CONSTRAINT fk_phone_type FOREIGN KEY(type) REFERENCES finance.phone_type(type))
