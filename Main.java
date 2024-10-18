import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        int again;

        do {
            if (stack.isEmpty()) {
                System.out.println("No students available. You can add new students.");
                System.out.println();
            }

            int id;
            boolean isValid;

            do {
                System.out.print("Input ID of Student: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid ID (number): ");
                    scanner.next();
                }
                id = scanner.nextInt();
                scanner.nextLine();

                if (id <= 0) {
                    System.out.println("Invalid ID. It must be greater than 0. Please try again.");
                    isValid = false;
                } else if (Check_ID(stack, id)) {
                    System.out.println("ID already exists. Please try again.");
                    isValid = false;
                } else {
                    isValid = true;
                }
            } while (!isValid);

            System.out.print("Input Your Name: ");
            String name = scanner.nextLine();

            double mark;
            do {
                System.out.print("Input Mark of Student (0-10): ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid mark (number): ");
                    scanner.next();
                }
                mark = scanner.nextDouble();
                scanner.nextLine();
                if (mark < 0 || mark > 10) {
                    System.out.println("Invalid, input must be from 0 to 10. Please try again.");
                }
            } while (mark < 0 || mark > 10);

            Student_Management studentManagement = new Student_Management(id, name, mark);
            stack.push(studentManagement);

            do {
                System.out.print("Do you want to add another student? (1: Yes, 2: No): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter 1 for Yes or 2 for No.");
                    scanner.next();
                }
                again = scanner.nextInt();
                scanner.nextLine();
            } while (again != 1 && again != 2);
        } while (again == 1);

        System.out.println();
        stack.displayStudents();
        System.out.println();

        while (confirmAction(scanner, "Edit Student by ID")) {
            editStudent(scanner, stack);
            System.out.println();
            stack.displayStudents();
        }

        while (confirmAction(scanner, "Delete Student by ID")) {
            deleteStudent(scanner, stack);
            if (stack.isEmpty()) {
                System.out.println("All students have been deleted. No more entries allowed.");
                break;
            }
            System.out.println();
            stack.displayStudents();
        }

        while (confirmAction(scanner, "Search for Student by ID")) {
            searchStudent(scanner, stack);
            System.out.println();
        }
    }

    public static void searchStudent(Scanner scanner, Stack stack) {
        int id;
        boolean validId;

        do {
            System.out.print("Input ID of Student to search: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid ID (number): ");
                scanner.next();
            }
            id = scanner.nextInt();
            scanner.nextLine();
            validId = (id > 0 && Check_ID(stack, id));
            if (!validId) {
                if (id <= 0) {
                    System.out.println("ID must be greater than 0. Please try again.");
                } else {
                    System.out.println("Student with ID " + id + " does not exist.");
                }
            }
        } while (!validId);

        Stack tempStack = new Stack();
        boolean found = false;

        while (!stack.isEmpty()) {
            Student_Management student = stack.pop();
            if (student.getID_Student() == id) {
                System.out.println("Id of Student: " + student.getID_Student());
                System.out.println("Name of Student: " + student.getName_Student());
                System.out.println("Mark of Student: " + student.getMark_Student());
                found = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static boolean Check_ID(Stack stack, int id) {
        Stack tempStack = new Stack();
        boolean found = false;

        while (!stack.isEmpty()) {
            Student_Management student = stack.pop();
            if (student.getID_Student() == id) {
                found = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return found;
    }

    public static boolean confirmAction(Scanner scanner, String action) {
        System.out.println("Do you want to " + action + "? (1: Yes, 2: No): ");
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please enter 1 for Yes or 2 for No: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
        } while (choice != 1 && choice != 2);
        return choice == 1;
    }

    public static void editStudent(Scanner scanner, Stack stack) {
        int id;
        boolean validId;
        do {
            System.out.print("Choose ID that you want to edit: ");
            while (!scanner.hasNextInt()) {
                System.out.println("ID must be numeric!!");
                System.out.print("Try again: ");
                scanner.nextLine();
            }
            id = scanner.nextInt();
            scanner.nextLine();
            validId = Check_ID(stack, id);
            if (!validId) {
                System.out.println("Your ID is not existing !!!!");
            }
        } while (!validId);

        Stack tempStack = new Stack();
        while (!stack.isEmpty()) {
            Student_Management student = stack.pop();
            if (student.getID_Student() == id) {
                int choice;
                do {
                    System.out.print("What do you want to edit? (1: Name, 2: Mark): ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Please only choose 1 or 2 !!!");
                        System.out.print("Try Again: ");
                        scanner.nextLine();
                    }
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } while (choice != 1 && choice != 2);

                if (choice == 1) {
                    System.out.print("Edit name to: ");
                    String newName = scanner.nextLine();
                    student.setName_Student(newName);
                    System.out.println("Name updated to: " + newName);
                } else {
                    double newMark;
                    do {
                        System.out.print("Edit mark to (0-10): ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input, please input mark of student !!!");
                            scanner.next();
                        }
                        newMark = scanner.nextDouble();
                        scanner.nextLine();
                        if (newMark < 0 || newMark > 10) {
                            System.out.println("Mark must be between 0 and 10. Try again.");
                        }
                    } while (newMark < 0 || newMark > 10);
                    student.setMark_Student(newMark);
                    System.out.println("Mark updated to: " + newMark);
                }
            }
            tempStack.push(student);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void deleteStudent(Scanner scanner, Stack stack) {
        int id;
        boolean validId;
        do {
            System.out.print("Choose ID that you want to delete: ");
            while (!scanner.hasNextInt()) {
                System.out.println("ID must be numeric!!");
                System.out.print("Try again: ");
                scanner.nextLine();
            }
            id = scanner.nextInt();
            scanner.nextLine();
            validId = Check_ID(stack, id);
            if (!validId) {
                System.out.println("Your ID is not existing !!!!");
            }
        } while (!validId);

        Stack tempStack = new Stack();
        while (!stack.isEmpty()) {
            Student_Management student = stack.pop();
            if (student.getID_Student() != id) {
                tempStack.push(student);
            } else {
                System.out.println("Student with ID " + id + " has been deleted.");
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}