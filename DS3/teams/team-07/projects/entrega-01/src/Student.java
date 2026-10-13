public class Student
{
    private String code;
    private String name;

    private boolean hasDisability;               // Grupo 1
    private double papa;                         // Para Grupo 2 (PAPA <= 3.1) y desempates
    private boolean academicVulnerability;       // Grupo 2 (PEAMA, riesgo, etc.)
    private double curricularProgress;           // Porcentaje de avance (ej: 85.0 para 85%)
    private int enrollmentCount;                 // Número de matrícula (ej: 3ª, 4ª, etc.)
    private boolean topTenPercent;               // Top 10% del promedio semestral anterior
    private boolean completedEdifyingSurvey;     // Encuesta EDIFICANDO completada
    private boolean completedRII;                // Registro de Intención de Inscripción (+1 punto en IPA)

    public Student(String code, String name, boolean hasDisability, double papa, boolean academicVulnerability, double curricularProgress,
                   int enrollmentCount, boolean topTenPercent, boolean completedEdifyingSurvey, boolean completedRII) {
        this.code = code;
        this.name = name;
        this.hasDisability = hasDisability;
        this.papa = papa;
        this.academicVulnerability = academicVulnerability;
        this.curricularProgress = curricularProgress;
        this.enrollmentCount = enrollmentCount;
        this.topTenPercent = topTenPercent;
        this.completedEdifyingSurvey = completedEdifyingSurvey;
        this.completedRII = completedRII;
    }
    // Grupo 1: Discapacidad
    // Grupo 2: Vulnerabilidad académica (PAPA <= 3.1 o PEAMA)
    // Grupo 3: Avance curricular >= 80%
    // Grupo 4: Avance curricular < 80%
    public int getAssignedGroup() {
        if (hasDisability) return 1;
        if (academicVulnerability || papa <= 3.1) return 2;
        if (curricularProgress >= 80.0) return 3;
        return 4;
    }
    // Calcula el Índice de Prioridad de Asignación (IPA) exclusivamente para el Grupo 4.
    // Factores: Momento del plan de estudios, Top 10% semestral, EDIFICANDO y RII (+1 punto).
    public double calculateIPA() {
        if (getAssignedGroup() != 4) return 0.0; // El IPA solo aplica para el Grupo 4

        double ipaScore = 0.0;

        if (enrollmentCount >= 3 && enrollmentCount <= 5) ipaScore += 2.0; // Factor 1: Momento en el plan de estudios (3ª a 5ª matrícula)
        if (topTenPercent) ipaScore += 3.0; // Factor 2: Rendimiento académico destacado (Top 10% usando fórmula de promedio semestral)
        if (completedEdifyingSurvey) ipaScore += 1.0; // Factor 3: Diligenciamiento de Encuesta Docente EDIFICANDO
        if (completedRII) ipaScore += 1.0; // Factor 4: Registro de Intención de Inscripción (RII) otorga +1 punto directo

        return ipaScore;
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public double getCurricularProgress() {
        return curricularProgress;
    }
    public double getPapa() {
        return papa;
    }
}