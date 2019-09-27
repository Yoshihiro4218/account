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

Optional雛形
```
public String method() {
        if(bindingResult.hasErrors()) {
            return "";
        }

        Optional<UserRepresentation> maybeUser = userService.findLockedUserByUsername(username);
        return maybeUser.map(user -> {
            if() {
                return "";
            }
            return "";
        }).orElseGet(() -> {
            return "";
        });
    }
```