package org.MohammadAli.models;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomerDTO {

    private String name;
    private String family;
    private float age;
    public CustomerDTO(String name, String family, float age) {
        this.name = name;
        this.family = family;
        this.age = age;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getFamily() {
        return family;
    }

    public void setFamily(java.lang.String family) {
        this.family = family;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                '}';
    }

    @Data
    public static class CREATE extends CustomerDTO{
        public CREATE(String name , String family , float age){
            super(name, family, age);
        }
    }


    @Data
    public static class RETRIEVE extends CustomerDTO{
        private AccountDTO accountDTO;

        @Override
        public String toString() {
            return "[" + "\n" +
                    "name :'" + getName() + '\'' + "\n" +
                    "family :'" + getFamily() + '\'' + "\n" +
                    "age :" + getAge() + "\n" +
                    "accountInfo :"  + accountDTO + "\n" +
                    ']';
        }
    }
}
