package examples;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.intuit.karate.junit5.Karate;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExamplesTest {

    @Test
    void testParallel() {
        Results results = Runner.path("classpath:examples")
                .outputCucumberJson(true)
                .parallel(3);
        generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    @Test
    void test() {
        Results results = Runner.path("classpath:examples")
            .outputCucumberJson(true)
            .parallel(1);
        generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    @Test
    void testDebug() {
        Results results = Runner.path("classpath:examples")
                .tags("@debug")
                .parallel(1);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "KarateTech");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}
