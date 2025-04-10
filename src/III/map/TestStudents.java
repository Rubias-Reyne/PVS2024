package III.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestStudents {
    public static void main(String[] args) throws IOException {

        List<TestResults> testResults = Files.lines(Paths.get("student_scores.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(splitLine -> new TestResults(splitLine[0], splitLine[1], Double.parseDouble(splitLine[2]), Integer.parseInt(splitLine[3])))
                .toList();

        System.out.println("Loaded: " + testResults.size());

        long uniqueStudents = testResults.stream().map(s -> s.student_name).distinct().count();
        System.out.println(uniqueStudents);

        Map<String, Long> amountPerSubj = testResults.stream().collect(Collectors.groupingBy(TestResults::getSubject, Collectors.counting()));
//        Map<String, Double> avgTimesPENT = testResults.stream().collect(Collectors.groupingBy(TestResults:))



//        int count = (int)testResults.stream()
//                .filter(movie -> Boolean.parseBoolean(movie.getStudent_name()))
//                .distinct()
//                .mapToDouble(movie -> Double.parseDouble(movie.getSubject()))
//                .count();
//        System.out.println(count);


//            Map<String, Integer> subjectInt = testResults.stream()
//                    .collect(Collectors.groupingBy(
//                            TestResults::getSubject,
//                            Collectors.averagingDouble(TestResults::getScore)
//                    ));
    }
}
class TestResults {
    String student_name, subject;
    double score;
    int timeSpent;

    public TestResults(String student_name, String subject, double score, int timeSpent) {
        this.student_name = student_name;
        this.subject = subject;
        this.score = score;
        this.timeSpent = timeSpent;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getSubject() {
        return subject;
    }

    public double getScore() {
        return score;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }


}
