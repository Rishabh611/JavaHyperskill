import org.HyperSkill.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestClass {
    @Test
    public void isNullExample(){
        String actual = null;
        String notNullActual = "AssertJ";

        assertThat(actual).isNull();
        assertThat(notNullActual).isNotNull();
    }

    @Test
    public void stringAssert() {
        String actual = "AssertJ is a great library for writing tests";
        assertThat(actual).isEqualToIgnoringCase("assertj is a great library for writing tests");

        assertThat(actual).startsWith("AssertJ");

        assertThat(actual).matches("AssertJ.*library.*writing tests");

        assertThat(actual).hasSize(44);
    }

    @Test
    public void isEqualToObjectExample() {
        Person actual = new Person("John", "Doe", 30);
        Person expected = new Person("John", "Doe", 30);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testListAsserts() {
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript");

        assertThat(languages).contains("Java", "Python");

        assertThat(languages).containsExactlyInAnyOrder("JavaScript", "Java", "Python");

        assertThat(languages).containsExactly("Java", "Python", "JavaScript");

        assertThat(languages).doesNotContain("PHP");
    }

    @Test
    public void typeAsserts() {
        Object number = 42;

        assertThat(number).isInstanceOf(Integer.class);

        assertThat(number).isInstanceOfAny(Integer.class, Long.class);

        assertThat(number).isNotInstanceOf(String.class);
    }

    @Test
    public void fieldAsserts() {
        Person person = new Person("John", "Doe", 30);
        assertThat(person).hasFieldOrPropertyWithValue("firstName", "John");
        assertThat(person).hasFieldOrProperty("lastName");
    }

    @Test
    public void satisfiesAsserts() {
        Person person = new Person("John", "Doe", 30);

        assertThat(person).satisfies(
                p -> {
                    assertThat(p.getFirstName()).isEqualTo("John");
                    assertThat(p.getAge()).isGreaterThanOrEqualTo(18);
                }
        );
    }
}
