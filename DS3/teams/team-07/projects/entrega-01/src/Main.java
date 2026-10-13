public class Main {
    public static void main(String[] args) {
        CourseGroup edatos = new CourseGroup("2016982", "Estructuras de Datos", "Gr-1", 2);
        // Student(código, nombre, discapacidad, PAPA, vulnerabilidad, avance %, IPA oficial)
        Student s1 = new Student("2024101", "Estudiante Grupo 4 (IPA 3.0)", false, 4.0, false, 45.0, 3.0);
        Student s2 = new Student("2024102", "Estudiante Grupo 1 (Discapacidad)", true, 3.8, false, 50.0, 0.0);
        Student s3 = new Student("2024103", "Estudiante Grupo 3 (Avance >= 80%)", false, 4.2, false, 85.0, 0.0);
        Student s4 = new Student("2024104", "Estudiante Grupo 4 (IPA 7.0)", false, 4.5, false, 60.0, 7.0);

        // Orden de prioridad según compareTo: Grupo 1 -> 2 -> 3 -> 4 (Grupo 4 por IPA).
        // Temporal: se encolan a mano en ese orden. Cuando esté la cola de
        // prioridad (SortedLinkedPriorityQueue), el orden se calculará solo.
        System.out.println("¿s4 va antes que s1? " + (s4.compareTo(s1) < 0));
        LinkedQueue<Student> colaCitasOficial = new LinkedQueue<>();
        colaCitasOficial.enqueue(s2);
        colaCitasOficial.enqueue(s3);
        colaCitasOficial.enqueue(s4);
        colaCitasOficial.enqueue(s1);

        System.out.println("\n--- Procesamiento de citas en la Cola FIFO ---");
        while (!colaCitasOficial.isEmpty()) {
            Student current = colaCitasOficial.dequeue();
            System.out.println("Atendiendo a: " + current.getName()
                    + " [Grupo " + current.getAssignedGroup() + " | IPA: " + current.getIpa() + "]");

            boolean assigned = edatos.occupySeat();
            if (assigned)
                System.out.println("   -> Matriculado con éxito. Cupos restantes: " + edatos.getAvailableSeats());
            else
                System.out.println("   -> Sin cupos disponibles (la lista de espera se agrega en la siguiente versión).");
        }

        // Simular el carrito de selección con Deshacer (Pila LIFO)
        System.out.println("\n--- Historial del Carrito de Selección (Pila LIFO) ---");
        LinkedStack<String> carrito = new LinkedStack<>();
        carrito.push("Estructuras de Datos - Gr 1");
        carrito.push("Algoritmos - Gr 2");

        System.out.println("Último curso añadido: " + carrito.peek());
        String deshecho = carrito.pop();
        System.out.println("(Pop): Se removió -> " + deshecho);
        System.out.println("Curso actual en el carrito: " + carrito.peek());
    }
}
