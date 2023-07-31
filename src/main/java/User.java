public class User {
    private Long Id;
    private String Name;
    private String LastName;
    private Integer Age;

    public User() {
    }

    public User(Long id, String name, String lastName, Integer age) {
        Id = id;
        Name = name;
        LastName = lastName;
        Age = age;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
