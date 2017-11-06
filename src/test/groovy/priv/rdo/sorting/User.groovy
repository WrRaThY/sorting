package priv.rdo.sorting

/**
 * @author WrRaThY
 * @since 06.11.2017
 */
class User implements Comparable<User>{
    int age
    int level

    User(int age, int level) {
        this.age = age
        this.level = level
    }

    @Override
    int compareTo(User compareTo) {
        if (age > compareTo.age){
            return 1
        } else if (age < compareTo.age){
            return -1
        }

        if (level > compareTo.level){
            return 1
        } else if (level < compareTo.level){
            return -1
        }

        return 0
    }

    @Override
    String toString() {
        return "User{" +
                "age=" + age +
                ", level=" + level +
                '}'
    }

    @Override
    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof User)) return false

        User user = (User) o

        if (age != user.age) return false
        if (level != user.level) return false

        return true
    }

    @Override
    int hashCode() {
        int result
        result = age
        result = 31 * result + level
        return result
    }

    static user(int age, int level) {
        new User(age, level)
    }
}
