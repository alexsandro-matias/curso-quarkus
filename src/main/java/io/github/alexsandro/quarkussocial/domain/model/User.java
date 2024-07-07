package io.github.alexsandro.quarkussocial.domain.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
//public class User extends PanacheEntityBase { // antes
//
// depois
public class User {

    //    Como herdamos de Panache, ele já implementa essa
    //    estratégia do ID de forma automática.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")

    /**
     Obrigatório somente
     se o nome do atributo for diferente do nome da propriedade.
     **/ private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
