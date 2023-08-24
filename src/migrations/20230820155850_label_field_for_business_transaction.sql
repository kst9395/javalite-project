CREATE TABLE labels(
    id serial primary key,
    label_name varchar(255) not null unique,
    created_at timestamp default current_timestamp
);

CREATE TABLE business_transactions_labels(
    id serial primary key,
    label_id int not null references labels(id),
    business_transaction_id int not null references business_transactions(id),
    unique(label_id, business_transaction_id)
);