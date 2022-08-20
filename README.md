# Cucumber-Master-Class

This project uses TestNG for runner

## How to excution this project?
**Way 1:** 
Run this command to your terminal (Mac/Linux/UNIX) or CMD (Windows): 
```bash
mvn clean test -Dcucumber.filter.tags="@CheckOut" -Dbrowser=Chrome
```

Or you can also use this command (if there is an error in your cmd/terminal)
```bash
mvn clean test -D"cucumber.filter.tags=@CheckOut" -Dbrowser=Chrome
```

Ps. you can enter any browser configuration in ```TestBase.java``` file if you want (e.g Edge, Firefox, etc)

**Way 2:**
Run without tags and brwoser only (it will execute all features files)
```bash
mvn clean test -Dbrowser=Chrome
```

**Way 3:**
Run the ```TestNGRunner.java``` file directly

## License
[MIT](https://choosealicense.com/licenses/mit/)
