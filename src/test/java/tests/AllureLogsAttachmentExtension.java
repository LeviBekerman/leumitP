package tests;

import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import static utils.AllureUtils.*;

public class AllureLogsAttachmentExtension implements BeforeEachCallback, AfterEachCallback {
    private String testUUID;

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        testUUID = getAllureTestUUID();
        addAllureUUIDToCurrentThreadLogs(testUUID);
    }

    @Override
    public void afterEach(ExtensionContext extensionContext)  {
      addAllureTxtAttachment(getAllLogMessageToCurrentTest());
    }

    private String getAllLogMessageToCurrentTest() {
        String uuid = "[" + testUUID + "]";
        return getAllMessage().stream().filter(log-> log.contains(uuid)).
                map(log -> log.replace(uuid, "")).
                collect(Collectors.joining("\n"));
    }

    @SneakyThrows
    private List<String> getAllMessage(){
        return readAllLines(get("logs/log.txt"));
    }
}
