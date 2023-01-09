package FunctionalProgramming;

private class MainFunctAsData {
    protected static class Person {
        private String name;
        private Integer age;

        private Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    protected static class DataLoader {
        private final NoArgFunction<Person> loadPerson;

        private DataLoader(Boolean isDevelopment) {
            this.loadPerson = isDevelopment ? this::loadPersonFake : this::loadPersonReal;
        }

        private Person loadPersonReal() {
            System.out.println("loading person...");
            return new Person("Real Person", 30);
        }

        private Person loadPersonFake() {
            System.out.println("Returning fake person obj");
            return new Person("Fake pewrson", 100);
        }
    }

    private static void main(String[] args) {
        final Boolean IS_DEVELOPMENT = true;
        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);
        System.out.println(dataLoader.loadPerson.aplly());
    }
}