public class Main {
    public static void main(String[] args) {
        CourseGroup edatos = new CourseGroup("2016982", "Estructuras de Datos", "Gr-1", 2);
        Student s1 = new Student("2024101", "Estudiante Grupo 4 (Sin RII)", false, 4.0, false, 45.0, 3, false, true, false);
        Student s2 = new Student("2024102", "Estudiante Grupo 1 (Discapacidad)", true, 3.8, false, 50.0, 3, false, false, false);
        Student s3 = new Student("2024103", "Estudiante Grupo 3 (Avance >= 80%)", false, 4.2, false, 85.0, 6, false, false, false);
        Student s4 = new Student("2024104", "Estudiante Grupo 4 (Con RII y Top 10%)", false, 4.5, false, 60.0, 4, true, true, true);

        // Organizar y encolar las citas en la Cola FIFO respetando la jerarquía estricta:
        // Grupo 1 -> Grupo 2 -> Grupo 3 -> Grupo 4 (ordenados internamente por IPA)
        LinkedQueue colaCitasOficial = new LinkedQueue();
        if (s2.getAssignedGroup() == 1) colaCitasOficial.enqueue(s2); // Primero Grupo 1
        if (s3.getAssignedGroup() == 3) colaCitasOficial.enqueue(s3); // Luego Grupo 3
        if (s4.getAssignedGroup() == 4) colaCitasOficial.enqueue(s4); // Luego Grupo 4 (s4 tiene mayor IPA que s1)
        if (s1.getAssignedGroup() == 4) colaCitasOficial.enqueue(s1);

        System.out.println("\n--- Procesamiento de citas en la Cola FIFO ---");
        while (!colaCitasOficial.isEmpty()) {
            Student current = (Student) colaCitasOficial.dequeue();
            int grupo = current.getAssignedGroup();
            double ipa = current.calculateIPA();

            System.out.println("Atendiendo a: " + current.getName() + " [Grupo " + grupo + " | IPA: " + ipa + "]");

            boolean assigned = edatos.occupySeat();
            if (assigned)
                System.out.println("   -> ¡Matriculado con éxito! Cupos restantes: " + edatos.getAvailableSeats());
            else
                System.out.println("   -> Sin cupos disponibles (Enviado a lista de espera).");
        }

        // Simular el carrito de selección con Deshacer (Pila LIFO)
        System.out.println("\n--- Historial del Carrito de Selección (Pila LIFO) ---");
        LinkedStack carrito = new LinkedStack();
        carrito.push("Estructuras de Datos - Gr 1");
        carrito.push("Algoritmos - Gr 2");

        System.out.println("Último curso añadido: " + carrito.peek());
        String deshecho = carrito.pop();
        System.out.println("(Pop): Se removió -> " + deshecho);
        System.out.println("Curso actual en el carrito: " + carrito.peek());
    }
}