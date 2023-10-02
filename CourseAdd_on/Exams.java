package CourseAdd_on;

public class Exams
{
    private boolean finalExam;
    private boolean Quiz;

    public double solveExam(double score) 
    {
        if (finalExam == false) 
        {
            finalExam = true;
            score += 60.0;
            System.out.println("Exam solved successfully");
            return score;
        }
        System.out.println("Exam already solved");
        return score;
    }

    public double solveQuiz(double score) 
    {
        if (Quiz == false) 
        {
            Quiz = true;
            score = score + 40.0;
            System.out.println("Quiz solved successfully");
            return score;
        }
        System.out.println("Quiz already solved");
        return score;
    }
    
    public boolean getExam() {
        return finalExam;
    }
    public boolean getQuiz() {
        return Quiz;
    }


}

