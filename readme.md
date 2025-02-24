# SpringBootApplication
**ФИО студента:** Безнутров Александр Дмитриевич  
**Преподаватель:** Карсканов Никита Андреевич

## Аннотация `@SpringBootApplication`
Аннотация `@SpringBootApplication` является ключевой в Spring Boot и объединяет в себе три основные аннотации:

- `@SpringBootConfiguration` - указывает, что класс является конфигурационным, включает в себя функции аннотации `@Configuration`.
- `@EnableAutoConfiguration` - включает автоматическую настройку Spring Boot.
- `@ComponentScan` - указывает, какие пакеты нужно сканировать.

## Параметры `@SpringBootApplication`
Аннотация `@SpringBootApplication` поддерживает несколько параметров:

### 1. `scanBasePackages`
Используется для указания пакетов, которые будут сканироваться для компонентов Spring.

**Пример:**
```java
@SpringBootApplication(scanBasePackages = {"com.example.service", "com.example.repository"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### 2. `scanBasePackageClasses`
Определяет классы, используемые для поиска базовых пакетов. Spring автоматически берет их пакеты как базовые.

**Пример:**
```java
@SpringBootApplication(scanBasePackageClasses = MyComponent.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### 3. `exclude`
Позволяет исключить конкретные автоконфигурации.

**Пример:**
```java
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### 4. `excludeName`
Принимает строковые имена классов автоконфигурации, которые необходимо исключить.

**Пример:**
```java
@SpringBootApplication(excludeName = {"org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### 5. `nameGenerator`
Позволяет указать генератор имен для компонентов, который будет использоваться во время сканирования.

**Пример:**
```java
@SpringBootApplication(nameGenerator = CustomBeanNameGenerator.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

### 6. `proxyBeanMethods`
Определяет, следует ли использовать проксирование методов конфигурационных классов.

**Пример:**
```java
@SpringBootApplication(proxyBeanMethods = false)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```