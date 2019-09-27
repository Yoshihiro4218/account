TODO: updated_at created_atのnotnullとdefault
```sql
create table accounts (
      id integer primary key auto_increment,
      email varchar(255),
      password char(60),
      created_at timestamp,
      updated_at timestamp
);
```