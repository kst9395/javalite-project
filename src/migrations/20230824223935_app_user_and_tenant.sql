CREATE TABLE app_users(
    id serial primary key,
    username varchar(255) not null unique,
    password varchar(255) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default null
);

CREATE TABLE tenants(
    id serial primary key,
    name varchar(255) not null unique,
    created_at timestamp default current_timestamp
);

CREATE TABLE tenant_states(
    id serial primary key,
    state_key varchar(255) not null,
    state_value varchar(255) not null,
    tenant_id int not null references tenants(id),
    unique(tenant_id, state_key,state_value)
);

CREATE TABLE app_users_tenants(
    id serial primary key,
    app_user_id int not null references app_users(id),
    tenant_id int not null references tenants(id),
    unique(app_user_id, tenant_id)
);