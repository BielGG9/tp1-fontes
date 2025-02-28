package quarkus;

public class CreateUserRequest {
    private String name;
    private int age;

    // Construtor padrão necessário para desserialização do JSON
    public CreateUserRequest() {}

    public CreateUserRequest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getname() {
        return name;
    }

    public void setname(String firstName) {
        this.name = firstName;
    }
}
