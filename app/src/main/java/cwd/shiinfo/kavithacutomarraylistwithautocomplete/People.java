package cwd.shiinfo.kavithacutomarraylistwithautocomplete;

public class People {

    private String name, lastName;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public People(String name, String lastName, String id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
}