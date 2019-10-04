TODO: updated_at created_atのnotnullとdefaultの設定
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

各UT

- spring のコンテキストでtest
```
@RunWith(SpringRunner.class)
@SpringBootTest
.
.
@Autowired
Xxxxxx target;
```

- Mock
```
@RunWith(MockitoJunitRunner.class)
.
.
@InjectMocks
Xxxxx target;
@Mock
Yyyyy yyyy;
```

- Controller
```
@RunWith(SpringRunner.class)
@WebMvcTest(XxxxxController.class)
.
.
@Autowired
MockMvc mockMvc;
@MockBean
Xxxxx xxxxx;
```
